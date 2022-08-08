import java.util.ArrayList;
import java.util.Scanner;

class TrancheMax {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        // Entree de la matrice
        System.out.println("Saisie de la matrice :");
        String matrice = clavier.nextLine();
        System.out.format("Matrice saisie :\n%s\n", matrice);
        clavier.close();

        // Validation de la matrice
        if (!checkFormat(matrice)) {
            return;
        }

        // Trouver la liste des lignes avec le plus grand nombre de 1 consecutif
        // Ces numéros de lignes sont stockés dans un tableau dynamique
        ArrayList<Integer> maxConsecutifList = findConsecutiveList(matrice);

        if (maxConsecutifList.isEmpty()) {
            System.out.println("Pas de lignes avec des 1 !");
        } else {
            System.out.println("Ligne(s) avec le plus de 1 consecutifs :");
            for (Integer index : maxConsecutifList) {
                System.out.println(index);
            }
        }
    }

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/
    public static boolean checkFormat(String laMatrice) {
        if (laMatrice.equals("")) {
            System.out.println("Matrice vide !");
            return false;
        }

        String[] lignes = laMatrice.split(" {1,}");

        for (int i = 0; i < lignes.length; ++i) {
            for (int j = 0; j < lignes[i].length(); ++j) {
                if ((lignes[i].charAt(j) != '1') &&
                        (lignes[i].charAt(j) != '0')) {
                    System.out.print("Matrice invalide : ");
                    System.out.println("seuls '1', '0' et ' ' sont admis !");
                    return false;
                }
            }
        }

        if (!checkLineLength(laMatrice)) {
            System.out.println("Matrice invalide, lignes de longueurs differentes !");
            return false;
        }

        return true;
    }

    public static boolean checkLineLength(String laLigne) {
        String[] lesLignes = laLigne.split(" {1,}");

        for (int i = 0; i < lesLignes.length - 1; ++i) {
            if (lesLignes[i].length() == 0) {
                continue;
            } else if (lesLignes[i].length() != lesLignes[i + 1].length()) {
                return false;
            }
        }

        return true;
    }

    public static ArrayList<Integer> findConsecutiveList(String laMatrice) {
        ArrayList<Integer> maxIndices = new ArrayList<Integer>();
        String[] lignes = laMatrice.split(" {1,}");
        int maxCount = 0;
        int temp = 0;
        int maxtemp = 0;
        for (int i = 0; i < lignes.length; ++i) {
            for (int j = 0; j < lignes[i].length(); ++j) {
                if (lignes[i].charAt(j) == '1') {
                    ++temp;
                    if (temp > maxtemp) {
                        maxtemp = temp;
                    }
                } else {
                    temp = 0;
                }
            }
            if (maxtemp > maxCount) {
                maxCount = maxtemp;
            }
            temp = 0;
        }
        maxtemp = 0;
        for (int i = 0; i < lignes.length; ++i) {
            for (int j = 0; j < lignes[i].length(); ++j) {
                if (lignes[i].charAt(j) == '1') {
                    ++temp;
                    if (temp > maxtemp) {
                        maxtemp = temp;
                    }
                } else {
                    temp = 0;
                }
            }
            if ((maxCount != 0) && (maxtemp == maxCount)) {
                if (lignes[0].length() == 0) {
                    maxIndices.add(i - 1);
                } else {
                    maxIndices.add(i);
                }
            }
            temp = 0;
            maxtemp = 0;
        }

        return maxIndices;
    }
    /*******************************************
     * Ne rien modifier apres cette ligne
     *******************************************/
}