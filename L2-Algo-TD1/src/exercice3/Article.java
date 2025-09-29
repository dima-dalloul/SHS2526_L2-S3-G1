package exercice3;

public class Article {
    private double prix;
    private double epaisseur;
    private String marque;
    private double poids;
    private String titre;
    private String modele;
    private int qteEnStock;
    private double dimension;
    private double largeur;
    private double hauteur;

    // Méthodes
    public double calculerFraisPort() {
        // Exemple de calcul des frais de port en fonction du poids et des dimensions
        double volume = largeur * hauteur * epaisseur; // Volume en cm^3
        double fraisPort = 5.0; // Frais de port de base

        if (poids > 1.0) {
            fraisPort += (poids - 1.0) * 2.0; // 2€ par kg supplémentaire
        }

        if (volume > 100000) { // Si le volume dépasse 100000 cm^3
            fraisPort += 10.0; // Frais supplémentaires pour les gros volumes
        }

        return fraisPort;
    }

    public void commander(int quantite) {
        if (quantite <= qteEnStock) {
            qteEnStock -= quantite;
            System.out.println("Commande de " + quantite + " " + titre + " passée avec succès.");
        } else {
            System.out.println("Stock insuffisant pour la commande de " + quantite + " " + titre + ".");
        }
    }

    public void genererPageWeb() {
        System.out.println("génération de la page web de l'article : " + titre);
        System.out.println("Prix : " + prix + "€");
        System.out.println("Quantité en stock : " + qteEnStock);
        System.out.println("Marque : " + marque);
        System.out.println("Modèle : " + modele);
        System.out.println("Poids : " + poids + " kg");
        dimension = largeur * hauteur * epaisseur;
        System.out.println("Dimensions : " + largeur + " x " + hauteur + " x " + epaisseur + " cm");
        System.out.println("Volume : " + dimension + " cm³");
    }
}

