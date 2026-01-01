(ns art-web.views
  (:require [hiccup.page :refer [html5 include-css]]))

;; Change this to "" for local dev, "/art" for GitHub Pages
(def ^:dynamic *base-url* "")

(defn url [path]
  (str *base-url* path))

(def elements
  [{:id "line" :title "Line" :desc "More than a path between points; it is the division of space. A line vibrates with tension, defining boundaries and suggesting trajectory within the picture plane."}
   {:id "shape" :title "Shape" :desc "The fundamental unit of composition. Shapes act not merely as outlines, but as fields of influence that define negative space and interact with neighboring forms."}
   {:id "form" :title "Form" :desc "The illusion of volume on a flat surface. Through the manipulation of light and shadow (chiaroscuro), form creates a perceptual ambiguity between the 2D plane and 3D space."}
   {:id "color" :title "Color" :desc "The most relative medium in art. Color creates mood and depth not through absolute hue, but through the interaction and vibration of adjacent chromatic fields."}
   {:id "texture" :title "Texture" :desc "The tactile quality of a surface, whether physical or implied. In the digital realm, texture arises from optical interference and the density of information."}
   {:id "space" :title "Space" :desc "Not emptiness, but volume. 'Ma' (negative space) is an active participant in composition, pushing against positive forms to create balance and breath."}
   {:id "value" :title "Value" :desc "The architecture of light. Independent of color, value establishes the dramatic structure of a piece, revealing geometry through the gradation of luminosity."}])

(def principles
  [{:id "balance" :title "Balance" :desc "The equilibrium of opposing visual forces. It is the asymmetrical tension where a massive static form is counterweighted by a small, dynamic element."}
   {:id "contrast" :title "Contrast" :desc "The interplay of opposites—clarity vs. obscurity, geometric vs. organic. High contrast creates drama; low contrast creates mystery."}
   {:id "emphasis" :title "Emphasis" :desc "The disruption of pattern. The eye is inevitably drawn to the anomaly—the stillness in chaos, or the single deviation in a field of uniformity."}
   {:id "movement" :title "Movement" :desc "The capture of time in a static medium. Through rhythm and line, the artist dictates the viewer's optical journey across the canvas."}
   {:id "pattern" :title "Pattern" :desc "Emergence from rules. Pattern is the predictable repetition that allows the viewer to anticipate continuity, creating a comforting or hypnotic visual structure."}
   {:id "rhythm" :title "Rhythm" :desc "Visual music. Unlike simple repetition, rhythm relies on syncopation and interval, creating a 'beat' that guides the eye through the composition."}
   {:id "unity" :title "Unity" :desc "The Gestalt moment. The fleeting instant where disparate chaotic elements align to form a coherent whole, proving the sum is greater than its parts."}])

(def composition
  {:id "composition" :title "Composition" :desc "The Synthesis. Composition is the act of arranging the Elements according to the Principles. It is the sentence constructed from the grammar of art—the deliberate orchestration of visual forces to create meaning, emotion, and aesthetic resolve."})

(defn layout [title & content]
  (html5
   [:head
    [:title (str title " - The Grammar of Art")]
    (include-css (url "/css/style.css"))
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]]
   [:body
    [:header
     [:div.logo-container
      [:img.logo {:src (url "/img/glider.png") :alt "Glider Pattern"}]
      [:h1 [:a {:href (url "/")} "The Grammar of Art"]]]
     [:nav
      [:ul
       [:li [:a.special {:href (url "/composition.html")} "Composition"]]]]]
    [:main content]
    [:footer
     [:p "The Grammar of Art - Built with Clojure"]]]))

(defn home-page []
  (layout "Home"
          [:div.hero
           [:h2 "Master the Basics"]
           [:p "Explore the building blocks of visual art."]
           [:div.grid-container
            [:div.card
             [:h3 "The Elements"]
             [:p "The tools to make art."]
             [:ul.link-grid (for [e elements] [:li [:a {:href (url (str "/element/" (:id e) ".html"))} (:title e)]])]]
            [:div.card
             [:h3 "The Principles"]
             [:p "How to use the tools."]
             [:ul.link-grid (for [p principles] [:li [:a {:href (url (str "/principle/" (:id p) ".html"))} (:title p)]])]]
            [:div.card.composition-card
             [:h3 "Composition"]
             [:p "The Synthesis."]
             [:ul.link-grid [:li [:a {:href (url "/composition.html")} "View the Masterpiece"]]]]]]))

(defn detail-page [type id]
  (let [items (cond 
                (= type "element") elements 
                (= type "principle") principles
                :else [composition])
        idx (first (keep-indexed #(when (= (:id %2) id) %1) items))
        item (nth items idx)
        prev-item (when (pos? idx) (nth items (dec idx)))
        next-item (when (< idx (dec (count items))) (nth items (inc idx)))]
    (if item
      (layout (:title item)
              [:div.detail-container {:class (str type "-" id)}
               [:div.text-content
                [:h2 (:title item)]
                [:p.definition (:desc item)]
                [:div.page-nav
                 (if prev-item
                   [:a.prev {:href (url (str "/" type "/" (:id prev-item) ".html"))} (str "← " (:title prev-item))]
                   [:span]) ;; spacer
                 (if next-item
                   [:a.next {:href (url (str "/" type "/" (:id next-item) ".html"))} (str (:title next-item) " →")])]]
               [:div.visual-demo
                [:div.demo-canvas]]])
      (layout "Not Found" [:h2 "Topic not found."]))))