UndestandingMyBatis
===================
Проект с примерами использования фреймворка MyBatis для работы с ораклом.
Помимо тривиальных запросов, так же будут приведены примеры получения специфических типов оракла.

Для корретной работы примера, необходимо создать тип в оракле.
create or replace type t_for_test_mybatis force is table of varchar2(4000)
