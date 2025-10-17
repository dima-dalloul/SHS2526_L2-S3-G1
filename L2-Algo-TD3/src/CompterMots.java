import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class CompterMots {

	public static void main(String[] args) throws IOException {
		// Je récupère le flux de lecture du fichier texte
		Path cheminVersFichier =  Paths.get("rougeetnoir.txt");

        // J'ouvre le fichier en lecture avec le charset par défaut
		BufferedReader fluxDeLecture = Files.newBufferedReader(cheminVersFichier, Charset.defaultCharset());

        // Je crée le scanner pour lire le fichier
		Scanner sc = new Scanner(fluxDeLecture);

        // Je crée le dictionnaire pour compter les occurrences
		DictionnaireStringInt dico = new DictionnaireStringInt();

        // Je définis le délimiteur du scanner pour qu'il sépare les mots
        // La regex signifie : tout ce qui n'est pas une lettre ou un chiffre
		sc.useDelimiter("([^\\p{L}\\p{Nd}]|\\s)+");

        // Je parcours tous les mots du fichier
		while (sc.hasNext()) {
            // Je lis le mot et le mets en minuscules
			String motLu = sc.next().toLowerCase();
            // J'ajoute ou modifie l'entrée dans le dictionnaire
			dico.ajouterModifier(motLu, dico.rechercherValeur(motLu)+1);
		}

        // Je ferme le scanner
		sc.close();

        // J'affiche le dictionnaire des occurrences
		System.out.println(dico);
	}
}
