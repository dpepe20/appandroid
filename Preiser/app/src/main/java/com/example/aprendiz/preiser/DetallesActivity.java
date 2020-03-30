package com.example.aprendiz.preiser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.aprendiz.preiser.clases.Prestamo;

public class DetallesActivity extends AppCompatActivity {
    public static Prestamo prestamolist = new Prestamo();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_prestamo);
        fijarDatos();

        }

    private void fijarDatos() {

        TextView aprendiz, estado, ficha, encargado, elemento, codigo_sena, fecha_entrgado, fecha_prestamo, serial;

        aprendiz = findViewById(R.id.txtaprendizDP);
        estado = findViewById(R.id.txtestadoDP);
        ficha = findViewById(R.id.txtfichaDP);
        encargado = findViewById(R.id.txtencargadoDP);
        elemento = findViewById(R.id.txtelementoDP);
        codigo_sena = findViewById(R.id.txtcodigo_senaDP);
        fecha_entrgado = findViewById(R.id.txtfecha_entregaDP);
        fecha_prestamo = findViewById(R.id.txtfecha_prestamoDP);
        serial = findViewById(R.id.txtserialDP);

        aprendiz.setText(prestamolist.getAprendiz().getNombre());
        estado.setText(prestamolist.getEstado());
        ficha.setText(prestamolist.getAprendiz().getFicha().get(0).getNumero_ficha());
        encargado.setText(prestamolist.getDetalles().get(0).getMaterial().getCuentadante().getNombre());
        elemento.setText(prestamolist.getDetalles().get(0).getMaterial().getNombre().getNombre());
        codigo_sena.setText(prestamolist.getDetalles().get(0).getMaterial().getCodigo_sena());
        fecha_entrgado.setText(prestamolist.getFecha_entrega());
        fecha_prestamo.setText(prestamolist.getFecha_prestamo());
        serial.setText(prestamolist.getDetalles().get(0).getMaterial().getNumero_serie());
    }
}

