package hiber.service;

import hiber.dao.UserDaoCar;
import hiber.dao.UserDaoUser;
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
   private UserDaoUser userDaoUser;

   @Autowired
   private UserDaoCar userDaoCar;

   @Transactional
   @Override
   public void deleteCarTable() {
      userDaoCar.deleteCarTable();
   }

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

   @Transactional
   @Override
   public void add(Car car) { userDaoCar.add(car); }

   @Override
   public List<User> getByCar(String model, int series) {
      return userDaoUser.getByCar(model, series);
   }

   @Override
   public List<User> listUsers() {
      return userDaoUser.listUsers();
   }

   @Override
   public List<Car> listCars() {
      return userDaoCar.listCars();
   }
}
