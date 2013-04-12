(use 'clojure.test)

(load-file "solution.clj")

(deftest task-04-test
  (let [all-stuck (set (for [x [0 1 2 3]
                             y [0 1 2 3]]
                         [[x y] :stuck]))
        up-left-moves (for [i (range 103 3 -1)
                            :let [start (mod i 4)
                                  end (mod (dec i) 4)]]
                        [[start start] [end end]])
        up-left (conj (vec up-left-moves) [[3 3] :no-more])]
    (is (= all-stuck (set (play-mall [[:X :X :X :X]
                                      [:X :X :X :X]
                                      [:X :X :X :X]
                                      [:X :X :X :X]])))
        "Test all stuck")
    (is (= up-left (play-mall        [[:- :- :- :-]
                                      [:- :- :- :-]
                                      [:- :- :- :-]
                                      [:- :- :- :X]]))
        "Test single dweller, going up and left")))

(run-tests)
