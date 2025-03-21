package hiber.service;

import hiber.dao.CarDao;
import hiber.dao.UserDao;
import hiber.model.Car;
import hiber.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class UserServiceImp implements UserService {

   @Autowired
   private UserDao userDaoUser;

   @Transactional
   @Override
   public void deleteUserTable() {
      userDaoUser.deleteUserTable();
   }

   @Transactional
   @Override
   public void add(User user) {
      userDaoUser.add(user);
   }

   @Override
   public List<User> getByCar(String model, int series) {
      return userDaoUser.getByCar(model, series);
   }

   @Override
   public List<User> listUsers() {
      return userDaoUser.listUsers();
   }
}
