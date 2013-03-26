(use 'clojure.test)

(load-file "solution.clj")

(deftest challenge-02-sample-test
  (is (= (-> (make-account) (deposit 10) balance)
         10))
  (is (= (try
           (deposit (make-account) 0.5)
           :didnt-raise
           (catch IllegalStateException e
             :raised-illegal-state))
         :raised-illegal-state))
  (is (= (let [account (make-account)]
           (deposit account 10)
           (withdraw account 5)
           (balance account))
         5)))

(run-tests)
