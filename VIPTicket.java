public class VIPTicket extends Ticket
{
    private String vipID;
    
    public VIPTicket(String concertDate, String concertTime, int seatNum, int quantity, double price, Client cl, String vipID) 
    {
        super(concertDate, concertTime, seatNum, quantity, price, cl);
        this.vipID = vipID;
    }
    
    public void setVIPTicket(String cd, String ct, int seatNum, int quantity, double price, Client cl, String vipID)
    {
        super.setTicket(cd,ct,seatNum,quantity,price,cl);    
        this.vipID = vipID;
    }
    
    public String getVipID() 
    {
        return vipID; 
    }
    
    public double calcPrice()
    {
        double vipDiscount = 0.20; //membership discount
        double total = 0.0;
        int seat = super.getSeatNum();
        double price = super.getPrice();
        if (seat <=200 && seat >=1){
                price = 1000.00;
            }else if (seat <=500 && seat >=200){
                price = 700.00;
            }else if (seat <=700 && seat >=500){
                price = 300.00;
            }
            else 
                price = 0.00;
        total = price * super.getQuantity();
        total = total - (total * vipDiscount);
        return total;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + vipID ;
    }
}

