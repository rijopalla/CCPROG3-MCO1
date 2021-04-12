public class Resource {
	//Behaviors
	private int resourceAmount = 0;
	
	//Methods
	public int addResource(int num) {
		this.resourceAmount += num;
		return this.resourceAmount;
	}
	
	public int subtractResource(int num) {
		this.resourceAmount -= num ;
		return this.resourceAmount;
	}
	
	public int getResourceAmount() {
		return this.resourceAmount;
	}
	
}
