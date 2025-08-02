public class Client
{
    private String clientName;
    private String password;
    
    public Client (String clientName, String password)
    {
        this.clientName = clientName;
        this.password = password;
    }
    
    public void setClient(String clName, String pass)
    {
        clientName = clName;
        password = pass;
    }
    
    public String getClientName()
    {
        return clientName;
    }
    
    public String getPassword()
    {
        return password;
    }
    
     public String toString() 
    {
        return String.format("Client: %s, Password: %s", clientName, password);
    }
}
