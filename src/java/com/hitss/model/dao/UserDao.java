package com.hitss.model.dao;
import com.hitss.model.pojo.User;
import java.util.List;

public interface UserDao {
    void insertUser(User user);
    void updateUser(User user);
    void deleteUser(User user);
    User findUserById(int idUser);
    User findUserByName(String username);
    List<User> findAllUser();    
}
