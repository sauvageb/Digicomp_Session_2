package exercices.date;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.SplittableRandom;

/*
 ** Consigne **
 *
 * Coder getTodayWithJava8 pour obtenir la date du jour en Java 8, avec le temps.
 *
 *************
 *
 * Resultat attendu : Date d'aujourd'hui :Thu Nov 25 10:46:20 CET 2021
 */
class Exo1 {

    public static void main(String[] args) {
        System.out.println("Date d'aujourd'hui :" + getToday());
        System.out.println("Date d'aujourd'hui :" + getTodayWithJava8());
    }

    public static String getToday() {
        return new Date().toString();
    }

    // TODO : le type de retour doit être modifié
    public static String getTodayWithJava8() {
        return "";
    }
}
