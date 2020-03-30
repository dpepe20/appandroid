package com.example.aprendiz.preiser.clases;

public class Ficha {

    private String numero_ficha;
    private String fecha_inicio;
    private String fecha_finalizacion;
    private String listado;
    private Programa programa;

    public Ficha() {
    }

    public Ficha(String numero_ficha, String fecha_inicio, String fecha_finalizacion, String listado, Programa programa) {
        this.numero_ficha = numero_ficha;
        this.fecha_inicio = fecha_inicio;
        this.fecha_finalizacion = fecha_finalizacion;
        this.listado = listado;
        this.programa = programa;
    }

    public String getNumero_ficha() {
        return numero_ficha;
    }

    public void setNumero_ficha(String numero_ficha) {
        this.numero_ficha = numero_ficha;
    }

    public String getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(String fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public String getFecha_finalizacion() {
        return fecha_finalizacion;
    }

    public void setFecha_finalizacion(String fecha_finalizacion) {
        this.fecha_finalizacion = fecha_finalizacion;
    }

    public String getListado() {
        return listado;
    }

    public void setListado(String listado) {
        this.listado = listado;
    }

    public Programa getPrograma() {
        return programa;
    }

    public void setPrograma(Programa programa) {
        this.programa = programa;
    }
}
