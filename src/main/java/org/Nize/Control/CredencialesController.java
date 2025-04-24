package org.Nize.Control;

import org.Nize.Models.CredencialesDAO;
import org.Nize.Models.User;
import org.Nize.Models.UserDAO;

public class CredencialesController {
    private CredencialesDAO credencialesDAO;
    private UserDAO userDAO;

    public CredencialesController(){
        credencialesDAO = new CredencialesDAO();
    }

    public void crearCredenciales(User user, int id){
        credencialesDAO.crearCredenciales(user, id);
    }

    public User iniciarSesion(String user, String pass){
        int id = credencialesDAO.iniciarSesion(user, pass);
        if(id != -1){
            return userDAO.getUsuarioId(id);
        }
        return null;
    }
}
