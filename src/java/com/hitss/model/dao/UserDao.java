package com.hitss.model.dao;
import com.hitss.model.pojo.User;
import java.util.List;

public interface UserDao {
    void newUser();
    void updateUser();
    void deleteUser();
    User findUserById(int idUser);
    User findUserByName(String username);
    List<User> findAllUser();    
}
