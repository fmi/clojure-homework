(use 'clojure.test)

(load-file "solution.clj")

(deftest sample-test
  (testing "empty"
    (is (= [0 0] (game {} {}))))
  (testing "first-last-three"
    (let [p0 {:v0 [() '(11) '(6 -1 3) '(5)] :v1 ['(11) '(6 -1 3) '(5) '(23 3 3 3 -1) () () '(5)]}
          p1 {:v0 [() '(11)] :v1 [] }]
      (is (= [3 1] (game p0 p1)))))
  (testing "average of sum of squares is bigger than other player's numbers"
    (let [p0 {:v ['(1, 2), (), '(8, -2), '(-1, 5, -1)]}
          p1 {:v ['(7 150) '(4 33)] :m {:f -50} :f (comp + + -) :s #{-1}}]
      (is (= [1 1] (game p0 p1)))))
  (testing "commutative fibonacci"
    (let [p0 {:f0 #(if (= [%1 %2] [0 0]) 0 111)}
          p1 {}]
      (is (= [1 0] (game p0 p1))))))

(run-tests)
