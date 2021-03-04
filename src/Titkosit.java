import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Titkosit {

	public static final char Kisbet�Eleje = 'a';
	public static final char Kisbet�V�ge = 'z';

	public static final char Nagybet�Eleje = 'A';
	public static final char Nagybet�V�ge = 'Z';

	public static final int ABCm�ret = 'Z' - 'A' + 1;

	public static void main(String[] args) throws IOException {
		

		String bemenet = "input.txt";
		int shift = 1;

		if (args.length == 1) {
			bemenet = args[0];
		} else if (args.length == 2) {
			shift = Integer.parseInt(args[1]);
		}

		String encrypted = titkos�t�s(bemenet, shift);

		System.out.println(encrypted);

	}

	public static String titkos�t�s(String bemenet, int shift) {
		String encrypted = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(bemenet))) {

			StringBuilder titkos�tott = new StringBuilder();
			String line = br.readLine();
			while (line != null) {

				for (int i = 0; i < line.length(); i++) {

					char input = line.charAt(i);
					char kezd�bet�;

					if (input >= Kisbet�Eleje && input <= Kisbet�V�ge) {
						kezd�bet� = Kisbet�Eleje;
					}

					else if (input >= Nagybet�Eleje && input <= Nagybet�V�ge) {
						kezd�bet� = Nagybet�Eleje;
					} else {
						titkos�tott.append(input);
						continue;
					}

					int inputKarakterIndex = input - kezd�bet�;

					int outputKarakterIndex = (inputKarakterIndex + shift) % ABCm�ret;

					char titkosKarakter = (char) (outputKarakterIndex + kezd�bet�);

					titkos�tott.append(titkosKarakter);
				}
				line=br.readLine();
				titkos�tott.append('\n');
			}

			encrypted = titkos�tott.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return encrypted;
	}

}
