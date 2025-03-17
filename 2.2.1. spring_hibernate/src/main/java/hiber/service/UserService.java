package hiber.service;

import hiber.model.Car;
import hiber.model.User;

import java.util.List;

public interface UserService {
    void add(User user);
    List<User> getByCar(String model, int series);
    void add(Car car);
    List<User> listUsers();
    void deleteTable(String table);
}
