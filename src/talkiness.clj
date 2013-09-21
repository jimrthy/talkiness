(ns talkiness
  (:require [slingshot.slingshot :refer [try+]]
            [talkiness.config :as config]
            [talkiness.system :as system]))

(defn event-loop []
  ;; Really just a placeholder do-nothing that waits for the web server
  ;; to terminate. I seem to have a chicken/egg problem with that.
  ;; The entire point to this is cleaning up resources.
  ;; Which, at the moment, mostly means stopping the web server.
  ;; For now, just do nothing.
  )

(defn -main []
  (let [dead-universe (system/init)]
    ;; Note that this approach is pretty much totally non-dynamic.
    ;; If you change your source, you must restart the server.
    ;; This is mainly intended to be run through the REPL during dev,
    ;; so that shouldn't be a huge issue.
    (system/start! dead-universe)
    (try+
     (event-loop)
      (finally
        ;; Because we shouldn't get here until the web server
        ;; quits anyway.
        ;; Actually, that isn't true.
        ;; Web server should be running in a separate thread.
        ;; Once we kick it off, this thread is pretty much
        ;; meaningless.
        ;; Worry about implications when there's something that's
        ;; getting close to actually being used.
        (comment (system/kill! universe))))))


