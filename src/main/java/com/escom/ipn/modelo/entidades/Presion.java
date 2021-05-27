/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.modelo.entidades;

import java.io.Serializable;
import java.sql.Timestamp;

public class Presion implements Serializable{
    private int idPresion;
    private float valorPresion;
    private Timestamp tiempoPresion;

    public Presion() {
    }

    public int getIdPresion() {
        return idPresion;
    }

    public void setIdPresion(int idPresion) {
        this.idPresion = idPresion;
    }

    public float getValorPresion() {
        return valorPresion;
    }

    public void setValorPresion(float valorPresion) {
        this.valorPresion = valorPresion;
    }

    public Timestamp getTiempoPresion() {
        return tiempoPresion;
    }

    public void setTiempoPresion(Timestamp tiempoPresion) {
        this.tiempoPresion = tiempoPresion;
    }
}
