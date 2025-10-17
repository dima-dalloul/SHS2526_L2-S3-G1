import java.util.Arrays;

public class DictionnaireStringInt {
	/**
	 * Tableau avec les clés
	 */
	String[] cles= new String[10];
	/**
	 * Tableau avec les valeurs
	 */
	private int[] valeurs= new int[10];
	
	/**
	 * nombre de mots réellement présents
	 */
	private int nbElements=0;
	
	
	/**
	 * Ajoute la paire (cle;valeur) si cle n'est pas dans le tableau des cles ou modifie la valeur associée.
	 * Utilise la méthode de recherche puis effectue des permutations depuis la fin
	 * @param cle
	 * @param valeur
	 */
	public void ajouterModifier(String cle, int valeur) {
		int idx = rechercherIdx(cle) ;
		if (idx>-1) {
			valeurs[idx]=valeur;
		}
		else {
			agrandir();
			idx = -idx -1; // ou idx~=idx
			for (int i=nbElements ; i>idx ;i--) {
				cles[i]=cles[i-1];
				valeurs[i]=valeurs[i-1];
			}
			cles[idx]=cle;
			valeurs[idx]=valeur;
			nbElements+=1;
			
		}
	}
	
	public int rechercherValeur(String cle) {
		int idx = rechercherIdx(cle);
		if (idx<0) return 0;
		return valeurs[idx];
	}
	
	/**
	 * Méthode de recherche dichotomique d'une clé dans le tableau des clés
	 * @param cle Chaine à rechercher dans le tableau des clés
	 * @return l'indice de la clé dans le tableau ou -1-idx avec idx qui est l'indice où aurait du se trouver la clé
	 */
	private int rechercherIdx(String cle) {
		int min=0;
		int max=nbElements;
		while (min<max) {
			int idx = (max+min)/2;
			int comp = cle.compareTo(cles[idx]);
			if (comp==0) {
				return idx;
			}
			else if (comp<0) {
				max=idx;
			}
			else {
				min=idx+1;
			}
		}
		return -1-(max+min)/2;
	}
	
	
	private void agrandir() {
		if (cles.length==nbElements) {
			cles=Arrays.copyOf(cles, cles.length+10);
			valeurs=Arrays.copyOf(valeurs, valeurs.length+10);
		}
	}
	

	public int supprimer(String mot) {
		int idx = rechercherIdx(mot);
		if (idx<0) return 0;
		int res = valeurs[idx];
		for (int i=idx ; i<nbElements-1 ; i++) {
			cles[i]=cles[i+1];
			valeurs[i]=valeurs[i+1];
		}
		// on aurait pu supprimer ce qui se trouve à nbElements, mais ce n'est pas obligatoire
		nbElements--;
		return res;
	}
	
	
	public String toString() {
		String text="'{";
		for (int i=0 ; i<nbElements ; i++) {
			text+="("+cles[i]+" : "+valeurs[i]+"),";
		}
		if (nbElements > 0) {
			text = text.substring(0, text.length()-1);
		}
		return text+"}";
	}

	public int donnerNbCles() {
		return nbElements;	
	}
	
	public String rechercherCleAvecValeurMax() {
		int max=0;
		String mot="";
		for (int i=0 ; i<nbElements ; i++) {
			if (max<valeurs[i]) {
				max=valeurs[i];
				mot=cles[i];
			}
		}
		return mot;
	}
	
	public String[] construireTableauDesCles() {
		String[] res = new String[nbElements];
		for (int i=0 ; i<nbElements ; i++) {
			res[i]=cles[i];
		}
		return res;
		// ou
		//return Arrays.copyOf(cles, nbElements);
	}
	
	
	
	/* VERSION NON TRIEE */
	/*
	private int rechercherIdx(String cle) {
		for (int i=0 ; i<nbElements ; i++) {
			if (cles[i].equals(cle)) {
				return i;
			}
		}
		return -1-nbElements;
	}
	
	public void ajouterModifier(String cle, int valeur) {
		int idx = rechercherIdx(cle) ;
		if (idx>-1) {
			valeurs[idx]=valeur;;
		}
		else {
			agrandir();
			cles[nbElements]=cle;
			valeurs[nbElements]=valeur;
			nbElements+=1;
		}
	}
	
	public int supprimer(String mot) {
		int idx = rechercherIdx(mot);
		if (idx==-1) return 0;
		int res = valeurs[idx];
		if (idx<nbElements-1) {
			cles[idx]=cles[nbElements-1];
			valeurs[idx]=valeurs[nbElements-1];
			// eventuellement (pour etre clean)
			cles[nbElements-1]=null;
		}
		nbElements--;
		return res;
	}
	*/
}
