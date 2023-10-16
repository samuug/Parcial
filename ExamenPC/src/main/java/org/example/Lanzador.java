package org.example;

import javafx.scene.chart.XYChart;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Lanzador {
    public static void main(String[] args) {
        XYChart.Series<String, Number> series = new XYChart.Series<>();

        Buffer buffer = new Buffer(series);
        ExecutorService executor = Executors.newCachedThreadPool();

        // Crear instancias de EstacionTrabajo con diferentes prioridades
        for (int i = 0; i < 10; i++) {
            EstacionTrabajo estacion = new EstacionTrabajo(buffer, i, i);
            buffer.agregarEstacion(estacion);
            executor.execute(estacion);
        }

        // Crear instancia de LineaEnsamblaje y ejecutar hilo
        LineaEnsamblaje lineaEnsamblaje = new LineaEnsamblaje(buffer);
        executor.execute(lineaEnsamblaje);

        // Cerrar el ExecutorService después de que todos los hilos hayan terminado
        executor.shutdown();
    }
}