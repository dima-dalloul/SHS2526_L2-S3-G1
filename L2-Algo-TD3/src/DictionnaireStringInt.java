import java.util.Arrays;

public class DictionnaireStringInt {
    // Ensemble de clés et valeurs, ainsi que le nombre d'éléments
    private String[] cles;
    private int[] valeurs;
    private int nbElements;

    // Constructeur
    public DictionnaireStringInt() {
        cles = new String[10];
        valeurs = new int[10];
        nbElements = 0;
    }

    // Méthodes
    /*
        Écrire la méthode rechercherIdx permettant de rechercher et retourner l’indice d’une clé
        passée en paramètre. Si la clé n’est pas présente la méthode retournera la valeur -1-idx
        (où idx est l’indice de la case où aurait du se trouver la clé).
        Rappel : l’égalité entre deux objets est réalisée en utilisant la méthode « equals ».
     */
    public int rechercherIdx(String cleATrouver){
        // Tester si le tableau est vide
        if(nbElements == 0){
            return -1;
        } else {
            // Le tableau n'est pas vide donc on peut chercher
            // On boucle sur la table clés
            for(int i = 0; i < nbElements; i++){
                // On teste l'égalité entre la clé actuelle et la clé à trouver
                if(cles[i].equals(cleATrouver)){
                    // Si on la trouve, on renvoie l'indice
                    return i;
                }
            }

            // Si on arrive ici, c'est que la clé n'a pas été trouvée. Donc on doit renvoyer -1-nbElements
            return -1 - nbElements;
        }
    }

    /*
        En se servant de la méthode définie à la question précédente, écrire la méthode
        rechercherValeur retournant la valeur associée à une clé.
        Si la clé n’est pas présente, on retournera 0.
     */
    public int rechercherValeur(String cle){
        // Tester si le tableau est vide
        if(nbElements > 0) {
            // Le tableau n'est pas vide donc on peut chercher
            int indice = rechercherIdx(cle);
            if(indice > -1) {
                // Si l'indice renvoyé est nul ou positif, c'est que la clé est bien présente
                return valeurs[indice];
            } else {
                // Si l'indice est négatif, c'est que la clé n'est pas dans le tableau
                return 0;
            }
        } else {
            // Le tableau est vide donc on renvoie 0
            return 0;
        }
    }

    /*
        Écrire la méthode agrandir qui permet de remplacer les tableaux si ils sont pleins.
        Les nouveaux tableaux auront une taille supérieure de 10 éléments
        (par rapport aux anciens tableaux).
     */
    public void agrandir(){
        if(nbElements == cles.length){
            // Si le nombre d'élémens est égal à la taille d'un des tableaux, cela indique qu'ils sont pleins
            // Solution 1 : s'appuyer sur les méthodes existantes
            cles = Arrays.copyOf(cles, cles.length + 10);
            valeurs = Arrays.copyOf(valeurs, valeurs.length + 10);

            /*
            // Solution 2 : faire à la main
            // Je crée le nouveau tableau
            String[] clesNouveau = new String[cles.length + 10];
            // Je copie les valeurs stockées depuis l'ancien vers le nouveau
            for(int i = 0; i < cles.length; i++){
                clesNouveau[i] = "" + cles[i];
            }
            // J'écrase la référence de l'ancien tableau vers le nouveau
            cles = clesNouveau;

            // Je crée le nouveau tableau
            String[] valeursNouveau = new String[valeurs.length + 10];
            // Je copie les valeurs stockées depuis l'ancien vers le nouveau
            for(int i = 0; i < valeurs.length; i++){
                valeursNouveau[i] = "" + valeurs[i];
            }
            // J'écrase la référence de l'ancien tableau vers le nouveau
            valeurs = valeursNouveau;
             */
        }
    }

    /*
    Écrire la méthode ajouterModifier qui permet d’ajouter une paire (clé ; valeur) si
    la clé n’est pas présente ou de remplacer valeur associée si la clé est déjà présente.
    Avant l’ajout, cette méthode appellera la méthode définie à la question précédente
    pour s’assurer qu’il y a la place suffisante dans le tableau
     */
    public void ajouterModifier(String cle, int valeurNouvelle){
        // On s'appuie sur la méthode précédente pour voir si la clé est déjà présente
        int indiceCle = rechercherIdx(cle);
        // Si l'indice renvoyé est nul ou positif, c'est que la clé est bien présente
        if(indiceCle > -1){
            // Cas remplacement valeur
            // On remplace la valeur avec la nouvelle valeur
            valeurs[indiceCle] = valeurNouvelle;
        } else {
            // Cas ajout clé et valeur
            // J'agrandis le tableau si besoin
            agrandir();
            // On rajoute la cle et la valeur au bout de chacun des tableaux
            cles[nbElements] = cle;
            valeurs[nbElements] = valeurNouvelle;
            // On incrémente le nombre d'éléments
            nbElements++;
        }
    }

    /*
    Écrire la méthode supprimer qui supprime couple (clé ; valeur).
    Pour cela, on remplacera la clé, resp. la valeur, à supprimer par le dernier élément du tableau.
     */
    public void supprimer(String cleASupprimer, int valeurASupprimer){
        // On s'appuie sur la méthode précédente pour voir si la clé est déjà présente
        int indiceCle = rechercherIdx(cleASupprimer);
        // Si l'indice est négatif, c'est que la clé n'est pas dans le tableau
        if(indiceCle <= -1)
            System.out.println("Aucune clé trouvée avec les éléments donnés en paramètre");
        else {
            // L'indice n'est pas négatif, donc la clé est présente dans le tableau
            // On écrase la clé et la valeur de l'indice à supprimer avec la clé et la valeur du dernier élément
            // du tablau
            cles[indiceCle] = cles[nbElements -1];
            valeurs[indiceCle] = valeurs[nbElements -1];
            // On vide le dernier élément des 2 tableaux
            cles[nbElements-1] = "";
            valeurs[nbElements-1] = 0;
            // On décrémente le nombre d'éléments
            nbElements--;
            // On affiche le résultat
            System.out.println("Le couple (" + cleASupprimer + ", " + valeurASupprimer + ") a bien été supprimé");
            System.out.println("Le nombre d'élémets est de " + nbElements);
        }
    }

    /*
    Écrire la méthode String toString() permettant de retourner une représentation du tableau
    associatif sous forme de chaîne de caractères.
    L’exemple du début sera représenté par la chaîne
    « { [Pomme : 3] , [Poire : 5] , [Banane : 2] } »
     */
    public String toString(){
        // J'ouvre l'accolade
        String resultat = "{ ";

        // Je boucle sur les 2 tableaux
        for(int i = 0; i < nbElements; i++){
            if(i < nbElements -1) {
                // Solution 1
                resultat = resultat + "[" + cles[i] + " : " + valeurs[i] + "] , ";
                // Solution 2
                // resultat += "[" + cles[i] + " : " + valeurs[i] + "] , ";
            } else {
                // Solution 1
                resultat = resultat + "[" + cles[i] + " : " + valeurs[i] + "] ";
                // Solution 2
                // resultat += "[" + cles[i] + " : " + valeurs[i] + "]  ";
            }
        }
        // Je ferme l'accolade
        resultat = resultat + "}";
        return resultat;
    }
}
