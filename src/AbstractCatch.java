import bean.NewsItem;
import download.Downloadable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

public abstract class AbstractCatch {
    protected String source;
    protected String url;
    protected String basePath="E:/Result/";
    protected Downloadable downloader;
    //新闻文本页面的队列。
    protected Queue<String> textHtmlQueue;
    //种子队列。（处理例如）
    protected Queue<String> seedQueue;
    public AbstractCatch(){
        textHtmlQueue=new LinkedBlockingQueue<>();
        seedQueue=new LinkedBlockingQueue<>();
        initSeeds();
    }
    //初始化种子。
    protected abstract void initSeeds();
    //得到完整的下载的本地路径。
    protected abstract String getWholePath();
    //根据从reader得到的数据进行分析得到，转化为统一的NewsItem格式。
    protected abstract NewsItem analyse(String text) throws Exception;
    //生成符合目标网站接口格式的时间
    protected String buildTime(int year,int month,int day,String format){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        Calendar calendar=Calendar.getInstance();
        int m=month-1;
        calendar.set(year,m,day);
        return simpleDateFormat.format(calendar.getTimeInMillis());
    }
    protected String buildNowTime(String format){
        Calendar calendar=Calendar.getInstance();
        int year=calendar.get(Calendar.YEAR);
        int month=calendar.get(Calendar.MONTH)+1;
        int day=calendar.get(Calendar.DATE);
        return buildTime(year,month,day,format);
    }
    //protected
    protected abstract String buildURLString();
    //从给定的网站构建Reader拉取网页数据。
    protected String getHtmlTextFromURL(String s,String charset) throws IOException {
        URL url=new URL(s);
        URLConnection urlConnection=url.openConnection();
        urlConnection.setRequestProperty("User-Agent", "Mozilla/31.0 (compatible; MSIE 10.0; Windows NT; DigExt)");
        InputStream inputStream=urlConnection.getInputStream();
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(inputStream,charset));
        String ss;
        String temp="";
        while ((ss=bufferedReader.readLine())!=null){
            temp=temp+ss;
        }
        bufferedReader.close();
        inputStream.close();
        return temp;
    }
    protected abstract void getNews();
    //将分析后的News统一加入给定队列。（该参数队列必须线程安全）
    protected void getNews(String charset) throws Exception {
        while (!textHtmlQueue.isEmpty()){
            url=textHtmlQueue.poll();
            String html=getHtmlTextFromURL(url,charset);
            analyse(html);
        }
    }
    protected byte[] getUTF8BytesFromGBKString(String gbkStr) {
        int n = gbkStr.length();
        byte[] utfBytes = new byte[3 * n];
        int k = 0;
        for (int i = 0; i < n; i++) {
            int m = gbkStr.charAt(i);
            if (m < 128 && m >= 0) {
                utfBytes[k++] = (byte) m;
                continue;
            }
            utfBytes[k++] = (byte) (0xe0 | (m >> 12));
            utfBytes[k++] = (byte) (0x80 | ((m >> 6) & 0x3f));
            utfBytes[k++] = (byte) (0x80 | (m & 0x3f));
        }
        if (k < utfBytes.length) {
            byte[] tmp = new byte[k];
            System.arraycopy(utfBytes, 0, tmp, 0, k);
            return tmp;
        }
        return utfBytes;
    }
    protected String unicodeToCn(String unicode) {
        String[] strs = unicode.split("\\\\u");
        String returnStr = strs[0];
        // 由于unicode字符串以 \ u 开头，因此分割出的第一个字符是""。
        for (int i = 1; i < strs.length; i++) {
            if(strs[i].length()==4) {
                returnStr += (char) Integer.valueOf(strs[i], 16).intValue();
            }else{
                String temp1=strs[i].substring(0,4);
                returnStr += (char) Integer.valueOf(temp1, 16).intValue();
                String temp2=strs[i].substring(4);
                returnStr += temp2;
            }
        }
        return returnStr;
    }
    public String buildDateInNativeFormat(String date,String format) throws ParseException {
        long time=buildTimeInLong(date,format);
        Date date1=new Date(time);
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        return simpleDateFormat.format(date1);
    }
    public long buildTimeInLong(String date,String format) throws ParseException {
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat(format);
        return simpleDateFormat.parse(date).getTime();
    }
}
