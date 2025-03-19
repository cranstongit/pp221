package hiber.dao;

import hiber.model.Car;

import java.util.List;

public interface UserDaoCar {
   void add(Car car);
   List<Car> listCars();
   void deleteCarTable();
}
