package org.example;

import org.example.DataAccessObject.UserDao;
import org.example.DataTransferObject.UserDto;
import org.example.impl.MySqlJdbcUserDao;

import java.math.BigDecimal;

public class DaoDemo {

    public static void main(String[] args) {

        /*
        An instance of UserDao is created, which represents the Data Access Object for
        interacting with user data in the database. It is assigned an instance of
        MySqlJdbcUserDao, which is a specific implementation of the UserDao interface.
         */
        UserDao userDao = new MySqlJdbcUserDao();

        /*
         * The getUserById method of the UserDao object is called with an argument of 3 to
         * retrieve a UserDto object representing a user with the given ID.
         */
        UserDto user = userDao.getUserById(3);

        System.out.println(user);

        /*
        the getUserByEmail method of the UserDao object is called, passing the email address of
        the retrieved user as an argument. This method retrieves a UserDto object based on the
        provided email address.
         */
        System.out.println(userDao.getUserByEmail(user.getEmail()));

        /*
         * A new UserDto object named newUser is created and its properties (firstName, lastName,
         * email, and money) are set.
         */
        UserDto newUser = new UserDto();
        newUser.setFirstName("Evheniy");
        newUser.setLastName("Kachanov");
        newUser.setEmail("e.kachanov@email.com");
        newUser.setMoney(BigDecimal.valueOf(1000));

        /*
        The saveUser method of the UserDao object is called, passing the newUser object as an
        argument. This method saves the newUser object to the database.
         */
        userDao.saveUser(newUser);

        System.out.println(userDao.getUserByEmail("e.kachanov@email.com"));
    }
}
