import java.io.FileWriter;
import java.io.IOException;

public class App {
	public static void main(String[] args) throws IOException {
		FileWriter fw;
		fw = new FileWriter("songque.txt");
		fw.write("Trong tù không rượu cũng không hoa.\n");
		fw.write("Cảnh đẹp đêm nay quá hững hờ.");
		fw.flush();
		fw.close();
	}
}
