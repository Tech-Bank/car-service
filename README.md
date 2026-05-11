# Aplikacja Car Service

## Dziedzina i konteksty

Aplikacja modeluje dziedzinę serwisowania pojazdów, w której wyodrębniono 6 poddziedzin: serwisowanie (dziedzina główna), kartoteka pojazdów, kartoteka klientów, płatności, firma, bezpieczeństwo.

W każdej z poddziedzin zlokalizowany jest kontekst ograniczony z wyrównaniem 1:1: Servicing, Vehicle File, Customer File, Payments, Company, Security.

## Uruchomienie

1. Wczytaj projekt w IDE (IntelliJ: File / Open lub File / New / Project from Version Control...).
2. Poczekaj, aż się zbuduje (Gradle).
3. Uruchom aplikację (Run / Debug Configurations lub Run na CarServiceApplication.java).

### Konsola H2

* w przeglądarce wskaż adres: http://localhost:8080/h2-console
* podaj URL: jdbc:h2:file:./data/car-service

### Swagger

* w przeglądarce wskaż adres: http://localhost:8080/swagger-ui/index.html

## Założenia dla modelowania

Powiązania technologiczne:
* encja dziedziny jest mapowana wprost na encję JPA;
* konteksty ograniczone są mapowane jako pakiety Java;
* identyfikator encji jest generowany automatycznie mechanizmami bazy danych;

Struktura modelu:
* każda encja rozszerza BaseEntity;
* identyfikator encji wewnątrz kontekstu jest modelowany jako Long; 
* każda fabryka implementuje StandardFactory; 

Odpowiedzialność warstw:
* agregaty są tworzone w warstwie aplikacyjnej za pomocą fabryk z warstwy dziedziny;
* agregaty są utrwalane w warstwie aplikacyjnej za pomocą repozytoriów z warstwy dziedziny;
* w warstwie aplikacyjnej są budowane komponenty reprezentujące przypadki użycia;
* obsługa transakcji jest realizowana wyłącznie przez warstwę aplikacyjną;

Widoczność:
* publiczny interfejs modelu dziedziny jest widoczny w warstwie aplikacyjnej;

Integracja kontekstów:
* kontekst wymagający usługi innego kontekstu definiuje port, drugi kontekst implementuje usługę za pomocą adaptera;
* identyfikatory agregatów pomiędzy kontekstami są modelowane za pomocą dedykowanych obiektów Identity zdefiniowanych w shared kernel;

REST API:
* agregat jest publikowany jako zasób REST;
* wykorzystywane są polecenia HTTP: GET, POST, PUT, DELETE;
* w usługach GET dla pojedynczego elementu jest udostępniany model agregatu;
* usługi POST i PUT otrzymują na wejściu dedykowane obiekty żądania;