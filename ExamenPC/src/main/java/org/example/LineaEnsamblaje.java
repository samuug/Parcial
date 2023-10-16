package org.example;

public class LineaEnsamblaje implements Runnable {
    private Buffer buffer;

    public LineaEnsamblaje(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        // Simulación de ensamblaje
        for (int i = 0; i < 100; i++) {
            String componente = buffer.consumir();
            System.out.println(componente + " ensamblado por LineaEnsamblaje-" + Thread.currentThread().getId());

            // Mostrar estadísticas cada 10 ensamblajes
            if (i % 10 == 0) {
                buffer.mostrarEstadisticas();
            }
        }
    }
}