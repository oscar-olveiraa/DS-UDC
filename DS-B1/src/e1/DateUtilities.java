//Noah R. Martín Cambeiro
//Oscar Olveira
//Grupo 3.1
package e1;

public class DateUtilities {

    public static boolean isLeap(int year) {
        // Se o ano cumple todas as condicions, e bisiesto
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    public static int numberOfDays(int month, int year) {
        if (month == 2) {//Miramos si o mes é febrero
            return isLeap(year) ? 29 : 28;   //Se o año é bisiesto e é febrero, devolve 29, si non 28

        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31; //Para os meses que teñan 31 dias devuelvese o numero de dias

        } else if (month == 4 || month == 6 || month == 9 || month == 11) {
            return 30; //Para os meses que teñan 30 dias devuelvese o numero de dias

        } else {
            throw new IllegalArgumentException("month is not valid"); //Se o formato non é valido lanzamos unha excepción
        }
    }

    public static String convertToISODate(String dateText) {
        String[] fecha = dateText.split("[,\\s]", 3); //String que fai que separe as partes dunha fecha no formato dado
        switch(fecha[0]){
            case "January":
                return (fecha[2].trim()+"-01-"+fecha[1]);
            case "February":
                return (fecha[2].trim()+"-02-"+fecha[1]);
            case "March":
                return (fecha[2].trim()+"-03-"+fecha[1]);
            case "April":
                return (fecha[2].trim()+"-04-"+fecha[1]);
            case "May":
                return (fecha[2].trim()+"-05-"+fecha[1]);
            case "June":
                return (fecha[2].trim()+"-06-"+fecha[1]);
            case "July":
                return (fecha[2].trim()+"-07-"+fecha[1]);
            case "August":
                return (fecha[2].trim()+"-08-"+fecha[1]);
            case "September":
                return (fecha[2].trim()+"-09-"+fecha[1]);
            case "October":
                return (fecha[2].trim()+"-10-"+fecha[1]);
            case "November":
                return (fecha[2].trim()+"-11-"+fecha[1]);
            case "December":
                return (fecha[2].trim()+"-12-"+fecha[1]);
            default:
                return("");
        }
        //fixemolo de ambas formas pero creemos que o switch e mais eficiente
        /*if (fecha[0].equals("January")) {
            return (fecha[2].trim() + "-01-" + fecha[1]);//devolve a data en formato ISO, o metodo trim esta para que non creara un espacio vacio no principio da cadena

        } else if (fecha[0].equals("February")) {
            return (fecha[2].trim() + "-02-" + fecha[1]);

        } else if (fecha[0].equals("March")) {
            return (fecha[2].trim() + "-03-" + fecha[1]);

        } else if (fecha[0].equals("April")) {
            return (fecha[2].trim() + "-04-" + fecha[1]);

        } else if (fecha[0].equals("May")) {
            return (fecha[2].trim() + "-05-" + fecha[1]);

        } else if (fecha[0].equals("June")) {
            return (fecha[2].trim() + "-06-" + fecha[1]);

        } else if (fecha[0].equals("July")) {
            return (fecha[2].trim() + "-07-" + fecha[1]);

        } else if (fecha[0].equals("August")) {
            return (fecha[2].trim() + "-08-" + fecha[1]);

        } else if (fecha[0].equals("September")) {
            return (fecha[2].trim() + "-09-" + fecha[1]);

        } else if (fecha[0].equals("October")) {
            return (fecha[2].trim() + "-10-" + fecha[1]);

        } else if (fecha[0].equals("November")) {
            return (fecha[2].trim() + "-11-" + fecha[1]);

        } else if (fecha[0].equals("December")) {
            return (fecha[2].trim() + "-12-" + fecha[1]);

        } else {
            return ("");
        }*/
    }

    public static boolean checkISODate(String ISODate) {
        String[] iso = ISODate.split("[-]", 3);
        int iso1 = Integer.parseInt(iso[0]); //parte fecha->ano
        int iso2 = Integer.parseInt(iso[1]); //parte fecha->mes
        int iso3 = Integer.parseInt(iso[2]); //parte fecha->dia
        if (iso2 < 0 || iso2 > 12) {//comprobamos se o mes é valido
            return false;

        } else if (!isLeap(iso1) && iso3 == 29) {//comprobamos no caso dos anos bisiestos
            return false;

        } else if (iso3 < 1 || iso3 > 31) {//comprobamos si o dia é valido
            return false;

        } else if (iso[0].length() > 4 || iso[1].length() > 2 || iso[2].length() > 2) {//comprobamos se o tamaño de cada parte da fecha e correcto
            return false;
        }
        return true;
    }
}
