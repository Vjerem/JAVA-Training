import java.util.Scanner;

public class Crypto {

    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    static final int DECALAGE = 4;

    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Veuillez entrer une chaine de caracteres : ");
        String s = scanner.nextLine();

        // la chaine a coder
        String aCoder = "";
        // la chaine codee
        String chaineCodee = "";

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        String alphaDecale = "";
        for (int d = DECALAGE; d < 26; d++) {
            alphaDecale += ALPHABET.charAt(d);
        }
        for (int d2 = 0; d2 < DECALAGE; d2++) {
            alphaDecale += ALPHABET.charAt(d2);
        }

        int tailleS = s.length();
        char space = ' ';
        for (int i = 0; i < tailleS; i++) {
            for (int j = 0; j < 26; j++) {
                if (s.charAt(i) == ALPHABET.charAt(j)) {
                    aCoder += s.charAt(i);
                }
            }
            if (s.charAt(i) == space) {
                aCoder += space;
            }
        }

        int tailleACoder = aCoder.length();
        for (int i = 0; i < tailleACoder; i++) {
            if (aCoder.charAt(i) == space) {
                chaineCodee += space;
            }
            for (int j = 0; j < 26; j++) {
                if (aCoder.charAt(i) == ALPHABET.charAt(j)) {
                    chaineCodee += alphaDecale.charAt(j);
                }
            }
        }
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        System.out.format("La chaine initiale etait : '%s'\n", s);

        if (aCoder.isEmpty()) {
            System.out.println("La chaine a coder est vide.\n");
        } else {
            System.out.format("La chaine a coder est : '%s'\n", aCoder);
            System.out.format("La chaine codee est : '%s'\n", chaineCodee);
        }
    }
}