package com.example.aprendiz.preiser.clases;

/**
 * Created by APRENDIZ on 16/11/2018.
 */

public class InfoAcercaDe {
    private String nombre;
    private String equipo;
    private String telefono;
    private int img;


    public InfoAcercaDe() {
    }

    public InfoAcercaDe(String nombre, String equipo, String telefono, int img) {
        this.nombre = nombre;
        this.equipo = equipo;
        this.telefono = telefono;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public int getImg(){
        return img;
    }

    public void setImg(int img){
        this.img=img;
    }

    @Override
    public String toString() {
        return "InfoAcercaDe{" +
                "nombre='" + nombre + '\'' +
                ", equipo='" + equipo + '\'' +
                ", telefono='" + telefono + '\'' +
                ", img=" + img +
                '}';
    }
}
