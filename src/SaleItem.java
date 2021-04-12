import java.util.Date;

public class SaleItem {
	private String SellerName;
	private String CustomerName;
	private Date DateSale;
	private String ItemName;
	private Double ItemValue;
	
	
	public SaleItem(String sellerName, String customerName, Date dateSale, String itemName, Double itemValue) {
		super();
		SellerName = sellerName;
		CustomerName = customerName;
		DateSale = dateSale;
		ItemName = itemName;
		ItemValue = itemValue;
	}
	public String getSellerName() {
		return SellerName;
	}
	public void setSellerName(String sellerName) {
		SellerName = sellerName;
	}
	public String getCustumerName() {
		return CustomerName;
	}
	public void setCustumerName(String custumerName) {
		CustomerName = custumerName;
	}
	public Date getDateSale() {
		return DateSale;
	}
	public void setDateSale(Date dateSale) {
		DateSale = dateSale;
	}
	public String getItemName() {
		return ItemName;
	}
	public void setItemName(String itemName) {
		ItemName = itemName;
	}
	public Double getItemValue() {
		return ItemValue;
	}
	public void setItemValue(Double itemValue) {
		ItemValue = itemValue;
	}
	@Override
	public String toString() {
		return "SaleItem [SellerName=" + SellerName + ", CustomerName=" + CustomerName + ", DateSale=" + DateSale
				+ ", ItemName=" + ItemName + ", ItemValue=" + ItemValue + "]";
	}
	
	
}
