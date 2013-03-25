(use 'clojure.test)

(load-file "solution.clj")

(defn add
  {:cached true
    :events :+
    :metrics "addition"}
  [& args]
  (count!)
  (apply + args))

(deftest task-03-sample-tests
  (is (= (do (reset-counter!) (count!) (count!) (get-count))
         2)
      "counter: two increments")

  (let [add (add-metrics + :add)]
    (is (= (do (add 1 1)
               (calls :add 1 1))
           1)
        "add-metrics: 1 call"))

  (let [events (atom [])
        add-to-events #(swap! events conj %&)
        add (add-events + :add)]
    (is (= (binding [*before* {:add add-to-events}]
             (add 1 2 3)
             @events)
           [[1 2 3]])
        "add-events: before"))

  (let [add (cache +)]
    (is (binding [*cache-hit* nil]
          (add 2 2)
          (add 2 2)
          (= *cache-hit* true))
        "cache: hit"))

  (let [add (annotated #'add)]
    (is (= (let [results (atom #{})
                 args-set (atom #{})]
             (binding [*before* {:+ #(swap! args-set conj %&)}
                       *after* {:+ #(swap! results conj (first %&))}]
               (reset-counter!)
               (add 1 2)
               (add 1 2)
               (add 2 3)
               (add 3 5)
               {:counter (get-count)
                :results @results
                :args-set @args-set
                :metrics {:add-1-2 (calls "addition" 1 2)
                          :add-2-3 (calls "addition" 2 3)
                          :add-3-5 (calls "addition" 3 5)
                          :add-5-8 (calls "addition" 5 8) } }))
           {:counter 3
            :results #{3 5 8}
            :args-set #{[1 2] [2 3] [3 5]}
            :metrics {:add-1-2 2 :add-2-3 1 :add-3-5 1 :add-5-8 0}})
        "everything together")))

(run-tests)
