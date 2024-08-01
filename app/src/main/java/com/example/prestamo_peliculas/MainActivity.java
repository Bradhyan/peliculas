package com.example.prestamo_peliculas;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView jtvbruto,jtvdescuento,jtvneto,jtvmensaje1,jtvmensaje2,jtvmensaje3;
    EditText jetcantidad,jetvalor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Ocultar la barra de titulo por defecto y asociar objetos Java con Xml
        getSupportActionBar().hide();
        jtvbruto=findViewById(R.id.tvbruto);
        jtvdescuento=findViewById(R.id.tvdescuento);
        jtvneto=findViewById(R.id.tvneto);
        jtvmensaje1=findViewById(R.id.tvmensaje1);
        jtvmensaje2=findViewById(R.id.tvmensaje2);
        jtvmensaje3=findViewById(R.id.tvmensaje3);
        jetcantidad=findViewById(R.id.etcantidad);
        jetvalor=findViewById(R.id.etvalor);
    }//onCreate

    public void Calcular(View view){
        String cantidad,valor;
        cantidad=jetcantidad.getText().toString();
        valor=jetvalor.getText().toString();
        //Validar que si digitaron numeros
        if (cantidad.isEmpty() || valor.isEmpty()){
            Toast.makeText(this, "Los valores son requeridos", Toast.LENGTH_SHORT).show();
            jetcantidad.requestFocus();
        }else{
            int cantidad_peliculas;
            float valor_pelicula,valor_bruto,descuento,valor_neto;
            //Conversiones de texto a numerico
            cantidad_peliculas=Integer.parseInt(cantidad);
            valor_pelicula=Float.parseFloat(valor);
            //Instanciar la clase
            ClsPeliculas objpeliculas=new ClsPeliculas(cantidad_peliculas);
            valor_bruto=objpeliculas.Calcular_valor_bruto(valor_pelicula);
            descuento=objpeliculas.Calcular_descuento(valor_bruto);
            valor_neto=objpeliculas.Calcular_valor_neto(valor_bruto,descuento);
            //Mostrar resultados
            jtvbruto.setText(String.valueOf(valor_bruto));
            jtvdescuento.setText(String.valueOf(descuento));
            jtvneto.setText(String.valueOf(valor_neto));
            jtvmensaje1.setVisibility(View.VISIBLE);
            jtvmensaje2.setVisibility(View.VISIBLE);
            jtvmensaje3.setVisibility(View.VISIBLE);
        }
    }//fin calcular

    public void Limpiar(View view){
        jtvbruto.setText("");
        jtvdescuento.setText("");
        jtvneto.setText("");
        jetcantidad.setText("");
        jetvalor.setText("");
        jtvmensaje1.setVisibility(View.INVISIBLE);
        jtvmensaje2.setVisibility(View.INVISIBLE);
        jtvmensaje3.setVisibility(View.INVISIBLE);
        jetcantidad.requestFocus();
    }//fin limpiar
}