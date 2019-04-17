(ns project-euler.problem07)

(defn primes []
  (loop [x  3
         xs [2]]
    (if (= (count xs) 10001)
      xs
      (if (some #(= 0 (mod x %)) xs)
        (recur (+ x 2) xs)
        (recur (+ x 2) (cons x xs))))))

(time (first (primes)))
