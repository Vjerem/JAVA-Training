import java.util.Scanner;

class Puissance4
{
  private static Scanner clavier = new Scanner(System.in);
  private final static int VIDE = 0;
  private final static int JAUNE = 1;
  private final static int ROUGE = 2;

  public static void main(String[] args)
  {
    System.out.println("main1");
    main1();

    System.out.println("main2");
    main2();

    System.out.println("main3");
    main3();

    System.out.println("main4");
    main4();

    System.out.println("main5");
    main5();

    System.out.println("main final");

    mainFinal();
  }



  static void initialise(int[][] grille)
  {
    for(int i = 0; i < grille.length; ++i) {
      for(int j = 0; j < grille[0].length; ++j) {
        grille[i][j] = VIDE;
      }
    }
  }


  static void afficheSimple(int[][] grille)
  {
    for(int[] ligne : grille) {
      for(int cellule : ligne) {
        if (cellule == VIDE) {
          System.out.print(' ');
        } else if (cellule == ROUGE) {
          System.out.print('O');
        } else {
          System.out.print('X');
        }
      }
      System.out.println();
    }
  }


  static void affiche(int[][] grille)
  {
    System.out.println();

    for(int[] ligne : grille) {
      System.out.print(" |");
      for(int cellule : ligne) {
        if (cellule == VIDE) {
          System.out.print(' ');
        } else if (cellule == ROUGE) {
          System.out.print('O');
        } else {
          System.out.print('X');
        }
        System.out.print('|');
      }
      System.out.println();
    }


    System.out.print('=');
    for(int i = 1; i <= grille[0].length; ++i) {
      System.out.print("=" +  i);
    }

    System.out.print("==");

    System.out.println("\n");
  }




  // la fonction joue essaie d'ajouter un pion de la couleur et a la
  // colonne indiquees.

  // On commence avec une version simple (joue0) qui cherche la case
  // vide la plus basse sur la colonne indiquee SANS faire de tests
  //
  // On montre ensuite qu'il faut faire attention aux colonnes pleines
  //
  // Une nouvelle version 'joue1' utilise un booleen dans la boucle, et
  // retourne true si elle a pu effectivement ajouter un pion, false sinon
  //
  // On ajoute pour la version finale 'joue' un test pour verifier que
  // la colonne est valide. On peut alors montrer que la boucle qui
  // demande a l'utilisateur d'entrer la colonne s'ecrit de facon
  // simple.
  //
  // On montre aussi dans joueAlternatif qu'on peut tester avant
  // d'entrer dans la boucle si la colonne est deja pleine. C'est une
  // approche moins generale---puisqu'on peut tester si la boucle va
  // sortir du tableau avant d'y entrer---mais plus simple dans ce cas.
  //

  static void joue0(int[][] grille, int colonne, int couleur)
  {
    // on parcourt la colonne en partant du bas jusqu'a trouver une case vide:
    int ligne = grille.length - 1;

    while (grille[ligne][colonne] != VIDE) {
      --ligne;
    }

    // on remplit la case vide trouvee:
    grille[ligne][colonne] = couleur;
  }

  static boolean joue1(int[][] grille, int colonne, int couleur)
  {
    int ligne = grille.length - 1;

    // on parcourt la colonne en partant du bas jusqu'a trouver une case vide,
    // ou jusqu'au haut de la colonne si la colonne est pleine:
    boolean pleine = false;
    while ((!pleine) && (grille[ligne][colonne] != VIDE)) {
      if (ligne == 0) {
        pleine = true;
      } else {
        --ligne;
      }
    }

    // si on n'est pas arrive jusqu'en haut de la colonne, on remplit la case vide trouvee,
    // sinon c'est que la colonne est pleine et le coup n'est pas valide:
    if (!pleine) {
      grille[ligne][colonne] = couleur;
      return true;
    } else {
      return false;
    }
  }


  static boolean joue(int[][] grille, int colonne, int couleur)
  {
    // si le numero de colonne n'est pas valide, le coup n'est pas valide:
    if (colonne >= grille[0].length) {
      return false;
    }

    // on parcourt la colonne en partant du bas jusqu'a trouver une case vide,
    // ou jusqu'au haut de la colonne si la colonne est pleine:
    int ligne = grille.length - 1;
    boolean pleine = false;
    while ((!pleine) && (grille[ligne][colonne] != VIDE)) {
      if (ligne == 0) {
        pleine = true;
      } else {
        --ligne;
      }
    }

    // si on n'est pas arrive jusqu'en haut de la colonne, on remplit la case vide trouvee,
    // sinon c'est que la colonne est pleine et le coup n'est pas valide:
    if (!pleine) {
      grille[ligne][colonne] = couleur;
      return true;
    } else {
      return false;
    }
  }

