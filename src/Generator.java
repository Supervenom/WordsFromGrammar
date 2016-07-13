import java.util.ArrayList;
import java.util.List;

public class Generator {

	private final Grammar grammar;
	private final List<String> words;
	private int actualDepth = 0;
	private int maxDepth;
	
	public Generator(Grammar grammar, int maxDepth) {
		this.grammar = grammar;
		words = new ArrayList<>();
		this.maxDepth = maxDepth;
	}
	
	public void generate() {
		generateProc(grammar.getAxiom());
		StdIOHandler handler = new StdIOHandler();
		handler.writeLine(toString());
	}
	
	private void generateProc(String word)
	{
		if (actualDepth > maxDepth) return;
		for (Rule r: grammar.getRules()) {
			if (r.isApplicable(word)) {
				String word2 = r.apply(word); 				//Here is the problem
				word2 = removeEpsilon(word2);            	//replace should be rewritten
				if (isAllTerminal(word2)) {     			//to subsitute not only all the
					words.add(word2);     					//occurrences
				}
				actualDepth = actualDepth +1;
				generateProc(word2);
				actualDepth = actualDepth-1;
			}
		}
	}
	
	private static String removeEpsilon(String word) {
		return word.replace("e", "");
	}
	
	private static boolean isAllTerminal(String word) {
		return word.equals(word.toLowerCase());
	}
	
	@Override
	public String toString() {
		String s = new String();
		s = "Words generated:";
		for (String w: words)
			s = s + "\n\t" + w;
		return s;
	}
}
