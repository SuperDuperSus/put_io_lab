# System aukcyjny

## Wprowadzenie

Specyfikacja wymagań funkcjonalnych w ramach informatyzacji procesu sprzedaży produktów w oparciu o mechanizm aukcyjny. 

## Procesy biznesowe

---
<a id="bc1"></a>
### BC1: Sprzedaż aukcyjna 

**Aktorzy:** [Sprzedający](#ac1), [Kupujący](#ac2)

**Opis:** Proces biznesowy opisujący sprzedaż za pomocą mechanizmu aukcyjnego. |

**Scenariusz główny:**
1. [Sprzedający](#ac1) wystawia produkt na aukcję. ([UC1](#uc1))
2. [Kupujący](#ac2) oferuje kwotę za produkt wyższą od aktualnie najwyższej oferty. ([BR1](#br1))
3. [Kupujący](#ac2) wygrywa aukcję ([BR2](#br2))
4. [Kupujący](#ac2) przekazuje należność Sprzedającemu.
5. [Sprzedający](#ac1) przekazuje produkt Kupującemu.

**Scenariusze alternatywne:** 

2.A. Oferta Kupującego została przebita, a [Kupujący](#ac2) pragnie przebić aktualnie najwyższą ofertę.
* 2.A.1. Przejdź do kroku 2.

3.A. Czas aukcji upłynął i [Kupujący](#ac2) przegrał aukcję. ([BR2](#br2))
* 3.A.1. Koniec przypadku użycia.

---

## Aktorzy

<a id="ac1"></a>
### AC1: Sprzedający

Osoba oferująca towar na aukcji.

<a id="ac2"></a>
### AC2: Kupujący

Osoba chcąca zakupić produkt na aukcji.


## Przypadki użycia poziomu użytkownika

### Aktorzy i ich cele

[Sprzedający](#ac1):
* [UC1](#uc1): Wystawienie produktu na aukcję
* [UC5](#uc5): Przekazanie produktu Kupującemu

[Kupujący](#ac2):
* [UC2](#uc2): Oferowanie kwoty za produkt
* [UC3](#uc3): Wygranie aukcji
* [UC4](#uc4): Przekazanie należności Sprzedającemu

---
<a id="uc1"></a>
### UC1: Wystawienie produktu na aukcję

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) zgłasza do systemu chęć wystawienia produktu na aukcję.
2. System prosi o podanie danych produktu i ceny wywoławczej.
3. [Sprzedający](#ac1) podaje dane produktu oraz cenę wywoławczą.
4. System weryfikuje poprawność danych.
5. System informuje o pomyślnym wystawieniu produktu na aukcję.

**Scenariusze alternatywne:** 

4.A. Podano niepoprawne lub niekompletne dane produktu.
* 4.A.1. System informuje o błędnie podanych danych.
* 4.A.2. Przejdź do kroku 2.

<a id="uc2"></a>
### UC2: Oferowanie kwoty za produkt

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wpisuje kwotę, jaką chce zapłacić na [Aukcji](#BO1).
2. System sprawdza kwotę.
3. System aktualizuje najwyższą ofertę na [Aukcji](#BO1).

**Scenariusze alternatywne:** 

2.A. Podana kwota jest niższa od 1 PLN albo niższa od aktualnej najwyższej oferty.
* 2.A.1. System informuje o błędnie wpisanej kwocie.
* 2.A.2. Przejdź do kroku 1.

---

<a id="uc3"></a>
### UC3: Wygranie aukcji

**Aktorzy:** [Kupujący](#ac2),[Sprzedający](#ac1)

**Scenariusz główny:**
1. System kończy [Aukcję](#BO1).
2. System wybiera najwyższą ofertę złożoną przez [Kupującego](#ac2).
3. System wpisuje product [Aukcję](#BO1) do [Kupującego](#ac2).
4. System informuje wybranego [Kupującego](#ac2) i [Sprzedającego](#ac1) o wyniku aukcji.
5. System usuwa [Aukcję](#BO1).

**Scenariusze alternatywne:** 

2.A. Nikt nie złożył oferty zakupu.
* 2.A.1. System informuje [Sprzedającego](#ac1), że [Produkt](#BO2) nie został sprzedany.
* 2.A.2. Przejdź do kroku 5.

---

<a id="uc4"></a>
### UC4: Przekazanie należności Sprzedającemu

**Aktorzy:** [Kupujący](#ac2)

**Scenariusz główny:**
1. [Kupujący](#ac2) wpisuje dane karty płatniczej.
2. System sprawdza dane płatnicze.
3. System przekierowuje środki.

**Scenariusze alternatywne:** 

2.A. Dane płatnicze są nieprawidłowe.
* 2.A.1. System informuje [Kupującego](#ac2) o błędnych danych.
* 2.A.2. Przejdź do kroku 1.

---

<a id="uc5"></a>
### UC5: Przekazanie produktu Kupującemu

**Aktorzy:** [Sprzedający](#ac1)

**Scenariusz główny:**
1. [Sprzedający](#ac1) przekazuje produkt [Kupującemu](#ac2).

**Scenariusze alternatywne:** 

1.A. Produkt jest uszkodzony lub niekompletny.
* 1.A.1. [Kupujący](#ac2) zgłasza problem do systemu.
* 1.A.2. System informuje [Sprzedającego](#ac1) o problemie.
* 1.A.3. Przejdź do kroku 1.

---

## Obiewkty biznesowe (inaczje obiekty dziedzinowe lub informatycjne)

### BO1: Aukcja

Aukcja jest formą zawierania transakcji kupna-sprzedaży, w której Sprzedający określa cenę wywoławczą produktu, natomiast Kupujący mogą oferować własną ofertę zakupu każdorazowo proponując kwotę wyższą od aktualnie oferowanej kwoty. Aukcja kończy się po upływie określonego czasu. Jeśli złożona została co najmniej jedna oferta zakupy produkt nabywa ten Kupujący, który zaproponował najwyższą kwotę. 

### BO2: Produkt

Fizyczny lub cyfrowy obiekt, który ma zostać sprzedany w ramach aukcji.

## Reguły biznesowe

<a id="br1"></a>
### BR1: Złożenie oferty

Złożenie oferty wymaga zaproponowania kwoty wyższej niż aktualnie oferowana o minimum 1,00 PLN.


<a id="br2"></a>
### BR2: Rozstrzygnięcie aukcji

Aukcję wygrywa ten z [Kupujący](#ac2)ch, który w momencie jej zakończenia (upłynięcia czasu) złożył najwyższą ofertę.

## Macierz CRUDL


| Przypadek użycia                                  | Aukcja | Produkt |
| ------------------------------------------------- | ------ | ------- |
| UC1: Wystawienie produktu na aukcję               | C,R    | C       |
| UC2: Oferowanie kwoty za produkt                  | U,R    | R       |
| UC3: Wygranie aukcji                              | D      | U       |
| UC4: Przekazanie należności Sprzedającemu         | -      | R       |
| UC5: Przekazanie produktu Kupującemu              | -      | D       |
