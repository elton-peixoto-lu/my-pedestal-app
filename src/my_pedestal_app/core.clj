(ns my-pedestal-app.core
    (:require [io.pedestal.http :as http]
      [my-pedestal-app.routes :as routes])
    (:gen-class))

(defonce server (atom nil))

(defn start []
      (reset! server (http/create-server routes/service-map))
      (http/start @server))

(defn stop []
      (http/stop @server))

(defn -main [& args]
      (start))
