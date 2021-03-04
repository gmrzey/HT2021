import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class Titkosit {

	public static final char KisbetûEleje = 'a';
	public static final char KisbetûVége = 'z';

	public static final char NagybetûEleje = 'A';
	public static final char NagybetûVége = 'Z';

	public static final int ABCméret = 'Z' - 'A' + 1;

	public static void main(String[] args) throws IOException {
		

		String bemenet = "input.txt";
		int shift = 1;

		if (args.length == 1) {
			bemenet = args[0];
		} else if (args.length == 2) {
			shift = Integer.parseInt(args[1]);
		}

		String encrypted = titkosítás(bemenet, shift);

		System.out.println(encrypted);

	}

	public static String titkosítás(String bemenet, int shift) {
		String encrypted = null;
		
		try (BufferedReader br = new BufferedReader(new FileReader(bemenet))) {

			StringBuilder titkosított = new StringBuilder();
			String line = br.readLine();
			while (line != null) {

				for (int i = 0; i < line.length(); i++) {

					char input = line.charAt(i);
					char kezdõbetû;

					if (input >= KisbetûEleje && input <= KisbetûVége) {
						kezdõbetû = KisbetûEleje;
					}

					else if (input >= NagybetûEleje && input <= NagybetûVége) {
						kezdõbetû = NagybetûEleje;
					} else {
						titkosított.append(input);
						continue;
					}

					int inputKarakterIndex = input - kezdõbetû;

					int outputKarakterIndex = (inputKarakterIndex + shift) % ABCméret;

					char titkosKarakter = (char) (outputKarakterIndex + kezdõbetû);

					titkosított.append(titkosKarakter);
				}
				line=br.readLine();
				titkosított.append('\n');
			}

			encrypted = titkosított.toString();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return encrypted;
	}

}
