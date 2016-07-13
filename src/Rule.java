
public class Rule {

	private final String left;
	private final String right;
	
	public Rule (String left, String right) {
		this.left = left;
		this.right = right;
	}
	
	public boolean isApplicable(String word) {
		return word.contains(left);
	}
	
	public String apply (String word) {
		return word.replace(left, right);
	}
	
	
	@Override
	public String toString() {
		return left + " -> " + right;
	}
	
}
