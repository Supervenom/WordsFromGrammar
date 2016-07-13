import java.io.IOException;

public class Main {
	
	public static void main(String[] args) throws IOException {
		int depth = 10;
		Grammar grammar = new Grammar();
		Generator generator = new Generator(grammar, depth);
		generator.generate();
	}
	
}
