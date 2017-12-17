package com.hitss.model.dao;
import com.hitss.model.pojo.User;
import java.util.List;

public interface UserDao {
    List<User> loginUser(String username, String password);
    String insertUser(User user);
    String updateUser(User user);
    String deleteUser(User user);
    List<User> findUserById(int idUser);
    List<User> findUserByName(String username);
    List<User> findAllUser();    
}
