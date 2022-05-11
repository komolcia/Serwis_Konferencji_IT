# Serwis_Konferencji_IT
Uruchomienie:

 source ~/.zshenv( dla mnie bo pracuje na macOs)
 ./mvnw spring-boot:run
Portal powinien obsługiwać następujące scenariusze:
1. Użytkownik może obejrzeć plan konferencji. 
Na początku trzeba dodać użytkownika:
POST http://localhost:8080/api/uzytkownik
{
    "login": "komolcia",
    "email":"komolcia@gmail.com"
   
}
GET http://localhost:8080/api/plan
Pokazuje się cały plan

2. Użytkownik po podaniu swojego loginu może obejrzeć prelekcje na które się zapisał. 
GET http://localhost:8080/api/komolcia
3. Jeżeli prelekcja ma jeszcze wolne miejsca, użytkownik ma możliwość dokonania rezerwacji. Podczas dokonywania rezerwacji powinien podać swój login oraz adres e-mail.
GET http://localhost:8080/api/uzytkownik/komolcia/komolcia@gmail.com/1
1-to jest id prelekcji
4. Jeżeli w systemie istnieje już użytkownik z danym loginem, ale z innym adresem e-mail, system powinien zaprezentować komunikat „Podany login jest już zajęty”.
Pojawia się
5. Poprawne dokonanie rezerwacji skutkuje wysłaniem powiadomienia użytkownikowi na podany przez niego adres (wysyłka wiadomości - patrz wskazówki). 
Na powiadomienia.txt
6. Użytkownik może anulować rezerwację. 
Nie może, bo mam cascade persist.
7. Użytkownik może zaktualizować swój adres e-mail. 
GET http://localhost:8080/api/komolcia/kom@wp.com
8. System umożliwia wyświetlenie listy zarejestrowanych użytkowników wraz z ich adresami e-mail. 
GET http://localhost:8080/api/uzytkownik
Nawet na jakie wykłady chodzą :)
12. Wygenerowanie zestawienia dla organizatora:
	- zestawienie wykładów wg zainteresowania (procentowy udział uczestników w danym wykładzie)
	- GET http://localhost:8080/api/zestawienie/wyklady
	- zestawienie ścieżek tematycznych wg zainteresowania (procentowy udział)
	- GET http://localhost:8080/api/zestawienie/temat

