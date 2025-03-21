package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.CarService;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);
      CarService carService = context.getBean(CarService.class);

      userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
      userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.add(new User("User3", "Lastname3", "user3@mail.ru"));

      carService.add(new Car("Honda", 100));
      carService.add(new Car("Ford", 200));
      carService.add(new Car("Audi", 300));

      List<User> users = userService.listUsers();
      for (User user : users) {
         System.out.println("Id = " + user.getId());
         System.out.println("First Name = " + user.getFirstName());
         System.out.println("Last Name = " + user.getLastName());
         System.out.println("Email = " + user.getEmail());
         System.out.println("Car = " + user.getCarId());
         System.out.println();
      }

      List<Car> cars = carService.listCars();
      for (Car car : cars) {
         System.out.println("Id = " + car.getId());
         System.out.println("Model = " + car.getModel());
         System.out.println("Series = " + car.getSeries());
         System.out.println();
      }

      for (int i = 0; i < cars.size(); i++) {
         users.get(i).setCarId(cars.get(i));
         userService.add(users.get(i));
      }

      List<User> usersWithHonda = userService.getByCar("Honda", 100);
      List<User> usersWithFord = userService.getByCar("Ford", 200);
      List<User> usersWithAudi = userService.getByCar("Audi", 300);

      for (User user : usersWithHonda) {
         System.out.println(user);
      }

      for (User user : usersWithFord) {
         System.out.println(user);
      }

      for (User user : usersWithAudi) {
         System.out.println(user);
      }

     /* добавил два метода удаления таблиц для упрощения тестирования,
      * чтобы не плодить одинаковых пользователей в таблице каждый раз
      * при вызове метода MainApp
      */
      userService.deleteUserTable();
      carService.deleteCarTable();

      context.close();
   }
}
