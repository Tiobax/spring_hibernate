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

      userService.addUser(new User("User1", "Lastname1", "user1@mail.ru", new Car("Mersedes", "S1")));
      userService.addUser(new User("User2", "Lastname2", "user2@mail.ru"));
      userService.addUser(new User("User3", "Lastname3", "user3@mail.ru", new Car("Reno", "Logan")));
      userService.addUser(new User("User4", "Lastname4", "user4@mail.ru", new Car("Lada", "Kalina")));

      List<User> users = userService.listUsers();
      for (User tmp : users) {
         System.out.println("Id = " + tmp.getId());
         System.out.println("First Name = " + tmp.getFirstName());
         System.out.println("Last Name = " + tmp.getLastName());
         System.out.println("Email = " + tmp.getEmail());
         System.out.println();
      }

      List<User> user = userService.userByCar("Reno", "Logan");
      for (User tmp : user) {
         System.out.println("Id = " + tmp.getId());
         System.out.println("First Name = " + tmp.getFirstName());
         System.out.println("Last Name = " + tmp.getLastName());
         System.out.println("Email = " + tmp.getEmail());
         System.out.println();
      }
      context.close();
   }
}
