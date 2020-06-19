package pre_project.dao;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pre_project.entity.Role;
import pre_project.entity.User;

@Repository
public class RoleDaoIml implements RoleDao{
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Role getByName(String name) {
        return (Role) sessionFactory.getCurrentSession()
                .createQuery("from Role where name = :name")
                .setParameter("name", name)
                .uniqueResult();
    }
}
