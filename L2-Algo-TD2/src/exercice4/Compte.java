package exercice4;

public class Compte {
    // Attributs
    private Personne titulaire;
    private double solde;
    private static double tauxChangeEuroVersDollar = 1.08;
    // On met tauxChange en static pour forcer une seule instance de taux de change pour tous les comptes

    // Constructeurs
    public Compte(){
        this.titulaire = new Personne();
        this.solde = 10000;
    }

    public Compte(Personne nouvellePersonne, double soldeCompte){
        this.titulaire = nouvellePersonne;
        this.solde = soldeCompte;
    }

    // Getters et Setters
    public Personne getTitulaire() {
        return titulaire;
    }

    public void setTitulaire(Personne titulaire) {
        this.titulaire = titulaire;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public double getTauxChangeEuroVersDollar() {
        return tauxChangeEuroVersDollar;
    }

    public void setTauxChangeEuroVersDollar(double tauxChangeEuroVersDollar) {
        this.tauxChangeEuroVersDollar = tauxChangeEuroVersDollar;
    }

    // Méthodes
    // Méthode 1 : déposer de l'argent
    public double deposerArgent(double montant){
        solde += montant;
        System.out.println("Vous avez déposé " + montant + "€. Nouveau solde : " + solde + "€.");
        return solde;
    }

    // Méthode 2 : retirer de l'argent
    public double retirerArgent(double montant){
        // On vérifie que le solde est suffisant avant de retirer l'argent
        if(montant <= solde){
            solde -= montant;
            System.out.println("Vous avez retiré " + montant + "€. Nouveau solde : " + solde + "€.");
            return solde;
        } else {
            // Solde insuffisant => Message pour que l'utilisateur retente avec moins de sous
            System.out.println("Solde insuffisant, veuillez retenter avec un montant moindre");
            return solde;
        }
    }

    // Méthode 3 : Transférer de l'argent vers un autre compte
    public void transfereVersAutreCompte(Compte autreCompte, double montant){
        if(autreCompte == null){
            // Compte inexistant
            System.out.println("Le compte cible n'existe pas");
        } else {
            // Le compte existe, donc on peut continuer
            // Je vérifie que je peux transférer ce montant depuis le compte initial
            if(montant <= this.solde){
                // On retire l'argent depuis le compte initial
                this.retirerArgent(montant);
                // On le transfère vers le compte cible
                // Option 1:
                // autreCompte.setSolde(montant);
                // Option 2:
                autreCompte.deposerArgent(montant);
                System.out.println("Vous avez transféré " + montant + "€ depuis le compte courant vers le compte de " + autreCompte.getTitulaire().afficherPersonneViaString());
            } else {
                // Solde insuffisant => On avertit l'utilisateur
                System.out.println("Solde insuffisant, veuillez retenter avec un montant moindre");
            }
        }
    }

    // Méthode 4 : afficher l'état du compte (titulaire et montant),
    public void afficherEtatCompte(){
        System.out.println("Titulaire compte: " + this.titulaire.afficherPersonneViaString() + ", Solde du compte : " + this.solde);
    }

    // Méthode 5 : Savoir si le compte appartient au même titulaire qu'un compte donné
    // (on suppose que toutes les instances de personnes sont différentes).
    public boolean memeTitulaireCompte(Compte autreCompte){
        // Je compare les attributs Personne de chaque compte plutôt que comparer les adresses mémoire
        if(this.titulaire.getNom().equals(autreCompte.getTitulaire().getNom()) &&
                this.titulaire.getPrenom().equals(autreCompte.getTitulaire().getPrenom()) &&
                this.titulaire.getVille().equals(autreCompte.getTitulaire().getVille())){
            // C'est la même personne car même prénom, même nom et même ville
            System.out.println("Les 2 comptes appartiennent à la même personne :");
            this.titulaire.afficherPersonneConsole();
            return true;
        } else{
            // Ce n'est pas la même personne
            System.out.println("Les 2 comptes n'appartiennent pas à la même personne :");
            System.out.println("Personne 1 :");
            this.titulaire.afficherPersonneConsole();
            System.out.println("Personne 2 :");
            autreCompte.titulaire.afficherPersonneConsole();
            return false;
        }
    }

    // Méthode 6 : On suppose que tous les comptes sont en euros, proposez une méthode retournant le montant d'un
    // compte en dollar en fonction d'un taux de change commun à tous les comptes
    public double montantSoldeEnDollar(){
        System.out.println("Le montant en dollar est de : " + this.solde * this.tauxChangeEuroVersDollar);
        return this.solde * this.tauxChangeEuroVersDollar;
    }

    // Méthode 7 : Changer le taux de change.
    public void changerTauxChange(double nouveauTaux){
        this.tauxChangeEuroVersDollar = nouveauTaux;
        System.out.println("Nouveau taux : " + nouveauTaux);
    }
}
