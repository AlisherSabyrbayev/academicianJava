package DateAndFormat;

import java.time.ZonedDateTime;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.ZoneId;

public class DateTimeOperations {

    public static void main(String s[]) {
        Scanner scanner = new Scanner(System.in);

        ZonedDateTime dateTime = ZonedDateTime.now();

        System.out.println("\nDefault Format: " + dateTime);

        while (true) {
            System.out.println("\nPress 1 for adding to or deleting from the current date/time," +
                    "\nPress 2 for changing the timezone," +
                    "\nAny other key to exit");

            String userAction = scanner.nextLine();

            if (userAction.equals("1")) {
                System.out.println("Enter which unit of time you want to add/delete:\n" +
                        "d - days, M - months, y - years, h - hours, m - minutes, s - seconds, w - weeks");
                String unitToChange = scanner.nextLine();

                System.out.println("Enter the quantity to change (for example, 3):");
                long qtyToChange = Long.parseLong(scanner.nextLine());

                System.out.println("\nPress 'a' to add, 'd' to delete," +
                        "\nAny other key to go back to the main menu");
                String addOrDel = scanner.nextLine();

                ZonedDateTime newDateTime = null;

                if (addOrDel.equals("a")) {
                    switch (unitToChange) {
                        case "d":
                            newDateTime = dateTime.plusDays(qtyToChange);
                            break;
                        case "M":
                            newDateTime = dateTime.plusMonths(qtyToChange);
                            break;
                        case "y":
                            newDateTime = dateTime.plusYears(qtyToChange);
                            break;
                        case "h":
                            newDateTime = dateTime.plusHours(qtyToChange);
                            break;
                        case "m":
                            newDateTime = dateTime.plusMinutes(qtyToChange);
                            break;
                        case "s":
                            newDateTime = dateTime.plusSeconds(qtyToChange);
                            break;
                        case "w":
                            newDateTime = dateTime.plusWeeks(qtyToChange);
                            break;
                        default:
                            System.out.println("Invalid input");
                            continue;
                    }
                } else if (addOrDel.equals("d")) {
                    switch (unitToChange) {
                        case "d":
                            newDateTime = dateTime.minusDays(qtyToChange);
                            break;
                        case "M":
                            newDateTime = dateTime.minusMonths(qtyToChange);
                            break;
                        case "y":
                            newDateTime = dateTime.minusYears(qtyToChange);
                            break;
                        case "h":
                            newDateTime = dateTime.minusHours(qtyToChange);
                            break;
                        case "m":
                            newDateTime = dateTime.minusMinutes(qtyToChange);
                            break;
                        case "s":
                            newDateTime = dateTime.minusSeconds(qtyToChange);
                            break;
                        case "w":
                            newDateTime = dateTime.minusWeeks(qtyToChange);
                            break;
                        default:
                            System.out.println("Invalid input");
                            continue;
                    }
                } else {
                    System.out.println("Invalid input");
                    continue;
                }

                System.out.println("\n\nEnter the format you would like to print the date and time in:");
                String strDateTimeFormat = scanner.nextLine();

                DateTimeFormatter newDateTimeformat = DateTimeFormatter.ofPattern(strDateTimeFormat);

                System.out.println("The date and time is: " + newDateTime.format(newDateTimeformat));
            }

            else if (userAction.equals("2")) {
                System.out.println("Check the following Zone options:");
                Object[] zoneIds = ZoneId.getAvailableZoneIds().toArray();
                for (Object zoneId : zoneIds) {
                    System.out.println(zoneId);
                }

                System.out.println("\n\nEnter the time zone you want to get the current time for:");
                String newZone = scanner.nextLine();

                ZonedDateTime newZoneDateTime = dateTime.withZoneSameInstant(ZoneId.of(newZone));

                DateTimeFormatter newDateTimeformat = DateTimeFormatter.ofPattern("dd MMM yyyy hh:mm:ss a zzz");
                
                System.out.println("The date and time is: " + newZoneDateTime.format(newDateTimeformat));
            }

            // Exit the program
            else {
                break;
            }
        }
    }
}