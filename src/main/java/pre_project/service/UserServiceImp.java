package pre_project.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pre_project.dao.UserDao;
import pre_project.entity.User;

import java.util.List;

@Service
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDao;

   @Transactional
   @Override
   public void add(User user) {
      userDao.add(user);
   }

   @Transactional(readOnly = true)
   @Override
   public List<User> listUsers() {
      return userDao.listUsers();
   }

   @Transactional
   @Override
   public void deleteUser(Long id) {
      userDao.deleteUser(id);
   }

   @Transactional
   @Override
   public void updateUser(User user) {
      userDao.updateUser(user);
   }

   @Transactional(readOnly = true)
   @Override
   public User getUser(Long id) {
      return userDao.getUser(id);
   }

   @Transactional
   @Override
   public UserDetails loadUserByUsername(String var1) throws UsernameNotFoundException {
      return userDao.getUserByName(var1);
   }
}
