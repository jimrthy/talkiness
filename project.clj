(defproject talkiness "0.1.0-SNAPSHOT"
  :description "Blogging...more as a homework assignment than anything else"
  :url "TODO"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[compojure "1.1.5"]
                 [korma "0.3.0-RC5"]
                 [migratus "0.6.0"]
                 [org.clojure/clojure "1.5.1"]
                 [org.postgresql/postgresql "9.2-1002-jdbc4"]
                 [ring/ring-core "1.2.0"]
                 [ring/ring-jetty-adapter "1.2.0"]
                 [slingshot "0.10.3"]]
  :main talkiness
  :min-lein-version "2.0.0"
  :pedantic? :abort
  :plugins [[migratus-lein "0.1.0"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "0.2.4"]]
                   :source-paths ["dev"]}}
  ;; This really seems like a bad thing to be storing somewhere this
  ;; public.
  :migratus {:store :database
             :migration-dir "migrations"
             :db {:classname "org.postgresql.Driver"
                  :subprotocol "postgresql"
                  :subname "//localhost:5432/talkiness"
                  :user "talky_person"
                  :password "publishing this seems like a horrible idea"}})
