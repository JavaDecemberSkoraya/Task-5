package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

   @Autowired
   private SessionFactory sessionFactory;

   @Override
   public void add(User user) {

      sessionFactory.getCurrentSession().save(user);
   }

   @Override
   @SuppressWarnings("unchecked")
   public List<User> listUsers() {
      TypedQuery<User> query=sessionFactory.getCurrentSession().createQuery("from User");
      return query.getResultList();
   }

   @Override
   public User findeOwner(String car_model, int car_series){
         TypedQuery <User> findUserQuery = sessionFactory.getCurrentSession()
                 .createQuery("FROM User u JOIN FETCH u.car c where c.model = :carModel AND c.serias = :carSeries").
                 setParameter("carModel", car_model)
                 .setParameter("carSeries", car_series);
         List <User> findUser = findUserQuery.getResultList();
         if (!findUser.isEmpty()){
            System.out.println("User find!");
            for (User user: findUser){
               System.out.println(user.getFirstName());
               return user;
            }

         }
      return null;
   }

}
