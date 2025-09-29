package exercice3;

public class Livre extends Article {
    // Attributs
    private String auteur;
    private int nombrePages;
    private String editeur;
    private int annee;

    // Méthode
    public void genererPageWeb() {
        super.genererPageWeb();
        System.out.println("Auteur : " + auteur);
        System.out.println("Nombre de pages : " + nombrePages);
        System.out.println("Éditeur : " + editeur);
        System.out.println("Année : " + annee);
    }

}
