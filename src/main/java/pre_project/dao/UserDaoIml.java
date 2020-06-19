package pre_project.dao;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pre_project.entity.Role;
import pre_project.entity.User;
import pre_project.service.RoleService;

import java.util.List;

@Repository
public class UserDaoIml implements UserDao {
    @Autowired
    private SessionFactory sessionFactory;




    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        Query query = sessionFactory.getCurrentSession().createQuery("from User");
        return query.getResultList();
    }

    @Override
    public void deleteUser(Long id) {
        sessionFactory.getCurrentSession().createQuery("delete User where id = :id ")
                .setParameter("id", id)
                .executeUpdate();
    }

    @Override
    public void updateUser(User user) {
        sessionFactory.getCurrentSession().createQuery("update User set firstName = :firstName, lastName = :lastName" +
                ", email = :email" +
                " where id = :id")
                .setParameter("id", user.getId())
                .setParameter("firstName", user.getFirstName())
                .setParameter("lastName", user.getLastName())
                .setParameter("email", user.getEmail())
                .executeUpdate();
    }

    @Override
    public User getUser(Long id) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User where id = :id")
                .setParameter("id", id)
                .uniqueResult();
    }

    @Override
    public User getUserByName(String name) {
        return (User) sessionFactory.getCurrentSession()
                .createQuery("from User where name = :name")
                .setParameter("name", name)
                .uniqueResult();
    }

}
