package org.example;

import static org.example.App.ALTO_TABLERO;
import static org.example.App.RADIO_BOLA;

public class Bola {
    private double x;
    private double y;
    private double velocidad;

    public Bola(double x, double y, double velocidad) {
        this.x = x;
        this.y = y;
        this.velocidad = velocidad;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setPosicion(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void actualizar() {
        y += velocidad;

        // Verificar colisión con el suelo
        if (y + RADIO_BOLA > ALTO_TABLERO) {
            y = ALTO_TABLERO - RADIO_BOLA;  // Ajustar la posición para que esté en el suelo
            velocidad = 0;  // Detener la bola
        }
    }
}