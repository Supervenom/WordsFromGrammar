import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Grammar {

	private final List<Rule> rules;
	private final String axiom;
	
	public Grammar() throws IOException {
		StdIOHandler handler = new StdIOHandler();
		handler.writeLine("Enter the axiom");
		axiom = handler.readLine();
		handler.writeLine("Enter the number of rules");
		int n = handler.readNumber();
		rules = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			handler.writeLine("Enter left side of rule " + (i+1) + "\n");
			String left = handler.readLine();
			handler.writeLine("Enter right side of rule " + (i+1) + "\n");
			String right = handler.readLine();
			rules.add(new Rule(left, right));
		}
		handler.writeLine(toString());
	}
	
	/**
	 * @return the rules
	 */
	public List<Rule> getRules() {
		return new ArrayList<>(rules);
	}

	/**
	 * @return the axiom
	 */
	public String getAxiom() {
		return axiom;
	}

	@Override
	public String toString() {
		String s = new String();
		s = "Grammar:\n\tAxiom: " + axiom +
				"\n\tRules:";
		for (Rule r: rules)
			s = s + "\n\t\t" + r;
		return s;
	}
	
}
