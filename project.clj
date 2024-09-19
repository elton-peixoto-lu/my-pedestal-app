(defproject my-pedestal-app "0.0.1-SNAPSHOT"
  :description "A simple Pedestal application"
  :dependencies [[org.clojure/clojure "1.10.3"]
                 [io.pedestal/pedestal.service "0.5.8"]
                 [io.pedestal/pedestal.jetty "0.5.8"]
                 [org.slf4j/slf4j-simple "1.7.32"]]
  :main ^:skip-aot my-pedestal-app.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})

