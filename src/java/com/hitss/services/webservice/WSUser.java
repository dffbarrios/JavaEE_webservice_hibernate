package com.hitss.services.webservice;
import com.hitss.model.pojo.User;
import com.hitss.model.dao.UserDaoImpl;
import com.hitss.utility.DateManagement;
import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

@WebService(serviceName = "WSUser")
public class WSUser {
    
    @WebMethod(operationName = "checkCredentials")
    public List<User> checkCredentials(
            @WebParam(name = "username") String username, 
            @WebParam(name = "password") String password) {       
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        return userDaoImpl.loginUser(username, password);                
    }
    
    @WebMethod(operationName = "insertUser")
    public String insertUser(
            @WebParam(name = "currentUser") String currentUser, 
            @WebParam(name = "currentPass") String currentPass,
            @WebParam(name = "name") String name, 
            @WebParam(name = "lastname") String lastname, 
            @WebParam(name = "username") String username, 
            @WebParam(name = "password") String password, 
            @WebParam(name = "status") String status) {
        User user; UserDaoImpl userDaoImpl = new UserDaoImpl();
        if(userDaoImpl.loginUser(currentUser, currentPass)!=null){
            if(!userDaoImpl.findUserByName(username).isEmpty()){
                return "Imposible finalizar operación: "
                        + " El usuario " + username + " ya existe";
            }else{           
                user = new User(name,lastname,
                    username,password,
                    DateManagement.getCurrentDate(),status);        
                return userDaoImpl.insertUser(user);
            }
        }else return "No esta autorizado para realizar esta operación";
    }

    @WebMethod(operationName = "updateUser")
    public String updateUser(
            @WebParam(name = "currentUser") String currentUser, 
            @WebParam(name = "currentPass") String currentPass,
            @WebParam(name = "idUser") int idUser, 
            @WebParam(name = "name") String name, 
            @WebParam(name = "lastname") String lastname, 
            @WebParam(name = "password") String password) {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        if(userDaoImpl.loginUser(currentUser, currentPass)!=null){
            User user = userDaoImpl.findUserById(idUser).get(0);        
            if(user!=null){
                user.setUsrName(name);
                user.setUsrLastname(lastname);
                user.setUsrPassword(password);
                return userDaoImpl.updateUser(user);
            }else return "El usuario " + name + " " + lastname + " no existe";
        }else return "No esta autorizado para realizar esta operación";
    }

    @WebMethod(operationName = "deleteUser")
    public String deleteUser(
            @WebParam(name = "currentUser") String currentUser, 
            @WebParam(name = "currentPass") String currentPass,
            @WebParam(name = "idUser") int idUser) {
       UserDaoImpl userDaoImpl=new UserDaoImpl();
        if(userDaoImpl.loginUser(currentUser, currentPass)!=null){
             User user = userDaoImpl.findUserById(idUser).get(0);
            return
               ((user!=null)?userDaoImpl.deleteUser(user):"El usuario a dar de baja no existe");
        }else return "No esta autorizado para realizar esta operación";     
    }

    @WebMethod(operationName = "listUser")
    public List<User> listUSer(
            @WebParam(name = "currentUser") String currentUser, 
            @WebParam(name = "currentPass") String currentPass,
            @WebParam(name = "username") String username) {
        UserDaoImpl userDaoImpl = new UserDaoImpl();
        if(userDaoImpl.loginUser(currentUser, currentPass)!=null){
            return userDaoImpl.findUserByName(username);
        }else return null;       
    }
    
    @WebMethod(operationName = "listUsers")
    public List<User> listUsers(
        @WebParam(name = "currentUser") String currentUser, 
        @WebParam(name = "currentPass") String currentPass)
    {
       UserDaoImpl userDaoImpl = new UserDaoImpl();
        if(userDaoImpl.loginUser(currentUser, currentPass)!=null){
             List<User> list = userDaoImpl.findAllUser();
            return list;
        }else return null;      
    }
}
