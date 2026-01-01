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
*   **Typography:** `Merriweather` (Serif) for headers, `Inter` (Sans-Serif) for body.
*   **Palette:**
    *   **Background:** Soft White (`#fdfdfd`)
    *   **Text:** Deep Blue (`#061735`)
    *   **Accents:** Gold (`#B3892C`)
*   **Layout:** "Compact Viewport" design. On desktop, content is split 35/65 (Text/Image) and fitted to `100vh` to eliminate vertical scrolling.
*   **Navigation:** A "Hub and Spoke" model. The Home page serves as the gallery directory. Detail pages feature Next/Prev navigation to guide the user through the curriculum linearly.
*   **Visuals:** All art demonstrations are created using pure CSS/CSS Art techniques, adhering to the project's color palette and focusing on perception/visual theory.

## Architecture

The application logic resides in the `art-web` directory.
*   **Dynamic Serving:** `art-web.handler` defines routes for development, allowing for fast iteration.
*   **Static Generation:** `art-web.static` leverages the same views to generate static HTML files, handling URL prefixes for GitHub Pages (e.g., `/art/`) and copying assets (CSS/Images).
*   **Content/Views:** `art-web.views` contains all textual content and HTML structure. It uses a dynamic `*base-url*` var to adapt links for different environments.

## Directory Structure

*   `art-web/`: The core Clojure project.
    *   `src/art_web/`: Source code.
        *   `handler.clj`: Ring application routes.
        *   `views.clj`: Hiccup templates and data definitions for Art Elements/Principles.
        *   `static.clj`: Script to generate the static site.
    *   `resources/public/css/`: CSS files.
    *   `resources/public/img/`: Image assets (e.g., `glider.png`).
    *   `project.clj`: Leiningen configuration.
*   `docs/`: The generated static website (HTML/CSS/IMG). This folder is served by GitHub Pages.

## Building and Running

All commands should be run from inside the `art-web` directory.

### 1. Development Server
Starts a local web server (usually on port 3000) with hot-reloading for views.
```bash
cd art-web
lein ring server
# OR for headless environments
lein ring server-headless
```

### 2. Generate Static Site
Compiles the views into static HTML files in the `docs/` directory. This script automatically adjusts paths (like CSS links) to work with the GitHub Pages subpath (`/art/`).
```bash
cd art-web
lein run -m art-web.static
```

### 3. Deploy
The `docs/` folder is configured to be served by GitHub Pages. To deploy updates:
1.  Run the generation command above.
2.  Commit the changes to `docs/`.
3.  Push to the `main` branch.
