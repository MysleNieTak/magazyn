package pl.sda.j133.hibernate.magazyn;

import lombok.Data;
import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hibernate.magazyn.model.Kategoria;
import pl.sda.j133.hibernate.magazyn.model.Produkt;
import pl.sda.j133.hibernate.magazyn.model.Sprzedaz;

import java.time.LocalDate;
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
        return "dodaj 3 x zywnosc";
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

        System.out.println("Podaj datę i godzinę sprzedaży między 2020-01-01 a 2020-03-01 (YYYY-MM-DDThh:mm:ss)");
        String dataSprz = Main.scanner.nextLine();
        LocalDateTime dataSprzedaży = LocalDateTime.parse(dataSprz);

        if (dataSprzedaży.isAfter(LocalDateTime.of(2020,1,1, 0,0)) && dataSprzedaży.isBefore(LocalDateTime.of(2020,3,1, 0,0)) ){
            System.out.println("Data mieści się w zakresie.");
        } else {
            System.out.println("Data jest poza zakresem.");
        }

        Sprzedaz sprzedaz = Sprzedaz.builder()
                .cena(cena)
                .dataCzasSprzedazy(dataSprzedaży)
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

        System.out.println("Podaj datę i godzinę sprzedaży między 2020-01-01 a 2020-03-01 (YYYY-MM-DDThh:mm:ss)");
        String dataSprz2 = Main.scanner.nextLine();
        LocalDateTime dataSprzedaży2 = LocalDateTime.parse(dataSprz2);

        if (dataSprzedaży2.isAfter(LocalDateTime.of(2020,1,1, 0,0)) && dataSprzedaży2.isBefore(LocalDateTime.of(2020,3,1, 0,0)) ){
            System.out.println("Data mieści się w zakresie.");
        } else {
            System.out.println("Data jest poza zakresem.");
        }

        Sprzedaz sprzedaz2 = Sprzedaz.builder()
                .cena(cena2)
                .dataCzasSprzedazy(dataSprzedaży2)
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

        System.out.println("Podaj datę i godzinę sprzedaży między 2020-01-01 a 2020-03-01 (YYYY-MM-DDThh:mm:ss)");
        String dataSprz3 = Main.scanner.nextLine();
        LocalDateTime dataSprzedaży3 = LocalDateTime.parse(dataSprz3);

        if (dataSprzedaży3.isAfter(LocalDateTime.of(2020,1,1, 0,0)) && dataSprzedaży3.isBefore(LocalDateTime.of(2020,3,1, 0,0)) ){
            System.out.println("Data mieści się w zakresie.");
        } else {
            System.out.println("Data jest poza zakresem.");
        }

        Sprzedaz sprzedaz3 = Sprzedaz.builder()
                .cena(cena3)
                .dataCzasSprzedazy(dataSprzedaży3)
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
