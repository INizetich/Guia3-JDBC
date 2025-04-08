package org.Nize.Control;

import org.Nize.Models.CuentaCorriente;
import org.Nize.Models.User;
import org.Nize.Models.UserDAO;

import java.util.List;

public class UserController {
    private UserDAO userDAO;

    public UserController(){
        userDAO = new UserDAO();
    }


    public void insertarUser(User user){
        userDAO.insertarUser(user);
    }

    public User getUser(String dni){
        return userDAO.getUsuario(dni);
    }


    public List<CuentaCorriente> listarCuentasCorrientes(int id){
        return userDAO.listarCuentasCorrientes(id);
    }
}
