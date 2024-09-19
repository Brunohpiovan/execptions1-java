
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;


public class Program {


    public static void main(String[] args) throws ParseException {
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        
        System.out.println("Romm Number: ");
        int number = sc.nextInt();
        System.out.println("Data de Check-in(dd/MM/yyy): ");
        Date checkIn = sdf.parse(sc.next());
        System.out.println("Data de Check-out(dd/MM/yyy): ");
        Date checkOut = sdf.parse(sc.next());
        
        if(!checkOut.after(checkIn)){
            System.out.println("Erro na reserva:A data de check-out deve ser apos a data de check-in.");
        }else{
            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva: "+reservation);
            
            System.out.println("");
            System.out.println("Data para atualizar a reserva:");
            System.out.println("Data de Check-in(dd/MM/yyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Data de Check-out(dd/MM/yyy): ");
            checkOut = sdf.parse(sc.next());
            
            String error=reservation.updateDates(checkIn, checkOut);
            if(error !=null){
                System.out.println("Erro na reserva: "+error);
            }else{
                System.out.println("Reserva: "+reservation);
            }
                
            }
            
        
        sc.close();
    }
    
}
