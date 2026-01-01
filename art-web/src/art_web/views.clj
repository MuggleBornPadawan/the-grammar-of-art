(ns art-web.views
  (:require [hiccup.page :refer [html5 include-css]]))

;; Change this to "" for local dev, "/art" for GitHub Pages
(def ^:dynamic *base-url* "")

(defn url [path]
  (str *base-url* path))

(def elements
  [{:id "line" :title "Line" :desc "The record of a gesture in time. Line is the primary division of the void, a path that vibrates with tension. It defines the boundaries of existence and suggests trajectory within the picture plane."}
   {:id "shape" :title "Shape" :desc "The imposition of boundary upon the infinite. Shapes are not merely outlines, but fields of influence that define negative space and establish the fundamental geography of the canvas."}
   {:id "form" :title "Form" :desc "The illusion of mass in a massless medium. Through the architecture of light and shadow (chiaroscuro), form creates a perceptual ambiguity, forcing the 2D plane to surrender to 3D volume."}
   {:id "color" :title "Color" :desc "The emotional frequency of light. It is the most relative and subjective medium, creating mood not through absolute hue, but through the vibrating interaction of adjacent chromatic fields."}
   {:id "texture" :title "Texture" :desc "The tactile memory of the eye. Whether physical or implied, texture disrupts the silence of the surface, introducing noise, history, and the density of information."}
   {:id "space" :title "Space" :desc "The active presence of nothingness. 'Ma' (negative space) is not empty; it is a pressurized volume that pushes against positive forms, allowing the composition to breathe."}
   {:id "value" :title "Value" :desc "The revealer of geometry. Independent of color, value establishes the dramatic structure of the image, carving form out of darkness through the precise gradation of luminosity."}])

(def principles
  [{:id "balance" :title "Balance" :desc "The precarious stillness between opposing forces. It is the management of visual weight, where a massive, static silence creates a counterweight to a small, dynamic noise."}
   {:id "contrast" :title "Contrast" :desc "The violence of difference. It is the juxtaposition of opposites—clarity vs. obscurity, geometric vs. organic—that generates visual energy and prevents the stasis of monotony."}
   {:id "emphasis" :title "Emphasis" :desc "The disruption of the expected. The eye is inevitably drawn to the anomaly—the single deviation in a field of uniformity that demands immediate interrogation."}
   {:id "movement" :title "Movement" :desc "The dragging of the eye through time. By manipulating rhythm and line, the artist acts as a director, dictating the viewer's optical journey across the static surface."}
   {:id "pattern" :title "Pattern" :desc "The comfort of prediction. Pattern is the establishment of rules that allows the viewer to anticipate continuity, creating a hypnotic visual structure that implies an infinite field."}
   {:id "rhythm" :title "Rhythm" :desc "Visual syncopation. Unlike simple repetition, rhythm relies on interval and variation, creating a musical 'beat' that pulses through the composition."}
   {:id "unity" :title "Unity" :desc "The resolution of chaos. The Gestalt moment where disparate, competing elements surrender their individuality to form a singular, inevitable whole."}])

(def perception
  [{:id "closure" :title "Closure" :desc "The viewer's complicity in creation. The mind refuses fragmentation, instinctively filling in gaps to perceive a whole form, proving that seeing is an act of construction."}
   {:id "proximity" :title "Proximity" :desc "The gravitational pull of forms. Objects placed near one another lose their isolation, read by the brain as a coherent unit or narrative group regardless of their individual nature."}
   {:id "similarity" :title "Similarity" :desc "The tribalism of vision. The eye aggressively groups elements that share characteristics—shape, color, size—creating implied layers and categories within a chaotic field."}
   {:id "figure-ground" :title "Figure-Ground" :desc "The instability of the subject. The constant battle between the object of focus and its context; playing with this boundary creates ambiguity and intellectual tension."}
   {:id "continuity" :title "Continuity" :desc "The inertia of sight. The eye prefers to follow a path of least resistance, flowing along curves and lines beyond their endpoints, linking separate events into a single narrative flow."}])

(def structure
  [{:id "golden-ratio" :title "Golden Ratio" :desc "The sacred proportion. A mathematical echo of organic growth (approx. 1:1.618) that yields an aesthetically inevitable balance, connecting the artifice of design to the laws of nature."}
   {:id "rule-of-thirds" :title "Rule of Thirds" :desc "The avoidance of the center. A grid system that forces the subject into the margins, creating a dynamic imbalance that is far more energetic and engaging than perfect symmetry."}
   {:id "hierarchy" :title "Hierarchy" :desc "The authoritarian ordering of information. Through scale, weight, and position, the artist manipulates the viewer's decoding process, determining what is read first, and what is read last."}
   {:id "economy" :title "Economy" :desc "The power of the omitted. The discipline of 'less is more,' where the removal of non-essential noise amplifies the signal of the subject."}
   {:id "variety" :title "Variety" :desc "The antidote to boredom. The necessary introduction of difference in scale, shape, or texture to hold the viewer's attention and prevent the composition from becoming a wallpaper."}])

