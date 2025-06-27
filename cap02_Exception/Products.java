package cap02_Exception;

public class Products {
	
	// Variaveis
	private Integer quantity;
	private Double price;
	private String name;
	
	
	//Constructor
	public Products() {};
	
	
	public Products(Integer quantity, Double price, String name) {
		
		this.quantity = quantity;
		this.price = price;
		this.name = name;
	}

	// Getter and setters
	public Integer getQuantity() {
		return quantity;
	}


	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}


	public Double getPrice() {
		return price;
	}


	public void setPrice(Double price) {
		this.price = price;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public double total() {
		return price * quantity;
	}
	
	

}
