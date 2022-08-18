class MostFrequent {

  public static void main(String[] args) {
    int[] tab1 = { 1, 1, 1, 7, 5, 6, 7, 1, 6, 2, 1, 7, 6 };
    int taille = tab1.length;

    /*******************************************
     * Completez le programme a partir d'ici.
     *******************************************/

    int[] tab2 = tab1;
    int taille2 = tab2.length;
    int counter = 1;
    int max = 0;
    int maxNumber = 0;
    int i;
    int j;

    for (i = 0; i < taille; i++) {
      for (j = 1; j < taille2; j++) {
        if (tab2[i] == tab2[j]) {
          counter++;
        }
        if (max < counter) {
          max = counter;
          maxNumber = tab2[i];
        }
      }
      counter = 0;
    }

    /*******************************************
     * Ne rien modifier apres cette ligne.
     *******************************************/
    System.out.println("Le nombre le plus frequent dans le tableau est le :");
    System.out.println(maxNumber + " (" + max + " x" + ")");
  }
}
