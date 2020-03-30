package com.example.aprendiz.preiser.clases;

public class Cuentadante {

    private String id;
    private String nombre;
    private String identificacion;

    public Cuentadante() {
    }

    public Cuentadante(String id, String nombre, String identificacion) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }
}
