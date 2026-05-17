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
