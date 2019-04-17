(ns project-euler.problem02)

(defn dot
  "The sum of the elementwise products of two vectors"
  [xs ys]
  (reduce +' (map *' xs ys)))

(defn transpose [xs]
  "Flips an N x M matrix along diagonal i,j such that i = j"
  (apply map vector xs))


(defn mmult
  "Multiplies an N x M matrix by an M x P matrix to produce an N x P matrix"
  ([xs ys]
   (let [matrix (map (fn [x] (map (partial dot x) (transpose ys))) xs)]
     (vec (map vec (doall matrix)))))
  ([xs ys & more]
   (reduce mmult (mmult xs ys) more)))

(defn m-exp
  "Matrix `mat` raised to the power of `n`"
  [mat n]
  (loop [n n
         xs mat
         ys [[1 0] [0 1]]]
    (if (= 1 n)
      (mmult xs ys)
      (if (even? n)
        (recur (/ n 2) (mmult xs xs) ys)
        (recur (/ (dec n) 2) (mmult xs xs) (mmult xs ys))))))


(defn nth-fib
  "The nth Fibonacci number"
  [n]
  (get-in (m-exp [[1 1] [1 0]] n) [1 0]))


;; (println (reduce +' (filter (partial < 4000000) (map nth-fib (range 3 100000 3)))))

