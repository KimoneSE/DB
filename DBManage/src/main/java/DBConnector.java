import java.sql.*;

/**
 * created by Kimone
 * date 2020/9/2
 */
public class DBConnector {
    public static void main(String[] args) {
        Connection connection;
        ResultSet resultSet;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/htsc_0902?useUnicode=true&characterEncoding=utf-8&characterSetResults=UTF-8&serverTimezone=Asia/Shanghai&&useSSL=true","root","");

            PreparedStatement statement = connection.prepareStatement("select * from user where username=?");
            statement.setString(1,"李四");
            resultSet = statement.executeQuery();
            while(resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUsername(resultSet.getString("username"));
                user.setSex(resultSet.getString("sex"));
                user.setAddress(resultSet.getString("address"));
                user.setBirthday(resultSet.getDate("birthday"));
                System.out.println(user.toString());
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
