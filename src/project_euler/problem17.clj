(ns project-euler.problem17
  (:require [clojure.string :refer [split]]))

(def ands
  (* 3 (- 1000 100 10)))

(def number-map
  {"1" "one"
   "2" "two"})


(defn int->word [x]
  (let [sx (->> x
               str
               reverse
               (partition-all 3 3)
               reverse
               (map reverse))]
    sx))