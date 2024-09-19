
package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import model.entities.Reservation;
import model.exceptions.DomainException;


public class Program {


    public static void main(String[] args){
        
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try{
            System.out.println("Romm Number: ");
            int number = sc.nextInt();
            System.out.println("Data de Check-in(dd/MM/yyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Data de Check-out(dd/MM/yyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reserva: "+reservation);

            System.out.println("");
            System.out.println("Data para atualizar a reserva:");
            System.out.println("Data de Check-in(dd/MM/yyy): ");
            checkIn = sdf.parse(sc.next());
            System.out.println("Data de Check-out(dd/MM/yyy): ");
            checkOut = sdf.parse(sc.next());
            reservation.updateDates(checkIn, checkOut);

            System.out.println("Reserva: "+reservation);
        }catch(ParseException e){
            System.out.println("Formato de data invalido.");
        }catch(DomainException e){
            System.out.println("Erro na reserva: "+e.getMessage());
        }catch(RuntimeException e){
            System.out.println("Erro inesperado.");
        }
                
            
        sc.close();
    }
    
}
