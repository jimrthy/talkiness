(ns talkiness.system
  (:require [korma.db :as db]
            [ring.adapter.jetty :as ws]
            [talkiness.config :as config]
            [talkiness.web :as web]))

(defn init []
  ;; This is a side-effect, which probably shouldn't happen here.
  ;; At the same time, it needs to happen ASAP
  ;; FIXME: Is that still true? People on IRC acted as if
  ;; they've never heard of the issue.
  (alter-var-root #'*read-eval* (constantly false))

  {:database (atom nil)
   :web-server (atom (ws/run-jetty #'web/app {:port (config/web-port)}))})

(defn- init-database [c-m]
  (db/defdb talky-db (db/postgres c-m)))

(defn start! [system]
  ;;; Database
  (let [connection-map {:db "talkiness"
                        :user "talky-person"
                        :password "seriously? multiple places?"}]
    (swap! (:database system) init-database connection-map))

  ;;; Web Server
  (.start @(:web-server system))

  ;;; Since it's called strictly for side-effects
  nil)

(defn kill-database [db]
  ;; Doesn't seem to be any obvious way in the surface korma docs re:
  ;; HOWTO actually do this.
  ;; FIXME: Dig deeper and find it. Has to be around somewhere.
  nil)

(defn kill! [system]
  (swap! (:database system) kill-database)
  (.stop @(:web-server system))
  nil)
