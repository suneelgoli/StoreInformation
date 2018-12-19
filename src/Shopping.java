import java.util.Scanner;
class Cart {
    Item[] items = new Item[50];
    Order order[] = new Order[50];
    int nextOrderIndex = 0;
    Scanner scanner = new Scanner(System.in);

    public void process() {
        System.out.println("Enter Your Choice");

        while (true) {
            System.out.println("1. Order");
            System.out.println("2. Cancel Order");
            System.out.println("3. Show Orders");
            System.out.println("4:Exit");
            System.out.println("Enter your Choice");
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    addOrder();
                    break;
                case 2:
                    cancelOrder();
                    break;
                case 3:
                    showOrder();
                    break;
                case 4:

                    System.exit(0);
                    break;
            }
        }
    }

    void addOrder() {
        Order order1 = new Order();
        System.out.println("Enter the  Product and Quantity  Here");
        order1.item = new Item(scanner.next(), scanner.nextInt());
        System.out.println("Enter Bank name and Userid and password");
        order1.nb = new Banking(scanner.next(), scanner.next(), scanner.next(), order1.item.calculateTotal());
        order1.item.print();
        order1.nb.pay.pay();
        order[nextOrderIndex] = order1;
        nextOrderIndex++;
    }

    void cancelOrder() {
        for (int i = 0; i < order.length; i++) {
            if (order[i] != null) {
                order[i] = null;
            }
        }
    }
    void showOrder()
    {
        for (int i=0;i<order.length;i++)
        {
            if (order[i]!=null)
            {
                order[i].print1();
            }
        }
    }
}
class Item
{
    int itemid;
    String name;
    double price=500.0;
    int quantity;
    Item(String name,int quantity)
    {
        this.itemid=itemid;
        this.name=name;
        this.quantity=quantity;
    }
    void print()
    {
        System.out.println("Product Name: " + name + "\n" + "Price:" + price);
        System.out.println("Quantity:" + quantity);
        System.out.println("Total :"+calculateTotal());
    }
    double calculateTotal()
    {
        return  (quantity * price);
    }
}
class Order
{
    Scanner sc=new Scanner(System.in);
    int orderid=0;
    Item item;
    Banking nb;
    Order()
    {

    }
    void print1()
    {
        System.out.println("Product Name: " + item.name + "\n" + "Price:" +item.price);
        System.out.println("Quantity:" + item.quantity);
        System.out.println("Total :"+item.calculateTotal());
    }
}
class Banking
{
    String bank_name;
    String userid;
    String password;
    Payment pay;
    Banking(String bank_name,String userid,String password,double amount)
    {
        this.bank_name=bank_name;
        this.userid=userid;
        this.password=password;
        pay=new Payment(amount);
    }
}
class Payment
{
    int paymentid;
    double amount;
    Payment(double amount)
    {
        paymentid=1;
        this.amount=amount;
        paymentid++;
    }
    void pay()
    {
        System.out.println("Payment ID:"+paymentid);
        System.out.println("Status:"+"Paid");
    }
}
public class Shopping {
    public static void main(String []args)
    {

        Cart cart=new Cart();
        cart.process();
    }
}