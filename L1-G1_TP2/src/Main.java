import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        /*
        Pour cela, il faut calculer le nombre de jours depuis le 1er janvier, prendre le reste de sa division
        par 7 et tenir compte du fait que le 1er janvier était un mercredi.
        Pour compter le nombre de jours depuis le 1er janvier, vous pouvez additionner le numéro du jour avec
        le nombre de jours des mois pleins qui précèdent (31 pour février, 31+28=59 pour mars, 31+28+31=90
        pour avril, 120 pour mai, 151 pour juin, 181 pour juillet, 212 pour août, 243 pour septembre, 273 pour
        octobre, 304 pour novembre et 334 pour décembre).
        Ainsi le 26 septembre est le 243+26 = 269e jour de l'année 2025. Comme le 1er janvier est le 1er jour
        de l'année, il y a donc 269-1=268 jours d'écart entre les deux. Le reste de la division de 268 par
        7 est 2. Donc le jour de la semaine correspondant au 26 septembre est décalé de 2 jours par rapport à
        celui du 1er janvier. C'est donc un vendredi.

         */
        int day, month, totalNumberOfDaysSinceFirstJanuary = 0, differenceInDays, restOfDivisionBy7;
        Scanner s;

        // Get the user's input
        s = new Scanner(System.in);
        System.out.println("What's the number of the day ?");
        day = s.nextInt();
        System.out.println("What's the number of the month ?");
        month = s.nextInt();

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

        /*
        Comme le 1er janvier est le 1er jour de l'année, il y a donc 269-1=268 jours d'écart entre les deux.
        Le reste de la division de 268 par
        7 est 2. Donc le jour de la semaine correspondant au 26 septembre est décalé de 2 jours par rapport à
        celui du 1er janvier. C'est donc un vendredi.
         */
        differenceInDays = (totalNumberOfDaysSinceFirstJanuary + day) - 1;
        restOfDivisionBy7 = differenceInDays % 7;

        // 1st January was a Wednesday
        if(restOfDivisionBy7 == 0){
            System.out.println("" +  day + "/" + month + " is a Wednesday");
        }if(restOfDivisionBy7 == 1){
            System.out.println("" +  day + "/" + month + " is a Thursday");
        }if(restOfDivisionBy7 == 2){
            System.out.println("" +  day + "/" + month + " is a Friday");
        }if(restOfDivisionBy7 == 3){
            System.out.println("" +  day + "/" + month + " is a Saturday");
        }if(restOfDivisionBy7 == 4){
            System.out.println("" +  day + "/" + month + " is a Sunday");
        }if(restOfDivisionBy7 == 5){
            System.out.println("" +  day + "/" + month + " is a Monday");
        }if(restOfDivisionBy7 == 6){
            System.out.println("" +  day + "/" + month + " is a Tuesday");
        }
    }
}