package com.example.aprendiz.preiser.clases;

public class Detalles {

    private String id;
    private Material material;
    private String estado_devolucion;
    private String cantidad;
    private String fecha_devolucion;

    public Detalles() {
    }

    public Detalles(String id, Material material, String estado_devolucion, String cantidad, String fecha_devolucion) {
        this.id = id;
        this.material = material;
        this.estado_devolucion = estado_devolucion;
        this.cantidad = cantidad;
        this.fecha_devolucion = fecha_devolucion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Material getMaterial() {
        return material;
    }

    public void setMaterial(Material material) {
        this.material = material;
    }

    public String getEstado_devolucion() {
        return estado_devolucion;
    }

    public void setEstado_devolucion(String estado_devolucion) {
        this.estado_devolucion = estado_devolucion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getFecha_devolucion() {
        return fecha_devolucion;
    }

    public void setFecha_devolucion(String fecha_devolucion) {
        this.fecha_devolucion = fecha_devolucion;
    }
}
