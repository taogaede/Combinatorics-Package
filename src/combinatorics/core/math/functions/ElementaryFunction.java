package combinatorics.core.math.functions;

import combinatorics.core.elements.Element;
import combinatorics.core.math.sets.FiniteSet;

public class ElementaryFunction extends Function{
	
	protected ElementaryFunction() {}
	
	public FiniteSet operate() {	
		FiniteSet result = new FiniteSet();
		if (domain.size() > 0) {	
			for (int i = 0; i < domain.size(); i++) {
				Element elementOutput = null;
				elementOutput = operation(domain.get(i));
				if (elementOutput != null){
					result.add(elementOutput);
				}
			}
		}
		if (domain.size() == 0){
			System.out.println("Set is empty");
		}
		return result;
	}
	
	protected Element operation(Element input) {return null;}
}
