(ns project-euler.problem20
  (require [clojure.string :as string]))

(defn !
  [n]
  (apply *' (range n 0 -1)))

(defn sum-digits
  [n]
  (apply + (map #(Integer/parseInt %) (string/split (str n) #""))))

(print (sum-digits (! 100)))