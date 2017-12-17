package com.hitss.model.dao;
import com.hitss.model.pojo.User;
import com.hitss.model.dao.HibernateUtil;
import org.hibernate.Query;
import java.util.List;

public class UserDaoImpl 
    implements UserDao{
    
     @Override
    public List<User> loginUser(String username, String password) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        List<User> user = null;
        try{
           Query query = hibernateUtil.getSession()
                    .createQuery("from User where usrUsername = :username"
                            + " and usrPassword = :password"
                            + " and usrEtaid = '1'")
                    .setParameter("username", username)
                    .setParameter("password",password);          
            if(!query.list().isEmpty()){
                user = query.list();
            }
        }catch(Exception Ex){
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error login the user.");
        }finally{
            hibernateUtil.closeSession();        
        }
        return user;
    }
    
    @Override
    public String insertUser(User user) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        String msg="";
        try{
            hibernateUtil.getSession().persist(user);
            hibernateUtil.getTransaction().commit();   
            msg = "Usuario creado";
        }catch(Exception E){
             msg = "Error creando usuario";
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error inserting the new user.");
        }finally{
              hibernateUtil.closeSession();
        }
        return msg;        
    }

    @Override
    public String updateUser(User user) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        String msg="";
        try{
            hibernateUtil.getSession().update(user);
            hibernateUtil.getTransaction().commit();
            msg = "Usuario actualizado";
        }catch(Exception Ex){
            msg="Error actualizando usuario";
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error updating the user.");
        }finally{
            hibernateUtil.closeSession();        
        }
        return msg;
    }

    @Override
    public String deleteUser(User user) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        String msg="";
        try{
            hibernateUtil.getSession().delete(user);
            hibernateUtil.getTransaction().commit();
            msg = "Usuario eliminado";
        }catch(Exception Ex){
            msg = "Error eliminando usuario";
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error deleting the user.");
        }finally{
            hibernateUtil.closeSession();        
        }
        return msg;
    }

    @Override
    public List<User> findUserById(int idUser) {
        HibernateUtil hibernateUtil = 
                new HibernateUtil();
        List<User> user;
        try{
            user = 
                hibernateUtil.getSession().createQuery("from User "
                        + " where usrId = :idUser")
                        .setParameter("idUser", idUser)
                        .list();
        }catch(Exception Ex){
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error finding user by id.");
        }finally{
            hibernateUtil.closeSession();            
        }
        return (user!=null)?user:null;
    }

    @Override
    public List<User> findUserByName(String username) {
        HibernateUtil hibernateUtil = new HibernateUtil();
        List<User> user;
        try{
            user = hibernateUtil.getSession()
                    .createQuery("from User where usrUsername = :username")
                    .setParameter("username", username)
                    .list();
        }catch(Exception Ex){
            hibernateUtil.tryRollBack();
            throw new RuntimeException("Error finding the user by name.");
        }finally{
            hibernateUtil.closeSession();        
        }
       return (user!=null)?user:null;
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
        return (users!=null)?users:null;
    }    
}
