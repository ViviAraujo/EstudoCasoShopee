import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Sales {

  List<SaleItem> listItens;
  List<String>SellerList;

	public Sales(ArrayList<String> sellername) {
		this.listItens = new ArrayList<SaleItem>();
		this.SellerList = sellername;

	}
	
	public void Add(String sellerName, String customerName, Date dateSale, String itemName, Double itemValue) {	
		boolean containSeller= false;
		for (int i=0; i<SellerList.size(); i++) {
			if (SellerList.get(i).startsWith(sellerName)){
				containSeller= true;
			}
		}
		if (containSeller == true){
			SaleItem item = new SaleItem(sellerName, customerName,dateSale,itemName,itemValue);
			boolean resultado= listItens.contains(item);
			if(resultado==false){	
				listItens.add(item);
			}
		}else {
			System.out.println("Seller not available");
		}
	}
	
	public void editsaleitem(int id, String newsellerName, String newcustomerName, Date newdateSale, String newitemName, Double newitemValue){
		listItens.get(id).setCustumerName(newcustomerName);
		listItens.get(id).setDateSale(newdateSale);
		listItens.get(id).setItemName(newitemName);
		listItens.get(id).setItemValue(newitemValue);
		listItens.get(id).setSellerName(newsellerName);
			
	}
	
	public SaleItem Search(int id) {
		SaleItem item = listItens.get(id);
		return item;
	}
	
	public void Remove(int id) {
		SaleItem item = Search(id);
		boolean resultado= listItens.contains(item);
		if(resultado==true){	
			listItens.remove(item);
		}	
	}
	
	public void getListItens() {
		for(int i=0; i< listItens.size(); i++ ) {
				System.out.println("ID:"+ i + " " + listItens.get(i));
		}
	}

	public List<SaleItem> list() {
		return listItens;
	}
	
	public void setListItens(List<SaleItem> listItens) {
		this.listItens = listItens;
	}
	
	@Override
	public String toString() {
		return "Sales [listItens=" + listItens.toString() + "]";
	}

	public ArrayList<String> compareSales() {
		ArrayList<String> orderbysales = new ArrayList<String>();
		List<String> sellerlist = selleravaliable();
		int max=0;
		String name="";
		while (sellerlist.size()>0) {
			for(int i=0; i<sellerlist.size();i++) {
				if (TotalSalesForEachSeller(sellerlist.get(i))>max) {
					max = TotalSalesForEachSeller(sellerlist.get(i));
					name = sellerlist.get(i);
				}
			}
			orderbysales.add(name);
			sellerlist.remove(name);
			max=0;
			name="";
		}
		return orderbysales;
	}
	
	public int TotalSalesForEachSeller(String sellername) {
		int total= 0;
		for( int i=0; i<listItens.size();i++) {
			if (listItens.get(i).getSellerName()==sellername) {
				total++;
			}
		}
		return total;
	}

	public void ListOrderbySales() {
		ArrayList<String> listsales = compareSales();
		for( int j=0; j < listsales.size();j++) {
			for(int i=0; i< listItens.size(); i++ ) {
				if (listItens.get(i).getSellerName().startsWith(listsales.get(j))) {
					System.out.println("ID:"+ i + " " + listItens.get(i));
				}
			}
		}
		
}
	
	public List<String> selleravaliable() {
		List<String> sellers= new ArrayList<String>();
		listItens.forEach(item ->{
			if(sellers.contains(item.getSellerName())==false) {
				sellers.add(item.getSellerName());	
			}});
		return sellers;
	}
	
}
