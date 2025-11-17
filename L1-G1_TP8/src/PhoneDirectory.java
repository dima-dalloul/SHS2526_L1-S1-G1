import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class PhoneDirectory {
    public static void main(String[] args) {
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

        /*
        Question c : Créez la boucle principale qui lit un caractère et qui boucle tant que
        l'utilisateur ne tape pas 'q'.
         */

        // I will show a start message and create the scanner
        Scanner s = new Scanner(System.in);
        System.out.println("Hello and welcome to my Phone Directory");
        // The user input is initialized to a letter different from 'q'
        char userInput;

        // We enter the loop
        do {
            // We let the user know his/her options
            System.out.println("(a)dd (f)ind (l)ist (d)elete (s)ave (r)estore (q)uit :");
            // We get the first letter
            userInput = s.nextLine().charAt(0);

            // We're going to use a switch this time
            switch (userInput) {
                case 'l':
                    // Display the phone directory
                    displayPhoneDirectory(arrayNames, arrayNumbers);
                    break;

                case 'f':
                    // Find in the phone directory
                    System.out.println("What is the name you're looking for ?");
                    String name = s.nextLine().toLowerCase();
                    // Basic search
                    System.out.println("Here is what we found in the directory : " + searchPhoneDirectory(arrayNames, arrayNumbers, name));
                    // Dichotomic search
                    System.out.println("Here is what we found in the directory (dichotomic search) : " + dichotomicSsearchPhoneDirectory(arrayNames, arrayNumbers, name));
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

                case 'd':
                    // Get the name to delete in the phone directory
                    System.out.println("What is the name you want to delete ?");
                    String nameToSuppress = s.nextLine();
                    deletePersonPhoneDirectory(arrayNames, arrayNumbers, nameToSuppress);
                    sortPhoneDirectory(arrayNames, arrayNumbers);
                    break;

                case 's':
                    // Save the phone directory to a file
                    savePhoneDirectoryToFile(arrayNames, arrayNumbers);
                    break;

                case 'r':
                    // Restore the phone directory from a file
                    restorePhoneDirectoryFromFile(arrayNames, arrayNumbers);
                    break;

                case 'q':
                    // Quit the program
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
    public static void displayPhoneDirectory(String[] arrayNames, String[] arrayNumbers) {
        // We loop through both arrays
        for (int i = 0; i < arrayNames.length; i++) {
            if (!arrayNames[i].equals("_END")) {
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
        for (int i = 0; (i < arrayNames.length) && (!arrayNames[i].equals("_END")); i++) {
            if (arrayNames[i].toLowerCase().equals(name)) {
                return arrayNumbers[i];
            }
        }
        // If we reach this point, the name was not found so we return an empty string
        return "";
    }

    /**
     *
     * Bonus. Modifier la recherche pour tirer parti du fait que les éléments sont ordonnés.
     * Vous pourrez ainsi programmer une recherche dichotomique sur les éléments du tableau
     * entre les indices inf et sup (initialement, 0 et tab.length-1). Le principe est de
     * comparer l’élément à rechercher avec l’élément médian tab[m], c’est-à-dire l’élément au
     * milieu du tableau, d’indice m=(inf+sup)/2. Si tab[m] est l’élément recherché, on arrête.
     * Si tab[m] se situe après l’élément recherché dans l’ordre lexicographique, on recommence
     * la recherche sur le sous-tableau entre les indices 0 et m-1, sinon, on recommence sur le
     * sous-tableau entre les indices m+1 et tab.length-1.
     *
     * @param arrayNames
     * @param arrayNumbers
     * @param name
     * @return
     */
    private static String dichotomicSsearchPhoneDirectory(String[] arrayNames, String[] arrayNumbers, String name) {
        int inf = 0;
        int sup = 0;

        // First, we need to find the upper limit of the stored elements
        for (int i = 0; i < arrayNames.length; i++) {
            if (arrayNames[i].equals("_END")) {
                sup = i - 1;
                break;
            }
        }

        while (inf <= sup) {
            int mid = (inf + sup) / 2;
            int comparisonResult = arrayNames[mid].toLowerCase().compareTo(name);

            if (comparisonResult == 0) {
                // We found the name
                return arrayNumbers[mid];
            } else if (comparisonResult < 0) {
                // The name is after mid
                inf = mid + 1;
            } else {
                // The name is before mid
                sup = mid - 1;
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
        if (!nameAlreadyAdded.isEmpty()) {
            // This means that the name exists already in the directory
            // We just have to update the number
            // We will loop in the arrays and find the name and update the number
            for (int i = 0; i < arrayNames.length && !arrayNames[i].equals("_END"); i++) {
                if (arrayNames[i].equals(nameToAdd)) {
                    // We found the name, so we update the number
                    arrayNumbers[i] = numberToAdd;
                    // We will break the loop since we have found the element to update
                    break;
                }
            }
        } else {
            // The name does not exist in the directory so we have to add it.
            int lastStoredIndex = 0;

            // We are going to loop in the arrays to find the element "_END"
            for (int i = 0; i < arrayNames.length; i++) {
                if (arrayNames[i].equals("_END")) {
                    lastStoredIndex = i;
                    break;
                }
            }

            // Once we have found it, we check if we still have place to store the new person's details
            if (lastStoredIndex < arrayNames.length - 1) {
                // We can add the name and the number
                arrayNames[lastStoredIndex] = nameToAdd;
                arrayNumbers[lastStoredIndex] = numberToAdd;
                arrayNames[lastStoredIndex + 1] = "_END";
                arrayNumbers[lastStoredIndex + 1] = "_END";

                System.out.println(nameToAdd + " / " + numberToAdd + " was added successfully");

            } else {
                // The phone directory is full, so we won't be able to add it.
                System.out.println("Sorry, the phone directory is full. The addition was not successful.");
            }
        }
    }

    /**
     * Bonus 1 : Delete a name from the directory
     * Écrire une action permettant de supprimer un enregistrement : demandez le nom,
     * vérifiez que le nom est bien dans le tableau puis décalez d’un cran à gauche toutes les
     * informations restantes. N’oubliez pas de modifier le menu proposé à l’utilisateur.
     *
     * @param arrayNames
     * @param arrayNumbers
     * @param nameToSuppress
     */
    private static void deletePersonPhoneDirectory(String[] arrayNames, String[] arrayNumbers, String nameToSuppress) {
        String nameAlreadyInTheDirectory = searchPhoneDirectory(arrayNames, arrayNumbers, nameToSuppress.toLowerCase());

        if (!nameAlreadyInTheDirectory.isEmpty()) {
            // The name exists in the directory, so we have to delete it
            for (int i = 0; i < arrayNames.length && !arrayNames[i].equals("_END"); i++) {
                if (arrayNames[i].equals(nameToSuppress)) {
                    // We found the name to delete
                    // We will shift all the next elements to the left by one position
                    for (int j = i; j < arrayNames.length - 1; j++) {
                        arrayNames[j] = arrayNames[j + 1];
                        arrayNumbers[j] = arrayNumbers[j + 1];

                        // If we reach _END, we can stop shifting
                        if (arrayNames[j].equals("_END")) {
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

    /**
     * Bonus 2 : Sort the phone directory alphabetically
     */
    private static void sortPhoneDirectory(String[] arrayNames, String[] arrayNumbers) {
        // We will use a simple bubble sort algorithm
        boolean swapped;
        int length = 0;

        // First, we need to find the length of the stored elements
        for (int i = 0; i < arrayNames.length; i++) {
            if (arrayNames[i].equals("_END")) {
                length = i;
                break;
            }
        }

        // Now we can sort the arrays
        do {
            swapped = false;
            for (int i = 0; i < length - 1; i++) {
                if (arrayNames[i].compareToIgnoreCase(arrayNames[i + 1]) > 0) {
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
        } while (swapped);
    }

    /**
     * Écrire une action sauvegarder qui copie l’intégralité de l’annuaire dans un fichier
     * texte. Ce fichier doit contenir un nom et un numéro par ligne, séparés par un pointvirgule.
     * Il est inutile de copier les chaînes "_FIN". Sur l'exemple ci-dessus, la première
     * ligne du fichier doit donc être :
     * DUPONT;06 70..44
     * Ajouter un choix dans le menu proposé à l’utilisateur.
     *
     * @param arrayNames
     * @param arrayNumbers
     */
    private static void savePhoneDirectoryToFile(String[] arrayNames, String[] arrayNumbers) {
        // We will use a StringBuilder to build the content to save
        StringBuilder sb = new StringBuilder();

        // We loop through the arrays to build the content
        for (int i = 0; i < arrayNames.length; i++) {
            if (!arrayNames[i].equals("_END")) {
                sb.append(arrayNames[i]).append(";").append(arrayNumbers[i]).append("\n");
            } else {
                break;
            }
        }

        // Now we write the content to a file
        FileWriter writer;
        try {
            writer = new FileWriter("phone_directory.txt");
            writer.write(sb.toString());
            writer.close();
            System.out.println("Phone directory saved successfully to phone_directory.txt");
        } catch (Exception e) {
            System.out.println("An error occurred while saving the phone directory: " + e.getMessage());
        }
    }

    /**
     * Écrire une action importer qui fait l'opération inverse en récupérant ce qui est dans
     * le fichier pour le copier dans le tableau. N'oubliez pas d'ajouter les chaînes "_FIN".
     *
     * @param arrayNames
     * @param arrayNumbers
     */
    private static void restorePhoneDirectoryFromFile(String[] arrayNames, String[] arrayNumbers) {
        // We will use a Scanner to read the file
        Scanner fileScanner;
        try {
            FileReader fileReader = new FileReader("phone_directory.txt");
            fileScanner = new Scanner(fileReader);
            int index = 0;

            // We read the file line by line
            while (fileScanner.hasNextLine() && index < arrayNames.length - 1) {
                String line = fileScanner.nextLine();
                String[] parts = line.split(";");
                if (parts.length == 2) {
                    arrayNames[index] = parts[0];
                    arrayNumbers[index] = parts[1];
                    index++;
                }
            }

            // We add the _END markers
            arrayNames[index] = "_END";
            arrayNumbers[index] = "_END";

            fileScanner.close();
            System.out.println("Phone directory restored successfully from phone_directory.txt");
        } catch (Exception e) {
            System.out.println("An error occurred while restoring the phone directory: " + e.getMessage());
        }
    }
}