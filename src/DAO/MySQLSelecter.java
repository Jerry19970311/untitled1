package DAO;

import bean.TimesLogItem;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class MySQLSelecter implements Select{
    private Connection connection;
    private PreparedStatement getNewsByIdAndSource;
    public MySQLSelecter() throws SQLException, ClassNotFoundException {
        this.connection=MySQLManager.init();
        init();
    }
    public void init() throws SQLException {
        String selectIS="SELECT * FROM article WHERE `id`=? AND `source`=?";
        this.getNewsByIdAndSource=connection.prepareStatement(selectIS);
    }
    public boolean haveJoined(String id,String source) throws SQLException {
        this.getNewsByIdAndSource.setString(1,id);
        this.getNewsByIdAndSource.setString(2,source);
        ResultSet resultSet=this.getNewsByIdAndSource.executeQuery();
        return resultSet.next();
        //return this.getNewsByIdAndSource.execute();
    }

    @Override
    public List<TimesLogItem> getAllLog(String source, String type) {
        return null;
    }

    @Override
    public void close() throws SQLException {
        this.connection.close();
    }
}
