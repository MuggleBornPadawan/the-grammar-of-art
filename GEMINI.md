# The Grammar of Art Web App

## Project Overview

This is a Clojure-based web application designed to teach the fundamental elements of art and principles of composition. It is a dual-mode application:
1.  **Development:** A dynamic web server using Ring and Compojure.
2.  **Production:** A static site generator that outputs HTML files to the `docs/` directory for hosting on GitHub Pages.

**Tech Stack:**
*   **Language:** Clojure
*   **Build Tool:** Leiningen
*   **Web Framework:** Ring / Compojure
*   **Templating:** Hiccup
*   **Styling:** Custom CSS (No preprocessors)

## Design Philosophy

The project uses a **"Modern Gallery"** aesthetic:
*   **Branding:** A unified SVG brand mark combining the Glider (hacker emblem) and the site title.
*   **Typography:** `Merriweather` (Serif) for headers, `Inter` (Sans-Serif) for body.
*   **Palette:**
    *   **Background:** Soft White (`#fdfdfd`)
    *   **Text:** Deep Blue (`#061735`)
    *   **Accents:** Gold (`#B3892C`)
*   **Layout:** "Compact Viewport" design. Both the Home page and Detail pages are fitted to `100vh` to eliminate vertical scrolling on desktop, providing a focused, immersive experience.
*   **Navigation:** A guided "linear tour" model. Users can flow through the curriculum using Next/Prev controls on each page.
*   **Generative Visuals:** Art demonstrations are created using pure CSS. They utilize **"Simulated Randomness"**—multiple asynchronous animation loops with prime-number durations—to create organic, non-repetitive visual experiences.

## Architecture

The application logic resides in the `art-web` directory.
*   **Dynamic Serving:** `art-web.handler` defines routes for development.
*   **Static Generation:** `art-web.static` leverages the same views to generate static HTML files, handling URL prefixes for GitHub Pages (e.g., `/art/`) and copying assets (CSS/Images/SVG).
*   **Content/Views:** `art-web.views` contains all textual content and HTML structure. Content is written from a curatorial perspective, focusing on visual theory (e.g., *Chiaroscuro*, *Gestalt*, *Negative Space*).

## Directory Structure

*   `art-web/`: The core Clojure project.
    *   `src/art_web/`: Source code.
        *   `handler.clj`: Ring application routes.
        *   `views.clj`: Hiccup templates and curatorial data definitions.
        *   `static.clj`: Script to generate the static site.
    *   `resources/public/css/`: Main stylesheet containing all generative art logic.
    *   `resources/public/img/`: Image and SVG assets (e.g., `logo_full.svg`).
    *   `project.clj`: Leiningen configuration.
*   `docs/`: The generated static website. This folder is served by GitHub Pages.

## Building and Running

All commands should be run from inside the `art-web` directory.

### 1. Development Server
Starts a local web server (usually on port 3000) with hot-reloading for views.
```bash
cd art-web
lein ring server
```

### 2. Generate Static Site
Compiles the views into static HTML files in the `docs/` directory.
```bash
cd art-web
lein run -m art-web.static
```

### 3. Deploy
Regenerate the static site, commit the `docs/` folder, and push to the `main` branch.
