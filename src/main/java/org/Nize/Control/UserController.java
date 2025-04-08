package org.Nize.Control;

import org.Nize.Models.User;
import org.Nize.Models.UserDAO;

public class UserController {
    private UserDAO userDAO;

    public UserController(){
        userDAO = new UserDAO();
    }


    public void insertarUser(User user){
        userDAO.insertarUser(user);
        userDAO.crearCredenciales(user);
    }
}
