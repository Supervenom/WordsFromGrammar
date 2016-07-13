import java.io.IOException;

public interface IOHandler<T> {

	T readLine() throws IOException;
	
	void writeLine(T t);
	
	int readNumber() throws IOException;
}




