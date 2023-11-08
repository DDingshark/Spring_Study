package user.dao.ConnectionMaker;

import java.sql.Connection;

public interface ConnectionMaker {
    public Connection makeConnection() throws ClassNotFoundException,SecurityException;

}
