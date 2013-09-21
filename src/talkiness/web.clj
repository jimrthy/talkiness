(ns talkiness.web
  (:use compojure.core))

(defn landing-page [_]
  "HELLO!")

(defroutes handler
  (GET "/" [] landing-page))

(def app
  ;; FIXME: This can't possibly be correct
  (-> handler))
