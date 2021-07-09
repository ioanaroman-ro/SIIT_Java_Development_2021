package siit.sevices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import siit.ValidationException;
import siit.db.UserDao;
import siit.model.User;

import java.util.List;


@Service
public class UserService {
    @Autowired
    UserDao userDao;

    public List<User> getAllUsers(){
        return userDao.getUsers();
    }

    public void changeStatus(User user){
        userDao.changeUserStatus(user);
    }

    public User getUserByUsername(String userName){
        List<User> registeredUsers = getAllUsers();
        User user = new User();
        for(User usr: registeredUsers){
            if(usr.getUserName().equals(userName)){
                user=usr;
            }
        }
        return user;
    }

    public void createNewUser(String userName,String password){
        List<User> registeredUsers = getAllUsers();
        User user = new User();
        if(password.length() >= 5){
            user.setPassword(password);
            for(User usr:registeredUsers){
                if(!userName.equals(usr.getUserName())){
                    user.setUserName(userName);
                    user.setStatus("Active");
                } else {
                    throw new ValidationException("Username already exists!");
                }
            }
        }else{
            throw new ValidationException("Password must be at least 5 characters long");
        }
        userDao.insertUser(user);
    }

    public User getUserById(int userId){
        List<User> registeredUsers = getAllUsers();
        User user = new User();
        for(User usr: registeredUsers){
            if(usr.getUserid() == userId){
                user=usr;
            }
        }
        return user;
    }

//    public User editUser(String name,String password,String role){
//        System.out.println(name);
//        System.out.println(password);
//        System.out.println(role);
//          User userEdited=  new User();
//          userDao.editUser(name,password,role);
//          List<User> users = userDao.getUsers();
//          if(password.matches("\\w{2}\\d{3}\\w{1}\\d{2}")) {
//              for (User user1 : users) {
//                  if (user1.getName().equals(name)) {
//                      userEdited = user1;
//                  }
//              }
//          }else{
//              throw new ValidationException("Password must be like 2Letters3Digits1Letter2Digits");
//          }
//          return userEdited;
//    }
//
//    public User getUserByName(String name){
//        List<User> users = userDao.getUsers();
//        User userTemp = null;
//        for(User user:users){
//            if(user.getName().equals(name)){
//                userTemp=user;
//            }
//        }
//        return  userTemp;
//    }
//
//
//    public void deleteUser(String name) {
//        userDao.deleteUser(name);
//    }
//
//    public String  getRole(User user){
//        return user.getRole();
//    }


}
