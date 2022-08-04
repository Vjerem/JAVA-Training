import java.util.Scanner;

public class Paques {
    private final static Scanner CLAVIER = new Scanner(System.in);

    public static int demanderAnnee() {
        int annee = 0;
        do {
            System.out.println("Entrez une annee (1583-4000) : ");
            annee = CLAVIER.nextInt();
        } while (annee < 1583 || annee > 4000);
        return annee;
    }

    public static void afficheDate(int annee, int jours) {
        if (jours <= 31) {
            System.out.print("Date de Paques en " + annee +
                             " : " + jours + " mars");
        }
        else {
            System.out.print("Date de Paques en " + annee +
                             " : " + (jours - 31) + " avril");
        }
        System.out.println();
        return;
    }

    public static int datePaques(int annee) {
        int jours = -1;
        int siecle = annee / 100;
        int p = (13 + (8 * siecle)) / 25;
        int q = siecle / 4;
        int M = (15 - p + siecle - q) % 30;
        int N = 4 + siecle - (q % 7);
        int d = (M + (19 * (annee % 19))) % 30;
        int e = (2 * (annee % 4) + 4 * (annee % 7) + 6 * d + N) % 7;

        if ((e == 6) && (((d == 28) && ((11 * (M + 1)) % 30 < 19)))) {
            jours = e + d + 22 - 7;
        }
        else if (e == 6 && d == 29) {
            jours = e + d + 22 - 7;
        }
        else {
            jours = e + d + 22;
        }

        return jours;
    }

    public static void main(String[] args) {
        int lAnnee = demanderAnnee();
        int lesJours = datePaques(lAnnee);
        afficheDate(lAnnee, lesJours);
    }
}