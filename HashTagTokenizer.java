
public class HashTagTokenizer {

	public static void main(String[] args) {

		String hashTag = args[1];
		String[] dictionary = readDictionary("dictionary.txt");
		breakHashTag(hashTag, dictionary);
	}

	public static String[] readDictionary(String fileName) {
		String[] dictionary = new String[3000];
		In in = new In(fileName);
		for (int i = 0; i < dictionary.length; i++) {
			dictionary[i] = in.readString();
		}
		return dictionary;
	}

	public static boolean existInDictionary(String word, String[] dictionary) {
		for (int i = 0; i < dictionary.length; i++) {
			if (word.equals(dictionary[i])) {
				return true;
			}
		}
		return false;
	}

	public static void breakHashTag(String hashtag, String[] dictionary) {
		hashtag = hashtag.toLowerCase();
		// Base case: do nothing (return) if hashtag is an empty string.
		if (hashtag.isEmpty()) {
			return;
		}

		int N = hashtag.length();
		for (int i = 0; i <= N; i++) { // change to 0 from 1 the i
			// #feedback - you should check if the substring(0,i) exists in the dictionary, and if so, print it and call breakHashTag again.
			if (existInDictionary(hashtag.substring(i, N), dictionary)) {
				breakHashTag(hashtag.substring(0, i), dictionary);
				System.out.println(hashtag.substring(i, N));
				return;

			}
		}

	}
}
