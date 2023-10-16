package org.example;

public class EstacionTrabajo implements Runnable {
    private Buffer buffer;
    private int id;
    private int prioridad;

    public EstacionTrabajo(Buffer buffer, int id, int prioridad) {
        this.buffer = buffer;
        this.id = id;
        this.prioridad = prioridad;
    }

    public int getId() {
        return id;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }

    @Override
    public void run() {
        try {
            // Simulación de producción de componentes
            for (int i = 0; i < 100; i++) {
                String componente = "Componente-" + i + " de EstacionTrabajo-" + id;
                buffer.producir(componente);
                System.out.println(componente + " producido por EstacionTrabajo-" + id);
                id = (id + 1) % 10;  // Cambiar a la siguiente estación en el siguiente ciclo
                prioridad++;  // Incrementar la prioridad en cada iteración
                buffer.actualizarPrioridad(id, prioridad);
            }
        } catch (Exception e) {
            e.printStackTrace(); // Maneja la excepción de manera apropiada
        }
    }

}