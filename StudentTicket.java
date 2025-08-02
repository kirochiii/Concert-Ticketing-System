public class StudentTicket extends Ticket
{
    private String stuID;
    
    public StudentTicket(String concertDate, String concertTime, int seatNum, int quantity, double price, Client cl, String stuID) 
    {
        super(concertDate, concertTime, seatNum, quantity, price, cl);
        this.stuID = stuID;
    }
    
    public void setStudentTicket(String cd, String ct, int seatNum, int quantity, double price, Client cl,String stuID)
    {
        super.setTicket(cd,ct,seatNum,quantity,price,cl);
        this.stuID = stuID;
    }
    
    public String getStuID() 
    { 
        return stuID; 
    }

    public double calcPrice()
    {
        double stuDiscount = 0.10; //student discount
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
        total = total - (total * stuDiscount);
        return total;
    }
    
    @Override
    public String toString()
    {
        return super.toString() + stuID;
    }
}
