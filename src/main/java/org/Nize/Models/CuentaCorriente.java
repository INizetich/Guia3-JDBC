package org.Nize.Models;

import org.Nize.Imp.TiposCaja;

import java.time.LocalDateTime;

public class CuentaCorriente {
    private int id_cuenta;
    private int id_usuario;
    private double saldo;
    private String fecha;
    private String tiposCaja = TiposCaja.CAJA_AHORRO.toString();


    public CuentaCorriente(int id_cuenta, int id_usuario, double saldo, String fecha, String tiposCaja) {
        this.id_cuenta = id_cuenta;
        this.id_usuario = id_usuario;
        this.saldo = saldo;
        this.fecha = fecha;
        this.tiposCaja = tiposCaja.toString();
    }

    public int getId_cuenta() {
        return id_cuenta;
    }

    public void setId_cuenta(int id_cuenta) {
        this.id_cuenta = id_cuenta;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "id_cuenta=" + id_cuenta +
                ", id_usuario=" + id_usuario +
                ", saldo=" + saldo +
                ", fecha='" + fecha + '\'' +
                ", tiposCaja='" + tiposCaja + '\'' +
                '}';
    }
}
