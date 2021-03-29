package com.emergentes.modelo;

public class Persona {
    private int id;
    private String nombres;
    private String apellidos;
    private int edad;
    
//Constructor
    
public Persona() {
 id = 0;
 nombres = "";
 apellidos = "";
 edad = 0;
 }

    public int getId() {
        return id;
    }

    public String getNombres() {
        return nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public int getEdad() {
        return edad;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }    
}
