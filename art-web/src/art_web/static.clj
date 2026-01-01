(ns art-web.static
  (:require [art-web.views :as views]
            [clojure.java.io :as io]))

(defn write-page [path content]
  (let [file (io/file "../docs" path)]
    (io/make-parents file)
    (spit file content)
    (println "Generated:" path)))

(defn -main []
  (println "Generating static site...")
  
  ;; Set base URL for GitHub Pages
  (alter-var-root #'views/*base-url* (constantly "/art"))

  ;; Generate Home
  (write-page "index.html" (views/home-page))

  ;; Generate Elements
  (doseq [e views/elements]
    (write-page (str "element/" (:id e) ".html") 
                (views/detail-page "element" (:id e))))

  ;; Generate Principles
  (doseq [p views/principles]
    (write-page (str "principle/" (:id p) ".html") 
                (views/detail-page "principle" (:id p))))

  ;; Copy CSS
  (let [css-source (io/file "resources/public/css")
        css-dest (io/file "../docs/css")]
    (if (.exists css-source)
      (do
        (.mkdirs css-dest)
        (doseq [file (file-seq css-source)]
          (when (.isFile file)
            (let [rel-path (subs (.getPath file) (count (.getPath css-source)))
                  dest-file (io/file css-dest (if (.startsWith rel-path "/") (subs rel-path 1) rel-path))]
              (io/make-parents dest-file)
              (io/copy file dest-file)
              (println "Copied CSS:" (.getName file))))))
      (println "Warning: CSS directory not found.")))

  ;; Copy Images
  (let [img-source (io/file "resources/public/img")
        img-dest (io/file "../docs/img")]
    (if (.exists img-source)
      (do
        (.mkdirs img-dest)
        (doseq [file (file-seq img-source)]
          (when (.isFile file)
            (let [rel-path (subs (.getPath file) (count (.getPath img-source)))
                  dest-file (io/file img-dest (if (.startsWith rel-path "/") (subs rel-path 1) rel-path))]
              (io/make-parents dest-file)
              (io/copy file dest-file)
              (println "Copied Image:" (.getName file))))))
      (println "Warning: Image directory not found.")))
  
  (println "Static site generation complete!"))
