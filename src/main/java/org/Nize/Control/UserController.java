package org.Nize.Control;


import org.Nize.Models.User;
import org.Nize.Models.UserDAO;

import java.util.List;

public class UserController {
    private UserDAO userDAO;
 private CredencialesController credencialesController = new CredencialesController();
    public UserController() {
        userDAO = new UserDAO();
    }


    public int insertarUser(User user)  {
        int id = userDAO.insertarUser(user);
        credencialesController.crearCredenciales(user, id);
        return id;
    }

    public User getUser(String dni) {
        return userDAO.getUsuario(dni);
    }
}

