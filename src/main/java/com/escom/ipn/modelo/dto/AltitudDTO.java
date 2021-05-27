/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.modelo.dto;

import com.escom.ipn.modelo.entidades.Altitud;
import java.io.Serializable;

public class AltitudDTO implements Serializable{
    private Altitud entidad;

    public AltitudDTO() {
        entidad = new Altitud();
    }

    public Altitud getEntidad() {
        return entidad;
    }

    public void setEntidad(Altitud entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id Altitud: ").append(getEntidad().getIdAltitud()).append("\n");
        sb.append("valor Altitud: ").append(getEntidad().getValorAltitud()).append("\n");
        sb.append("timestamp Altitud: ").append(getEntidad().getTiempoAltitud()).append("\n");
        return sb.toString();
    }
}
