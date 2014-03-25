(use 'clojure.test)

(load-file "solution.clj")

(deftest challenge-04-sample-test
  (let [digits (vec "0123456789")]
    (is (= (shorten-ranges "qwerty" [\q \w \e \r \t \y]) "q..y"))
    (is (= (shorten-ranges "->01|0123|4567" (vec "0123456789")) "->01|0..3|4..7"))))

(run-tests)
