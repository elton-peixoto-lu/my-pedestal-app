(ns my-pedestal-app.routes
    (:require [io.pedestal.http :as http]
      [io.pedestal.http.route :as route]
      [io.pedestal.http.body-params :as body-params]
      [my-pedestal-app.handlers :as handlers]))

(def common-interceptors
  [(body-params/body-params)
   http/html-body])

(def routes
  (route/expand-routes
    #{["/" :get (conj common-interceptors handlers/index) :route-name :index]
      ["/action" :post (conj common-interceptors handlers/action-handler) :route-name :action]}))

(def service-map
  {:env :prod
   ::http/routes routes
   ::http/resource-path "/public"
   ::http/type :jetty
   ::http/port 8080})
