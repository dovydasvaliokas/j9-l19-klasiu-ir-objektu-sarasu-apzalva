public class Knyga {
    private int id;
    private String pavadinimas;
    private String autoriausVardas;
    private String autoriausPavarde;
    private String zanras;
    private int puslapiuSkaicius;
    private String leidejas;

    public Knyga() {
    }

    public Knyga(String pavadinimas, String autoriausVardas, String autoriausPavarde, String zanras, int puslapiuSkaicius, String leidejas) {
        this.pavadinimas = pavadinimas;
        this.autoriausVardas = autoriausVardas;
        this.autoriausPavarde = autoriausPavarde;
        this.zanras = zanras;
        this.puslapiuSkaicius = puslapiuSkaicius;
        this.leidejas = leidejas;
    }

    public String getPavadinimas() {
        return pavadinimas;
    }

    public void setPavadinimas(String pavadinimas) {
        this.pavadinimas = pavadinimas;
    }

    public String getAutoriausVardas() {
        return autoriausVardas;
    }

    public void setAutoriausVardas(String autoriausVardas) {
        this.autoriausVardas = autoriausVardas;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAutoriausPavarde() {
        return autoriausPavarde;
    }

    public void setAutoriausPavarde(String autoriausPavarde) {
        this.autoriausPavarde = autoriausPavarde;
    }

    public String getZanras() {
        return zanras;
    }

    public void setZanras(String zanras) {
        this.zanras = zanras;
    }

    public int getPuslapiuSkaicius() {
        return puslapiuSkaicius;
    }

    public void setPuslapiuSkaicius(int puslapiuSkaicius) {
        this.puslapiuSkaicius = puslapiuSkaicius;
    }

    public String getLeidejas() {
        return leidejas;
    }

    public void setLeidejas(String leidejas) {
        this.leidejas = leidejas;
    }

    @Override
    public String toString() {
        return "Knyga{" +
                "id=" + id +
                ", pavadinimas='" + pavadinimas + '\'' +
                ", autoriausVardas='" + autoriausVardas + '\'' +
                ", autoriausPavarde='" + autoriausPavarde + '\'' +
                ", zanras='" + zanras + '\'' +
                ", puslapiuSkaicius=" + puslapiuSkaicius +
                ", leidejas='" + leidejas + '\'' +
                '}';
    }
}
