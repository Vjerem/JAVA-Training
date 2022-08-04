import java.util.Scanner;

public class Velo {

    public static void main(String[] args) {
        Scanner clavier = new Scanner(System.in);
        System.out.print("Donnez l'heure de début de la location (un entier) : ");
        int debut = clavier.nextInt();
        System.out.print("Donnez l'heure de fin de la location (un entier) : ");
        int fin = clavier.nextInt();

        /*******************************************
         * Completez le programme a partir d'ici.
         *******************************************/
        double heureCreuse = 1.0;
        double heurePleine = 2.0;
        int tempsMatinNuit = 0;
        int tempsJournee = 0;
        double totalFrancs = 0;
        
        if (debut < 0 || debut > 24 || fin < 0 || fin > 24){
        	
            System.out.println("Les heures doivent être comprises entre 0 et 24 !");

        } else{
        	
        	if (debut == fin) {
        		
                System.out.println("Bizarre, vous n'avez pas loué votre vélo bien longtemps !");

                
        	} else {
        		
        		if (debut > fin){
        			
        	        System.out.println("Bizarre, le début de la location est après la fin ...");

        		} else{
        			
        			if (debut < 7){
        				
        				
        				if (fin <= 7){
        					
        					tempsMatinNuit =+ (fin-debut);
        					
        					
        				} else if (fin > 7 && fin <= 17) {
        					
        					tempsMatinNuit =+ (7-debut);
        					tempsJournee =+ fin - 7;
        					
        				} else if (fin > 17) {
        					tempsMatinNuit =+ (7-debut);
        					tempsJournee = 17 - debut - tempsMatinNuit;
        					tempsMatinNuit = tempsMatinNuit +  (fin - 17);
        					
        				}
        				
        			}
        			
        			if (debut >= 7 && debut < 17){
        				
        				if (fin <= 17){
        					
        					tempsJournee = fin - debut;
        					
        				} else {
        					
        					tempsJournee = 17 - debut;
        					tempsMatinNuit = fin - 17;
        					
        				}
        				
        			}
        			
        			if (debut >= 17){
        				
        				tempsMatinNuit = fin - debut;
        				
        			}
        				
        				
        			
        			System.out.println("Vous avez loué votre vélo pendant");
        			
        			if (tempsMatinNuit > 0) {
        				
        				System.out.println(tempsMatinNuit + " heure(s) au tarif horaire de " + heureCreuse + " franc(s)");
        				
        			}
        			
        			if (tempsJournee > 0){
        				
            			System.out.println(tempsJournee + " heure(s) au tarif horaire de " + heurePleine + " franc(s)");

        			}
        			totalFrancs = tempsMatinNuit * heureCreuse + tempsJournee * heurePleine;
        			
        			System.out.println("Le montant total à payer est de " + totalFrancs + " franc(s)." );
        			
        			
        			
        		}
        		
        	}
        	
        }


        /*******************************************
         * Ne rien modifier apres cette ligne.
         *******************************************/

        clavier.close();
    }
}