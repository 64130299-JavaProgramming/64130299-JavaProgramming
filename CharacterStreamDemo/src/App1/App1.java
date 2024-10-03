package App1;

import java.io.FileReader;
import java.io.IOException;

public class App1 {
	public static void main(String[] args) throws IOException {
		FileReader fr = new FileReader("songque.txt");
		char [] buff = new char[10];
		fr.read(buff);
		fr.close();
		for(int i = 0;i<10;i++) {
			System.out.print(buff[i]);
		}
		System.out.print(String.valueOf(buff));
	}
}
