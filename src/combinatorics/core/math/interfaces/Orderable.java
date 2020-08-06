package combinatorics.core.math.interfaces;

public interface Orderable{

	public boolean isGreaterThan(Orderable other);
	public Orderable min(Orderable other);
	public Orderable max(Orderable other);
	
}
