import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

// Good for implementing a "saving" feature
public class ReadObjects {

	public static void main(String args[]) {
		System.out.println("Reading objects...");

		try (FileInputStream fi = new FileInputStream("people.bin")) {

			ObjectInputStream is = new ObjectInputStream(fi);

			Person person1 = (Person) is.readObject();
			Person person2 = (Person) is.readObject();

			is.close();
			
			System.out.println(person1);
			System.out.println(person2);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
}
