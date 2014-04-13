(use 'clojure.test)

(load-file "solution.clj")

(deftest challenge-05-sample-test
  (let [coll (lazy
               (+ 1 2)
               (/ 1 0))]
    (is (not (realized? coll)))
    (is (= (first coll) 3))))

(run-tests)
