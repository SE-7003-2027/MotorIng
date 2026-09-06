# Proyecto: Motor de juegos tipo NetHack

Se usarán varias clases abstractas, descritas posteriormente:
Descripción

### Descripción

Motor de videojuegos 2D/3D extensible y orientado a turnos inspirado en juegos clásicos tipo *roguelike* (como NetHack). Proporciona la infraestructura básica para gestionar mapas en grilla, sincronización de acciones de múltiples entidades, físicas simplificadas por celdas y renderizado gráfico flexible.

### Roles
Por definir


### Funcionalidades 

## Escenario

Área principal del juego en donde se renderizará el mundo de acuerdo a una lista de sprites contra las referencias al mundo cargado. Tendrá una lista de jugadores y se esperará a que todos los jugadores hayan hecho un movimiento o interacción antes de cambiar el frame y actualizar el escenario.

- Actualizar pantalla

## Mundo

Un grid de $n \times m$ que contendrá una referencia a cualquier interactuable o espacio vacío en cada celda. Pueden ser cargados y descargados.

## Objetos fisicos

Cualquier objeto dentro del mundo. No puede estar encima de otro objeto dentro del mundo. hitbox, sprites, construcción y destrucción de los objetos.

## Visualizador

Un parser entre las referencias del mundo y los sprites de los objetos fisicos.

## Pared

Objeto fisico no movible. Sin ningún tipo de interacción.

## Interactuable

Objeto fisico no movible con una función interna.

## Movibles

NPCs o jugadores. Clase abstracta que se puede mover.

## Jugador

Movible controlable, además podrá interactuar con objetos interactuables

## NPCs

Movible. (add? o que lo haga el programador?) Se mueve al jugador

## Adicional: Interfaz 3D

Usando Raycast y Java Swing.


### Objetivo

Diseñar e implementar un motor de videojuegos modular, mantenible y extensible en Java (utilizando Swing) que abstraiga la complejidad de la gestión de mundos matriciales, el renderizado (2D y Raycasting 3D), la detección de colisiones en grilla y la sincronización de acciones por turnos, sirviendo como marco de trabajo (*framework*) para el desarrollo eficientemente estructurado de juegos tipo *roguelike*.

### Estado del proyecto *Fase Actual:** *Diseño Arquitectónico e Implementación Inicial (Alfa)*

- [x] **Definición de Arquitectura:** Diseño de clases abstractas base (`ObjetoFisico`, `Movible`, `Interactuable`).
- [ ] **Gestor de Mundo:** Implementación de la matriz $n \times m$ y métodos de carga/descarga.
- Por definir
