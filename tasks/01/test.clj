(deftest task-01-test
  (letfn [(abs [n] (if (neg? n) (- n) n))
          (close? [a b] (< (abs (- a b)) 0.01))
          (cube [x] (* x x x))]
    (is (close? 10 (bisect #(- (cube %) 1000) 8 30 close?))
      "simple bisect")
    (is (close? 9.999 (bisect #(- (cube %) 1000) 8 30 close?))
      "bisect with a number close enough to the root")
    (is (close? 1.2599 (bisect #(- (cube %) 2) 0 10 close?))
      "bisect with irrational number")
    (is (nil? ((make-bisector 0.01) #(- (cube %) 1000) -5 9))
      "make-bisector with negative funciton values for both points")
    (is (close? 10 ((make-bisector 0.01) #(- 1000 (cube %)) -200 100 ))
      "make-bisector with inverted positive and negative function values at points"))

  (is (-> (make-queue) empty-queue?)
      "empty queue is empty")
  (is (->
        (make-queue)
        (push-to-queue "baba")
        ((complement empty-queue?)))
      "empty queue is empty")
  (is (->
        (make-queue)
        (push-to-queue "baba")
        pop-from-queue
        pop-from-queue
        empty-queue?)
      "empty queue can be popped")
  (is (= 199360981
         (-> (make-queue)
             (push-to-queue "baba")
             (push-to-queue 199360981)
             (push-to-queue "wink")
             pop-from-queue
             peek-at-queue))
      "push push push pop peek")
  (is (= 199360981
         (-> (make-queue)
             (push-to-queue "baba")
             (push-to-queue "wink")
             pop-from-queue
             (push-to-queue 199360981)
             (push-to-queue "rake")
             pop-from-queue
             peek-at-queue))
      "push push pop push push pop peek")
  (is (= 199360981
         (-> (make-queue)
             (push-to-queue "baba")
             (push-to-queue "wink")
             pop-from-queue
             pop-from-queue
             pop-from-queue
             (push-to-queue 199360981)
             peek-at-queue))
      "push some then pop all then push again")
  (is (-> (make-queue)
          (push-to-queue "baba")
          (push-to-queue "wink")
          pop-from-queue
          pop-from-queue
          peek-at-queue
          nil?)
      "peek at empty queue is nil"))
