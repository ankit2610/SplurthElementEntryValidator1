import java.util.LinkedHashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PlanetSplurthElementValidator {

	public static final int SYMBOL_LENGTH = 2;

	public static void main(String[] args) {
		PlanetSplurthElementValidator obj = new PlanetSplurthElementValidator();
		System.out.println("************************Start Sample Outputs***********************************");
		System.out.println(obj.isValidElementEntry("Spenglerium", "Ee"));
		System.out.println(obj.isValidElementEntry("Zeddemorium", "Zr"));
		System.out.println(obj.isValidElementEntry("Venkmine", "Kn"));
		System.out.println(obj.isValidElementEntry("Stantzon", "Zt"));
		System.out.println(obj.isValidElementEntry("Melintzum", "Nn"));
		System.out.println(obj.isValidElementEntry("Tullium", "Ty"));
		System.out.println("************************End Sample Outputs***********************************");
		System.out.println(obj.getFirstAlphabeticalSymbol("Slimyrin"));

		if (args.length == 2) {
			System.out.println("************************Output for Given Input***********************************");
			System.out.println(obj.isValidElementEntry(args[0], args[1]));
		}

	}

	/*
	 * this method validates whether the entered symbol follows the rule with
	 * the element name
	 */
	public boolean isValidElementEntry(String element, String symbol) {
		boolean result = false;
		if (element.trim().length() == 0 || symbol.trim().length() == 0) {
			System.out.println("Element name or Symbol name can not be blank!! please enter values");
			result = false;
		} else if (!Pattern.matches("[A-Za-z]+", element) || !Pattern.matches("[A-Za-z]+", symbol)) {
			System.out.println("Element name or Symbol name can contains only letters (a to z and A-Z) ");
			result = false;

		} else if (symbol.trim().length() != SYMBOL_LENGTH) {
			System.out.println("Symbol name should be of exact two letters!!");
			result = false;
		} else {
			String regEx = "^[a-z]*" + symbol.toLowerCase().charAt(0) + "[a-z]*" + symbol.toLowerCase().charAt(1)
					+ "[a-z]*";
			Pattern pattern = Pattern.compile(regEx);

			Matcher matcher = pattern.matcher(element.toLowerCase());
			result = matcher.matches();
			if (!result)
				System.out.println("'" + symbol + "'" + " is Not a valid symbol for " + "'" + element + "'");
			else {
				System.out.println("'" + symbol + "'" + " is a valid symbol for " + "'" + element + "'");

			}
		}
		return result;
	}

	/*
	 * this method return a Symbol with first Alphabetical order
	 */

	String getFirstAlphabeticalSymbol(String element) {
		element = element.toLowerCase();
		char firstChar = element.charAt(0);
		for (int i = 1; i < element.length() - 1; i++) {
			if (element.charAt(i) < firstChar)
				firstChar = element.charAt(i);
		}
		char secondChar = element.charAt(element.indexOf(firstChar) + 1);

		for (int i = element.indexOf(firstChar) + 1; i < element.length(); i++) {
			if (element.charAt(i) < secondChar)
				secondChar = element.charAt(i);
		}

		return String.valueOf(firstChar).toUpperCase() + String.valueOf(secondChar);
	}

}
