# Parcial

# Mi repositorio:
https://github.com/samuug/Parcial.git

## Enunciado:
Título: La Operación de Galton en la Fábrica de Campanas de Gauss

En el año 1850, en un universo paralelo donde la tecnología avanzó rápidamente, Sir Francis Galton creó un dispositivo que llamó la "máquina de la distribución normal". Esta máquina, basada en su tablero de Galton, demostró que al caer bolas a través de una serie de clavos en ángulo, la distribución final de las bolas en los contenedores inferiores formaba una curva de campana, también conocida como una distribución normal o Gaussiana.

Galton fundó una fábrica, "Campanas de Gauss", para producir estas máquinas en masa y demostrar este fenómeno matemático al mundo. En la fábrica, varias estaciones de trabajo simultáneas producen diferentes componentes de la máquina, y el ensamblaje final se lleva a cabo en una línea de producción separada.

Tú, un brillante ingeniero de software de la época, has sido contratado para simular el proceso de producción utilizando hilos de ejecución para modelar la concurrencia de la fabricación. Debes cumplir con los siguientes requisitos:

    Cada estación de trabajo de la fábrica es un hilo de ejecución independiente. Estos hilos deben coordinarse entre sí para asegurar que los componentes de la máquina se produzcan en el orden correcto y en las cantidades correctas para el ensamblaje final.

    Implementa un mecanismo de sincronización para garantizar que los componentes de la máquina se produzcan y ensamblen de manera ordenada. Esto puede implicar el uso de locks, semáforos, o variables de condición.

    Implementa la producción y el ensamblaje de la máquina como un problema de productor-consumidor. Las estaciones de trabajo que producen componentes son los productores, y la línea de ensamblaje es el consumidor.

    Usa un modelo de memoria compartida para permitir la comunicación entre los hilos. Los componentes producidos por las estaciones de trabajo deben colocarse en un búfer compartido del que la línea de ensamblaje pueda retirarlos.

    Implementa la distribución de las tareas de producción entre las estaciones de trabajo utilizando un algoritmo de scheduling. Puede ser round-robin, prioridad, más corto primero, etc.

    Usa técnicas de programación paralela y distribuida para acelerar el proceso de producción. Esto puede implicar la distribución de la carga de trabajo entre varios procesadores o nodos de un sistema distribuido.

Tu misión final es mostrar cómo a medida que el número de bolas (simuladas con hilos) cae a través del tablero, la distribución final se acerca cada vez más a una distribución normal. Este fenómeno debe ser mostrado visualmente en tiempo real a medida que las bolas llegan a los contenedores inferiores.

El objetivo es utilizar el poder de la programación paralela y distribuida para ilustrar este fenómeno en un entorno de producción concurrente, y en el proceso, aprender más acerca de cómo implementar y coordinar hilos de ejecución en un entorno de programación real.
Rúbrica de calificación:

1. Diseño e implementación de hilos (20 puntos)

    Cada estación de trabajo está correctamente modelada como un hilo de ejecución independiente (10 puntos)
    Los hilos se coordinan correctamente para la producción en paralelo (10 puntos)

2. Sincronización (20 puntos)

    Se implementa correctamente un mecanismo de sincronización para asegurar la producción ordenada y el ensamblaje de la máquina (10 puntos)
    La sincronización se utiliza eficazmente para evitar condiciones de carrera y deadlocks (10 puntos)

3. Problema del productor-consumidor (20 puntos)

    La producción de componentes y el ensamblaje de la máquina están correctamente modelados como un problema del productor-consumidor (10 puntos)
    El búfer compartido se gestiona correctamente (10 puntos)

4. Modelo de memoria compartida (10 puntos)

    Se utiliza correctamente un modelo de memoria compartida para la comunicación entre hilos (5 puntos)
    Los datos se gestionan correctamente en la memoria compartida, sin conflictos ni inconsistencias (5 puntos)

5. Scheduling (10 puntos)

    Se implementa y utiliza correctamente un algoritmo de scheduling para la distribución de tareas de producción (5 puntos)
    El algoritmo de scheduling se utiliza eficazmente para maximizar la eficiencia de la producción (5 puntos)

6. Programación paralela y distribuida (10 puntos)

    Se utiliza eficazmente la programación paralela y distribuida para acelerar el proceso de producción (5 puntos)
    La carga de trabajo se distribuye equitativamente entre los procesadores o nodos (5 puntos)

7. Visualización de la distribución normal (10 puntos)

    La distribución de las bolas en los contenedores inferiores se visualiza en tiempo real (5 puntos)
    La visualización muestra claramente que la distribución final se acerca a una distribución normal (5 puntos)

Por último, la rúbrica podría tener un componente adicional de documentación y estilo de código (10 puntos), en el que se valore la legibilidad y la organización del código, así como la calidad y la completitud de la documentación y los comentarios en el código.
