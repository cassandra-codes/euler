(ns project-euler.problem04
  (:require [clojure.string :as string]))


(defn palindrome
  "Appends a mirror image of itself to x and parses it as an int."
  [x]
  (let [first-half (str x)
        second-half (string/join (reverse first-half))]
    (Integer/parseInt (str first-half second-half))))


(defn closest-factor-pair
  "Finds the two factors closest to the square root of x."
  [x]
  (let [sqrt (Math/sqrt x)]
    (loop [k    (int sqrt)]
      (cond (> (/ x k) 999) nil
            (zero? (mod x k)) x
            :else (recur (dec k))))))

(defn solution
  "Display the largest palindromic product of 2 three-digit integers"
  []
  (let [palindromes (map palindrome (range 997 100 -1))]
    (println (first (filter some? (map closest-factor-pair palindromes))))))

(defn time-it [x] (with-out-str (time x)))

(println (time-it (solution)))
