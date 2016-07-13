import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static int rec = 0;
	
	public static void main(String[] args) throws IOException {
		Grammar grammar = new Grammar();
		Generator generator = new Generator(grammar);
	}

	private static boolean is_all_terminal (String word)
	
	{
		String low = new String();
		low = word.toLowerCase();
		return word.equals(low);
	}
	
	
	private static void generate(String word, String[][] rules, int n)
	{
		int i;
		String word2 = new String();
		if (rec>10) return;
		for (i=0; i<n; i++) {
			word2 = word;
			if (word.contains(rules[i][0])) {
				word2 = word2.replace(rules[i][0], rules[i][1]); //Here is the problem
				word2 = remove_epsilon(word2);            //replace should be rewritten
				if (is_all_terminal(word2)) {     //to subsitute not only all the
					System.out.println(word2 + "\n");     //occurrences
				}
				rec = rec +1;
				generate(word2, rules, n);
				rec = rec-1;
			}
		}
		return;
	}
	
	
}
