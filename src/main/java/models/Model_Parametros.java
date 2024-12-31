/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Model_Parametros", propOrder = {
    "indicador",
    "fechaInicio",
    "fechaFinal",
    "nombre",
    "subnivel",
    "correo",
    "token"
})
public class Model_Parametros {
    protected String indicador;
    protected String fechaInicio;
    protected String fechaFinal;
    protected String nombre;
    protected String subnivel;
    
    protected String correo;
    protected String token;

    public String getIndicador() {
        return indicador;
    }
    public void setIndicador(String indicador) {
        this.indicador = indicador;
    }

    public String getFechaInicio() {
        return fechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getFechaFinal() {
        return fechaFinal;
    }
    public void setFechaFinal(String fechaFinal) {
        this.fechaFinal = fechaFinal;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSubnivel() {
        return subnivel;
    }
    public void setSubnivel(String subnivel) {
        this.subnivel = subnivel;
    }

    public String getCorreo() {
        return correo;
    }
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getToken() {
        return token;
    }
    public void setToken(String token) {
        this.token = token;
    }
}
