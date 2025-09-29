package exercice1;

public class Bouteille {
    // Attributs
    private double capacite;
    private double volumeActuel;
    private boolean estFermee;

    // Constructeur
    public Bouteille(double capacite){
        this.capacite = capacite;
    }

    // Méthode pour tester
    public static void main(String[] args) {
        Bouteille maBouteille = new Bouteille(100.0); // Création d'une bouteille de capacité 100 unités
        maBouteille.ouvrirBouteille();
        maBouteille.ajouterLiquide(50);
        maBouteille.calculerNiveauRestant();
        maBouteille.enleverLiquide(20);
        maBouteille.calculerNiveauRestant();
        maBouteille.fermerBouteille();
    }

    // Méthodes demandées dans l'exercice
    public void ouvrirBouteille() {
        if (estFermee) {
            estFermee = false;
            System.out.println("La bouteille est maintenant ouverte.");
        } else {
            System.out.println("La bouteille est déjà ouverte.");
        }
    }

    public void fermerBouteille() {
        if (!estFermee) {
            estFermee = true;
            System.out.println("La bouteille est maintenant fermée.");
        } else {
            System.out.println("La bouteille est déjà fermée.");
        }
    }

    public void ajouterLiquide(double volume) {
        if (!estFermee) {
            if (volumeActuel + volume <= capacite) {
                volumeActuel += volume;
                System.out.println("Ajout de " + volume + " unités de liquide. Volume actuel: " + volumeActuel);
            } else {
                System.out.println("Impossible d'ajouter autant de liquide. Capacité dépassée.");
            }
        } else {
            System.out.println("La bouteille est fermée. Ouvrez-la d'abord.");
        }
    }

    public void enleverLiquide(double volume) {
        if (!estFermee) {
            if (volumeActuel - volume >= 0) {
                volumeActuel -= volume;
                System.out.println("Enlèvement de " + volume + " unités de liquide. Volume actuel: " + volumeActuel);
            } else {
                System.out.println("Impossible d'enlever autant de liquide. Volume insuffisant.");
            }
        } else {
            System.out.println("La bouteille est fermée. Ouvrez-la d'abord.");
        }
    }

    public void viderBouteille() {
        if (!estFermee) {
            volumeActuel = 0;
            System.out.println("La bouteille a été vidée.");
        } else {
            System.out.println("La bouteille est fermée. Ouvrez-la d'abord.");
        }
    }

    public void remplirBouteille() {
        if (!estFermee) {
            volumeActuel = capacite;
            System.out.println("La bouteille a été remplie.");
        } else {
            System.out.println("La bouteille est fermée. Ouvrez-la d'abord.");
        }
    }

    public void calculerNiveauRestant() {
        double niveauRestant = capacite - volumeActuel;
        System.out.println("Niveau restant dans la bouteille: " + niveauRestant);
    }

}
