package combinatorics.core;

import combinatorics.core.elements.*;

public class Operation implements Printable{
	private String description = "This is the base Operation description.  It's not very interesting.";
	protected ElementTyper elementTyper = new ElementTyper();
	
	public CombinatorialSet operateSet(CombinatorialSet set) {	
		
		CombinatorialSet result = new CombinatorialSet();
		if (set.size() > 0) {	
			for (int i = 0; i < set.size(); i++) {
				Element elementOutput = null;
				elementOutput = operation(set.get(i));
				if (elementOutput != null){
					result.add(elementOutput);
				}
			}
		}
		if (set.size() == 0){
			System.out.println("Set is empty");
		}
		return result;
	}
	
	public Element operation(Element dummy) {return null;}
	
	//Overridden description getter
	protected String getDescription() {
		return "";
	}
	
	public void print() {
		System.out.println(this.description);
	}
}

