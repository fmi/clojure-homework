(use 'clojure.test)

(load-file "solution.clj")

(deftest challenge-02-sample-test
  (is (= (fight :scissors :spock) [:spock :smashes :scissors])))

(run-tests)
