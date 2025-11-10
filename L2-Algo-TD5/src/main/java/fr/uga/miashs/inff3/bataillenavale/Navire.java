package fr.uga.miashs.inff3.bataillenavale;

public class Navire {
    // ------------------- Attributs -------------------//
    private Coordonnee debut;   // debut est la coordonnée du début
    private Coordonnee fin;     // fin est la coordonnée de fin du navire
    private Coordonnee[] partiesTouchees;   // Le tableau partiesTouchees contient les coordonnées du navire qui sont touchées
    private int nbTouchees;     // nbTouchees le nombre de parties du navire réellement touchées.

    // ------------------- Constructeur -------------------//

    /**
     * Constructeur qui calcule la coordonnée de fin à partir des paramètres longueur et estVertical.
     * L'attribut partiesTouchees sera instancié et l’attribut nbTouchees initialisé à 0.
     * @param debut
     * @param longueur
     * @param estVertical
     */
    public Navire(Coordonnee debut, int longueur, boolean estVertical){
        this.debut = debut;

        // Je teste si c'est vertical
        if(estVertical){
            // la coordonnée de fin sera sur la même colonne mais pas la même ligne
            fin = new Coordonnee((debut.getLigne() + longueur - 1), debut.getColonne());
        } else {
            // la coordonnée de fin sera sur la même ligne mais pas la même colonne
            fin = new Coordonnee(debut.getLigne(), (debut.getColonne() + longueur - 1));
        }

        // J'initialise les parties touchées à 0 car on est au début
        this.partiesTouchees = new Coordonnee[longueur];
        this.nbTouchees = 0;
    }

    // ------------------- Méthodes -------------------//
    /**
     * Méthode pour afficher ne représentation textuelle d’un navire, .i.e. sa cordonnée de début,
     * celle de fin ainsi que les coordonnées touchées
     * @return String d'affichage
     */
    public String toString(){
        return "Navire dont la coordonnée de début est : " + debut.toString() +
                ", dont la coordonnée de fin est : " + fin.toString() +
                " et il a ces coordonnées touchées " + partiesTouchees.toString();
    }

    /**
     * Méthode Getter de la coordonnée de début
     * @return Coordonnée fin
     */
    public Coordonnee getDebut(){
        return debut;
    }

    /**
     * Méthode Getter de la coordonnée de fin
     * @return Coordonnée fin
     */
    public Coordonnee getFin(){
        return fin;
    }

    /**
     * Méthode qui retourne true si la coordonnée passée en paramètre est contenue dans le navire.
     * @param c à tester
     * @return true si elle est dans le navire
     */
    public boolean contient(Coordonnee c){
        // Je teste si la colonne donnée est entre la colonne de début et celle de fin
        // Ainsi que si la ligne donnée est entre la ligne de début et celle de fin
        return (
                ((this.debut.getColonne() <= c.getColonne()) && (c.getColonne() <= this.fin.getColonne()))
                &&
                ((this.debut.getLigne() <= c.getLigne()) && (c.getLigne() <= this.fin.getLigne()))
                );
    }

    /**
     * Cette méthode retourne true ssi les intervalles [d1; f1] et [d2; f2] ont une intersection non vide
     * @param d1 début navire 1
     * @param f1 fin navire 1
     * @param d2 début navire 2
     * @param f2 fin navire 2
     * @return vrai si les intervalles ont une intersection non vide
     */
    private static boolean intersectionNonVide(int d1, int f1, int d2, int f2) {
        // Je teste si les intervalles se chevauchent
        return (Math.max(d1, d2) <= Math.min(f1, f2));

        // V2 : merci Laurena
        //return ((d1 < d2 && d2 < f1) || (d2 < d1 && d1 < f2));
    }

    /**
     * Tester si le navire actuel chevauche le navire passé en paramètre. Pour qu’un navire chevauche un autre
     * navire, il faut que les intervalles formés par les coordonnées de début de fin s’intersectent à la
     * fois au horizontalement (intervalles des abscisses) et verticalement (intervalles des ordonnées).
     * @param n navire à tester (on récupère ses coordonnées de début et de fin
     * @return true ssi le chevauche le navire passé en paramètre
     */
    public boolean chevauche(Navire n){
        // V1
        return
                // Les navires doivent partager au moins une ligne
                (debut.getLigne() <= n.getFin().getLigne() && n.getDebut().getLigne() <= fin.getLigne())
                // et au moins une colonne
                && (debut.getColonne() <= n.getFin().getColonne() && n.getDebut().getColonne() <= fin.getColonne());

        // V2 : Merci Hadjer
        // boolean interLignes = intersectionNonVide (this.debut.getLigne(), this.fin.getLigne(),n.debut.getLigne(), n.fin.getLigne());
        // boolean interColonnes = intersectionNonVide (this.debut.getColonne(), this.fin.getColonne(),n.debut.getColonne(), n.fin.getColonne());
        // return interLignes && interColonnes;
    }

