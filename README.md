# The Grammar of Art

An educational web application covering the fundamental **Elements of Art**, **Principles of Composition**, and their final **Synthesis**.

Built with **Clojure**, this project serves as both a dynamic educational tool and a static site generator for hosting on GitHub Pages. It features a "Modern Gallery" aesthetic designed for maximum readability and visual impact.

## 🎨 Content Covered

### The 7 Elements of Art
Materiality and Perception:
*   Line, Shape, Form, Color, Texture, Space, and Value.

### The 7 Principles of Composition
Organization and Psychology:
*   Balance, Contrast, Emphasis, Movement, Pattern, Rhythm, and Unity.

### The Synthesis
*   **Composition:** "The Arrested Moment"—the freezing of dynamic forces in precarious equilibrium.

## 🚀 Features
*   **Dynamic Development:** Real-time rendering using Clojure/Ring.
*   **Generative CSS Art:** Each concept includes a sophisticated, real-time CSS animation using prime-number timing loops to simulate organic randomness.
*   **"Modern Gallery" Theme:** High-readability layout with a Soft White background, Deep Blue text, and Gold accents.
*   **Compact Viewport UI:** Optimized to fit content on a single screen (100vh) without scrolling on desktop.
*   **Linear Navigation:** "Next/Previous" controls allow for a guided, sequential tour of the curriculum.
*   **Static Site Generation:** Automated script to compile views into optimized HTML for GitHub Pages.

## 🛠 Tech Stack
*   **Language:** Clojure
*   **Web Server:** Ring / Jetty
*   **Routing:** Compojure
*   **HTML Generation:** Hiccup
*   **Visuals:** Pure CSS (Generative)
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
Visit the live gallery here: [https://mugglebornpadawan.github.io/art/](https://mugglebornpadawan.github.io/art/)

## 📜 License
This project is open source and available under the [GNU General Public License v3.0](LICENSE).