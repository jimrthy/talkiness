(ns talkiness.models
  (:use korma.core))

(declare author)

;; Want versioned posts. This approach doesn't particularly work.
(defentity post
  (entity-fields :title :body :saved :version)
  (many-to-many author :author_post))

(defentity name
  (entity-fields :first :middle :last))

(defentity author
  (has-many name))

