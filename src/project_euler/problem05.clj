(ns project-euler.problem05)

(defn divide-if-divisible
  "Divides x by y if y is a factor x, otherwise returns x."
  [x y]
  (if (= 0 (mod x y))
    (/ x y)
    x))

(defn reduce-primes
  "Reduces a collection of integers to the minimum collection of primes
  required to produce each integer."
  [xs]
  (loop [xs xs
         ys []]
    (if-not (seq xs)
      ys
      (recur
        (map #(divide-if-divisible % (first xs)) (rest xs))
        (cons (first xs) ys)))))


(def n 20)
(def solution (reduce *' (lazy-seq (reduce-primes (range 2 (inc n))))))

(println solution)
