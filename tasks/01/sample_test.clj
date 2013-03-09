(use 'clojure.test)

(load-file "solution.clj")

(defn abs [n]
  (if (neg? n) (- n) n))

(deftest sample-test
  (testing "half interval method"
    (let [difference 0.001
          fuzzy-equals? #(< (abs (- %1 %2)) difference)
          f #(+ 1 (+ % %))]
      (is (fuzzy-equals? (- 1/2) (bisect f -100 100 fuzzy-equals?)))
      (is (fuzzy-equals? (- 1/2) ((make-bisector difference) f -100 100)))))
  (testing "queue"
    (is (= "baba"
           (peek-at-queue
             (push-to-queue
               (push-to-queue
                 (pop-from-queue
                   (push-to-queue (make-queue) "wink-wink"))
                 "baba")
               "wink-wink"))))))

(run-tests)
