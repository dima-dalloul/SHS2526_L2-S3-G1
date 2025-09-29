package exercice3;

public class JeuVideo extends Article {
    private String console;
    private int annee;

    public void genererPageWeb() {
        super.genererPageWeb();
        System.out.println("Console : " + console);
        System.out.println("Année : " + annee);
    }
}
