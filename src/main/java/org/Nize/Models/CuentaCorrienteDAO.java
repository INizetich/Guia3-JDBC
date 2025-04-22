package org.Nize.Models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class CuentaCorrienteDAO {
    private Connection connection;
    public CuentaCorrienteDAO(){
        connection = Conexion.getInstance().getConnection();
    }

    public void insertarCuenta(CuentaCorriente cuentaCorriente, int id_usuario){
        String sql = "INSERT INTO Cuenta(id_usuario,tipo,saldo,fecha_creacion) VALUES(?,?,?,?)";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaActual = LocalDateTime.now();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id_usuario);
            preparedStatement.setString(2,cuentaCorriente.getTiposCaja());
            preparedStatement.setDouble(3,cuentaCorriente.getSaldo());
            preparedStatement.setString(4,fechaActual.format(formateador));
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public void abrirCajaAhorro(int id_usuario){
        String sql = "INSERT INTO Cuenta(id_usuario,tipo,saldo,fecha_creacion) VALUES(?,?,?,?)";
        DateTimeFormatter formateador = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime fechaActual = LocalDateTime.now();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sql)){
            preparedStatement.setInt(1,id_usuario);
            preparedStatement.setString(2,"CAJA_AHORRO");
            preparedStatement.setDouble(3,0);
            preparedStatement.setString(4,fechaActual.format(formateador));
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }


}
