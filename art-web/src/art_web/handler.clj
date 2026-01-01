(ns art-web.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [art-web.views :as views]))

(defroutes app-routes
  (GET "/" [] (views/home-page))
  (GET "/element/:id" [id] (views/detail-page "element" id))
  (GET "/principle/:id" [id] (views/detail-page "principle" id))
  (route/resources "/")
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))