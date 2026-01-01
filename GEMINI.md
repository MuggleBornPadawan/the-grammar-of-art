# The Grammar of Art Web App

## Project Overview

This is a Clojure-based interactive web application designed to teach the fundamental elements of art, principles of composition, and visual phenomenology through a series of conceptually-driven interactive artworks.

It is a dual-mode application:
1.  **Development:** A dynamic web server using Ring and Compojure.
2.  **Production:** A static site generator that outputs a complete, high-performance web app to the `docs/` directory.

**Tech Stack:**
*   **Language:** Clojure
*   **Build Tool:** Leiningen
*   **Interactivity:** Vanilla JS + CSS Variables
*   **Styling:** Custom CSS (Behavioral, Generative & Responsive)

## Design Philosophy

The project uses a **"Modern Gallery"** aesthetic coupled with a sophisticated interaction model.
*   **Curatorial Voice:** Content is written from a high-end curatorial perspective, focusing on the philosophical "why" behind each concept.
*   **Interaction as Revelation:** User input is designed as a form of inquiry. Instead of direct control (e.g., dragging a shape), the user applies a **force** (e.g., gravity, pressure), revealing the underlying principles through the artwork's emergent behavior.
*   **Layout:** "Compact Viewport" design (100vh) for an immersive, non-scrolling desktop experience.

## Architecture

*   **Interactive Layer (`js/interaction.js`):** A lightweight script that tracks mouse/touch coordinates and provides normalized `--int-x` and `--int-y` CSS variables to the artworks.
*   **Behavioral Visuals (`css/style.css`):** Each of the 24 artworks has a "Curator's Cut" implementation. The CSS uses `calc()` and custom properties to create a physics-and-behavior-driven system that responds to the interactive inputs, rather than relying on simple, looping animations.
*   **Static Generation (`static.clj`):** Compiles all pages and copies the full CSS/JS/Image asset suite to the `docs/` folder.

## Curriculum Structure

The site is organized into 6 distinct pillars:
1.  **The Elements:** The primal forces of vision.
2.  **The Principles:** The grammar of relationships.
3.  **Perception:** The active construction of reality.
4.  **Structure:** The hidden geometry of composition.
5.  **Spatial Depth:** The conquest of the 2D plane.
6.  **Color Dynamics:** The alchemy of feeling.

## Directory Structure

*   `art-web/`: The core Clojure project.
    *   `src/art_web/`:
        *   `handler.clj`: Compojure routes for all curriculum paths.
        *   `views.clj`: Hiccup templates and the complete curatorial text database.
        *   `static.clj`: Static site generator.
    *   `resources/public/`:
        *   `css/style.css`: Main stylesheet containing all behavioral art definitions.
        *   `js/interaction.js`: The coordinate-to-force translation script.
        *   `img/`: SVG logos and assets.
*   `docs/`: The generated static website.

## Building and Running

### 1. Development Server
```bash
cd art-web
lein ring server
```

### 2. Generate Static Site
```bash
cd art-web
lein run -m art-web.static
```
