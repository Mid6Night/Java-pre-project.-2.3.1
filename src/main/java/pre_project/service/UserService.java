package pre_project.service;


import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import pre_project.entity.User;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {
    void add(User user);
    List<User> listUsers();
    void deleteUser(Long id);
    void updateUser(User user);
    User getUser(Long id);
}
