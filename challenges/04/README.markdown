# Обхвати

Напишете функция `shorten-ranges`, която приема низ и вектор от chars. Функцията
връща като резултат низa със съркатени в него всички поднизове, състоящи се от
повече от 2 последователни елемента на вектора. Механизма на действие е да
вървим по низа от ляво на дясно, като всеки път обработваме първото най-дълго
съкращение, след което продължаваме нататък. Малко примери:

    (shorten-ranges "qwerty" [\q \w \e \r \t \y])        ; "q..y"
    (shorten-ranges "->01|0123|4567" (vec "0123456789")) ; "->01|0..3|4..7"

    (shorten-ranges "aaaabbbb" (vec "aaaa|bbbb|aaaabbbb")) ; a..b
    (shorten-ranges "aabcc" (vec "aab|bcc")) ; a..bcc

    (shorten-ranges "baaaaaa" (vec "baa|aaaaaaaaaa")) ; b..aa..a
    (shorten-ranges "baab" (vec "aab|baa")) ;  b..ab
