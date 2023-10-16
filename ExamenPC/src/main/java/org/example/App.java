package org.example;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class App extends Application {

    private static final int ANCHO_TABLERO = 400;
    static final int ALTO_TABLERO = 600;
    static final int RADIO_BOLA = 10;
    private static final int NUMERO_BOLAS = 100;

    private List<Bola> bolas = new ArrayList<>();
    private Random random = new Random();

    @Override
    public void start(Stage primaryStage) {
        Canvas canvas = new Canvas(ANCHO_TABLERO, ALTO_TABLERO);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        Group root = new Group();
        root.getChildren().add(canvas);

        primaryStage.setTitle("Bolas Cayendo");
        primaryStage.setScene(new Scene(root, ANCHO_TABLERO, ALTO_TABLERO));
        primaryStage.show();

        // Crear bolas iniciales
        for (int i = 0; i < NUMERO_BOLAS; i++) {
            double x = random.nextDouble() * ANCHO_TABLERO;
            double y = randomGaussian(0.5, 0.2) * ALTO_TABLERO;
            double velocidad = random.nextDouble() * 5 + 1;
            Bola bola = new Bola(x, y, velocidad);
            bolas.add(bola);
        }

        // Crear un bucle de animación para simular bolas cayendo
        AnimationTimer animationTimer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // Limpiar el canvas
                gc.clearRect(0, 0, ANCHO_TABLERO, ALTO_TABLERO);

                // Dibujar el tablero
                gc.strokeRect(0, 0, ANCHO_TABLERO, ALTO_TABLERO);

                // Simulación de movimiento y colisiones de bolas
                for (Bola bola : bolas) {
                    bola.actualizar();
                    gestionarColisiones(bola);
                    dibujarBola(gc, bola);
                }
            }
        };

        // Iniciar la simulación de bolas cayendo
        animationTimer.start();
    }

    private double randomGaussian(double media, double desviacionEstandar) {
        return random.nextGaussian() * desviacionEstandar + media;
    }

    private void dibujarBola(GraphicsContext gc, Bola bola) {
        gc.setFill(Color.BLUE);
        gc.fillOval(bola.getX() - RADIO_BOLA, bola.getY() - RADIO_BOLA, RADIO_BOLA * 2, RADIO_BOLA * 2);
    }

    private void gestionarColisiones(Bola bola) {
        for (Bola otraBola : bolas) {
            if (bola != otraBola && tienenColision(bola, otraBola)) {
                resolverColision(bola, otraBola);
            }
        }
    }

    private boolean tienenColision(Bola bola1, Bola bola2) {
        double distancia = Math.hypot(bola1.getX() - bola2.getX(), bola1.getY() - bola2.getY());
        return distancia < 2 * RADIO_BOLA;
    }

    private void resolverColision(Bola bola1, Bola bola2) {
        // Ajustar posiciones para evitar la colisión
        double nuevaX1 = bola1.getX() - 0.5;
        double nuevaX2 = bola2.getX() + 0.5;
        double nuevaY1 = bola1.getY() - 0.5;
        double nuevaY2 = bola2.getY() + 0.5;

        bola1.setPosicion(nuevaX1, nuevaY1);
        bola2.setPosicion(nuevaX2, nuevaY2);
    }

    public static void main(String[] args) {
        launch(args);
    }
}

