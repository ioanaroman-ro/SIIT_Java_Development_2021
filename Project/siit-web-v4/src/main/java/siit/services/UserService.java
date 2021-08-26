package siit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.ValidationException;
import siit.db.UserDao;
import siit.model.User;

import javax.servlet.http.HttpSession;
import java.util.List;


@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> getAllUsers() {
        return userDao.getUsers();
    }

    public void changeStatus(User user) {
        userDao.changeUserStatus(user);
    }

    public User getUserByUsername(String userName) {
        List<User> registeredUsers = getAllUsers();
        User user = new User();
        for (User usr : registeredUsers) {
            if (usr.getUserName().equals(userName)) {
                user = usr;
            }
        }
        return user;
    }

    public void createNewUser(String userName, String password) {
        List<User> registeredUsers = getAllUsers();
        User user = new User();
        if (password.length() >= 5) {
            user.setPassword(password);
            for (User usr : registeredUsers) {
                if (!userName.equals(usr.getUserName())) {
                    user.setUserName(userName);
                    user.setStatus("Active");
                } else {
                    throw new ValidationException("Username already exists!");
                }
            }
        } else {
            throw new ValidationException("Password must be at least 5 characters long");
        }
        userDao.insertUser(user);
    }

    public User getUserById(int userId) {
        List<User> registeredUsers = getAllUsers();
        User user = new User();
        for (User usr : registeredUsers) {
            if (usr.getUserid() == userId) {
                user = usr;
            }
        }
        return user;
    }

    public boolean checkUser(String userName, String password) {
        User user = new User();
        user.setUserName(userName);
        user.setPassword(password);
        boolean isUser = false;
        for (User usr : getAllUsers()) {
            if (usr.equals(user)) {
                isUser = true;
                user.setStatus(usr.getStatus());
                break;
            }
        }

        if (user.getStatus().equals("Inactive")) {
            throw new ValidationException("User invalid. Please contact admin.");
        }
        return isUser;
    }

    public void changePersonalData(User user) {
        userDao.changePersonalData(user);
    }

    public void changePassword(User user) {
        userDao.changePassword(user);
    }

    private String getName(HttpSession session) {
        return session.getAttribute("logged_user").toString();
    }

    public int getId(HttpSession session) {
        String name = this.getName(session);
        int id = 0;
        for (User user : this.getAllUsers()) {
            if (user.getUserName().equals(name)) {
                id = user.getUserid();
            }
        }
        return id;
    }

}
