package com.hitss.model.dao;
import org.hibernate.Session;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class HibernateUtil {
    private SessionFactory sessionFactory;
    private Session session = null;
    private Transaction transaction = null;
    
    public HibernateUtil(){
        this.sessionFactory = null;
        this.session = null;
        this.transaction = null;
        this.createSession();
    }
    
    private void createSession(){
        try{
            sessionFactory = new AnnotationConfiguration()
                                .configure()
                                .buildSessionFactory();
            this.session = this.getSessionFactory().openSession();
            this.transaction = session.beginTransaction();                                
        }catch(Throwable ex){
            System.err.println("Initial SessionFactory creation failed." + ex);
        }
    }
    
    private SessionFactory getSessionFactory(){
        return this.sessionFactory;
    }
    
    public Session getSession(){
        return this.session;
    }
    
    public Transaction getTransaction(){
        return this.transaction;
    }
    
    public void closeSession(){
        this.session.close();
    }
    
    public void tryRollBack(){
        this.transaction.rollback();
    }
    
//private static final SessionFactory sessionFactory;
    
    /*static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }*/
    
    /*public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }*/

}