# RoomsLamps
Not completed. 
____
java, mysql, spring, hibernate, maven, thymeleaf, html, ajax

# ТЗ
Приложение “Комнаты с лампочками”\
Заходя на веб страницу, пользователь имеет возможность:
- создать комнату, указав ее имя и страну из списка. Страна нужна, чтобы ограничить пользователям доступ в комнату. +
- просмотреть список созданных комнат (включая комнаты, созданные другими пользователями) +
- “зайти” в одну из комнат и включить/выключить лампочку, находящуюся в ней. +
\Если страна пользователя отличается от страны комнаты, то при попытке входа в комнату пользователю показывается ошибка.\
Определение страны производится по IP адресу пользователя. // пока не реализовано\
Изменение состояния лампочки, должно отображаться для всех пользователей в комнате (как можно быстрее, без перезагрузки страницы) +\
Логин\регистрация не нужны. +\
Требования к реализации:
- Язык программирования серверной части - Java +
- UI может быть тривиальным +
- Unit/Integration тесты //пока нет
- Должна быть реализовано сохранение состояния между перезапусками приложения +
- Очень желательно иметь возможность запускать одной консольной командой без установки сторонних зависимостей. Если очень хочется  использовать docker/docker-compose. +
