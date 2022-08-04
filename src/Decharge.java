import java.util.Scanner;
import java.util.Arrays;
import java.text.DecimalFormat;

public class Decharge {
	private static DecimalFormat df = new DecimalFormat("#.000");

	/*******************************************
	 * Completez le programme a partir d'ici.
	 *******************************************/
	public static double calculerDistance(int x1, int y1, int x2, int y2) {
		double distance = 0.0;
		distance = Math.sqrt(((x1 - x2) * (x1 - x2)) +
				((y1 - y2) * (y1 - y2)));
		return distance;
	}

	public static int plusProche(int x, int y, int[] coordonneesHabitations) {
		int indexPlusProche = -1;
		double distancePlusProche = 1000000;
		double test = 1000000;

		for (int i = 0; i < coordonneesHabitations.length; i += 2) {
			test = calculerDistance(coordonneesHabitations[i],
					coordonneesHabitations[i + 1], x, y);
			if (test < distancePlusProche) {
				indexPlusProche = i;
				distancePlusProche = test;
			}
		}
		return indexPlusProche / 2;
	}

	public static int[] troisPlusProches(int x, int y,
			int[] coordonneesHabitations) {
		int[] lesTroisPlusProches = new int[6];
		int[] tmp = new int[coordonneesHabitations.length];
		System.arraycopy(coordonneesHabitations, 0, tmp, 0,
				coordonneesHabitations.length);
		int counter = 0;
		int index3PlusProches = 0;
		int indextmp = -1;

		while (counter < 3) {
			indextmp = plusProche(x, y, tmp) * 2;
			lesTroisPlusProches[index3PlusProches] = tmp[indextmp];
			lesTroisPlusProches[index3PlusProches + 1] = tmp[indextmp + 1];
			index3PlusProches += 2;
			tmp[indextmp] = 1000000;
			tmp[indextmp + 1] = 1000000;
			counter++;
		}

		return lesTroisPlusProches;
	}

	public static int[] meilleurePlace(int x, int y,
			int[] coordonneesHabitations) {
		int[] tmp = new int[6];
		System.arraycopy(troisPlusProches(x, y, coordonneesHabitations),
				0, tmp, 0,
				troisPlusProches(x, y, coordonneesHabitations).length);
		int[] optimal = new int[2];
		optimal[0] = (tmp[0] + tmp[2] + tmp[4]) / 3;
		optimal[1] = (tmp[1] + tmp[3] + tmp[5]) / 3;
		return optimal;
	}

	/*******************************************
	 * Ne rien modifier apres cette ligne.
	 *******************************************/

	public static void afficheTroisPlusProches(int x, int y, int[] coordonneesHabitations) {
		int[] tpp = troisPlusProches(x, y, coordonneesHabitations);

		System.out.println("(" + x + "," + y + ") est a :");
		for (int i = 0; i < 3; i++) {
			System.out.println("    " + df.format(calculerDistance(x, y, tpp[2 * i], tpp[2 * i + 1])) + " de ("
					+ tpp[2 * i] + "," + tpp[2 * i + 1] + ")");
		}
	}

	// PROGRAMME PRINCIPAL
	public static void main(String args[]) {

		int[] coordonneesHabitations = {
				9, 30, 18, 8, 3, 18, 25, 36
		};

		// Lecture des donnees
		Scanner clavier = new Scanner(System.in);
		System.out.print("Entrez la coordonnee x de la decharge: ");
		int x = clavier.nextInt();
		System.out.print("Entrez le coordonnee y de la decharge: ");
		int y = clavier.nextInt();

		// trouve les coordonnees de l'habitation la plus proche
		// (identifiees par l'indice correspondant dans le tableau
		// de coordonnees)
		int plusProche = plusProche(x, y, coordonneesHabitations);
		System.out.println("--- Question 1 ---");
		System.out.println("Coordonnees de l'habitation la plus proche de la decharge :");
		System.out.println("(" + coordonneesHabitations[plusProche * 2] + ","
				+ coordonneesHabitations[plusProche * 2 + 1] + ") ; distance = " +
				df.format(calculerDistance(x, y, coordonneesHabitations[plusProche * 2],
						coordonneesHabitations[plusProche * 2 + 1]))
				+ " metres");

		// trouve les coordonnees des 3 habitations les plus proches et affiche les
		// coordonnees

		System.out.println("--- Question 2 ---");
		System.out.println("Coordonnees des 3 habitations les plus proches de la decharge :");
		afficheTroisPlusProches(x, y, coordonneesHabitations);

		// affiche le centre de gravite des 3 plus proches (la meilleure place)
		int[] grav = meilleurePlace(x, y, coordonneesHabitations);
		System.out.println("--- Question 3 ---");
		System.out.println("Coordonnees de la meilleure place pour la decharge :");
		System.out.println("(" + grav[0] + "," + grav[1] + ")");
		clavier.close();
	}

}