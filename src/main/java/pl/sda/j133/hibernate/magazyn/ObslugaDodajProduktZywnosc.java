package pl.sda.j133.hibernate.magazyn;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hibernate.magazyn.model.Kategoria;
import pl.sda.j133.hibernate.magazyn.model.Produkt;
import pl.sda.j133.hibernate.magazyn.model.Sprzedaz;

import java.time.LocalDateTime;
import java.util.Random;

/**
 * @author Paweł Recław, AmeN
 * @project j133-hibernate-magazyn
 * @created 03.12.2022
 */
public class ObslugaDodajProduktZywnosc implements ObslugaKomendy {

    @Override
    public String getKomenda() {
        return "dodaj 3 produkty z kategorii ZYWNOSC";
    }

    public void obslugaKomendy() {
        System.out.println("Podaj nazwe 1 produktu:");
        String nazwa1 = Main.scanner.nextLine();

        System.out.println("Podaj cenę 1 produktu:");
        String stringCena = Main.scanner.nextLine();
        double cena = Double.parseDouble(stringCena);

        System.out.println("Podaj liczbę sprzedanych produktów:");
        String stringLiczba = Main.scanner.nextLine();
        double liczba = Double.parseDouble(stringLiczba);

        System.out.println("Podaj miesiąc sprzedaży od 1 do 3:");
        String miesSprz = Main.scanner.nextLine();
        int miesiac = Integer.parseInt(miesSprz);

        System.out.println("Podaj dzień sprzedaży od 1 do 31:");
        String dzieńSprz = Main.scanner.nextLine();
        int dzien = Integer.parseInt(dzieńSprz);

        Sprzedaz sprzedaz = Sprzedaz.builder()
                .cena(cena)
                .dataCzasSprzedazy
                        (LocalDateTime.of(2020,miesiac,dzien,0,0))
                .ilosc(liczba)
                .build();

        System.out.println("Podaj nazwe 2 produktu:");
        String nazwa2 = Main.scanner.nextLine();

        System.out.println("Podaj cenę 2 produktu:");
        String stringCena2 = Main.scanner.nextLine();
        double cena2 = Double.parseDouble(stringCena2);

        System.out.println("Podaj liczbę sprzedanych produktów:");
        String stringLiczba2 = Main.scanner.nextLine();
        double liczba2 = Double.parseDouble(stringLiczba2);

        System.out.println("Podaj miesiąc sprzedaży od 1 do 3:");
        String miesSprz2 = Main.scanner.nextLine();
        int miesiac2 = Integer.parseInt(miesSprz2);

        System.out.println("Podaj dzień sprzedaży od 1 do 31:");
        String dzieńSprz2 = Main.scanner.nextLine();
        int dzien2= Integer.parseInt(dzieńSprz2);

        Sprzedaz sprzedaz2 = Sprzedaz.builder()
                .cena(cena2)
                .dataCzasSprzedazy
                        (LocalDateTime.of(2020,miesiac2,dzien2,0,0))
                .ilosc(liczba2)
                .build();

        System.out.println("Podaj nazwe 3 produktu:");
        String nazwa3 = Main.scanner.nextLine();

        System.out.println("Podaj cenę 3 produktu:");
        String stringCena3 = Main.scanner.nextLine();
        double cena3 = Double.parseDouble(stringCena3);

        System.out.println("Podaj liczbę sprzedanych produktów:");
        String stringLiczba3 = Main.scanner.nextLine();
        double liczba3 = Double.parseDouble(stringLiczba3);

        System.out.println("Podaj miesiąc sprzedaży od 1 do 3:");
        String miesSprz3 = Main.scanner.nextLine();
        int miesiac3 = Integer.parseInt(miesSprz3);

        System.out.println("Podaj dzień sprzedaży od 1 do 31:");
        String dzieńSprz3 = Main.scanner.nextLine();
        int dzien3 = Integer.parseInt(dzieńSprz3);

        Sprzedaz sprzedaz3 = Sprzedaz.builder()
                .cena(cena3)
                .dataCzasSprzedazy
                        (LocalDateTime.of(2020,miesiac3,dzien3,0,0))
                .ilosc(liczba3)
                .build();


        Produkt produkt1 = Produkt.builder()
                .nazwa(nazwa1)
                .kategoria(Kategoria.ZYWNOSC)
                .build();

        Produkt produkt2 = Produkt.builder()
                .nazwa(nazwa2)
                .kategoria(Kategoria.ZYWNOSC)
                .build();

        Produkt produkt3 = Produkt.builder()
                .nazwa(nazwa3)
                .kategoria(Kategoria.ZYWNOSC)
                .build();




        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(produkt1);
            session.persist(produkt2);
            session.persist(produkt3);

            session.persist(sprzedaz);
            session.persist(sprzedaz2);
            session.persist(sprzedaz3);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
    }
}
