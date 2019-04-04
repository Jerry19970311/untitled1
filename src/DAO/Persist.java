package DAO;

import bean.NewsItem;
import bean.TimesLogItem;

public interface Persist {
    void insertNewsItem(NewsItem newsItem);
    void updateClickNum(int id,int num);
    void updateCommentNum(int id,int num);
    void deleteTimeLog(String source, String type);
    void insertTimeLog(TimesLogItem timesLogItem);
    void insertTimeLos(String source,String type,long start_time,int status);
    void close();
}
