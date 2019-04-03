import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.text.ParseException;
import java.util.Iterator;

public class Test {
    public static void main(String[] args) throws IOException, ParseException {
        /*System.out.println(new Date().getTime()+"\t"+System.currentTimeMillis());
        System.out.println(new SimpleDateFormat("yyyyMMdd").parse("20190104").getTime());
        Calendar calendar=Calendar.getInstance();
        calendar.set(2019,Calendar.JANUARY,4);
        System.out.println(calendar.getTimeInMillis());
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.getTime());*/
        /*SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        System.out.println(simpleDateFormat.format(new Date()));*/
        String url="https://new.qq.com/omn/20190401/20190401A03WML.html?pgv_ref=aio2015&ptlang=2052";
        String text=getHtmlTextFromURL(url,"GBK");
        Document document= Jsoup.parse(text);
        //Elements elements=document.select("script:contains(window.DATA)");
        //System.out.println(document.cssSelector());
        //Elements elements=document.getElementsContainingText("window.DATA");
        //System.out.println(document.select(TencentDispatch.ARTICLE_CLASS));
        Elements elements=document.select("p[class=\"one-p\"]");
        //Elements elements=document.select("head");
        Iterator<Element> iterator=elements.iterator();
        while (iterator.hasNext()){
            Element temp=iterator.next();
            System.out.println(temp.text()+"\n----------------------------------------------------\n");
        }
    }
    public static String getHtmlTextFromURL(String s,String charset) throws IOException {
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

}
