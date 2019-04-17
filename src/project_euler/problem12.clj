(ns project-euler.problem12)


(defn prime-factors
  "Returns the prime factors of n."
  [n]
  (loop [x  2
         n  n
         xs []]
    (if (> x n)
      xs
      (if (= 0 (mod n x))
        (recur x (/ n x) (cons x xs))
        (recur (inc x) n xs)))))

(defn factor-count
  "Returns the number of factors belonging to n."
  [n]
  (let [factors (prime-factors n)]
    (apply * (map (comp inc count) (vals (group-by (partial +) factors))))))

(defn triangle
  "Produces the nth triangular number."
  [n]
  (/ (* n (+ n 1)) 2))

(def triangles
  "Lazily generates triangular numbers."
  (map triangle (map inc (range))))

(println (first (filter #(> (factor-count %) 500) triangles)))
