(ns project-euler.problem09)

;;;; A Pythagorean triplet is a set of three natural numbers, a < b < c, for which,
;;;;
;;;; a2 + b2 = c2
;;;; For example, 32 + 42 = 9 + 16 = 25 = 52.
;;;;
;;;; There exists exactly one Pythagorean triplet for which a + b + c = 1000.
;;;; Find the product abc.

(defn t-1
  [[a b c]]
  [(+      a   (* -2 b) (* 2 c))
   (+ (* 2 a)     (- b) (* 2 c))
   (+ (* 2 a)  (* -2 b) (* 3 c))])

(defn t-2
  [[a b c]]
  [(+      a   (*  2 b) (* 2 c))
   (+ (* 2 a)        b  (* 2 c))
   (+ (* 2 a)  (*  2 b) (* 3 c))])

(defn t-3
  [[a b c]]
  [(+    (- a)  (* 2 b) (* 2 c))
   (+ (* -2 a)       b  (* 2 c))
   (+ (* -2 a) (*  2 b) (* 3 c))])


(defn transform [abc]
  [(t-1 abc) (t-2 abc) (t-3 abc)])


(defn triplets [abc]
  (lazy-cat (transform abc) (mapcat triplets (transform abc))))


(def pythagorean-triplets
  (triplets [3 4 5]))

(defn find-primitive [n]
  (first (filter #(= 0 (mod n (apply + %))) pythagorean-triplets)))


(defn solution [n]
  (let [primitive (find-primitive n)
        primitive-sum (apply + primitive)]
    (map #(* % (/ n primitive-sum))  primitive)))

(println (solution 1000))


