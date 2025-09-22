import java.util.Scanner;

public class TP22 {
    public static void main(String[] args) {
        /*Faire la même chose mais avec n’importe quelle autre année entre 1901 et 2099, en demandant
        à l'utilisateur le jour de la semaine du 1er janvier de cette année-là. Attention, dans cet intervalle,
         les années multiples de 4 sont bissextiles et comptent un jour de plus en février, ce qui va décaler
         de un les nombres de jours à partir de mars. Voici un exemple pour l’année 2002 qui n’est pas bissextile
         :
        Quel est le numéro du jour : 6
        Quel est le numéro du mois : 3
        Quelle est l'année : 2002
        Quel était le numéro du jour du 1er janvier 2002 (1:lundi, 2:mardi, ...) ? 2
        Le 6/3/2002 était un mercredi.
        */

        int day, month, totalNumberOfDaysSinceFirstJanuary = 0, differenceInDays, restOfDivisionBy7;
        int year, dayOfWeekOfFirstJanuary;
        Scanner s;

        // Get the user's input
        s = new Scanner(System.in);
        System.out.println("What's the number of the day ?");
        day = s.nextInt();
        System.out.println("What's the number of the month ?");
        month = s.nextInt();
        System.out.println("What's the number of the year ?");
        year = s.nextInt();
        System.out.println("What weekday was the 1st January ? 0 for Monday, 1 for Tuesday, 2 for Wednesday, 3 for Thursday, 4 for Friday, 5 for Saturday, 6 for Sunday");
        dayOfWeekOfFirstJanuary = s.nextInt();

        if(year % 4 == 0) { // We check if the year was a leap/bissextile year
            if (month == 1) { // JANUARY
                totalNumberOfDaysSinceFirstJanuary = 0;
            } else if (month == 2) { // FEBRUARY
                totalNumberOfDaysSinceFirstJanuary += 31; // we add the 31 days of January
            } else if (month == 3) { // MARCH
                totalNumberOfDaysSinceFirstJanuary += 31 + 29; // we add the 31 days of January and the 29 days of February
            } else if (month == 4) { // APRIL
                totalNumberOfDaysSinceFirstJanuary += 31 + 29 + 31;
            } else if (month == 5) { // MAY
                totalNumberOfDaysSinceFirstJanuary += 31 + 29 + 31 + 30;
            } else if (month == 6) { // JUNE
                totalNumberOfDaysSinceFirstJanuary += 31 + 29 + 31 + 30 + 31;
            } else if (month == 7) { // JULY
                totalNumberOfDaysSinceFirstJanuary += 31 + 29 + 31 + 30 + 31 + 30;
            } else if (month == 8) { // AUGUST
                totalNumberOfDaysSinceFirstJanuary += 31 + 29 + 31 + 30 + 31 + 30 + 31;
            } else if (month == 9) { // SEPTEMBER
                totalNumberOfDaysSinceFirstJanuary += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31;
            } else if (month == 10) { // OCTOBER
                totalNumberOfDaysSinceFirstJanuary += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
            } else if (month == 11) { // NOVEMBER
                totalNumberOfDaysSinceFirstJanuary += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
            } else if (month == 12) { // DECEMBER
                totalNumberOfDaysSinceFirstJanuary += 31 + 29 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
            }
        } else {
            if(month == 1) { // JANUARY
                totalNumberOfDaysSinceFirstJanuary = 0;
            } else if (month == 2) { // FEBRUARY
                totalNumberOfDaysSinceFirstJanuary += 31; // we add the 31 days of January
            } else if (month == 3) { // MARCH
                totalNumberOfDaysSinceFirstJanuary += 31 + 28; // we add the 31 days of January and the 28 days of February
            } else if (month == 4) { // APRIL
                totalNumberOfDaysSinceFirstJanuary += 31 + 28 + 31;
            } else if (month == 5) { // MAY
                totalNumberOfDaysSinceFirstJanuary += 31 + 28 + 31 + 30;
            } else if (month == 6) { // JUNE
                totalNumberOfDaysSinceFirstJanuary += 31 + 28 + 31 + 30 + 31;
            } else if (month == 7) { // JULY
                totalNumberOfDaysSinceFirstJanuary += 31 + 28 + 31 + 30 + 31 + 30;
            } else if (month == 8) { // AUGUST
                totalNumberOfDaysSinceFirstJanuary += 31 + 28 + 31 + 30 + 31 + 30 + 31;
            } else if (month == 9) { // SEPTEMBER
                totalNumberOfDaysSinceFirstJanuary += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31;
            } else if (month == 10) { // OCTOBER
                totalNumberOfDaysSinceFirstJanuary += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30;
            } else if (month == 11) { // NOVEMBER
                totalNumberOfDaysSinceFirstJanuary += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31;
            } else if (month == 12) { // DECEMBER
                totalNumberOfDaysSinceFirstJanuary += 31 + 28 + 31 + 30 + 31 + 30 + 31 + 31 + 30 + 31 + 30;
            }
        }
        //TO BE CONTINUED NEXT WEEK
    }
}