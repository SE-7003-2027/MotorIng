# Proyecto: Motor de juegos tipo NetHack

Se usarán varias clases abstractas, descritas posteriormente:

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
