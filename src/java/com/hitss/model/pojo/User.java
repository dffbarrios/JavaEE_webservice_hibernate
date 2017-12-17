package com.hitss.model.pojo;
import java.util.Date;
import java.io.Serializable;

public class User  implements Serializable {

     private Integer usrId;
     private String usrName;
     private String usrLastname;
     private String usrUsername;
     private String usrPassword;
     private Date usrCreationdate;
     private String usrEtaid;

    public User() {
    }

    public User(String usrName, String usrLastname, 
            String usrUsername, String usrPassword, 
            Date usrCreationdate, String usrEtaid) {
       this.usrName = usrName;
       this.usrLastname = usrLastname;
       this.usrUsername = usrUsername;
       this.usrPassword = usrPassword;
       this.usrCreationdate = usrCreationdate;
       this.usrEtaid = usrEtaid;
    }
   
    public Integer getUsrId() {
        return this.usrId;
    }
    
    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }
    public String getUsrName() {
        return this.usrName;
    }
    
    public void setUsrName(String usrName) {
        this.usrName = usrName;
    }
    public String getUsrLastname() {
        return this.usrLastname;
    }
    
    public void setUsrLastname(String usrLastname) {
        this.usrLastname = usrLastname;
    }
    public String getUsrUsername() {
        return this.usrUsername;
    }
    
    public void setUsrUsername(String usrUsername) {
        this.usrUsername = usrUsername;
    }
    public String getUsrPassword() {
        return this.usrPassword;
    }
    
    public void setUsrPassword(String usrPassword) {
        this.usrPassword = usrPassword;
    }
    public Date getUsrCreationdate() {
        return this.usrCreationdate;
    }
    
    public void setUsrCreationdate(Date usrCreationdate) {
        this.usrCreationdate = usrCreationdate;
    }
    public String getUsrEtaid() {
        return this.usrEtaid;
    }
    
    public void setUsrEtaid(String usrEtaid) {
        this.usrEtaid = usrEtaid;
    }
}


