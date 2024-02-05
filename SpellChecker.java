import javax.print.DocFlavor.STRING;

public class SpellChecker {

	public static void main(String[] args) {
		String word = args[0];
		int threshold = Integer.parseInt(args[1]);
		String[] dictionary = readDictionary("dictionary.txt");
		String correction = spellChecker(word, threshold, dictionary);
		System.out.println(correction);
	}

	public static String tail(String str) {
		str = str.substring(1, str.length());
		return str;
	}

	public static int levenshtein(String word1, String word2) {
		word1 = word1.toLowerCase();
		word2 = word2.toLowerCase();
		if (word1.length() == 0) {
			return word2.length();
		}
		if (word2.length() == 0) {
			return word1.length();
		}

		if (word1.charAt(0) == word2.charAt(0)) {
			levenshtein(tail(word1), tail(word2));
		} else {
			return 1 + (Math.min(Math.min(levenshtein(tail(word1), word2), levenshtein(word1, tail(word2))),
					levenshtein(tail(word1), tail(word2))));
		}
		return 0;

	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++) {
			dictionary[i] = in.readString();
		}
		return dictionary;

	}

	public static String spellChecker(String word, int threshold, String[] dictionary) {
		// Your code goes here
		return null;
	}

}
