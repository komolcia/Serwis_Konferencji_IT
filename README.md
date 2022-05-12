# Serwis_Konferencji_IT
Uruchomienie:
Trzeba zainstalować maven, intelij i postman w celu sprawdzenia wartości


 https://maven.apache.org/download.cgi -maven

https://www.jetbrains.com/idea/ -intelij

https://www.postman.com/downloads/ -Postman

mvn spring-boot:run w terminalu

./mvnw spring-boot:run

Portal powinien obsługiwać następujące scenariusze:
1. Użytkownik może obejrzeć plan konferencji. 
Na początku trzeba dodać użytkownika:


POST http://localhost:8080/api/uzytkownik
{

    "login": "komolcia", 
    "email":"k@gmail.com"
   
}

GET http://localhost:8080/api/plan

Pokazuje się cały plan

2. Użytkownik po podaniu swojego loginu może obejrzeć prelekcje na które się zapisał. 

GET http://localhost:8080/api/komolcia

3. Jeżeli prelekcja ma jeszcze wolne miejsca, użytkownik ma możliwość dokonania rezerwacji. Podczas dokonywania rezerwacji powinien podać swój login oraz adres e-mail.

GET http://localhost:8080/api/komolcia/k@gmail.com/1

GET http://localhost:8080/api/komolcia/k@gmail.com/5

1-to jest id prelekcji. Na planie można zobaczyć.
4. Jeżeli w systemie istnieje już użytkownik z danym loginem, ale z innym adresem e-mail, system powinien zaprezentować komunikat „Podany login jest już zajęty”.

Pojawia się.

Proszę dwa razy dać POST ten sam.

5. Poprawne dokonanie rezerwacji skutkuje wysłaniem powiadomienia użytkownikowi na podany przez niego adres (wysyłka wiadomości - patrz wskazówki). 

Na powiadomienia.txt

6. Użytkownik może anulować rezerwację. 

GET http://localhost:8080/api/komolcia/usun/5
7. Użytkownik może zaktualizować swój adres e-mail. 

GET http://localhost:8080/api/komolcia/kom@wp.com

8. System umożliwia wyświetlenie listy zarejestrowanych użytkowników wraz z ich adresami e-mail. 

GET http://localhost:8080/api/uzytkownik

Nawet na jakie wykłady chodzą :)

9. Wygenerowanie zestawienia dla organizatora:

zestawienie wykładów wg zainteresowania (procentowy udział uczestników w danym wykładzie)

GET http://localhost:8080/api/wyklady

zestawienie ścieżek tematycznych wg zainteresowania (procentowy udział)
    
GET http://localhost:8080/api/temat

Tutaj pojawia się zestawienie bazowane na ilości zapisanych na jakiekolwiek prelekcje, ponieważ gdy ta sama osoba zapisze się na tą samą ścieżkę 3 razy(bo może, ale wtedy już nie pójdzie na inne ścieżki bo są w tych samych godzinach) wyniki są niepoprawne i pojawiają się powyżej 100%

Dodatkowe funkcjonalnści:
1. Znalezienie użytkownika poprzez id.

GET http://localhost:8080/api/uzytkownik/1

2. Usunięcie użytkownika poprzez id.

DELETE http://localhost:8080/api/uzytkownik/1


Jeśli pojawia się użytkownik z niezmienionymi danymi to oznacza że jakaś operacja się nie powiodła np. jeśli na prelekcje zapisanych jest już 5 użytkowników