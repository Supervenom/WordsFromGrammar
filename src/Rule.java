
public class Rule {

	private final String left;
	private final String right;
	
	public Rule (String left, String right) {
		this.left = left;
		this.right = right;
	}
	
	@Override
	public String toString() {
		return left + " -> " + right;
	}
	
}
