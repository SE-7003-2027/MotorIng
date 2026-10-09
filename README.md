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

## Running the Grid Prototype (`Test` / `Test2` Classes)

To test the engine architecture, verify grid rendering, and evaluate collision detection with single-cell and multi-cell entities, run the entry points located in the `src/` folder.

### Option 1: Via Terminal / Command Line

1. Open your terminal at the **root directory** of the project (one level above `src/`).

2. Compile all source files into the `bin/` output directory:
   ```bash
   javac -d bin src/*.java src/World/*.java src/Physical/*.java src/Controller/*.java src/Inputs/*.java
   

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
  Manages the static Map and the list of active Physical entities. Evaluates movement validity using canMove(), calculates collision intersections via detectCollisions(), and coordinates game updates in update().

* **`Map & MapReader`:**

Map represents the static environment as a two-dimensional character array. MapReader parses external text map files (e.g., maps/map.txt) to dynamically load level structures.

* **`CollisionInfo`:**

Encapsulates collision data during movement checks. Holds references to touched static map tiles (e.g., walls #) and other Physical objects intersected during a move intent.

### Entity Hierarchy

* **Physical (Base Entity Class):**

  Base class for all elements in the world. Holds coordinates (x, y) and sprite representation. Includes the trackCollision attribute and the onCollision(CollisionInfo info) callback to receive collision updates from World.

* **ClusterPhysical:**

  Extends Physical. Supports entities that occupy multiple cells or non-rectangular shapes (such as $2 \times 2$ boxes, L-shaped walls, or large monsters) using a 2D character matrix shape.

### Inputs & Controllers (src.Inputs & src.Controller)

    * Input (Interface), ConsoleInput & JframeInput:

    Abstract input handling for asynchronous terminal commands or Java Swing keyboard events (WASD, Arrow keys, Space).

    * Controller & UserController:

    Translates raw inputs into game actions (such as Translation vectors (dx, dy)) associated with a specific Physical entity.
### Presentation Layer (src Package)

    * Scenery (Master Controller Abstraction):

    Abstract base class for rendering and game state display loops.

    * Draw & MapPanel:

    Swing GUI implementation. Draw manages the JFrame window, while MapPanel performs grid rendering and sprite drawing via AWT Graphics.
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

* [x] SPIKE Research & ADR: Architecture definition and technology stack validation.
* [x] Map Loading System: External map parsing (MapReader) to load dynamic $n \times m$ grid matrices (Map).
* [x] HitBox & World Collision Engine: Implementation of detectCollisions() in World and CollisionInfo data passing.
* [x] Collision Tracking in Physical Objects: Added trackCollision attribute and onCollision() notification hook in Physical.
* [x] Multi-cell Entity Support: Custom shape occupancy checking with ClusterPhysical.
* [x] Input & Controller Mapping: Keyboard listening via JframeInput/ConsoleInput translated into Translation actions.
* [x] Swing Canvas & Rendering Loop: Integrated Draw and MapPanel GUI window rendering.
* * To be defined
  * [ ] Interactive Collision Responses: Implement reactive logic on onCollision() (e.g., picking up items, taking damage, triggering events).
  * [ ] Specialized Entity Classes: Extend Physical into concrete classes (Player, NPC, Interactable, Wall).
  * [ ] NPC AI & Pathfinding: Introduce automated controllers for enemy navigation toward target entities.

