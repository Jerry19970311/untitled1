import bean.NewsItem;

public class Test {
    public static void main(String[] args) throws Exception {
        /*Class.forName("com.mysql.jdbc.Driver");
        String url="jdbc:mysql://localhost:3306/hadoop?serverTimezone=UTC";
        String username="root";
        String password="root";
        Connection connection=(Connection) DriverManager.getConnection(url,username,password);*/
        AbstractCatch abstractCatch=new SinaDispatch();
        String url="https://news.sina.com.cn/c/2019-04-08/doc-ihvhiewr3969687.shtml";
        String html=abstractCatch.getHtmlTextFromURL(url,"utf-8");
        System.out.println(html);
        NewsItem analyse=abstractCatch.analyse(html);
        output(analyse);
        //abstractCatch.getNews();
        //Select select=new MySQLSelecter();
        //System.out.println(select.haveJoined("123456","48654856"));
        /*System.out.println(new Date().getTime()+"\t"+System.currentTimeMillis());
        System.out.println(new SimpleDateFormat("yyyyMMdd").parse("20190104").getTime());
        Calendar calendar=Calendar.getInstance();
        calendar.set(2019,Calendar.JANUARY,4);
        System.out.println(calendar.getTimeInMillis());
        System.out.println(calendar.get(Calendar.MONTH));
        System.out.println(calendar.getTime());*/
        /*SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMdd");
        System.out.println(simpleDateFormat.format(new Date()));*/
        /*String url="https://new.qq.com/omn/20190401/20190401A03WML.html?pgv_ref=aio2015&ptlang=2052";
        String text=getHtmlTextFromURL(url,"GBK");
        Document document= Jsoup.parse(text);*/
        //Elements elements=document.select("script:contains(window.DATA)");
        //System.out.println(document.cssSelector());
        //Elements elements=document.getElementsContainingText("window.DATA");
        //System.out.println(document.select(TencentDispatch.ARTICLE_CLASS));
        //Elements elements=document.select("p[class=\"one-p\"]");
        //Elements elements=document.select("head");
        /*Iterator<Element> iterator=elements.iterator();
        while (iterator.hasNext()){
            Element temp=iterator.next();
            System.out.println(temp.text()+"\n----------------------------------------------------\n");
        }*/
    }
    /*public static String getHtmlTextFromURL(String s,String charset) throws IOException {
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
    }*/
    public static void output(NewsItem newsItem){
        System.out.println("id:"+newsItem.getId());
        System.out.println("source:"+newsItem.getSource());
        System.out.println("type:"+newsItem.getType());
        System.out.println("title:"+newsItem.getTopic());
        System.out.println("publish time:"+newsItem.getPublish_time());
        System.out.println("author:"+newsItem.getAuthor());
        System.out.println("text:"+newsItem.getText_path());
        System.out.println("url:"+newsItem.getUrl());
        System.out.println("tags:"+newsItem.getTags());
    }

}
