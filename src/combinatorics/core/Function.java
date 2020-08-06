package combinatorics.core;

public class Function implements Printable {

	public FiniteSet domain;
	public String description = "";
	
	protected Function() {}
	
	public void setDomain(FiniteSet domain) {
		this.domain = domain;
	}

	public FiniteSet operate() {return null;}
	
	public void print() {
		System.out.println(this.description);
	}
}