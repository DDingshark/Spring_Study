package user.dao;
import user.dao.ConnectionMaker.ConnectionMaker;
import user.dao.ConnectionMaker.DConnectionMaker;
import user.domain.User;

import java.sql.*;

public abstract class UserDao {

    private SimpleConnectionMaker simpleConnectionMaker;
    private ConnectionMaker conectionMaker;
    //INIT
    public UserDao()
    {
        simpleConnectionMaker = new SimpleConnectionMaker();
        conectionMaker = new DConnectionMaker();
    }
    public void add(User user) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //Connection c = getConnection();
        //Connection c = simpleConnectionMaker.makeNewConnection();
        Connection c = conectionMaker.makeConnection();

        PreparedStatement ps = c.prepareStatement(
                "insert into users(id,name,password) values (?,?,?)");
        ps.setString(1, user.getId());
        ps.setString(2, user.getName());
        ps.setString(3, user.getPassword());
        ps.executeUpdate();
        ps.close();
        c.close();

    }

    public User get(String id) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        //Connection c =getConnection();
        Connection c = simpleConnectionMaker.makeNewConnection();
        PreparedStatement ps = c.prepareStatement(
                "select * from users where id = ?");
        ps.setString(1, id);

        ResultSet rs = ps.executeQuery();
        rs.next();
        User user = new User();
        user.setId(rs.getString("id"));
        user.setName(rs.getString("name"));
        user.setPassword(rs.getString("password"));

        rs.close();
        ps.close();
        c.close();

        return user;
    }



    /*

    private Connection getConnection() throws ClassNotFoundException, SQLException{
        Class.forName("com.mysql.jdbc.Driver");
        Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/spring_study","root","100101");

        return c;
    }    */

    public abstract Connection getConnection() throws ClassNotFoundException, SQLException;
}

