import java.io.*;
public class ConcertApp
{
    public static void main (String[]args)
    { 
        try
        {
            FileReader fr = new FileReader("ConcertInfo.txt");
            BufferedReader br = new BufferedReader(fr);
            //classes for output file 
            FileWriter fw = new FileWriter("output.txt");
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);
        
            Client cl;
            String clientName, password, concertDate, concertTime, vipID, stuID;
            double price = 0.0;
            double total = 0.0;
            int seatNum, quantity, typeOfTicket;
            String line;
            int ticketIndex=0;
        
            pw.println("                      Welcome To BookTix Concert Ticketing System!");
            pw.println("            Aren't you happy that your favorite star is coming to Malaysia?!");
            pw.println("                Come reserve your ticket immediately while they last!!" );
            pw.println("*");
            pw.println("|     Seat Number     |          Price          |         Date         |     Time     |");
            pw.println("*");
            pw.println("| 1-200               | RM1000.00               | 15 September 2025    | 4-6 PM       |");
            pw.println("|                     |                         |                      | 6-8 PM       |");
            pw.println("|                     |                         |                      | 8-10 PM      |");
            pw.println("|-------------------------------------------------------------------------------------|");
            pw.println("| 201-500             | RM700.00                | 16 September 2025    | 2-4 PM       |");
            pw.println("|                     |                         |                      | 4-6 PM       |");
            pw.println("|                     |                         |                      | 6-8 PM       |");
            pw.println("|-------------------------------------------------------------------------------------|");
            pw.println("| 501-700             | RM300.00                | 17 September 2025    | 4-6 PM       |");
            pw.println("|                     |                         |                      | 6-8 PM       |");
            pw.println("|                     |                         |                      | 8-10 PM      |");
            pw.println("*");
    
            Ticket[] tickets = new Ticket[15];
            while ((line=br.readLine()) != null && ticketIndex < tickets.length)
            {
                String[]details = line.split(",");
                clientName = details[0];
                password = details[1];
                concertDate = details[2];
                concertTime = details[3];
                seatNum = Integer.parseInt(details[4]);
                quantity = Integer.parseInt(details[5]);
                typeOfTicket = Integer.parseInt(details[6]);
            
                cl = new Client(clientName, password);
                if (typeOfTicket == 1) // for VIP ticket
                {
                    vipID = details[7];
                
                    tickets[ticketIndex]= new VIPTicket(concertDate, concertTime, seatNum, quantity, price, cl, vipID);
                }
                else 
                {
                    stuID = details[7];
                
                    tickets[ticketIndex] = new StudentTicket(concertDate, concertTime, seatNum, quantity, price, cl, stuID);
                }
                total = tickets[ticketIndex].calcPrice();
            
                pw.println("=== BOOKING " + (ticketIndex + 1) + " ===");
                pw.println("Client: " + clientName);
                pw.println("Concert Date: " + concertDate);
                pw.println("Concert Time: " + concertTime);
                pw.println("Seats: " + seatNum + " to " + (seatNum + quantity - 1));
                pw.println("Quantity: " + quantity);
                pw.printf("Total Price: RM%.2f%n", tickets[ticketIndex].calcPrice());
                pw.println();
                ticketIndex++;
            }
            double totalRevenue = 0;
            int totalTickets = 0;
            
            pw.println("=== SUMMARY ===");
            pw.println("Total Bookings: " + ticketIndex);
            
            // Process ARRAY OF OBJECTS to calculate summary
            for (int i=0; i < ticketIndex; i++) 
            {
                // Accessing composite object through Client
                totalRevenue += tickets[i].calcPrice();
                totalTickets += tickets[i].getQuantity();
            }
            
            pw.println("Total Tickets Sold: " + totalTickets);
            pw.printf("Total Revenue: RM%.2f%n", totalRevenue);
    
            br.close();
            pw.close();
        
            pw.println("Data processed successfully!");
            pw.println("Check output.txt for booking details.");
            pw.println("Total bookings processed: " + ticketIndex);
        } // end try
        catch(FileNotFoundException fnf)
        {  
            System.out.println("Input file does not exist");
        }
        catch (EOFException eof)
        { 
            System.out.println(eof.getMessage());
        }
        catch(IOException io)
        {
            System.out.println(io.getMessage()); 
        }
    }   
}
