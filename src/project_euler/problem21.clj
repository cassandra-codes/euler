(ns project-euler.problem21)

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


(defn amicable?
  "True if n has membership in an amicable pair, but does not bother about
  what the other element of the pair is."
  [n]
  (and (= n (d (d n))) (not= n (d n))))


(defn amicable-sum
  "The sum of all amicable numbers below n"
  [n]
  (apply + (filter amicable? (range 1 (inc n)))))


(print (amicable-sum 10000))
