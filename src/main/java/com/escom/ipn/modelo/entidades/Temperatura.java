/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.modelo.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

public class Temperatura implements Serializable{
    private int idTemperatura;
    private float valorTemperatura;
    private Timestamp tiempoTemperatura;

    public Temperatura() {
    }

    public int getIdTemperatura() {
        return idTemperatura;
    }

    public void setIdTemperatura(int idTemperatura) {
        this.idTemperatura = idTemperatura;
    }

    public float getValorTemperatura() {
        return valorTemperatura;
    }

    public void setValorTemperatura(float valorTemperatura) {
        this.valorTemperatura = valorTemperatura;
    }

    public Timestamp getTiempoTemperatura() {
        return tiempoTemperatura;
    }

    public void setTiempoTemperatura(Timestamp tiempoTemperatura) {
        this.tiempoTemperatura = tiempoTemperatura;
    }
}
