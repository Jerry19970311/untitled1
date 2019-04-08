package download;

import bean.NewsItem;

public interface Downloadable {
    void download(String dir,String path,NewsItem newsItem);
    void downloadText(String dir,String path,String text);
}
