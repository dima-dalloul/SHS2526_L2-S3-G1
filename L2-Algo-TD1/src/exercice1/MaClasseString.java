package exercice1;

public class MaClasseString {
    public static void main(String[] args) {
        String exemple = "Bonjour le monde";

        // 1. Méthode pour obtenir la longueur de la chaîne
        int longueur = exemple.length();
        System.out.println("Longueur de la chaîne: " + longueur);

        // 2. Méthode pour convertir la chaîne en majuscules
        String majuscules = exemple.toUpperCase();
        System.out.println("Chaîne en majuscules: " + majuscules);

        // 3. Méthode pour vérifier si la chaîne contient un certain mot
        boolean contientLe = exemple.contains("le");
        System.out.println("La chaîne contient 'le': " + contientLe);

        // 4. Méthode pour remplacer un mot par un autre
        String remplacée = exemple.replace("monde", "univers");
        System.out.println("Chaîne après remplacement: " + remplacée);

        // 5. Méthode pour extraire une sous-chaîne
        String sousChaine = exemple.substring(8, 10); // extrait "le"
        System.out.println("Sous-chaîne extraite: " + sousChaine);
    }
}
