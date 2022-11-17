public class PirmasPavyzdys {
    public static void main(String[] args) {
        Knyga knyga = new Knyga();
        knyga.setPavadinimas("Karo menas");
        knyga.setAutoriausVardas("Sun");
        knyga.setAutoriausPavarde("Tzu");
        knyga.setZanras("dalykinis");
        knyga.setPuslapiuSkaicius(83);
        knyga.setLeidejas("Penguin Books");
        System.out.println(knyga);

        Knyga knyga2 = new Knyga("Knygos pavadinimas", "Knygos aut vardas", "aut pavarde","fantastika", 158, "Penguin Books");
        System.out.println(knyga2);

        System.out.println("knyga.autorius = " + knyga.getAutoriausVardas());

        // Palyginame, kurios knygos puslapių skaičius didenis
        if (knyga.getPuslapiuSkaicius() > knyga2.getPuslapiuSkaicius()) {
            System.out.println("Pirmos didesnis");
        } else if (knyga2.getPuslapiuSkaicius() > knyga.getPuslapiuSkaicius()) {
            System.out.println("Antros didesnis");
        }
        else {
            System.out.println("Abiejų puslapių skaičius yra vienodas");
        }

        // Patikriname ar knygų yra toks pat leidėjas
        if (knyga.getLeidejas().equals(knyga2.getLeidejas())) {
            System.out.println("Jų yra toks pat leidėjas");
        }
        else {
            System.out.println("Jų nėra toks pat leidėjas");
        }

    }
}