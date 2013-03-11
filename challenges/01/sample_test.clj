(use 'clojure.test)

(load-file "solution.clj")

(deftest challenge-01-sample-test
  (is (= (histogram [0 0 0 0 2 2]) [4 0 2]))
  (is (= (histogram '(1 1 1 4)) [0 3 0 0 1]))
  (is (= (histogram [0]) [1])))

(run-tests)
