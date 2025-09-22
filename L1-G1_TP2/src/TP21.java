import java.util.Scanner;

public class TP21 {
    public static void main(String[] args) {
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