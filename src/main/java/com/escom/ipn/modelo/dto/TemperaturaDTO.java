/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.escom.ipn.modelo.dto;

import com.escom.ipn.modelo.entidades.Temperatura;
import java.io.Serializable;

public class TemperaturaDTO implements Serializable{
    private Temperatura entidad;

    public TemperaturaDTO() {
        entidad = new Temperatura();
    }

    public Temperatura getEntidad() {
        return entidad;
    }

    public void setEntidad(Temperatura entidad) {
        this.entidad = entidad;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id Temperatura: ").append(getEntidad().getIdTemperatura()).append("\n");
        sb.append("valor Temperatura: ").append(getEntidad().getValorTemperatura()).append("\n");
        sb.append("timestamp Temperatura: ").append(getEntidad().getTiempoTemperatura()).append("\n");
        return sb.toString();
    }
}
