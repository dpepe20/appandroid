package com.example.aprendiz.preiser.clases;

import java.util.List;

public class Aprendiz {

    private String id;
    private String nombre;
    private String identificacion;
    private String tipo_documento;
    private String estado;
    private List<Ficha> ficha;

    public Aprendiz() {
    }

    public Aprendiz(String id, String nombre, String identificacion, String tipo_documento, String estado, List<Ficha> ficha) {
        this.id = id;
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.tipo_documento = tipo_documento;
        this.estado = estado;
        this.ficha = ficha;
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

    public String getTipo_documento() {
        return tipo_documento;
    }

    public void setTipo_documento(String tipo_documento) {
        this.tipo_documento = tipo_documento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public List<Ficha> getFicha() {
        return ficha;
    }

    public void setFicha(List<Ficha> ficha) {
        this.ficha = ficha;
    }
}
