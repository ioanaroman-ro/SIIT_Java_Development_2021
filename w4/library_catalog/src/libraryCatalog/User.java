package libraryCatalog;

import java.util.Arrays;
import java.util.List;

public class User {

    static List<String> users = Arrays.asList("0","1","2");

    public static boolean checkUser(String id){
        if (users.contains(id)){
            try{
                return true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        System.err.println("User not found!");
        return false;
    }



}
