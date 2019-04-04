import bean.NewsItem;
import bean.tencent.NewsList;
import bean.tencent.TencentCategories;
import bean.tencent.WindowDATA;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import download.FileDownload;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class TencentDispatch extends AbstractCatch{
    public static final String TENCENT_API="https://pacaio.match.qq.com/openapi/json?key=";
    public static final String ARTICLE_CLASS="one-p";
    private TencentCategories categories;
    private List<TencentCategories.DataBean> dataBeans;
    //private String url;
    public TencentDispatch() throws FileNotFoundException {
        super();
        downloader=new FileDownload(basePath+"tencent");
        source="腾讯";
        categories=new Gson().fromJson(new FileReader("tencent_categories.json"),TencentCategories.class);
        dataBeans=categories.getData();
    }
    @Override
    protected void initSeeds() {
    }

    @Override
    protected String getWholePath() {
        return null;
    }

    //坑爹的腾讯，没给点击量就算了~
    @Override
    protected NewsItem analyse(String text) throws Exception{
        NewsItem result=new NewsItem();
        Gson gson=new Gson();
        Document document= Jsoup.parse(text);
        String base=document.selectFirst("head").children().last().data();
        System.out.println(base);
        base=base.substring(base.indexOf('{'));
        WindowDATA windowDATA= gson.fromJson(base,WindowDATA.class);
        result.setTopic(windowDATA.getTitle());
        result.setSource(source);
        result.setId(windowDATA.getArticle_id());
        result.setType(windowDATA.getCatalog1());
        result.setUrl(url);
        result.setPublish_time(buildTimeInLong(windowDATA.getPubtime(),"yyyy-MM-dd HH:mm:ss"));
        result.setComment_id(windowDATA.getComment_id());
        result.setAuthor(windowDATA.getMedia());
        String[] tagString=windowDATA.getTags().split(",");
        Set<String> tags=new HashSet<String>();
        tags.addAll(Arrays.asList(tagString));
        result.setTags(tags);
        downloader.download(result);
        downloader.downloadText(result.getText_path(),getArticle(document));
        return result;
    }

    //腾讯的滚动新闻API在此处理。
    @Override
    protected String buildURLString() {
        int num=20;
        int page=0;
        while (true) {
            String listUrl = TENCENT_API + dataBeans.get(33).getName() + ":" + buildTime(2019,4,3,"yyyyMMdd") + "&num=" + num + "&page="+page;
            try {
                NewsList newsList = getNewsList(listUrl);
                if (newsList!=null&&"ok".equals(newsList.getMsg())) {
                    List<NewsList.DataBean> list = newsList.getData();
                    Iterator<NewsList.DataBean> iterator = list.iterator();
                    while (iterator.hasNext()) {
                        String temp = iterator.next().getUrl();
                        if(temp.startsWith("https")) {
                            continue;
                        }
                        temp=temp.replace("http","https");
                        System.out.println(temp);
                        textHtmlQueue.add(temp);
                    }
                    page++;
                    Thread.sleep((long) (2000+2000*Math.random()));
                    System.out.println("??????????????????????????????????????");
                }else {
                    System.out.println("--------------------------------------"+page);
                    break;
                }
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public NewsList getNewsList(String api) throws IOException {
        String resultStr=getHtmlTextFromURL(api,"UTF-8");
        System.out.println(api);
        System.out.println(resultStr);
        Gson gson=new Gson();
        try {
            NewsList result=gson.fromJson(resultStr,NewsList.class);
            return result;
        }catch (JsonSyntaxException e){
            System.out.println("----------------------------------------------");
            return null;
        }
    }

    @Override
    protected void getNews() {
        try {
            getNews("GBK");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String getArticle(Document document){
        String result="";
        Elements elements=document.select("p[class=\""+ARTICLE_CLASS+"\"]");
        Iterator<Element> iterator=elements.iterator();
        while (iterator.hasNext()){
            result=result+iterator.next().text();
        }
        return result;
    }
}
