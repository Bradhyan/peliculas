package com.example.prestamo_peliculas;

public class ClsPeliculas {

    private int cantidad;

    public ClsPeliculas(int cantidad) {
        this.cantidad = cantidad;
    }

    public float Calcular_valor_bruto(float valor){
        float valor_bruto=cantidad * valor;
        return valor_bruto;
    }

    public float Calcular_descuento(float valor_bruto){
        float descuento=0;
        if (cantidad >= 5)
            descuento=(valor_bruto * 10)/100;
        return descuento;
    }

    public float Calcular_valor_neto(float valor_bruto,float descuento){
        return valor_bruto - descuento;
    }
}
