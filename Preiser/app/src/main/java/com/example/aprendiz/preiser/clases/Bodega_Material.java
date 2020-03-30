package com.example.aprendiz.preiser.clases;

public class Bodega_Material {

    private String id;
    private Material material;
    private Bodega bodega;
    private String Fecha_Ingresa;
    private String Fecha_Salida;

    public Bodega_Material() {
    }

    public Bodega_Material(String id, Material material, Bodega bodega, String fecha_Ingresa, String fecha_Salida) {
        this.id = id;
        this.material = material;
        this.bodega = bodega;
        Fecha_Ingresa = fecha_Ingresa;
        Fecha_Salida = fecha_Salida;
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

    public Bodega getBodega() {
        return bodega;
    }

    public void setBodega(Bodega bodega) {
        this.bodega = bodega;
    }

    public String getFecha_Ingresa() {
        return Fecha_Ingresa;
    }

    public void setFecha_Ingresa(String fecha_Ingresa) {
        Fecha_Ingresa = fecha_Ingresa;
    }

    public String getFecha_Salida() {
        return Fecha_Salida;
    }

    public void setFecha_Salida(String fecha_Salida) {
        Fecha_Salida = fecha_Salida;
    }
}
