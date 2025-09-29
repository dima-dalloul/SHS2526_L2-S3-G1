package exercice4;

public class Personne {
    // Attributs
    private String nom;
    private String prenom;
    private String ville;

    // Constructeurs
    public Personne(){
        this.nom = "Taricot";
        this.prenom = "Ben";
        this.ville = "Strasbourg";
    }

    public Personne(String nom, String prenom, String ville){
        // Étant donné que les attributs n'ont aucune dépendance entre eux, on peut choisir l'ordre comme on le souhaite
        this.ville = ville;
        this.nom = nom;
        this.prenom = prenom;
    }

    // Méthodes
    // Méthode d'affichage d'une personne dans la console Java
    public void afficherPersonneConsole(){
        System.out.println("Nom : " + this.nom + ", Prénom : " + this.prenom + ", Ville : " + this.ville);
    }

    // Méthode d'affichage d'une personne via un retour String
    public String afficherPersonneViaString(){
        return ("Nom : " + this.nom + ", Prénom : " + this.prenom + ", Ville : " + this.ville);
    }

    // Getters et Setters
    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
