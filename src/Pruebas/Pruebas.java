/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Pruebas;

import Negocio.Hospedaje;
import Negocio.LogicaHospedajes;
import java.security.Timestamp;

/**
 *
 * @author josue
 */
public class Pruebas {
    public static void main(String[] args) {
        LogicaHospedajes logi = new LogicaHospedajes();
        System.out.println(logi.getNroDiasDisponibles("2"));
        for (Hospedaje h : logi.cargarHospedajes("")) {
            System.out.println(h.toString());
        }
    }
}
