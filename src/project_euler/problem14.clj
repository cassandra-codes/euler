(ns project-euler.problem14)


(defn add-hailstones [x]
  (if (= 0 (mod (dec x) 3))
    [(*' 2 x) (/ (dec x) 3)]
    [(*' 2 x)]))

(defn collatz-gen [x]
  (lazy-cat (add-hailstones x) (add-hailstones x)))

(def collatz
    (lazy-cat [1 2 4 8 16] (add-hailstones (last collatz))))

(println (take 40 collatz))

