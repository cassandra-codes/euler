(ns project-euler.problem23)

(defn divisors [n]
  (loop [i  2
         ds [1]]
    (if (> i (Math/sqrt n))
      (distinct ds)
      (if (= 0 (mod n i))
        (recur (inc i) (concat ds [i (/ n i)]))
        (recur (inc i) ds)))))


(defn d
  [n]
  (apply + (divisors n)))


(defn perfect?
  [n]
  (= n (d n)))

(defn deficient?
  [n]
  (> n (d n)))

(defn abundant?
  [n]
  (< n (d n)))