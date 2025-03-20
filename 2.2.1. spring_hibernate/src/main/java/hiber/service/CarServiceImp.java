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
public class CarServiceImp implements CarService {

   @Autowired
   private CarDao userDaoCar;

   @Transactional
   @Override
   public void deleteCarTable() {
      userDaoCar.deleteCarTable();
   }

   @Transactional
   @Override
   public void add(Car car) { userDaoCar.add(car); }

   @Override
   public List<Car> listCars() {
      return userDaoCar.listCars();
   }
}
