import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class DocDuLieu {
	public static void main(String[] args) throws IOException {
		FileOutputStream fout = null;
		try {
			fout = new FileOutputStream("ViDu.clc");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("Không có file,xem lại.");
		}
			for (int i = 1; i < 127; i++) fout.write(i);	
			fout.flush();
			fout.close();
		System.out.println("Done");
			
	}
}
