package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
   public static void main(String[] args) throws SQLException {
      AnnotationConfigApplicationContext context =
            new AnnotationConfigApplicationContext(AppConfig.class);

      UserService userService = context.getBean(UserService.class);

      User user1 = new User("User1", "Lastname1", "user1@mail.ru");
      User user2 = new User("User2", "Lastname2", "user2@mail.ru");
      User user3 = new User("User3", "Lastname3", "user3@mail.ru");
      Car car1 = new Car("Honda", 100);
      Car car2 = new Car("Ford", 200);

      user1.setCarId(car2);
      user2.setCarId(car1);
      user3.setCarId(car1);

      userService.add(user1);
      userService.add(user2);
      userService.add(user3);

      List<User> users = userService.listUsers();
      //оставляю на всякий случай т.к. это было изначальной заготовке
      for (User user : users) {
         System.out.println("Id = "+user.getId());
         System.out.println("First Name = "+user.getFirstName());
         System.out.println("Last Name = "+user.getLastName());
         System.out.println("Email = "+user.getEmail());
         System.out.println();
      }

      List<User> usersWithHonda = userService.getByCar("Honda", 100);
      List<User> usersWithFord = userService.getByCar("Ford", 200);

      for (User user : usersWithHonda) {
         System.out.println(user);
      }

      for (User user : usersWithFord) {
         System.out.println(user);
      }

     /* добавил два метода удаления таблиц для упрощения тестирования,
      * чтобы не плодить одинаковых пользователей в таблице каждый раз
      * при вызове метода MainApp
      */
      userService.deleteTable("users");
      userService.deleteTable("cars");

      context.close();
   }
}
