import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AntrasPavyzdysSuFailu {
    public static String FAILO_PAVADINIMAS = "knygos.csv";

    public static void main(String[] args) {
        ArrayList<Knyga> visosKnygos = new ArrayList<>();
        try {
            visosKnygos = nuskaitytiKnygasIsFailo(FAILO_PAVADINIMAS);
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Tokio failo nėra");
        }

       // isvestiKnygasKasEilute(visosKnygos);

        // Sukuriame Scannerį, kuris nuskaitys iš konsolės vartotojo įvedamą pavadinimą pagal kurį ieškos knygą
        Scanner skait = new Scanner(System.in);
        System.out.println("Įveskite pavadinimą ieškomos");
        String ieskomasPavadinimas = skait.nextLine();
        Knyga ieskomaKnyga = rastiKnyga(visosKnygos, ieskomasPavadinimas);
        System.out.println("ieskomaKnyga = " + ieskomaKnyga);

        // Filtruojame knygas pagal vartotojo ivesta leideja
        System.out.println("Įveskite ieškomą leidėją, pagal kurį norite filtruoti");
        String ieskomasLeidejas = skait.nextLine();
        ArrayList<Knyga> leidejoKnygos = filtruotiPagalLeideja(visosKnygos, ieskomasLeidejas);
        isvestiKnygasKasEilute(leidejoKnygos);

        // Filtruojam pagal daugiau puslapiu skaiciu
        System.out.println("Įveskite psl skaičių");
        int ieskomasPslSkaicius = skait.nextInt();
        ArrayList<Knyga> daugiauUzPslKnygos = filtruotiPagalPuslapiuSkaiciuDaugiau(visosKnygos, ieskomasPslSkaicius);
        isvestiKnygasKasEilute(daugiauUzPslKnygos);

        // Surandame ieškomo leidėjo iš viso išleistų knygų kiekį
        System.out.println("Įveskite leidėją, kurio knygų kiekio ieškosime");
        skait.nextLine();
        String ieskomasLeidejasKiekis = skait.nextLine();
        ArrayList<Knyga> leidejoKnygosKiekis = filtruotiPagalLeideja(visosKnygos, ieskomasLeidejasKiekis);
        System.out.println("leidejoKnygosKiekis.size() = " + leidejoKnygosKiekis.size());
    }

    public static ArrayList<Knyga> nuskaitytiKnygasIsFailo(String failoAdresas) throws FileNotFoundException {
        File failas = new File(failoAdresas);
        Scanner skaitytuvas = new Scanner(failas);
        ArrayList<Knyga> knygos = new ArrayList<>();


        skaitytuvas.nextLine();         // praleidžiama pirma eilutė
        int i = 1;      // kintamasis naudojamas knygų id "generavimui"
        while (skaitytuvas.hasNextLine()) {
            String eilute = skaitytuvas.nextLine();
            String[] isskaldytaEilute = eilute.split(",");
            Knyga knyga = new Knyga();
            knyga.setPavadinimas(isskaldytaEilute[0]);
            knyga.setAutoriausPavarde(isskaldytaEilute[1]);
            knyga.setAutoriausVardas(isskaldytaEilute[2]);
            knyga.setZanras(isskaldytaEilute[3]);
            knyga.setPuslapiuSkaicius(Integer.parseInt(isskaldytaEilute[4]));
            knyga.setLeidejas(isskaldytaEilute[5]);
            knyga.setId(i);
            i++;
            knygos.add(knyga);
        }
        return knygos;
    }

    public static void isvestiKnygasKasEilute(ArrayList<Knyga> knygos) {
        for (Knyga knyga : knygos) {
            System.out.println("knyga = " + knyga);
        }
    }

    public static Knyga rastiKnyga(ArrayList<Knyga> knygos, String ieskomasPavadinimas) {
        for (Knyga knyga : knygos) {
            if (ieskomasPavadinimas.equalsIgnoreCase(knyga.getPavadinimas())) {
                return knyga;
            }
        }
        return new Knyga();
    }

    public static ArrayList<Knyga> filtruotiPagalLeideja(ArrayList<Knyga> knygos, String ieskomasLeidejas) {
        ArrayList<Knyga> filtruotosKnygos = new ArrayList<>();
        for (Knyga knyga : knygos) {
            if (knyga.getLeidejas().equalsIgnoreCase(ieskomasLeidejas)) {
                filtruotosKnygos.add(knyga);
            }
        }
        return filtruotosKnygos;
    }

    public static ArrayList<Knyga> filtruotiPagalPuslapiuSkaiciuDaugiau(ArrayList<Knyga> knygos, int daugiauUzPuslapiu) {
        ArrayList<Knyga> filtruotosKnygos = new ArrayList<>();
        for (Knyga knyga : knygos) {
            if (knyga.getPuslapiuSkaicius() > daugiauUzPuslapiu) {
                filtruotosKnygos.add(knyga);
            }
        }
        return filtruotosKnygos;
    }


}
