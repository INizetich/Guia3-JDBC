package org.Nize.Models;

import org.Nize.Models.Imp.Permisos;

public class Credenciales {
    private int ID_Credencial;
    private int ID_Usuario;
    private String userName;
    private String password;
    private Permisos permisos = Permisos.CLIENTE;

    public Credenciales(int ID_Usuario, String userName, String password) {
        this.ID_Usuario = ID_Usuario;
        this.userName = userName;
        this.password = password;
    }

    public int getID_Credencial() {
        return ID_Credencial;
    }



    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int ID_Usuario) {
        this.ID_Usuario = ID_Usuario;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Permisos getPermisos() {
        return permisos;
    }

    public void setPermisos(Permisos permisos) {
        this.permisos = permisos;
    }

    @Override
    public String toString() {
        return "Credenciales{" +
                "ID_Credencial=" + ID_Credencial +
                ", ID_Usuario=" + ID_Usuario +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