    /**
     * Tester si le navire actuel touche le navire passé en paramètre.
     * (on considère que deux navires adjacents au niveau
     *      * de la diagonale ne se touchent pas). Pour que deux navires se touchent il faut que les deux
     *      * navires s’intersectent sur l’une des dimensions (horizontalement ou verticalement) et
     *      * qu’ils se touchent sur l’autre dimension.
     * @param n navire à tester
     * @return true ssi le navire actuel touche le navire passé en paramètre
     */
    public boolean touche(Navire n){
        // V1
        return (
                    // La ligne de fin d'un des navires touche la ligne de début de l'autre
                    (debut.getLigne() == n.getFin().getLigne()+1 || fin.getLigne() == n.getDebut().getLigne() -1 )
                    &&
                    // ET ils partagent au moins une colonne au commun
                    (debut.getColonne()<=n.getFin().getColonne() && n.getDebut().getColonne()<=fin.getColonne())
                )
                ||  // ou
                (
                   // La colonne de fin d'un des navires touche la colonne de début de l'autre
                    (debut.getColonne()==n.getFin().getColonne()+1 || n.debut.getColonne()==fin.getColonne()+1)
                    &&
                    // ET ils partagent au moins une ligne au commun
                    (debut.getLigne()<=n.getFin().getLigne() && n.getDebut().getLigne()<= fin.getLigne())
                );

        // V2 : Merci Roxanne - s'appuie sur Voisines pour tester si les navires se touchent.
        // (n.getDebut().voisine(this.debut)) || (n.getDebut().voisine(this.fin))
        // || (n.getFin().voisine(this.debut)) || (n.getFin().voisine(this.fin));
    }

    /**
     * Teste si la coordonnée c est contenue dans partiesTouchees du navire actuel
     * @param c Coordonnee c à tester
     * @return true si la coordonnée c est contenue dans partiesTouchees , false sinon.
     */
    public boolean estTouche(Coordonnee c){
        // V1 : boucle for classique
        for(int i = 0; i < nbTouchees; i++){
            if(c.equals(partiesTouchees[i])){
               return true;
            }
        }
        return false;

        /* // V2 : boucle for un peu plus avancée
        for(Coordonnee coordonnePartiesTouchees : partiesTouchees){
            if (coordonnePartiesTouchees.equals(c)){
                return true;
            }
        }
        return false;
        */
    }

    /**
     * Teste si le tir de coordonnée c touche le navire. L'attribut partiesTouchees et nbTouchees
     * seront mis à jour si la coordonnée c touche le navire et si elle n'est pas déjà présente
     * dans le tableau.
     * @param c Coordonnee c à tester
     * @return true si le tir de coordonnée c touche le navire, false sinon
     */
    public boolean recoitTir(Coordonnee c){
        if(estTouche(c)){
            // La coordoonnée c est déjà dans Parties Touchées, donc on peut faire un petit message console
            // pour dire qu'elle y est déjà
            System.out.println("Le navire est déjà touché à " + c.toString());
            return true;
        } else {
            // La coordonnée c n'y est pas déjà donc 2 choses:
            // 1- On teste si elle touche le navire
            // 2- Si elle le touche, on la rajoute au bout du tableau PartiesTouchées et
            // on met à jour nbTouchees
            // Sinon, on renvoie faux
            if(contient(c)){
                partiesTouchees[nbTouchees] = c;
                nbTouchees++;
                System.out.println("Le navire vient d'être touché à " + c.toString());
                return true;
            } else {
                return false;
            }
        }
    }

    /**
     * Renvoie vrai si le navire a été touché
     * @return true si le navire a été touché au moins une fois
     */
    public boolean estTouche(){
        return nbTouchees>0;
    }

    /**
     * Renvoie vrai si le navire a coulé, i.e. il a toutes ses cases touchéeq
     * @return true si le navire a coulé
     */
    public boolean estCoule(){
        return nbTouchees == partiesTouchees.length;
    }
}