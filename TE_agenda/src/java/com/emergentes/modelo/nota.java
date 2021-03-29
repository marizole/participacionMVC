package com.emergentes.modelo;

public class nota {
    private int id;
    private String hora;
    private String actividad;
    private String completado;
    
//Constructor
    
public nota() {
 id = 0;
 hora = "";
 actividad = "";
 completado = "";
 }

    public int getId() {
        return id;
    }

    public String getHora() {
        return hora;
    }

    public String getActividad() {
        return actividad;
    }

    public String getCompletado() {
        return completado;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public void setCompletado(String completado) {
        this.completado = completado;
    }

   
}
