package edu.hillel;

import edu.hillel.models.Auto;
import edu.hillel.models.User;
import edu.hillel.services.UserService;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        final UserService userService = new UserService();

        for (int i = 1; i <= 5; i++) {
            final User user = new User("Name" + i, new Random().nextInt(21) + 20);
            userService.saveUser(user);

            final Auto bmw = new Auto("BMW", "Black");
            final Auto ford = new Auto("Ford", "Red");

            bmw.setUser(user);
            ford.setUser(user);

            user.addAuto(bmw);
            user.addAuto(ford);

            userService.updateUser(user);
        }

        System.out.println(userService.findAllUsers());
    }
}
