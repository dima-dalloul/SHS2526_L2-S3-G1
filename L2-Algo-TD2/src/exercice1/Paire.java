package exercice1;

// Classe Paire représentant une paire d'entiers
public class Paire {
    // Attributs
    private int entier1;
    private int entier2;

    // Constructeur qui met les valeurs des
    // entiers 1 et 2 à 0
    public Paire() {
        this.entier1 = 0;
        this.entier2 = 0;
    }

    // Constructeur qui met les valeurs des
    // entiers 1 et 2 aux valeurs passées en
    // paramètre
    public Paire(int valeur1, int valeur2){
        this.entier1 = valeur1;
        this.entier2 = valeur2;
    }

    /* Ajoutez une méthode dans la classe
    paire qui retourne true que si les valeurs
    de la paire passée en paramètre sont égales
    aux valeurs de la paire sur laquelle la
    méthode est appelée.
     */
    public boolean estEgale(Paire unePaire){
        // Je récupère les valeurs des entiers 1 et 2 de la paire
        int entier1Paire = unePaire.getEntier1();
        int entier2Paire = unePaire.getEntier2();

        // Je compare les valeurs des entiers 1 et 2 de la paire avec la paire actuelle
        if((this.entier1 == entier1Paire) && (this.entier2 == entier2Paire))
            return true;
        else
            return false;
    }

    //-------------------- Getters et Setters --------------------
    public void setEntier1(int nouvelleValeur){
        this.entier1 = nouvelleValeur;
    }

    public void setEntier2(int nouvelleValeur){
        this.entier2 = nouvelleValeur;
    }

    public int getEntier1(){
        return this.entier1;
    }

    public int getEntier2(){
        return this.entier2;
    }
}
