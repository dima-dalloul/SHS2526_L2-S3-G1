import exercice1.Paire;
import exercice2.Temperature;
import exercice4.Compte;
import exercice4.Personne;

public class Main {
    /* Exercice 1
    public static void main(String[] args) {

        Paire paire = new Paire(5, 8);
        Paire paire2 = new Paire(5, 8);

        System.out.println("Sont égales ? " + paire.estEgale(paire2)); // renvoie vrai
        System.out.println("Sont égales ? " + (paire == paire2)); // renvoie faux
    }
    */

    /* Exercice 2
    public static void main(String[] args) {
//           Elle proposera les fonctionnalités suivantes :
//            •	S'ajouter une température
//            •	Retourner la valeur de la température en °C, en °F,  en K
//            •	Tester l'égalité de températures
//            •	Comparer deux températures (la méthode retournera une nombre négatif si la température sur laquelle
//            on appelle la méthode est inférieur à la température passée en paramètre, 0 si elles sont égales, une
//            nombre positif sinon)

        Temperature maTemperature = new Temperature();
        System.out.println("Température au début : " + maTemperature.getTemperatureCelsius());
        maTemperature.ajouterTemperature(8);
        System.out.println("Température après ajout : " + maTemperature.getTemperatureCelsius());
        System.out.println("Température en Celsius : " + maTemperature.getTemperatureCelsius());
        System.out.println("Température en Fahrenheit : " + maTemperature.getTemperatureFahrenheit());
        System.out.println("Température en Kelvin : " + maTemperature.getTemperatureKelvin());

        System.out.println("Test égalité (11, 11) ? " + maTemperature.testEgaliteTemperatures(11, 11));
        System.out.println("Test égalité (11.0, 11.1) ? " + maTemperature.testEgaliteTemperatures(11.0, 11.1));

        System.out.println("Comparaison température 15 avec température actuelle ? " + maTemperature.compareDeuxTemperatures(15.0));
    }
    */

    // Exercice 3 : se reférer au paquetage exercice3 puis classe Portee

    /* Exercice 4  : */
    public static void main(String[] args) {
        // On va utiliser le jeu de test fourni
        Personne p = new Personne() ;
        Compte c1 = new Compte() ;
        c1.setTitulaire(p) ;
        Personne p2 = new Personne("Bagnama", "Cham", "New York");
        Compte c2 = new Compte() ;
        c2.setTitulaire(p2);
        c1.memeTitulaireCompte(c2); // Résultat doit être False

        c2.retirerArgent(5000);
        c2.deposerArgent(10000);

        Personne p3 = new Personne("BEN ALLAL SEGHIR", "Tanis", "Frodo");
        Compte c3 = new Compte() ;
        c3.setTitulaire(p3);
        c2.transfereVersAutreCompte(c3, 3000); // Cadeau fiscal............
        c3.afficherEtatCompte();

        c3.changerTauxChange(0.55);
        c3.montantSoldeEnDollar();
    }
}