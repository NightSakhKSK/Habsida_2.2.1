package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.management.Query;
import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args) throws SQLException {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        userService.add(new User("User1", "Lastname1", "user1@mail.ru"));
        userService.add(new User("User2", "Lastname2", "user2@mail.ru"));
        userService.add(new User("User3", "Lastname3", "user3@mail.ru"));
        userService.add(new User("User4", "Lastname4", "user4@mail.ru"));

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println();
        }
        User user = new User("Toast", "Chingy", "Toast@mail.ru");
        Car car = new Car("Tesla", 444);
        user.setCar(car);
        userService.add(user);

        User user2 = new User("Lilly", "Pichu", "llp@mail.ru");
        Car car2 = new Car("Tank", 34);
        user.setCar(car2);
        userService.add(user2);

        User user3 = new User("ValkyRae", "Waifu", "ValkyRae@mail.ru");
        Car car3 = new Car("Toyota", 5);
        user.setCar(car3);
        userService.add(user3);

        List<User> users2 = userService.listUsers();
        for (User x : users) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car_model = " + user.getCar().getModel());
            System.out.println("Car_series = " + user.getCar().getSeries());
            System.out.println();
        }

        List<User> users3 = userService.findUserByCar("Tesla", 444);
        for (User x : users3) {
            System.out.println("Id = " + user.getId());
            System.out.println("First Name = " + user.getFirstName());
            System.out.println("Last Name = " + user.getLastName());
            System.out.println("Email = " + user.getEmail());
            System.out.println("Car_model = " + user.getCar().getModel());
            System.out.println("Car_series = " + user.getCar().getSeries());
            System.out.println();
            context.close();
        }
    }
}
