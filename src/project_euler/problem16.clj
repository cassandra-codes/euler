(ns project-euler.problem16
  (:require [clojure.string :as string]))

(defn big-exp [n k]
  (reduce #(*' %1 %2) (repeat k n)))

(def big-num (big-exp 2 1000))

(defn sum-digits [x]
  (let [xs (map #(Integer. %) (string/split (str x) #""))]
    (reduce #(+ %1 %2) xs)))

(println (sum-digits big-num))