package DAO;

import bean.NewsItem;
import bean.TimesLogItem;

import java.sql.Connection;
import java.sql.SQLException;

public class MySQLPersister implements Persist{
    private Connection connection;
    public MySQLPersister() throws SQLException, ClassNotFoundException {
        this.connection=MySQLManager.init();
    }

    @Override
    public void insertNewsItem(NewsItem newsItem) {

    }

    @Override
    public void updateClickNum(int id, int num) {

    }

    @Override
    public void updateCommentNum(int id, int num) {

    }

    @Override
    public void deleteTimeLog(String source, String type) {

    }

    @Override
    public void insertTimeLog(TimesLogItem timesLogItem) {

    }

    @Override
    public void insertTimeLos(String source, String type, long start_time, int status) {

    }

    @Override
    public void close() throws SQLException {
        this.connection.close();
    }
}
