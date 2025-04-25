package org.Nize.Control;

import org.Nize.Models.CuentaCorriente;
import org.Nize.Models.CuentaCorrienteDAO;

public class CuentaCorrienteController {
    CuentaCorrienteDAO ccdao = new CuentaCorrienteDAO();

    public void abrirCuentaCorriente(int id_usuario){
        ccdao.abrirCuentaCorriente( id_usuario);
    }

    public void abrirCajaAhorro(int id_usuario){
        ccdao.abrirCajaAhorro(id_usuario);
    }
}
