package org.Nize.Models;

public class User {
    private int ID_Usuario;
    private String nombre;
    private String apellido;
    private String dni;
    private String email;
    private String fecha_Creacion;

    public User(String nombre, String apellido, String dni, String email){
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.email = email;
        this.fecha_Creacion = null;
        this.ID_Usuario = -1;
    }

    public int getID_Usuario() {
        return ID_Usuario;
    }

    public void setID_Usuario(int id_usuario){
        this.ID_Usuario = id_usuario;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFecha_Creacion() {
        return fecha_Creacion;
    }

    public void setFecha_Creacion(String fecha_Creacion) {
        this.fecha_Creacion = fecha_Creacion;
    }

    @Override
    public String toString() {
        return "User{" +
                "ID_Usuario=" + ID_Usuario +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", dni='" + dni + '\'' +
                ", email='" + email + '\'' +
                ", fecha_Creacion=" + fecha_Creacion +
                '}';
    }
}
