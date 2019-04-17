(ns project-euler.problem06)

(defn sum-of-squares [xs]
  (reduce +' (map #(*' % %) xs)))

(defn square-of-sums [xs]
  (#(*' % %) (reduce +' xs)))

(def solution (- (square-of-sums (range 1N 101N)) (sum-of-squares (range 1N 101N))))

(println solution)