(def spatial-depth
  [{:id "linear-perspective" :title "Linear Perspective" :desc "The rationalization of infinity. A mathematical system that pierces the picture plane, creating a convincing window into a constructed, receding world."}
   {:id "atmospheric-perspective" :title "Atmospheric Perspective" :desc "The weight of the air. The realization that atmosphere is not transparent; it veils distant forms in light and cool tones, simulating the vastness of the natural world."}
   {:id "foreshortening" :title "Foreshortening" :desc "The aggressive projection. The visual distortion of an object's dimensions when viewed head-on, thrusting the form violently into the viewer's space."}
   {:id "overlapping" :title "Overlapping" :desc "The hierarchy of distance. The simplest yet most effective cue for depth; when one object obscures another, it asserts its dominance in the Z-axis."}])

(def color-dynamics
  [{:id "temperature" :title "Temperature" :desc "The tactile quality of light. The psychological sensation of heat (advance) and cold (retreat) that manipulates the viewer's perception of depth and mood."}
   {:id "saturation" :title "Saturation" :desc "The intensity of existence. The difference between a shout and a whisper; high chroma demands attention, while desaturation implies distance, age, or neutrality."}
   {:id "simultaneous-contrast" :title "Simultaneous Contrast" :desc "The lie of the eye. The phenomenon where a color's identity is unstable, shifting dramatically based on the chromatic context that surrounds it."}])

(def composition
  {:id "composition" :title "Composition" :desc "The Arrested Moment. Composition is not a formula; it is the freezing of dynamic forces in a state of precarious equilibrium. It is a confrontation between the rigid logic of geometry and the chaotic will of the artist, holding the viewer in the tension between these opposing powers."})

(defn layout [title & content]
  (html5
   [:head
    [:title (str title " - The Grammar of Art")]
    (include-css (url "/css/style.css"))
    [:script {:src (url "/js/interaction.js") :defer true}]
    [:meta {:name "viewport" :content "width=device-width, initial-scale=1"}]]
   [:body
    [:header
     [:a.logo-link {:href (url "/")}
      [:img.full-logo {:src (url "/img/logo_full.svg") :alt "The Grammar of Art"}]]
     [:nav
      [:ul
       [:li [:a.special {:href (url "/composition.html")} "Composition"]]]]]
    [:main content]
    [:footer
     [:p "The Grammar of Art - Built with Clojure"]]]))

(defn home-page []
  (layout "Home"
          [:div.hero
           [:h2 "The Vocabulary of Vision"]
           [:p "A curated exploration of the forces that shape visual perception."]
           [:div.grid-container
            [:div.collection
             [:h3 "The Elements"]
             [:p "The primal atoms of art."]
             [:ul.link-grid (for [e elements] [:li [:a {:href (url (str "/element/" (:id e) ".html"))} (:title e)]])]]
            [:div.collection
             [:h3 "The Principles"]
             [:p "The management of tension."]
             [:ul.link-grid (for [p principles] [:li [:a {:href (url (str "/principle/" (:id p) ".html"))} (:title p)]])]]
            [:div.collection
             [:h3 "Perception"]
             [:p "The construction of reality."]
             [:ul.link-grid (for [p perception] [:li [:a {:href (url (str "/perception/" (:id p) ".html"))} (:title p)]])]]
            [:div.collection
             [:h3 "Structure"]
             [:p "The hidden geometry."]
             [:ul.link-grid (for [s structure] [:li [:a {:href (url (str "/structure/" (:id s) ".html"))} (:title s)]])]]
            [:div.collection
             [:h3 "Spatial Depth"]
             [:p "The conquest of the plane."]
             [:ul.link-grid (for [s spatial-depth] [:li [:a {:href (url (str "/spatial-depth/" (:id s) ".html"))} (:title s)]])]]
            [:div.collection
             [:h3 "Color Dynamics"]
             [:p "The alchemy of feeling."]
             [:ul.link-grid (for [c color-dynamics] [:li [:a {:href (url (str "/color-dynamics/" (:id c) ".html"))} (:title c)]])]]]
           [:div.composition-section
            [:h3 "Composition"]
            [:p "The Synthesis of Forces."]
            [:a.button {:href (url "/composition.html")} "View the Masterpiece"]]]))

(defn detail-page [type id]
  (let [items (cond 
                (= type "element") elements 
                (= type "principle") principles
                (= type "perception") perception
                (= type "structure") structure
                (= type "spatial-depth") spatial-depth
                (= type "color-dynamics") color-dynamics
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
                (if (= id "composition")
                  [:div.demo-canvas
                   [:div.layer-structure]
                   [:div.layer-space
                    [:div.horizon]]
                   [:div.layer-subject]]
                  [:div.demo-canvas])]])
      (layout "Not Found" [:h2 "Topic not found."]))))