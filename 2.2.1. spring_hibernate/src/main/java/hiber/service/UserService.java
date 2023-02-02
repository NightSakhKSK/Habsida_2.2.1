package hiber.service;

import hiber.model.User;

import javax.management.Query;
import java.util.List;

public interface UserService {
    void add(User user);
    List<User> listUsers();
    List<User> findUserByCar(String carModel, int carSeries);
}
