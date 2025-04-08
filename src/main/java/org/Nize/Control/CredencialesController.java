package org.Nize.Control;

import org.Nize.Models.CredencialesDAO;
import org.Nize.Models.User;

public class CredencialesController {
    private CredencialesDAO credencialesDAO;

    public CredencialesController(){
        credencialesDAO = new CredencialesDAO();
    }

    public void crearCredenciales(User user){
        credencialesDAO.crearCredenciales(user);
    }
}
