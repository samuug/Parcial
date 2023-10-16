package org.example;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import javafx.application.Platform;
import javafx.scene.chart.XYChart;
public class Buffer {

    private int producidos = 0;
    private int ensamblados = 0;
    private XYChart.Series<String, Number> series;

    private PriorityQueue<EstacionTrabajo> estaciones = new PriorityQueue<>((e1, e2) -> Integer.compare(e1.getPrioridad(), e2.getPrioridad()));
    private Queue<String> queue = new LinkedList<>();

    public Buffer(XYChart.Series<String, Number> series) {
        this.series = series;
    }

    public synchronized void producir(String componente) {
        try {
            while (queue.size() >= 10) {
                try {
                    wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            producidos++;
            Platform.runLater(() -> {
                series.getData().add(new XYChart.Data<>(String.valueOf(producidos), ensamblados));
            });
            queue.offer(componente);
            notifyAll();
        } catch (Exception e) {
            e.printStackTrace(); // Maneja la excepción de manera apropiada
        }
    }

    public synchronized String consumir() {
        while (queue.isEmpty()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        ensamblados++;

        Platform.runLater(() -> {
            series.getData().add(new XYChart.Data<>(String.valueOf(producidos), ensamblados));
        });

        String componente = queue.poll();
        notifyAll();
        return componente;
    }


    public synchronized void mostrarEstadisticas() {
            System.out.println("Componentes producidos: " + producidos);
            System.out.println("Componentes ensamblados: " + ensamblados);
        }

    public synchronized void agregarEstacion(EstacionTrabajo estacion) {
        estaciones.offer(estacion);
    }

    public synchronized void actualizarPrioridad(int id, int prioridad) {
        for (EstacionTrabajo estacion : estaciones) {
            if (estacion.getId() == id) {
                estacion.setPrioridad(prioridad);
                break;
            }
        }
    }
}


