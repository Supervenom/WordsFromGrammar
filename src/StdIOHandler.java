import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class StdIOHandler implements IOHandler<String> {

	private BufferedReader reader;
	private PrintWriter writer;
	
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
	}

	@Override
	public int readNumber() throws IOException {
		return Integer.parseInt(reader.readLine());
	}
	
	

}
