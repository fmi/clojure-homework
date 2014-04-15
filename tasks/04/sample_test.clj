(use 'clojure.test)

(load-file "solution.clj")

(deftest task-04-sample-test
  (is (= (match 3
           1 :1
           2 :2
           3 :3
           4 :4)
        :3))

  (is (= (match [3 4]
           :seq  :0
           _     :1
           [2 3] :2
           [_ 4] :3
           [4 5] :4)
        :3)))

(run-tests)
