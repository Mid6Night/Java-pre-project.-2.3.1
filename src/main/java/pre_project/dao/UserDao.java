package pre_project.dao;

import pre_project.entity.User;

import java.util.List;

public interface UserDao {
    void add(User user);
    List<User> listUsers();
    void deleteUser(Long id);
    void updateUser(User user);
    User getUser(Long id);
    User getUserByName(String name);
}
