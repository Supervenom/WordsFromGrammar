import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class StdIOHandler implements IOHandler<String> {

	private final BufferedReader reader;
	private final PrintWriter writer;
	
	public StdIOHandler() {
		reader = new BufferedReader(new InputStreamReader(System.in));
		writer = new PrintWriter(System.out);
	}
	
	@Override
	public String readLine() throws IOException {
		return reader.readLine();
	}

	@Override
	public void writeLine(String t) {
		writer.println(t);
		writer.flush();
	}

	@Override
	public int readNumber() throws IOException {
		return Integer.parseInt(reader.readLine());
	}
	
}
