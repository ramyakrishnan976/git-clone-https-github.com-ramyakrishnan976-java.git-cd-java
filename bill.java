import java.util.*;
public class bill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Customer Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Previous Reading: ");
        double prev = sc.nextDouble();
        System.out.print("Enter Current Reading: ");
	double curr =sc.nextDouble();
	System.out.print("Enter Connect Type (1 for Domestic, 2 for Non-Domestic): ");
        int type = sc.nextInt();
	double unit = curr - prev;
        double rate = 0;
	
	if(type==1)
	{
		if (unit <= 100)
		{
			rate= 4.80;	
		}
		else if(unit <= 200)
		{
			rate= 5.80;
		}
		else
		{
			rate= 6.50;
		}
	}
	else
	{
		rate= 6.05;
	}
	double total=unit*rate;
	System.out.println("\n Electricity Bill ");
        System.out.println("Customer: " + name);
        System.out.println("Units Consumed: " + unit);
        System.out.println("Rate per Unit: Rs. " + rate);
        System.out.println("Total Amount: Rs. " + total);
        
        sc.close();
    }
}
