package app.domain.model;

public class Order {
	  private long orderNumber;
	    private int itemNumber;
	    private double cost;
		public long getOrderNumber() {
			return orderNumber;
		}
		public void setOrderNumber(long orderNumber) {
			this.orderNumber = orderNumber;
		}
		public int getItemNumber() {
			return itemNumber;
		}
		public void setItemNumber(int itemNumber) {
			this.itemNumber = itemNumber;
		}
		public double getCost() {
			return cost;
		}
		public void setCost(double cost) {
			this.cost = cost;
		}
	    
	    
}
