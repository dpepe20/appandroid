package com.example.aprendiz.preiser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.aprendiz.preiser.clases.Bodega_Material;
import com.example.aprendiz.preiser.clases.Prestamo;

import java.util.List;

public class Detalles_Elemento extends AppCompatActivity {
    public static Bodega_Material bodega_materialList = new Bodega_Material();
    public static Prestamo prestamolista = new Prestamo();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles__elemento);
        fijarDatos();
    }

    private void fijarDatos() {
        TextView ambiente, marca, categoria, encargado, estado, serie, codigo_sena;

        ambiente = findViewById(R.id.txtambienteDE);
        marca = findViewById(R.id.txtmarcaDE);
        categoria = findViewById(R.id.txtcategoriaDE);
        encargado = findViewById(R.id.txtencargadoDE);
        estado = findViewById(R.id.txtestado_prestamoDE);
        serie = findViewById(R.id.txtserialDE);
        codigo_sena = findViewById(R.id.txtcodigo_senaDE);

        ambiente.setText(bodega_materialList.getBodega().getNombre());
        marca.setText(bodega_materialList.getMaterial().getNombre().getNombre());
        categoria.setText(bodega_materialList.getMaterial().getCategoria().getNombre());
        encargado.setText(bodega_materialList.getMaterial().getCuentadante().getNombre());
        estado.setText(prestamolista.getEstado());
        serie.setText(bodega_materialList.getMaterial().getNumero_serie());
        codigo_sena.setText(prestamolista.getDetalles().get(0).getMaterial().getCodigo_sena());

    }
}
