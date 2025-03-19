package ie.atuteamproject;
public class Orders
{
    private int orderID;
    private int quantity;
    private String date;
    private String dateShipped;

    public int getOrderID()
    {
        return orderID;
    }



    // test
    public void setOrderID(int orderID)
    {
        this.orderID = orderID;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public String getDate()
    {
        return date;
    }

    public void setDate(String date)
    {
        this.date = date;
    }

    public String getDateShipped()
    {
        return dateShipped;
    }

    public void setDateShipped(String dateShipped)
    {
        this.dateShipped = dateShipped;
    }

    //test
}

