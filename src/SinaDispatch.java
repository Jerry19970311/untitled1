import bean.NewsItem;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SinaDispatch extends AbstractCatch implements ClickedUpdatable{
    @Override
    protected void initSeeds() {

    }

    @Override
    protected String getWholePath() {
        return null;
    }

    @Override
    protected NewsItem analyse(String text) throws Exception {
        Set<String> tags=new HashSet<String>();
        NewsItem result=new NewsItem();
        Document document= Jsoup.parse(text);
        Element head=document.selectFirst("head");
        //title标签是把浏览器中的标签信息原封不动搬过来的，所以不提倡用。
        /*Element title=head.selectFirst("title");
        result.setTopic(title.text());*/
        Elements metas=head.select("meta");
        Iterator<Element> metaIterator=metas.iterator();
        boolean[] check=new boolean[]{false,false,false,false,false,false};
        while (metaIterator.hasNext()&&(!chec(check))){
            Element temp=metaIterator.next();
            if("keywords".equals(temp.attr("name"))||"content".equals(temp.attr("name"))){
                String[] ts=temp.attr("content").split(",");
                tags.addAll(Arrays.asList(ts));
                check[0]=true;
            }
            if("og:title".equals(temp.attr("property"))){
                String title=temp.attr("content");
                result.setTopic(title);
                check[1]=true;
            }
            if("og:url".equals(temp.attr("property"))){
                String url=temp.attr("content");
                result.setUrl(url);
                check[2]=true;
            }
            if("article:published_time".equals(temp.attr("property"))){
                String originalTime=temp.attr("content");
                long time=buildTimeInLong(originalTime,"yyyy-MM-ddTHH;mm:ss+08:00");
                result.setPublish_time(time);
                check[3]=true;
            }
            if("article:author".equals(temp.attr("property"))){
                String author=temp.attr("content");
                result.setAuthor(author);
                check[4]=true;
            }
            if("comment".equals(temp.attr("name"))){
                String[] channelAndId=temp.attr("content").split(":");
                result.setType(channelAndId[0]);
                result.setId(channelAndId[1]);
                result.setComment_id(channelAndId[1]);
                check[5]=true;
            }
        }
        result.setTags(tags);
        Element body=document.body();
        Elements texts=body.select("p");
        Iterator<Element> iterator=texts.iterator();
        StringBuilder resultTextBuilder=new StringBuilder();
        while (iterator.hasNext()){
            resultTextBuilder.append(iterator.next().text());
        }
        String resultText=resultTextBuilder.toString();
        downloader.download(result);
        downloader.downloadText(result.getText_path(),resultText);
        return null;
    }

    public boolean chec(boolean[] ch){
        boolean result=true;
        for(int i=0;i<ch.length;i++){
            result=result&&ch[i];
        }
        return result;
    }

    @Override
    protected String buildURLString() {
        return null;
    }

    @Override
    protected void getNews() {

    }

    @Override
    public void clickedUpdate(String source, String id, int number) {

    }
}
