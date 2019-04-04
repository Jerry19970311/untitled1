package download;

import java.sql.Connection;
import java.sql.SQLException;

public class MixedDownLoad extends FileDownload{
    private Connection connection;
    public MixedDownLoad(String based) throws SQLException, ClassNotFoundException {
        super(based);
    }

}