  static boolean joueAlternative(int[][]grille, int colonne, int couleur)
  {
    // si le numero de colonne n'est pas valide, le coup n'est pas valide:
    if (colonne >= grille[0].length) {
      return false;
    }

    // si la colonne est pleine, le coup n'est pas valide:
    if (grille[0][colonne] != VIDE) {
      return false;
    }

    // on parcourt la colonne en partant du bas jusqu'a trouver une case vide:
    int ligne = grille.length - 1;
    while (grille[ligne][colonne] != VIDE){
      --ligne;
    }

    // on remplit la case vide trouvee:
    grille[ligne][colonne] = couleur;
    return true;
  }




  static boolean joueOverflow(int[][] grille, int colonne, int couleur)
  {
    // si le numero de colonne n'est pas valide, le coup n'est pas valide:
    if (colonne >= grille[0].length) {
      return false;
    }

    // on parcourt la colonne en partant du bas jusqu'a trouver une case vide.
    //
    // Si le test (ligne > = grille.length) devient faux, c'est qu'on a
    // soustrait 1 a ligne quand elle valait 0, ce qui arrive quand la
    // colonne est pleine:
    int ligne = grille.length - 1;
    while ((ligne >= 0) && (grille[ligne][colonne] != VIDE)) {
      --ligne;
    }

    // si ligne < grille.length n a trouve une case vide et on la remplit,
    // sinon c'est que la colonne est pleine et le coup n'est pas valide:
    if (ligne < grille.length) {
      grille[ligne][colonne] = couleur;
      return true;
    } else {
      return false;
    }
  }


    static int compte(int[][] grille,
		      int ligneDepart, int colonneDepart,
		      int dirLigne, int dirColonne)
    {
       int compteur = 0;
	
	int ligne = ligneDepart;
	int colonne = colonneDepart;
	
	// on part de la case (ligneDepart, colonneDepart) et on parcourt la grille
	// dans la direction donnee par (dirLigne, dirColonne)
	// tant qu'on trouve des pions de la meme couleur que le pion de depart.
	// On sait qu'on ne peut pas sortir de la grille.
	while(ligne < grille.length && colonne < grille[0].length && grille[ligne][colonne] == grille[ligneDepart][colonneDepart]) {
	    
      ++compteur;
      ligne   = ligne   + dirLigne;
      colonne = colonne + dirColonne;

    }

    return compteur;
  }



  static boolean estCeGagne(int[][] grille, int couleurJoueur)
  {
    // on parcourt la grille

    for(int ligne = 0; ligne < grille.length; ++ligne) {
      for(int colonne = 0; colonne < grille[ligne].length; ++colonne) {
        int couleurCase = grille[ligne][colonne];

        // pour chaque case qui contient un pion de la bonne couleur,
        // on compte les pions de la meme couleur dans 4 directions:
        if (couleurCase == couleurJoueur) {
          if (
            // en diagonale, vers le haut et la droite:
            (ligne >= 3 && compte(grille, ligne, colonne, -1, +1) >= 4) ||

            // horizontalement, vers la droite:
            (colonne <= grille[ligne].length - 4 && compte(grille, ligne, colonne, 0, +1) >= 4) ||

            // en diagonale, vers le bas et la droite:
            (ligne <= grille.length - 4 && colonne <= grille[ligne].length - 4 &&
             compte(grille, ligne, colonne, +1, +1) >= 4) ||

            // verticalement, vers le bas:
            (ligne <= grille.length - 4 && compte(grille, ligne, colonne, +1, 0) >= 4)
            ) {

            // si le nombre de pions pour au moins une des directions est au moins 4, le joueur a gagne:
            return true;
          }
        }
      }
    }

    // si on a parcouru toute la grille sans trouver au moins 4 pions
    // alignes, le joueur n'a pas gagne, du moins pas encore:
    return false;
  }


  static boolean estCeGagne2(int[][] grille, int couleurJoueur)
  {
    // on parcourt la grille

    for(int ligne = 0; ligne < grille.length; ++ligne) {
      for(int colonne = 0; colonne < grille[ligne].length; ++colonne) {
        int couleurCase = grille[ligne][colonne];

        // pour chaque case qui contient un pion de la bonne couleur,
        // on compte les pions de la meme couleur dans 4 directions:
        if (couleurCase == couleurJoueur) {
          final int ligneMax = grille.length - 4;
          final int colonneMax = grille[ligne].length - 4;
          if (
            // en diagonale, vers le haut et la droite:
            (ligne > 2 && compte(grille, ligne, colonne, -1, +1) >= 4) ||

            // horizontalement, vers la droite:
            (colonne <= colonneMax && compte(grille, ligne, colonne, 0, +1) >= 4) ||

            // en diagonale, vers le bas et la droite:
            (ligne <= ligneMax && colonne <= colonneMax && compte(grille, ligne, colonne, +1, +1) >= 4) ||

            // verticalement, vers le bas:
            (ligne <= ligneMax && compte(grille, ligne, colonne, +1, 0) >= 4)
            ) {

            // si le nombre de pions pour au moins une des directions est au moins 4, le joueur a gagne:
            return true;
          }
        }
      }
    }

    // si on a parcouru toute la grille sans trouver au moins 4 pions
    // alignes, le joueur n'a pas gagne, du moins pas encore:
    return false;
  }


