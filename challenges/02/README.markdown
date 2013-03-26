# Сметка

Напишете прост интерфейс за създаване на сметка в банка. Той трябва да предлага следните функции:

* `(make-account)` която създава нова сметка с баланс 0
* `(balance account)` която връща баланса на сметката
* `(deposit account amount)` увеличава сметката с `amount` и връща сметката
* `(withdraw account amount)` намалява сметката с `amount` и връща сметката
* Последните две операции трябва да повдигат `IllegalStateException`, ако потребителя опита да ползва друго, освен цели числа (`integer?`)

Представете си, че сметката ни има неограничен кредит и съответно е напълно ОК баланса да е отрицателен. `withdraw` и `deposit` трябва да връщат сметката за удобвство при извикване. Примерен код:

    (-> (make-account) (deposit 10) (withdraw 6) balance)
    ; 4

    (def account (make-account))
    (deposit account 20)
    (withdraw account 50)
    (balance account) ; -30

    (deposit account 0.5)
    ; IllegalStateException
