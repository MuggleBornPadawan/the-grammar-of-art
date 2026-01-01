# The Grammar of Art

An educational web application covering the fundamental **Elements of Art** and **Principles of Composition**.

Built with **Clojure**, this project serves as both a dynamic educational tool and a static site generator for hosting on GitHub Pages. It features a "Modern Gallery" aesthetic designed for maximum readability and visual impact.

## 🎨 Content Covered

### The 7 Elements of Art
Tools used to create artwork:
*   Line, Shape, Form, Color, Texture, Space, and Value.

### The 7 Principles of Composition
Methods for organizing the elements:
*   Balance, Contrast, Emphasis, Movement, Pattern, Rhythm, and Unity.

### The Synthesis
*   **Composition:** The orchestration of elements according to principles.

## 🚀 Features
*   **Dynamic Development:** Real-time rendering using Clojure/Ring.
*   **Curatorial Visuals:** Each concept includes a sophisticated, real-time CSS animation exploring visual theory.
*   **"Modern Gallery" Theme:** High-readability layout with a Soft White background, Deep Blue text, and Gold accents.
*   **Compact Viewport UI:** Designed to fit content on a single screen without scrolling on desktop.
*   **Linear Navigation:** "Next/Previous" controls allow users to tour the gallery sequentially.
*   **Static Site Generation:** Automated script to compile views into optimized HTML for GitHub Pages.
*   **Responsive Design:** Mobile-friendly fallback layout.

## 🛠 Tech Stack
*   **Language:** Clojure
*   **Web Server:** Ring / Jetty
*   **Routing:** Compojure
*   **HTML Generation:** Hiccup
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
Visit the live project here: [https://mugglebornpadawan.github.io/art/](https://mugglebornpadawan.github.io/art/)

## 📜 License
This project is open source and available under the [GNU General Public License v3.0](LICENSE).