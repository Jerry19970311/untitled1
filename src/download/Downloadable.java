package download;

import bean.NewsItem;

public interface Downloadable {
    void download(NewsItem newsItem);
    void downloadText(String path,String text);
}
