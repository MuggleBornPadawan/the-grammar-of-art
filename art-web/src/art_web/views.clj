(ns art-web.views
  (:require [hiccup.page :refer [html5 include-css]]))

;; Change this to "" for local dev, "/art" for GitHub Pages
(def ^:dynamic *base-url* "")

(defn url [path]
  (str *base-url* path))

(def elements
  [{:id "line" :title "Line" :desc "A point moving in space. Line can vary in width, length, curvature, color, or direction."}
   {:id "shape" :title "Shape" :desc "A two-dimensional area or plane that may be open or closed, free-form or geometric. It is found in nature or is made by humans."}
   {:id "form" :title "Form" :desc "A three-dimensional volume or the illusion of three dimensions; related to shape (which is 2D)."}
   {:id "color" :title "Color" :desc "The visual sensation dependent on the reflection or absorption of light from a given surface."}
   {:id "texture" :title "Texture" :desc "The surface quality of materials, either actual (tactile) or implied (visual)."}
   {:id "space" :title "Space" :desc "The emptiness or area between, around, above, below, or contained within objects."}
   {:id "value" :title "Value" :desc "Lightness or darkness of a hue or neutral color."}])

(def principles
  [{:id "balance" :title "Balance" :desc "The arrangement of parts so that they reach a state of equilibrium."}
   {:id "contrast" :title "Contrast" :desc "The arrangement of opposite elements (light vs. dark colors, rough vs. smooth textures, large vs. small shapes) in a piece."}
   {:id "emphasis" :title "Emphasis" :desc "Used to make certain parts of an artwork stand out. It creates the center of interest or focal point."}
   {:id "movement" :title "Movement" :desc "How the eye moves through the composition; leading the attention of the viewer from one aspect of the work to another."}
   {:id "pattern" :title "Pattern" :desc "The repetition of specific visual elements such as a unit of shape or form."}
   {:id "rhythm" :title "Rhythm" :desc "A principle of design that indicates movement, created by the careful placement of repeated elements."}
   {:id "unity" :title "Unity" :desc "The relationship among the elements of a visual that helps all the elements function together. Unity gives a sense of oneness to a visual image."}])

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
       [:li [:span "Elements: "]
        (for [e elements]
          [:a {:href (url (str "/element/" (:id e) ".html"))} (:title e)])]
       [:li [:span "Principles: "]
        (for [p principles]
          [:a {:href (url (str "/principle/" (:id p) ".html"))} (:title p)])]]]]
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
             [:ul (for [e elements] [:li [:a {:href (url (str "/element/" (:id e) ".html"))} (:title e)]])]]
            [:div.card
             [:h3 "The Principles"]
             [:p "How to use the tools."]
             [:ul (for [p principles] [:li [:a {:href (url (str "/principle/" (:id p) ".html"))} (:title p)]])]]]]))

(defn detail-page [type id]
  (let [items (if (= type "element") elements principles)
        item (first (filter #(= (:id %) id) items))]
    (if item
      (layout (:title item)
              [:div.detail-container {:class (str type "-" id)}
               [:div.text-content
                [:h2 (:title item)]
                [:p.definition (:desc item)]]
               [:div.visual-demo
                [:div.demo-canvas]]])
      (layout "Not Found" [:h2 "Topic not found."]))))
