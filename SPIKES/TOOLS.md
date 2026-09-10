# Herramientas y Frameworks

Para el desarrollo del proyecto será necesario definir qué bibliotecas o controles podemos usar.

## Frameworks de Programación

* **JNI (Java Native Interface):** Es un framework que permite a los programas compilados en la Máquina Virtual de Java (JVM) interactuar con código nativo escrito en C, C++ o ensamblador. Esto permite traducir funciones de Java a C/C++ con el fin de optimizar memoria, espacio y ejecutar operaciones de bajo nivel útiles para el desarrollo de este motor.

## Bindings y Acceso Nativo

* **LWJGL (Lightweight Java Game Library):** Biblioteca destinada a juegos comerciales en Java. Actúa como un conjunto de herramientas que dan acceso a librerías nativas (C/C++) mediante *bindings*. Da acceso a tres librerías principales:
  * **OpenGL:** Permite acceder a funciones de gráficos 2D y 3D, dibujando en la pantalla usando la GPU (ej. `glClear`, `glDrawArrays`, `glVertex3f`).
  * **OpenAL:** Proporciona funciones de manejo de audio, como reproducir sonidos, música y efectos en 3D.
  * **OpenCL:** Ejecuta cálculos pesados de CPU/GPU, útil para operaciones de optimización.

## Frameworks de Desarrollo Gráfico

* **LibGDX:** Framework que utiliza el conjunto de *bindings* anterior (LWJGL) para gráficos de escritorio. Su plantilla básica extiende de la clase `ApplicationAdapter` o `Game` y ofrece métodos de ciclo de vida:
  * `create()`: Inicializa recursos (texturas, sonidos, etc.).
  * `render()`: Se ejecuta en cada *frame* para dibujar y actualizar la lógica.
  * `dispose()`: Libera memoria al cerrar la aplicación.
* **JavaFX:** Framework orientado a interfaces gráficas tradicionales (GUI). Ideal para crear aplicaciones de escritorio con ventanas, menús, botones, animaciones y gráficos 2D/3D básicos.

## Bibliotecas Matemáticas

* **JOML:** Biblioteca que incluye un conjunto de clases para operaciones matemáticas relacionadas con vectores y matrices. Es esencial para el motor, ya que se requerirá realizar transformaciones y cálculos de gráficos 3D. Sus clases principales incluyen `Vector2f`, `Vector3f`, `Matrix4f` y `Quaternionf`.
