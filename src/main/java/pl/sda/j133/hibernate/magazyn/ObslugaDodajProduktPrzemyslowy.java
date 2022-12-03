package pl.sda.j133.hibernate.magazyn;

import org.hibernate.Session;
import org.hibernate.Transaction;
import pl.sda.j133.hibernate.magazyn.model.Kategoria;
import pl.sda.j133.hibernate.magazyn.model.Produkt;

/**
 * @author Paweł Recław, AmeN
 * @project j133-hibernate-magazyn
 * @created 03.12.2022
 */
public class ObslugaDodajProduktPrzemyslowy implements ObslugaKomendy {

    @Override
    public String getKomenda() {
        return "dodaj 3 produkty z kategorii PRZEMYSLOWE";
    }

    public void obslugaKomendy() {
        System.out.println("Podaj nazwe 1 produktu:");
        String nazwa1 = Main.scanner.nextLine();

        System.out.println("Podaj nazwe 2 produktu:");
        String nazwa2 = Main.scanner.nextLine();

        System.out.println("Podaj nazwe 3 produktu:");
        String nazwa3 = Main.scanner.nextLine();

        Produkt produkt1 = Produkt.builder()
                .nazwa(nazwa1)
                .kategoria(Kategoria.PRZEMYSLOWE)
                .build();

        Produkt produkt2 = Produkt.builder()
                .nazwa(nazwa2)
                .kategoria(Kategoria.PRZEMYSLOWE)
                .build();

        Produkt produkt3 = Produkt.builder()
                .nazwa(nazwa3)
                .kategoria(Kategoria.PRZEMYSLOWE)
                .build();




        try (Session session = HibernateUtil.INSTANCE.getSessionFactory().openSession()) {
            Transaction transaction = session.beginTransaction();

            session.persist(produkt1);
            session.persist(produkt2);
            session.persist(produkt3);

            transaction.commit();
        } catch (Exception e) {
            System.err.println("Błąd: " + e);
        }
    }
}
