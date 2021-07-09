package siit.db;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import siit.ValidationException;
import siit.model.User;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;


    public List<User> getUsers() {
        return jdbcTemplate.query("select * from Users", this::getUser);
    }

    private User getUser(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserName(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        user.setStatus(rs.getString("status"));
        user.setFirstName(rs.getString("firstname"));
        user.setLastName(rs.getString("lastname"));
        user.setUserid(rs.getInt("userid"));
        return user;
    }

    public void insertUser(User user) {
        String updateUser = "Insert into users (username,password,status)values(?,?,?)";
        jdbcTemplate.update(updateUser, user.getUserName(), user.getPassword(), user.getStatus());
    }

    public void deleteUser(String userName) {
        String deleteUser = "delete from users where name=?";
        jdbcTemplate.update(deleteUser, userName);
    }

    public void editUserLoginInfo(int userid, String userName, String password) {
        String editUser = "update users set username =?,password=? where userid=?";
        jdbcTemplate.update(editUser, userName, password, userid);
    }

    public void editUserPersonalData(int userid, String firstName, String lastName) {
        String editUser = "update users set firstName =?,lastName=? where userid=?";
        jdbcTemplate.update(editUser, firstName, lastName, userid);
    }

    public void changeUserStatus(User user) {
        String status = user.getStatus();
        String editUser = "update users set status =? where userid=?";
        if (status.equals("Active") || status.equals("Inactive")) {
            jdbcTemplate.update(editUser, status, user.getUserid());
        } else {
            throw new ValidationException("Status can only be Active or Inactive");
        }

    }

}
