package org.Nize.Control;


import org.Nize.Models.User;
import org.Nize.Models.UserDAO;

public class UserController {
    private UserDAO userDAO;
    private CredencialesController credencialesController = new CredencialesController();
    private CuentaCorrienteController cuentaCorrienteController = new CuentaCorrienteController();

    public UserController() {
        userDAO = new UserDAO();
    }


    public int insertarUser(User user) {
        int id = userDAO.insertarUser(user);
        if (id != -1) {
            credencialesController.crearCredenciales(user, id);
            cuentaCorrienteController.abrirCajaAhorro(id);
        }
        return id;
    }

    public User getUser(String dni) {
        return userDAO.getUsuarioDNI(dni);
    }
}

