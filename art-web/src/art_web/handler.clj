(ns art-web.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [art-web.views :as views]))

(defroutes app-routes
  (GET "/" [] (views/home-page))
  (GET "/element/:id" [id] (views/detail-page "element" id))
  (GET "/principle/:id" [id] (views/detail-page "principle" id))
  (GET "/perception/:id" [id] (views/detail-page "perception" id))
  (GET "/structure/:id" [id] (views/detail-page "structure" id))
  (GET "/spatial-depth/:id" [id] (views/detail-page "spatial-depth" id))
  (GET "/color-dynamics/:id" [id] (views/detail-page "color-dynamics" id))
  (GET "/composition.html" [] (views/detail-page "composition" "composition"))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))