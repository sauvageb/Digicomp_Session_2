package exercices.date;

import java.time.LocalDate;

/*
 ** Consigne **
 *
 * Evaluez si deux dates sont égales
 * Date 1 : la date du premier jour de votre formation Java 8
 * Date 2 : la date du jour
 *
 * Affichez un message pour indiquer si elles sont égales ou non
 *
 *************
 *
 * Resultat attendu :
 */
class Exo4 {

    public static void main(String[] args) {
        LocalDate date1 = null;
        LocalDate date2 = null;

        if(identicalDates(date1, date2)){
            System.out.println("date1 and date2 are identical dates");
        }else {
            System.out.println("date1 and date2 are different");
        }

    }

    // TODO
    public static boolean identicalDates(LocalDate date1, LocalDate date2){
       return false;
    }


}
