package com.example.aprendiz.preiser.clases;

import java.util.List;

public class Prestamo {

    private String id;
    private String fecha_prestamo;
    private String estado;
    private Aprendiz aprendiz;
    private String fecha_entrega;
    private List<Detalles> detalles;

    public Prestamo() {
    }

    public Prestamo(String id, String fecha_prestamo, String estado, Aprendiz aprendiz, String fecha_entrega, List<Detalles> detalles) {
        this.id = id;
        this.fecha_prestamo = fecha_prestamo;
        this.estado = estado;
        this.aprendiz = aprendiz;
        this.fecha_entrega = fecha_entrega;
        this.detalles = detalles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFecha_prestamo() {
        return fecha_prestamo;
    }

    public void setFecha_prestamo(String fecha_prestamo) {
        this.fecha_prestamo = fecha_prestamo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Aprendiz getAprendiz() {
        return aprendiz;
    }

    public void setAprendiz(Aprendiz aprendiz) {
        this.aprendiz = aprendiz;
    }

    public String getFecha_entrega() {
        return fecha_entrega;
    }

    public void setFecha_entrega(String fecha_entrega) {
        this.fecha_entrega = fecha_entrega;
    }

    public List<Detalles> getDetalles() {
        return detalles;
    }

    public void setDetalles(List<Detalles> detalles) {
        this.detalles = detalles;
    }
}
