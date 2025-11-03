import java.util.Scanner;

public class PhoneDirectory {
    public static void main(String[] args){
        // Question a : create the 2 arrays
        String[] arrayNames = new String[100];
        String[] arrayNumbers = new String[100];

        // Fill with dummy elements
        arrayNames[0] = "Dima";
        arrayNumbers[0] = "0123456789";
        arrayNames[1] = "Claude";
        arrayNumbers[1] = "9876543210";
        arrayNames[2] = "_END";
        arrayNumbers[2] = "_END";

        // Display the phone directory
        displayPhoneDirectory(arrayNames, arrayNumbers);

        /* Question c : Créez la boucle principale qui lit un caractère et qui boucle tant que
        l'utilisateur ne tape pas 'q'.
         */

        // I will show a start message and create the scanner
        Scanner s = new Scanner(System.in);
        System.out.println("Hello and welcome to my Phone Directory");
        // The user input is initialized to a letter different than 'q'
        char userInput = 'd';

        // We enter the loop
        do{
            // We let the user know his/her options
            System.out.println("(a)jouter (r)echerche (l)ister (q)uitter :");
            // We get the first letter
            userInput = s.nextLine().charAt(0);

            if(userInput == 'l'){
                displayPhoneDirectory(arrayNames, arrayNumbers);
            }
        } while (userInput != 'q');

        System.out.println("Thank you & Goodbye !");
    }

    /*
    Question b: Écrire une action qui permet d'afficher le contenu de l’annuaire
    (une ligne par personne) et appelez-la dans le main.
    Cette action prend les deux tableaux en paramètre
     */
    public static void displayPhoneDirectory(String[] arrayNames, String[] arrayNumbers){
        // We loop through both arrays
        for(int i = 0; i < arrayNames.length; i++){
            if(!arrayNames[i].equals("_END")) {
                // if I didn't reach the end, I should show the line
                System.out.println(arrayNames[i] + " / " + arrayNumbers[i]);
            } else {
                // I have reached _END, so I break the loop
                break;
            }
        }
    }
}