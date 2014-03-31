(deftest challenge-04-test
  (let [digits (vec "0123456789")
        letters (vec "abcdefghijklmnopqrstuvwxyz")]
    (is (= (shorten-ranges "qwerty" [\q \w \e \r \t \y]) "q..y"))
    (is (= (shorten-ranges "->0123|4567" digits) "->0..3|4..7"))
    (is (= (shorten-ranges "defghijkmnoprst" letters) "d..km..pr..t"))
    (is (= (-> "asf123123dfghkwxyz0125678opqrstu"
               (shorten-ranges digits)
               (shorten-ranges letters))
           "asf1..31..3df..hkw..z0..25..8o..u"))
    (is (= (shorten-ranges "aabcc" (vec "aab|bcc")) "a..bcc"))
    (is (= (shorten-ranges "aaaabbbb" (vec "aaaa|bbbb|aaaabbbb")) "a..b"))
    (is (= (shorten-ranges "baaaaaa" (vec "baaPPaaaaaaaaaa")) "b..aa..a"))))
