import java.util.ArrayList;
import java.util.List;

public class Generator {

	private final Grammar grammar;
	private final List<String> words;
	private static int rec = 0;
	
	public Generator(Grammar grammar) {
		this.grammar = grammar;
		words = new ArrayList<>();
	}
	
	public void generate(int depth) {
		
	}
	
	private String removeEpsilon(String word) {
		return word.replace("e", "");
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
