(ns project-euler.problem10)

(defn mod-zero?
  "Checks if x is evenly divisible by y"
  [x y]
  (= 0 (mod x y)))

(defn primes [n]
  (loop [xs (range 2 (inc n))
         primes []]
    (if (> (first xs) (Math/sqrt n))
      (concat primes xs)
      (let [k  (first xs)
            xs (filter #(not (mod-zero? % k)) xs)]
        (recur xs (cons k primes))))))

(time (reduce + (primes 2000000)))