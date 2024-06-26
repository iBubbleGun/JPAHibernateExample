package edu.hillel.services;

import edu.hillel.dao.UserDao;
import edu.hillel.models.Auto;
import edu.hillel.models.User;

import java.util.List;

public class UserService {

    private final UserDao usersDao = new UserDao();

    public User findUser(int id) {
        return usersDao.findById(id);
    }

    public void saveUser(User user) {
        usersDao.save(user);
    }

    public void deleteUser(User user) {
        usersDao.delete(user);
    }

    public void updateUser(User user) {
        usersDao.update(user);
    }

    public List<User> findAllUsers() {
        return usersDao.findAll();
    }

    public Auto findAutoById(int id) {
        return usersDao.findAutoById(id);
    }
}
