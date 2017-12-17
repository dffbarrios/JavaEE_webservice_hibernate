package com.hitss.model.dao;
import com.hitss.model.pojo.User;
import com.hitss.model.dao.HibernateUtil;
import org.hibernate.Query;
import java.util.List;

public class UserDaoImpl 
    implements UserDao{

    @Override
    public void insertUser(User user) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        try{
            hibernateUtil.getSession().persist(user);
            hibernateUtil.getTransaction().commit();         
        }catch(Exception E){
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error inserting the new user.");
        }finally{
              hibernateUtil.closeSession();
        }
    }

    @Override
    public void updateUser(User user) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        try{
            hibernateUtil.getSession().update(user);
            hibernateUtil.getTransaction().commit();
        }catch(Exception Ex){
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error updating the user.");
        }finally{
            hibernateUtil.closeSession();        
        }
    }

    @Override
    public void deleteUser(User user) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        try{
            hibernateUtil.getSession().delete(user);
            hibernateUtil.getTransaction().commit();
        }catch(Exception Ex){
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error deleting the user.");
        }finally{
            hibernateUtil.closeSession();        
        }
    }

    @Override
    public User findUserById(int idUser) {
        HibernateUtil hibernateUtil = 
                new HibernateUtil();
        User user;
        try{
            user = (User)
                hibernateUtil.getSession().get(User.class, idUser);
        }catch(Exception Ex){
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error finding user by id.");
        }finally{
            hibernateUtil.closeSession();            
        }
        return (user!=null)?user:null;
    }

    @Override
    public User findUserByName(String username) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        User user;
        try{
            user = (User) hibernateUtil.getSession()
                    .createQuery("from User where usrName = :username")
                    .setParameter("username", username)
                    .list();
        }catch(Exception Ex){
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error finding the user by name.");
        }finally{
            hibernateUtil.closeSession();        
        }
        return user;
    }

    @Override
    public List<User> findAllUser() {
        HibernateUtil hibernateUtil = new HibernateUtil();
        List<User> users;
        try{
            users =
                    hibernateUtil.getSession().createQuery("from User").list();            
        }catch(Exception E){
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error Listing Users");
        }finally{
            hibernateUtil.closeSession();
        }        
        return users;
    }
    
}
