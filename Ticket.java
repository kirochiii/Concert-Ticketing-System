public abstract class Ticket
{
    private String concertDate;
    private String concertTime;
    private int seatNum;
    private int quantity;
    private double price;
    private Client cl;
    
    // normal constructor
    public Ticket (String concertDate, String concertTime, int seatNum, int quantity, double price, Client cl)
    {
        this.concertDate = concertDate;
        this.concertTime = concertTime;
        this.seatNum = seatNum;
        this.quantity = quantity;
        this.cl = cl;
    }
    
    public void setTicket(String cd, String ct, int seatNum, int quantity, double price, Client cl)
    {
        concertDate = cd;
        concertTime = ct;
        this.seatNum = seatNum;
        this.quantity = quantity;
        this.price = price;
        this.cl = cl;
    }
    
    public String getConcertDate()
    {
        return concertDate;
    }
    
    public String getConcertTime()
    {
        return concertTime;
    }

    public int getSeatNum()
    {
        return seatNum;
    }
    
    public int getQuantity()
    {
        return quantity;
    }
    
    public double getPrice()
    {
        return price;
    }
    
    public abstract double calcPrice();
    
    public Client getCl()
    {
        return cl;
    }
    
    public String toString()
    {
       return concertDate + concertTime + seatNum + quantity + price ; 
    }
}
   
