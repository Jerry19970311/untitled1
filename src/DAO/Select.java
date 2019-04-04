package DAO;

import bean.TimesLogItem;

import java.sql.SQLException;
import java.util.List;

public interface Select {
    boolean haveJoined(String id,String source) throws SQLException;
    List<TimesLogItem> getAllLog(String source,String type);
    void close() throws SQLException;
}
