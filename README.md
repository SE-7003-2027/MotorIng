# Project: NetHack-like Game Engine

---

## Team members

* **Member 1:** [Espejel Báez]
* **Member 2:** [Cristian Josue]
* **Member 3:** [Martinez Oviedo]
* **Member 4:** [Pimientel Casillas]
* **Member 5:** [Isaac Rivera]

---

## Executive Summary

Developing grid-based and turn-based games (such as classic *roguelikes*) often forces developers to repeatedly implement low-level mechanics like input synchronization, matrix coordinate mapping, and custom rendering loops.

---

## Technical Requirements & Setup

* **Programming Language:** Java (JDK 17 or higher recommended, minimum JDK 11).
* **Build / IDE:** Compatible with any standard Java IDE (IntelliJ IDEA, Eclipse, VS Code) or command line (Terminal).
* * To be defined
  * **GUI / Graphics:** Standard Java Swing & AWT (included in the standard JDK).
---

## Running the Grid Prototype (`Test` Class)

To test the current architecture and visualize the rendered matrix grid, you can run the `Test` entry point located in the `src/` folder.

### Option 1: Via Terminal / Command Line

1. Open your terminal at the root directory of the project.
2. Compile all Java source files from the `src/` directory into a `bin/` folder:
   ```bash
   javac -d bin src/*.java

---

## Description

Extensible 2D/3D game engine oriented toward turn-based gameplay mechanics and inspired by classic *roguelikes* (such as NetHack). It provides the core infrastructure to manage grid-based maps, synchronize multi-entity actions, handle simplified cell-based movement, and perform flexible graphical rendering.

---

## System Architecture & Classes

Below is the description of the core abstract and concrete classes that form the engine:

### Master Controller & Canvas

* **`Scenery` (Master Controller):** 
  The core controller of the entire game engine. It captures user inputs, manages turn cycles, receives updated coordinate data from `PhysicalObject` instances, and instructs `World` on what to render.

* **`World` (Canvas & Matrix):** 
  An $n \times m$ grid matrix acting as a visual canvas. Depending on the commands and data sent by `Scenery` (object positions and sprites), `World` renders all sprites in their corresponding cell locations. It supports map loading and unloading operations. *(Future update: `World` will evaluate collisions between entities with HitBoxes).*

### Entity Hierarchy

* **`PhysicalObject` (Abstract Class):** 
  Base class for any element present in the world. Holds spatial position coordinates and sprite references, returning its updated position to `Scenery` during every cycle. *(Note: HitBox and collision detection will be integrated in future releases).*

* **`Movable` (Abstract Class):** 
  Extends `PhysicalObject`. Abstract base class that enables entity movement across the grid matrix.

* **`Player`:** 
  Extends `Movable`. Controllable entity that responds to user input and interacts with interactive objects in the world.

* **`NPC`:** 
  Extends `Movable`. Non-player character controlled by automated logic (moves toward the player).

* **`Interactable` (Abstract Class):** 
  Extends `PhysicalObject`. Immovable object that triggers internal functions or events upon interaction.

* **`Wall`:** 
  Extends `PhysicalObject`. Immovable, static physical barrier without interactions.

* **`Visualizer`:** 
  Intermediary component acting between world grid references and `PhysicalObject` graphical sprites.

---

## Additional Features: 3D Interface

* **Raycasting Rendering:** 
  Optional pseudo-3D visual projection module built using custom *Raycast* algorithms and Java Swing graphics components.

---

## Objective

Design and implement a modular, maintainable, and extensible game engine in Java (using Swing) that abstracts the complexity of managing matrix-based worlds, rendering (both 2D and 3D Raycasting), grid collision detection, and turn action synchronization, serving as an efficient framework for *roguelike* game development.

---

## Project Status

**Current Phase:** Architectural Design & Initial Implementation (Alpha)

* [x] **SPIKE Research & ADR:** Architecture definition and technology validation.
* [x] **Core Hierarchy Setup:** Abstract base classes created (`PhysicalObject`, `Movable`, `Interactable`).
* [x] **Master Controller (`Scenery`):** Basic input reception and output loop generation.
* [x] **Grid Canvas (`World`):** Matrix setup for receiving sprite position arrays and drawing map layouts.
* * To be defined
  * [ ] **HitBox & Collision Engine:** Adding hitboxes to `PhysicalObject` and collision evaluation in `World`.
  * [ ] **Map Loading System:** File parsing for loading and unloading $n \times m$ matrices.
  * [ ] **NPC Pathfinding:** AI logic for dynamic pathing toward the player.

