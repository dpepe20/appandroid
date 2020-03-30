package com.example.aprendiz.preiser.clases;

import java.util.List;

public class Material {

    private String id;
    private String tipo_elemento;
    private Nombre nombre;
    private String codigo_sena;
    private String numero_serie;
    private String cantidad;
    private String estado;
    private String imagen;
    private Categoria categoria ;
    private Cuentadante cuentadante;

    public Material() {
    }

    public Material(String id, String tipo_elemento, Nombre nombre, String codigo_sena, String numero_serie, String cantidad, String estado, String imagen, Categoria categoria, Cuentadante cuentadante) {
        this.id = id;
        this.tipo_elemento = tipo_elemento;
        this.nombre = nombre;
        this.codigo_sena = codigo_sena;
        this.numero_serie = numero_serie;
        this.cantidad = cantidad;
        this.estado = estado;
        this.imagen = imagen;
        this.categoria = categoria;
        this.cuentadante = cuentadante;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTipo_elemento() {
        return tipo_elemento;
    }

    public void setTipo_elemento(String tipo_elemento) {
        this.tipo_elemento = tipo_elemento;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre_material) {
        this.nombre = nombre_material;
    }

    public String getCodigo_sena() {
        return codigo_sena;
    }

    public void setCodigo_sena(String codigo_sena) {
        this.codigo_sena = codigo_sena;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public Cuentadante getCuentadante() {
        return cuentadante;
    }

    public void setCuentadante(Cuentadante cuentadante) {
        this.cuentadante = cuentadante;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNumero_serie() {
        return numero_serie;
    }

    public void setNumero_serie(String numero_serie) {
        this.numero_serie = numero_serie;
    }
}
