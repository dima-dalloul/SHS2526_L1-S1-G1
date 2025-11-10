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

        sortPhoneDirectory(arrayNames, arrayNumbers);

        // Display the phone directory
        displayPhoneDirectory(arrayNames, arrayNumbers);

        /* Question c : Créez la boucle principale qui lit un caractère et qui boucle tant que
        l'utilisateur ne tape pas 'q'.
         */

        // I will show a start message and create the scanner
        Scanner s = new Scanner(System.in);
        System.out.println("Hello and welcome to my Phone Directory");
        // The user input is initialized to a letter different from 'q'
        char userInput;

        // We enter the loop
        do{
            // We let the user know his/her options
            System.out.println("(a)jouter (r)echerche (l)ister (s)upprimer (q)uitter :");
            // We get the first letter
            userInput = s.nextLine().charAt(0);

            // We're going to use a switch this time
            switch (userInput){
                case 'l':
                    // Display the phone directory
                    displayPhoneDirectory(arrayNames, arrayNumbers);
                    break;

                case 'r':
                    // Search the phone directory
                    System.out.println("What is the name you're looking for ?");
                    String name = s.nextLine().toLowerCase();
                    System.out.println("Here is what we found in the directory : " + searchPhoneDirectory(arrayNames, arrayNumbers, name));
                    break;

                case 'a':
                    // Add a person's name and number in the phone directory
                    System.out.println("What is the name you want to add ?");
                    String nameToAdd = s.nextLine();
                    System.out.println("What is the number you want to add ?");
                    String numberToAdd = s.nextLine();
                    addNewPersonPhoneDirectory(arrayNames, arrayNumbers, nameToAdd, numberToAdd);
                    sortPhoneDirectory(arrayNames, arrayNumbers);
                    break;

                case 's':
                    // Get the name to delete in the phone directory
                    System.out.println("What is the name you want to delete ?");
                    String nameToSuppress = s.nextLine();
                    deletePersonPhoneDirectory(arrayNames, arrayNumbers, nameToSuppress);
                    sortPhoneDirectory(arrayNames, arrayNumbers);
                    break;

                default:
                    System.out.println("Wrong input, try again");
                    break;
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

    /**
     * Question d : Écrire une fonction renvoyant le numéro de téléphone à partir du nom, ou la chaîne vide si
     * le nom n'existe pas. Complétez le main en appelant cette fonction
     */
    private static String searchPhoneDirectory(String[] arrayNames, String[] arrayNumbers, String name) {
        for(int i = 0; (i < arrayNames.length) && (!arrayNames[i].equals("_END")); i++){
            if(arrayNames[i].toLowerCase().equals(name)){
                return arrayNumbers[i];
            }
        }
        // If we reach this point, the name was not found so we return an empty string
        return "";
    }

    /**
     * Question e : Écrire le code permettant d’ajouter une personne : demander le nom et le numéro, vérifier que
     * ce nom n’existe pas déjà, vérifier que les tableaux ne sont pas pleins et ranger ces informations
     * à la place de la chaîne "_FIN" qui sera décalée d’un cran à droite.
     */
    private static void addNewPersonPhoneDirectory(String[] arrayNames, String[] arrayNumbers, String nameToAdd, String numberToAdd) {
        String nameAlreadyAdded = searchPhoneDirectory(arrayNames, arrayNumbers, nameToAdd.toLowerCase());
        if(!nameAlreadyAdded.isEmpty()){
            // This means that the name exists already in the directory
            // We just have to update the number
            // We will loop in the arrays and find the name and update the number
            for(int i = 0; i < arrayNames.length && !arrayNames[i].equals("_END"); i++){
                if(arrayNames[i].equals(nameToAdd)){
                    // We found the name, so we update the number
                    arrayNumbers[i] = numberToAdd;
                    // We will break the loop since we have found the element to update
                    break;
                }
            }
        } else{
            // The name does not exist in the directory so we have to add it.
            int lastStoredIndex = 0;

            // We are going to loop in the arrays to find the element "_END"
            for(int i = 0; i < arrayNames.length; i++){
                if(arrayNames[i].equals("_END")){
                    lastStoredIndex = i;
                    break;
                }
            }

            // Once we have found it, we check if we still have place to store the new person's details
            if(lastStoredIndex < arrayNames.length - 1){
                // We can add the name and the number
                arrayNames[lastStoredIndex] = nameToAdd;
                arrayNumbers[lastStoredIndex] = numberToAdd;
                arrayNames[lastStoredIndex + 1 ] = "_END";
                arrayNumbers[lastStoredIndex + 1 ] = "_END";

                System.out.println(nameToAdd + " / " + numberToAdd + " was added successfully");

            } else {
                // The phone directory is full, so we won't be able to add it.
                System.out.println("Sorry, the phone directory is full. The addition was not successful.");
            }
        }
    }

    /** Bonus 1 : Delete a name from the directory */
    private static void deletePersonPhoneDirectory(String[] arrayNames, String[] arrayNumbers, String nameToSuppress) {
        String nameAlreadyInTheDirectory = searchPhoneDirectory(arrayNames, arrayNumbers, nameToSuppress.toLowerCase());

        if(!nameAlreadyInTheDirectory.isEmpty()){
            // The name exists in the directory, so we have to delete it
            for(int i = 0; i < arrayNames.length && !arrayNames[i].equals("_END"); i++){
                if(arrayNames[i].equals(nameToSuppress)){
                    // We found the name to delete
                    // We will shift all the next elements to the left by one position
                    for(int j = i; j < arrayNames.length - 1; j++){
                        arrayNames[j] = arrayNames[j + 1];
                        arrayNumbers[j] = arrayNumbers[j + 1];

                        // If we reach _END, we can stop shifting
                        if(arrayNames[j].equals("_END")){
                            break;
                        }
                    }
                    System.out.println(nameToSuppress + " was deleted successfully from the phone directory.");
                    // We break the loop since we have found and deleted the element
                    break;
                }
            }
        } else {
            // The name does not exist in the directory
            System.out.println("The name " + nameToSuppress + " does not exist in the phone directory.");
        }
    }

    /** Bonus 2 : Sort the phone directory alphabetically */
    private static void sortPhoneDirectory(String[] arrayNames, String[] arrayNumbers) {
        // We will use a simple bubble sort algorithm
        boolean swapped;
        int length = 0;

        // First, we need to find the length of the stored elements
        for(int i = 0; i < arrayNames.length; i++){
            if(arrayNames[i].equals("_END")){
                length = i;
                break;
            }
        }

        // Now we can sort the arrays
        do{
            swapped = false;
            for(int i = 0; i < length - 1; i++){
                if(arrayNames[i].compareToIgnoreCase(arrayNames[i + 1]) > 0){
                    // We need to swap the elements in both arrays
                    String tempName = arrayNames[i];
                    String tempNumber = arrayNumbers[i];

                    arrayNames[i] = arrayNames[i + 1];
                    arrayNumbers[i] = arrayNumbers[i + 1];

                    arrayNames[i + 1] = tempName;
                    arrayNumbers[i + 1] = tempNumber;

                    swapped = true;
                }
            }
        } while(swapped);
    }

}