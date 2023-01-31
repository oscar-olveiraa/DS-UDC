//Noah R. Martín Cambeiro
//Oscar Olveira
//Grupo 3.1
package e1;


import org.w3c.dom.CDATASection;

public class DateUtilities {

    public static boolean isLeap ( int year ){
        // Si el año cumple todas las condiciones, es bisiesto
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    public static int numberOfDays(int month , int year) {//intentar evaluar mais resumidamente os meses
        if (month == 2) {//Miramos si el mes es febrero
            return isLeap(year) ? 29 : 28;   //Si el año es bisiesto y es febrero, devuelve 29, si no 28

        } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            return 31; //Para los meses que tengan 31 dias se devuelve el numero de dias
        } else if (month == 4 || month == 6 || month == 9 || month == 11){
            return 30; //Para los meses que tengan 30 dias se devuelve el numero de dias
        }else{
            throw new IllegalArgumentException("month is not valid"); //Si el formato no es valido lanzamos una excepción
        }
    }

    public static String convertToISODate(String dateText){
        String[] fecha=dateText.split("[,\\s]",3);
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

    }

    /*public static boolean checkISODate (String ISODate){
        String[] fecha=ISODate.split("[-]");
        if(fecha.length[0]==4){

        }
        return true;
    }*/
    


}
