(ns my-pedestal-app.handlers
    (:require [io.pedestal.interceptor :refer [interceptor]]
      [ring.util.response :as ring-resp]))

(def index
  (interceptor
    {:name ::index
     :enter
     (fn [context]
         (assoc context :response
                (-> (ring-resp/resource-response "index.html" {:root "public"})
                    (ring-resp/content-type "text/html"))))}))

(def action-handler
  (interceptor
    {:name ::action-handler
     :enter
     (fn [context]
         (assoc context :response
                (ring-resp/response "Hi Human!")))}))
