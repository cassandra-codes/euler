(ns project-euler.problem01)

(defn upper-bound [k n]
  (Math/floor (/ (dec n) k)))

(defn sum-k [k n]
  (let [p (upper-bound k n)]
    (* k (/ (*' (inc p) p) 2))))

(defn subsets [s]
  (if (seq s)
    (let [f   (first s)
          srs (subsets (disj s f))]
      (concat srs (map #(conj % f) srs)))
    (list '())))

(defn sum-ks [n & xs]
  (let [xs (set xs)]
    (int (reduce + (map #(if  (odd?  (count %))
                              (sum-k (reduce * %) n)
                           (- (sum-k (reduce * %) n)))
                        (filter #(not-empty %) (subsets xs)))))))
