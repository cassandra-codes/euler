(ns project-euler.problem15)

(defn build-lattice
  "Populates each vertex in an n x n lattice with the number of
   possible paths to that vertex from 0,0 only going down or right."
  [n]
  (loop [lattice [(repeat (inc n) 1)]
         n   n]
    (if (= 0 n)
      lattice
      (recur (conj lattice (reductions + (last lattice))) (dec n)))))

(defn get-paths
  "The number of possible paths to the bottom-right corner of an n x n
  lattice, starting from the top-left and only moving down or right."
  [n]
  (last (last (build-lattice n))))


(time (get-paths 20))
