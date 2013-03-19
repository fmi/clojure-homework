(defn abs [x]
  (if (pos? x) x (- x)))

(defn bisect [f neg-point pos-point close-enough?]
  (let [mid (/ (+ neg-point pos-point) 2)]
    (if (close-enough? neg-point pos-point)
      mid
      (let [f-mid (f mid)]
        (cond
          (pos? f-mid) (recur f neg-point mid close-enough?)
          (neg? f-mid) (recur f mid pos-point close-enough?)
          :else mid)))))

(defn make-bisector [tolerance]
  (fn [f a b]
    (let [a-value (f a)
          b-value (f b)
          close-enough? #(< (abs (- %1 %2)) tolerance)]
      (cond
        (and (neg? a-value) (pos? b-value)) (bisect f a b close-enough?)
        (and (pos? a-value) (neg? b-value)) (bisect f b a close-enough?)
        :else nil))))

(defn make-queue [] [])
(defn empty-queue? [q] (empty? q))
(defn push-to-queue [q x] (conj q x))
(defn peek-at-queue [q] (first q))
(defn pop-from-queue [q] (if (empty-queue? q) [] (subvec q 1)))

