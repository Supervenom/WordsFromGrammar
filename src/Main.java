import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 */

/**
 * @author vanoni
 *
 */
public class Main {

	/**
	 * @param args
	 */
	static int rec = 0;
	
	public static void main(String[] args) {
		int i;
		int n;
		String temp = new String();
		String axiom = new String();
		
		BufferedReader br = new BufferedReader(
                new InputStreamReader(System.in));
		
		System.out.println("Enter the axiom");
		
		try {
			axiom = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Enter the number of rules");
		
		try {
			temp = br.readLine();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		n = Integer.parseInt(temp);  
		String[][] rules;
		rules = new String[n][2];
		for (i=0; i<n; i++) {
			System.out.println("Enter left side of rule " + (i+1) + "\n");
			try {
				rules[i][0] = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Enter right side of rule " + (i+1) + "\n");
			try {
				rules[i][1] = br.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		print_rules(rules, n);
		
		generate(axiom, rules, n);

	}

	private static boolean is_all_terminal (String word)
	
	{
		String low = new String();
		low = word.toLowerCase();
		return word.equals(low);
	}
	
	private static void print_rules(String[][] rules, int n)
	{
		int i;
		for (i=0; i<n; i++) {
			System.out.println(rules[i][0] + "\t->\t" + rules[i][1] + "\n");
		}
	}
	
	private static void generate(String word, String[][] rules, int n)
	{
		int i;
		String word2 = new String();
		if (rec>10) return;
		for (i=0; i<n; i++) {
			word2 = word;
			if (word.contains(rules[i][0])) {
				word2=word2.replace(rules[i][0], rules[i][1]);
				if (is_all_terminal(word2)) {
					System.out.println(word2 + "\n");
				}
				rec = rec +1;
				System.out.println(word2 + "\n");
				generate(word2, rules, n);
				rec = rec-1;
			}
		}
		return;
	}
}
