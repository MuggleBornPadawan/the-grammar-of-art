# The Grammar of Art

A comprehensive, interactive web application exploring the fundamental vocabulary of visual art. This project is a philosophical exhibition, a technical demonstration of **Generative CSS**, and a "Curator's Cut" of interactive art.

Built with **Clojure**, it features a "Modern Gallery" aesthetic designed for an immersive, non-scrolling desktop experience.

## 🎨 The 6 Pillars of the Curriculum

The application covers 24 distinct concepts across six core categories, narrated through a refined, curatorial perspective:

1.  **The Elements:** The primal forces of vision (Line, Shape, Form, Color, Texture, Space, Value).
2.  **The Principles:** The grammar of relationships (Balance, Contrast, Rhythm, Unity, etc.).
3.  **Perception (Gestalt):** The active construction of reality (Closure, Figure-Ground, Proximity).
4.  **Structure:** The hidden geometry of composition (Golden Ratio, Rule of Thirds, Hierarchy).
5.  **Spatial Depth:** The conquest of the 2D plane (Perspective, Atmospheric Depth, Foreshortening).
6.  **Color Dynamics:** The alchemy of feeling (Temperature, Saturation, Simultaneous Contrast).

## 🚀 Key Features

*   **Conceptually-Driven Interactions:** This is not a simple "Workshop." User input acts as a **force** (gravity, pressure, order) that influences each artwork, revealing its core principles through emergent behavior rather than direct control.
    *   *e.g., Bend the "Line" like a bowstring, squeeze "Space" like a vise, or align chaotic "Unity" with a wave of order.*
*   **The Cinematic Finale:** A multi-layered "Composition" masterclass that synthesizes all concepts into a singular, orchestrated visual narrative, also influenced by user interaction.
*   **Refined Curatorial Voice:** Content written with the depth and poetic analysis of a veteran art curator, moving beyond simple definitions into visual theory.
*   **Behavioral CSS Art:** Sophisticated, code-driven visualizations that prioritize meaningful, conceptually-relevant responses over simple, looping animations.
*   **Dual-Mode Architecture:** A dynamic Clojure/Ring development server and a high-performance Static Site Generator for GitHub Pages.

## 🛠 Tech Stack

*   **Language:** Clojure
*   **Interactivity:** Vanilla JavaScript + CSS Custom Properties (Variables)
*   **Web Server:** Ring / Jetty
*   **Routing:** Compojure
*   **HTML Generation:** Hiccup
*   **Visuals:** Pure CSS (Behavioral & Interactive)
*   **Hosting:** GitHub Pages (via the `docs/` folder)

## 💻 Local Development

### Prerequisites
*   [Leiningen](https://leiningen.org/) installed.

### Run the Dev Server
1. Navigate to the app directory:
   ```bash
   cd art-web
   ```
2. Start the server:
   ```bash
   lein ring server
   ```
   The site will be available at `http://localhost:3000`.

### Generate Static Production Build
To update the `docs/` folder for GitHub Pages:
```bash
cd art-web
lein run -m art-web.static
```

## 🌐 Live Site
Visit the interactive gallery here: [https://mugglebornpadawan.github.io/art/](https://mugglebornpadawan.github.io/art/)

## 📜 License
This project is open source and available under the [GNU General Public License v3.0](LICENSE).