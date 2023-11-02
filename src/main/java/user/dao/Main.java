package user.dao;

import user.domain.User;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        UserDao dao = new UserDao();

        User user = new User();
        user.setId("DDi");
        user.setName("띵주");
        user.setPassword("shark");

        dao.add(user);
        System.out.println(user.getId() + "등록완료");

        User user2 = dao.get(user.getId());
        System.out.println(user2.getName());
        System.out.println(user2.getPassword());

        System.out.println(user2.getId()+ "조회성공");
    }
}
