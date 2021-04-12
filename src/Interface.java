import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;


public class Interface {

	public static <T> void main(String[] args) {
		ArrayList<String>SellerList= new ArrayList<String>();
		 SellerList.add("Seller1");
		 SellerList.add("Seller2");
		 SellerList.add("Seller3");
		 SellerList.add("Seller4");
		 SellerList.add("Seller5");
		 
		Sales sales = new Sales(SellerList);
		Date data = new Date();
		System.out.println(data);
		System.out.println();
		
		sales.Add("Seller3", "customer5", data, "lamen", 12.00);
		sales.Add("Seller2", "customer1", data, "lamen", 20.00);
		sales.Add("Seller2", "customer1", data, "soju", 50.00);
		sales.Add("Seller5", "customer5", data, "lamen", 12.00);

	    System.out.println("WELCOME TO YOUR SALES BY VIVI");
	    boolean saida=true;
	    while(saida !=false) {
		System.out.println("                                                         ");
		System.out.println("SELECT 1- Add new Sale item, 2- Edit Sale Item, 3- Remove Sale Item, 4- List Sales, 5- Order list by Sales, 0- Exit");		
		
		Scanner scanner = new Scanner(System.in);
        System.out.print("Digite um número inteiro: ");
        int option = scanner.nextInt();
        
        switch(option) {
        case 0:
        	saida= false;
        	break;
        case 1:
        	System.out.println("Enter with Seller Name:");
        	String sellername = scanner.next();
        	System.out.println("Enter with Customer Name:");
        	String customer = scanner.next();
        	Date date = new Date();
        	System.out.println("Enter with Item Name:");
        	String itemname = scanner.next();
        	System.out.println("Enter with Item Value: Ex: 35,99");
        	double itemvalue = scanner.nextDouble();
        	sales.Add(sellername, customer, date, itemname, itemvalue);
        	System.out.println("Sale registered!");
        	break;
        case 2:
        	System.out.println("Enter with Item Id that you want to update:");
        	int idUpdate = scanner.nextInt();
        	System.out.println("Enter with Seller Name:");
        	String newsellername = scanner.next();
        	System.out.println("Enter with Customer Name:");
        	String newcustomer = scanner.next();
        	Date newdate = new Date();
        	System.out.println("Enter with Item Name:");
        	String newitemname = scanner.next();
        	System.out.println("Enter with Item Value:");
        	double newitemvalue = scanner.nextDouble();
       
        	sales.editsaleitem(idUpdate,newsellername, newcustomer, newdate, newitemname, newitemvalue);
        	System.out.println("Sale Updated!");
        	break;
        	
        case 3:
        	System.out.println("Enter with Item Id that you want to delete:");
        	int id = scanner.nextInt();
        	sales.Remove(id);
        	System.out.println("Item Removed!");
        	break;
        case 4:
        	sales.getListItens();
        	break;
        case 5:
        	sales.ListOrderbySales();
        	break;
        default:
        	System.out.println("Option not available");
        	break;
        }
        
	}
		
	}
}
