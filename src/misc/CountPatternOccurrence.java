package misc;

public class CountPatternOccurrence {
	public static void main(String[] args) {
		String str = "AGCATGCTGCAGTCATGCTTAGGCTA";
		String pat = "GCT";
		System.out.println(countPatternOccurrence(str, pat));
	}

	static int countPatternOccurrence(String str, String pat) {
		int i = 0, j = 0;
		int strLength = str.length();
		int patLength = pat.length();
		int count = 0;
		while (i < strLength) {
			if (str.charAt(i) == pat.charAt(j)) {
				i++;
				j++;
				if (j == patLength) {
					j = 0;
					count++;
				}
				continue;
			}
			j = 0;
			if (str.charAt(i) == pat.charAt(j)) {
				j++;
			}
			i++;
		}
		return count;
	}
}
