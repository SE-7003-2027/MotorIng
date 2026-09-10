# Tarea

Investigar videojuegos que puedan jugarse completamente desde una terminal y abstraer sus elementos principales para identificar patrones de diseño reutilizables para el motor gráfico.

---

## Descripción

Se realizó un pequeño *spike* de videojuegos cuya interacción puede realizarse completamente desde una terminal, utilizando caracteres ASCII/Unicode y entradas de teclado.


### 1. NetHack

**Tipo:** Roguelike / exploración de mazmorras.

NetHack puede jugarse mediante una interfaz basada en caracteres. El mapa se representa mediante símbolos y cada elemento visible pertenece a una categoría concreta.

**Características generales**
- Mundo representado en una cuadrícula.
- Juego por turnos.
- Exploración de niveles o habitaciones.
- Combate contra enemigos.
- Inventario y objetos utilizables.
- Interacción con puertas, escaleras, trampas y elementos del mapa.
- Uso de caracteres para representar entidades.

**Objetos básicos que pueden abstraerse**
- `Jugador`
- `Enemigo`
- `Objeto`
  - arma, armadura, comida, poción, herramientas
- `Celda`
  - suelo
  - pared
  - puerta
  - escalera
  - trampa

**Movimientos y controles principales**
- Movimiento en 8 direcciones.
  - arriba, abajo, izquierda, derecha y diagonalmente.
- Movimiento con teclado numérico o teclas configuradas.
- Interacciones mediante teclas individuales.
- Acciones como recoger, soltar, usar, atacar, abrir o cerrar.
- Cada movimiento o acción normalmente consume un turno.

---

### 2. Angband

**Tipo:** Roguelike / exploración y combate.

Angband utiliza un mapa basado en cuadrícula y puede jugarse mediante una interfaz de terminal. El jugador explora una mazmorra generada proceduralmente y combate enemigos mientras obtiene equipo.

**Características generales**
- Juego por turnos.
- Mapa de cuadrícula.
- Generación procedural.
- Sistema de vida, atributos y equipo.
- Enemigos con diferentes comportamientos.
- Inventario.
- Objetos utilizables y equipables.

**Objetos básicos que pueden abstraerse**
- `Jugador`
- `Monstruo`
- `Item`
- `Arma`
- `Armadura`
- `Consumible`
- `Pared`
- `Puerta`
- `Trampa`
- `Escalera`

**Movimientos y controles principales**
- Flechas o teclado numérico.
- En el esquema roguelike también se utilizan:
  - `h`: izquierda
  - `j`: abajo
  - `k`: arriba
  - `l`: derecha
  - `y`, `u`, `b`, `n`: diagonales
- Si el jugador intenta moverse hacia una casilla ocupada por un enemigo, el movimiento puede convertirse en un ataque.
- Existen comandos adicionales para correr, descansar, usar objetos y explorar.

---

### 3. Dungeon Crawl Stone Soup (modo consola)

**Tipo:** Roguelike / estrategia y exploración.

Dungeon Crawl Stone Soup dispone de una versión clásica ASCII/consola que puede jugarse completamente mediante teclado.

**Características generales**
- Juego por turnos.
- Movimiento sobre una cuadrícula.
- Exploración de mazmorras.
- Combate cuerpo a cuerpo, a distancia y magia.
- Diferentes tipos de enemigos.
- Inventario y equipamiento.
- Objetos consumibles.
- Escaleras, puertas, trampas y tiendas.
- Exploración automática disponible como comando.

**Objetos básicos que pueden abstraerse**
- `Jugador`
- `Enemigo`
- `Item`
- `Arma`
- `Armadura`
- `Poción`
- `Pergamino`
- `Varita`
- `CeldaMapa`
- `Puerta`
- `Escalera`
- `Trampa`

**Movimientos y controles principales**
- Movimiento en ocho direcciones.
  - Igual que Nethack arriba, abajo, izquierda, derecha y diagonalmente.
- Flechas, teclado numérico o teclas configuradas.
- Comandos de teclado para atacar, recoger, utilizar o equipar objetos.
- Comandos para descansar y explorar automáticamente.
- Una acción del jugador representa normalmente un turno del juego.

---

## Abstracción general

Reduciendo estos videjuegos a sus componente básicos podemos obtener lo siguiente:

### Entidades


Entidad
- posicion
- simbolo
- estado


Una entidad representa cualquier elemento que ocupa o aparece en una posición del mapa.

Ejemplos:
- `jugador`
- `enemigo`
- `comida`
- `objeto`
- `proyectil`

### Posición


Posicion
- x
- y


La mayoría de juegos se modela en una matriz bidimensional, por lo que solo necesitamos el eje x y y.

### Jugador


Jugador : Entidad
- vida
- direccion
- inventario
- puntuacion


No todos los juegos necesitan todos los atributos. Por ejemplo, Snake puede necesitar dirección y puntuación, mientras que un roguelike necesita vida e inventario.

### Objeto
Objeto : Entidad
- tipo
- efecto
- recogible


Ejemplos:
- comida
- arma
- llave
- poción
- moneda

### Celda del mapa

```text
Celda
├── tipo
├── transitable
└── simbolo
```

Ejemplos de tipos:

- SUELO
- PARED
- PUERTA
- TRAMPA
- SALIDA

## Objetivo

Identificar videojuegos que funcionen completamente mediante una interfaz de terminal y analizar sus mecánicas principales para así de abstraer las estructuras, entidades e interacciones más básicas que puedan ser reutilizadas posteriormente dentro del motor gráfico.

A partir del análisis, los componentes que aparecen con mayor frecuencia son:

- un mapa o espacio de juego;
- una posición (x, y);
- un jugador;
- entidades u objetos;
- movimiento y controles;
- detección de colisiones;
- reglas de interacción entre entidades;
- estado general del juego;
- atributos y comportamientos asociados a cada tipo de objeto;
- un ciclo encargado de procesar entradas y actualizar el estado del juego.

De este spike se busca obtener principalmente una referencia de las estructuras y comportamientos fundamentales que comparten distintos videojuegos, independientemente de que su representación original sea mediante caracteres en una terminal. Estas abstracciones podrán utilizarse posteriormente como base para definir componentes dentro del motor gráfico.

---

## Criterios de aceptación

- [x] Identificar al menos tres videojuegos que puedan jugarse mediante una interfaz de terminal.
- [x] Documentar sus características generales y objetos principales.
- [x] Abstraer los elementos comunes hasta obtener una estructura básica que se usará para el motor gráfico en terminal.

---

## Dependencias

Para realizar la investigación no se requiere implementar código.

---

### Fuentes consultadas

- NetHack Guidebook — https://www.nethack.org/
- Angband Manual — https://angband.readthedocs.io/
- Dungeon Crawl Stone Soup — https://github.com/crawl/crawl

