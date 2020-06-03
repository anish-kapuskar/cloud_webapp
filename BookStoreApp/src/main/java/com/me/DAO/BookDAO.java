package com.me.DAO;

import com.me.bean.Book;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


/**
 *
 * @author anish
 */
public class BookDAO {
    private Session session=null;
   private static final SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();   
   private Session getSession(){
       if(session==null || !session.isOpen()){
           session = sf.openSession();
       }
       return session;
   }

   public int addBook(Book book) {
        int result = 0;
        try {
            getSession().beginTransaction();
            getSession().save(book);
            getSession().getTransaction().commit();
             result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
            getSession().getTransaction().rollback();
        } finally {
            getSession().close();
        }
        return result;
    }
    
/**    public Book browseBook(String key, String value){
//        String query  ="";
        Query q = null;
        System.out.println("key is: "+key);
        switch(key){
            case "name":
                q = getSession().createQuery("from Book where name = :searchValue");
                break;
            case "email":
                q = getSession().createQuery("from Book where email= :searchValue");
                break;
            case "age":
                q = getSession().createQuery("from Book where age= :searchValue");
                break;
        }
                  
        try {
            getSession().beginTransaction();
//            Query q = getSession().createQuery(query);
            q.setParameter("searchValue", value);
            Book book =(Book) q.uniqueResult();
            return book;
//       
        } catch (HibernateException e) {
            e.printStackTrace();
            return null;
        } finally {
            getSession().close();
        }
    } 
    */
public List<Book> searchBookbyAll(String keyword){

    List<Book> mov = new ArrayList<Book>();
    try{
        getSession().beginTransaction();
        Query q = getSession().createQuery("from Book WHERE seller NOT LIKE :keyword");
        q.setString("keyword", "%"+keyword+"%");
        mov = q.list();
        getSession().getTransaction().commit();
    } catch(HibernateException ex){
        ex.printStackTrace();
        getSession().getTransaction().rollback();
    } finally{
        getSession(). close();
    }

    return mov;
}
     public List<Book> searchBookbySeller(String keyword){
       
        List<Book> mov = new ArrayList<Book>();
        try{
            getSession().beginTransaction();
            Query q = getSession().createQuery("from Book WHERE seller LIKE :keyword");
            q.setString("keyword", "%"+keyword+"%");
            mov = q.list();
            getSession().getTransaction().commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
            getSession().getTransaction().rollback();
        } finally{
           getSession(). close();
        }
       
        
        return mov;
    }
        public List<Book> searchBookbyEmail(String keyword){
       
        List<Book> mov = new ArrayList<Book>();
        try{
            getSession().beginTransaction();
            Query q = getSession().createQuery("from Book WHERE isbn LIKE :keyword");
            q.setString("keyword", "%"+keyword+"%");
            mov = q.list();
            getSession().getTransaction().commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
            getSession().getTransaction().rollback();
        } finally{
           getSession(). close();
        }
       
        
        return mov;
    }
           public List<Book> searchBookbyDate(String keyword){
       
        List<Book> mov = new ArrayList<Book>();
        try{
            getSession().beginTransaction();
            Query q = getSession().createQuery("from Book WHERE date LIKE :keyword");
            q.setString("keyword", "%"+keyword+"%");
            mov = q.list();
            getSession().getTransaction().commit();
        } catch(HibernateException ex){
            ex.printStackTrace();
            getSession().getTransaction().rollback();
        } finally{
           getSession(). close();
        }
       
        
        return mov;
    }
           
        public int deleteBookById(int id){
              int result = 0;
        try {
            getSession().beginTransaction();
            org.hibernate.Query q = getSession().createQuery("from Book where id= :id");
            q.setInteger("id", id);
            Book bookToDelete = (Book)q.uniqueResult();
            getSession().delete(bookToDelete);
            getSession().getTransaction().commit();
             result = 1;
        } catch (HibernateException e) {
            e.printStackTrace();
           getSession().getTransaction().rollback();
        } finally {
            getSession(). close();
        }
         return result;
    }
        
        public Book getBookById(int id){
             
        try {
            getSession().beginTransaction();
            org.hibernate.Query q = getSession().createQuery("from Book where id= :id");
            q.setInteger("id", id);
            Book bookGetId = (Book)q.uniqueResult();
             return bookGetId;
        } catch (HibernateException e) {
            e.printStackTrace();
           getSession().getTransaction().rollback();
        } finally {
            getSession(). close();
        }
         return null;
    }
        
        public int updateBook(int id, String isbn, String title, String authors, String date, int quantity, double price, String seller,String time)
        {
        int result =0;
        try{
            getSession().beginTransaction();
            Query q = getSession().createQuery("from Book where id= :id");
             q.setInteger("id", id);
              Book bookUpdate = (Book)q.uniqueResult();
              bookUpdate.setIsbn(isbn);
              bookUpdate.setTitle(title);
              bookUpdate.setAuthors(authors);
              bookUpdate.setDate(date);
              bookUpdate.setQuantity(quantity);
              bookUpdate.setPrice(price);
            bookUpdate.setSeller(seller);
            bookUpdate.setTime(time);

              
               getSession().save(bookUpdate);
            getSession().getTransaction().commit();
             result = 1;
              
        }catch(HibernateException e) {
            e.printStackTrace();
           getSession().getTransaction().rollback();
        } finally {
            getSession(). close();
        }
        return result;
        }
     
    

}
