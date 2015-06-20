import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteObjects {

	public static void main(String args[]) {
		System.out.println("Writing objects...");

		Person mike = new Person(543, "Mike");
		Person sue = new Person(123, "Sue");

		System.out.println(mike);
		System.out.println(sue);

		// FileOutputStream is meant for writing streams of raw bytes such as
		// image data to a file

		// we use try with resources here. This will automatically close the
		// FileStream
		try (FileOutputStream fs = new FileOutputStream("people.bin")) {

			ObjectOutputStream os = new ObjectOutputStream(fs);
			
			os.writeObject(mike);
			os.writeObject(sue);
			
			os.close();
			
		} catch (FileNotFoundException e) {
			// can't create file
			e.printStackTrace();
		} catch (IOException e) {
			// can't write to file
			e.printStackTrace();
		}
	}
}
