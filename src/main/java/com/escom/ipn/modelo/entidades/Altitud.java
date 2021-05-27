/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.modelo.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

public class Altitud implements Serializable{
    private int idAltitud;
    private float valorAltitud;
    private Timestamp tiempoAltitud;

    public Altitud() {
    }

    public int getIdAltitud() {
        return idAltitud;
    }

    public void setIdAltitud(int idAltitud) {
        this.idAltitud = idAltitud;
    }

    public float getValorAltitud() {
        return valorAltitud;
    }

    public void setValorAltitud(float valorAltitud) {
        this.valorAltitud = valorAltitud;
    }

    public Timestamp getTiempoAltitud() {
        return tiempoAltitud;
    }

    public void setTiempoAltitud(Timestamp tiempoAltitud) {
        this.tiempoAltitud = tiempoAltitud;
    }
}
