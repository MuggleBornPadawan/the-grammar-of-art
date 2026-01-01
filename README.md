# The Grammar of Art

```
  _______ _                  
 |__   __| |                 
    | |  | |__   ___         
    | |  | '_ \ / _ \        
    | |  | | | |  __/        
    |_|  |_| |_|\___|        
   _____                                                      __ 
  / ____|                                                    / _|
 | |  __ _ __ __ _ _ __ ___  _ __ ___   __ _ _ __    ___  __| |
 | | |_ | '__/ _` | '_ ` _ \| '_ ` _ \ / _` | '__|  / _ \/ _` |
 | |__| | | | (_| | | | | | | | | | | | (_| | |    |  __/ (_| |
  \_____|_|  \__,_|_| |_| |_|_| |_| |_|\__,_|_|     \___|\__,_|
      /\       | |                                             
     /  \   _ _| |_                                            
    / /\ \ | '__| __|                                          
   / ____ \| |  | |_                                           
  /_/    \_\_|   \__|                                          
```

A comprehensive, interactive web application exploring the fundamental vocabulary of visual art. This project is a philosophical exhibition, a technical demonstration of **Generative CSS**, and a "Curator's Cut" of interactive phenomenology.

Built with **Clojure**, it features a "Modern Gallery" aesthetic designed for an immersive, non-scrolling desktop experience.

## 🏛️ Enter the Exhibition
Visit the interactive gallery here: [https://mugglebornpadawan.github.io/the-grammar-of-art/](https://mugglebornpadawan.github.io/the-grammar-of-art/)

---

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
*   **The Synthesis Engine:** A multi-layered finale that replaces traditional animation loops with a tunable system. The user must find the "Golden Mean" between Order and Entropy to resolve the composition.
*   **Refined Curatorial Voice:** Content written with the depth and poetic analysis of a veteran art curator, moving beyond simple definitions into visual theory.
*   **Behavioral CSS Art:** Sophisticated, code-driven visualizations that prioritize meaningful, conceptually-relevant responses over simple, looping animations.
*   **Dual-Mode Architecture:** A dynamic Clojure/Ring development server and a high-performance Static Site Generator for GitHub Pages.

## 🧠 The Philosophy of Code

Why Code? This project posits that the laws of art are algorithmic. A line is a vector; balance is an equation. By encoding these principles into a rigid syntax (CSS and Clojure), we strip away the romance of the hand to reveal the raw mechanics of the eye. 

The code does not merely simulate art; it simulates the **conditions** under which art becomes inevitable. CSS Custom Properties act as physical constants (Tension, Gravity, Light), while Clojure provides the immutable structure of the curriculum itself. The medium is chosen to prove that even within the deterministic logic of a computer, the human "Sweet Spot" of composition remains a discovery, not a calculation.

## 🛠 Tech Stack

*   **Logic:** Clojure — Functional composition of visual concepts.
*   **Interactivity:** Vanilla JavaScript — Bridging input vectors to CSS Physics.
*   **Visuals:** Pure CSS — Behavioral, generative, and responsive.
*   **Web Server:** Ring / Jetty — For dynamic development.
*   **Templating:** Hiccup — Declarative HTML generation.
*   **Hosting:** GitHub Pages — Optimized static delivery.

## 💻 Local Development

### Prerequisites
*   [Leiningen](https://leiningen.org/) installed.

### Run the Dev Server
1. Navigate to the app directory: `cd art-web`
2. Start the server: `lein ring server`
   The site will be available at `http://localhost:3000`.

### Generate Static Production Build
To update the `docs/` folder for GitHub Pages:
```bash
cd art-web
lein run -m art-web.static
```

## 📜 License
This project is open source and available under the [GNU General Public License v3.0](LICENSE).
