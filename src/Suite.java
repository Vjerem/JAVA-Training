import java.util.Scanner;

class Suite {

    public static void main(String[] args) {

        Scanner clavier = new Scanner(System.in);

        int debut;
        do {
            System.out.print("de (>= 1) ? ");
            debut = clavier.nextInt();
        } while (debut < 1);

        int fin;
        do {
            System.out.print("a (>= " + debut + ") ? ");
            fin = clavier.nextInt();
        } while (fin < debut);

        int res;

        int n;

        for (int i = debut; i <= fin ; i++) {

            res = i;

            n = 0;

            while(res != 0) {

                n += 1;

                if(res%3 == 0){
                    res+=4;
                } 


                else if (res%4==0) {
                    res=res/2;
                }

                else {
                    res-=1;
                }

            }

            System.out.println(i + " -> " + n);
        }
        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/
        clavier.close();
    }
}