  static void main0()
  {
    int[][] grille = new int[6][7];

    initialise(grille);
    afficheSimple(grille);

  }

  static void main1()
  {
    int[][] grille = new int[6][7];

    initialise(grille);
    affiche(grille);

  }

  static void  main2()
  {
    int[][] grille = new int[6][7];

    initialise(grille);
    affiche(grille);

    joue1(grille, 3, ROUGE);
    affiche(grille);

    joue1(grille, 2, JAUNE);
    affiche(grille);

    joue1(grille, 3, ROUGE);
    affiche(grille);

  }

  static void main3()
  {
    int[][] grille = new int[6][7];

    initialise(grille);
    affiche(grille);

    for(int i = 0; i < 10; ++i) {
      boolean  valide = joue(grille, 3, ROUGE);

      if (!valide) {
        System.out.println("impossible d'ajouter un pion sur cette colonne" );
      }

      affiche(grille);
    }

  }

  static void main4()
  {
    int[][] grille = new int[6][7];

    initialise(grille);
    affiche(grille);

    boolean valide = joue(grille, 3, ROUGE);
    affiche(grille);
    System.out.println(compte(grille, grille.length - 1, 3, 0, 1));

    valide = joue(grille, 4, ROUGE);
    affiche(grille);
    System.out.println(compte(grille, grille.length - 1, 3, 0, 1));

    valide = joue(grille, 5, ROUGE);
    affiche(grille);
    System.out.println(compte(grille, grille.length - 1, 3, 0, 1));

    valide = joue(grille, 6, ROUGE);
    affiche(grille);
    System.out.println(compte(grille, grille.length - 1, 3, 0, 1));

  }

  static void joue(int[][] grille, int couleurJoueur)
  {
    int colonne;
    boolean valide;

    do {
      colonne = clavier.nextInt();

      // les indices des tableaux commencent par 0 en Java:
      --colonne;

      valide = joue(grille, colonne, couleurJoueur);
      if (!valide) {
        System.out.println(" > Ce coup n'est pas valide");
      }
    } while(!valide);
  }


  static void main5()
  {
    int[][] grille =  new int[6][7];

    initialise(grille);
    affiche(grille);

    int couleurJoueur = JAUNE;
    boolean gagne;

    do {
      if (couleurJoueur == JAUNE) {
        System.out.println("Joueur X :  entrez un numero de colonne");
      } else {
        System.out.println("Joueur O :  entrez un numero de colonne");
      }

      joue(grille, couleurJoueur);

      affiche(grille);

      gagne = estCeGagne(grille, couleurJoueur);

      // on change la couleur pour la couleur de l'autre joueur:
      if (couleurJoueur == JAUNE) {
        couleurJoueur = ROUGE;
      } else {
        couleurJoueur = JAUNE;
      }

    } while(!gagne);

    // attention, on a change la couleur pour la couleur de l'autre joueur !
    if (couleurJoueur == JAUNE) {
      System.out.println("Le joueur O a gagne !");
    } else {
      System.out.println("Le joueur X a gagne !");
    }
  }


  static    boolean plein(int[][] grille)
  {
    // Si on trouve une case vide sur la premiere ligne, la grille n'est pas pleine:
    for(int cellule : grille[0]) {
      if (cellule == VIDE) {
        return false;
      }
    }

    // Sinon, la grille est pleine:
    return true;
  }


  static void mainFinal()
  {
    int[][] grille = new int[6][7];

    initialise(grille);
    affiche(grille);

    int couleurJoueur = JAUNE;
    boolean gagne;

    do {
      if (couleurJoueur == JAUNE) {
        System.out.println("Joueur X :  entrez un numero de colonne");
      } else {
        System.out.println("Joueur O :  entrez un numero de colonne");
      }

      joue(grille, couleurJoueur);

      affiche(grille);

      gagne = estCeGagne(grille, couleurJoueur);

      // on change la couleur pour la couleur de l'autre joueur:
      if (couleurJoueur == JAUNE) {
        couleurJoueur = ROUGE;
      } else {
        couleurJoueur = JAUNE;
      }

    } while(!gagne && !plein(grille));

    if (gagne) {
      // attention, on a change la couleur pour la couleur de l'autre joueur !
      if (couleurJoueur == JAUNE) {
        System.out.println("Le joueur O a gagne !");
      } else {
        System.out.println("Le joueur X a gagne !");
      }
    } else {
      System.out.println("Match nul !");
    }
  }

}
