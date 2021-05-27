/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.modelo.dto;

import com.escom.ipn.modelo.entidades.Presion;
import java.io.Serializable;

public class PresionDTO implements Serializable{
    private Presion entidad;

    public PresionDTO() {
        entidad = new Presion();
    }

    public Presion getEntidad() {
        return entidad;
    }

    public void setEntidad(Presion entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id Presion: ").append(getEntidad().getIdPresion()).append("\n");
        sb.append("valor Presion: ").append(getEntidad().getValorPresion()).append("\n");
        sb.append("timestamp Presion: ").append(getEntidad().getTiempoPresion()).append("\n");
        return sb.toString();
    }
}
