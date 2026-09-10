# Project: NetHack-like Game Engine

Several abstract classes will be used, described below:

Description

### Description

Extensible 2D/3D video game engine oriented towards turn-based gameplay and inspired by classic *roguelike* games (such as NetHack). It provides the basic infrastructure for managing grid-based maps, synchronizing actions of multiple entities, simplified cell-based physics, and flexible graphical rendering.

### Roles

To be defined

### Functionalities

## Scenario

Main area of the game where the world will be rendered according to a list of sprites against the references to the loaded world. It will have a list of players and will wait for all players to have made a move or interaction before changing the frame and updating the scenario.

* Update screen

## World

An $n \times m$ grid that will contain a reference to any interactable object or empty space in each cell. They can be loaded and unloaded.

## Physical Objects

Any object within the world. It cannot be on top of another object within the world. Hitbox, sprites, construction and destruction of objects.

## Visualizer

A parser between the world references and the sprites of the physical objects.

## Wall

Immovable physical object. Without any type of interaction.

## Interactable

Immovable physical object with an internal function.

## Movables

NPCs or players. Abstract class that can be moved.

## Player

Controllable movable, it will also be able to interact with interactable objects.

## NPCs

Movable. (add? or should the programmer do it?) Moves towards the player.

## Additional: 3D Interface

Using Raycast and Java Swing.

### Objective

Design and implement a modular, maintainable, and extensible video game engine in Java (using Swing) that abstracts the complexity of managing matrix-based worlds, rendering (2D and 3D Raycasting), grid-based collision detection, and turn-based action synchronization, serving as a framework for the efficiently structured development of *roguelike* games.

### Project Status

Current Phase: Architectural Design and Initial Implementation (Alpha)

* [x] **Architecture Definition:** Design of base abstract classes (`PhysicalObject`, `Movable`, `Interactable`).

* [ ] **World Manager:** Implementation of the $n \times m$ matrix and load/unload methods.

* To be defined
