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

		if (args.length == 2) {
			System.out.println("************************Output for Given Input***********************************");
			System.out.println(obj.isValidElementEntry(args[0], args[1]));
		}

	}

	public boolean isValidElementEntry(String element, String symbol) {
		boolean result = false;
		if (element.trim().length() == 0 || symbol.trim().length() == 0) {
			System.out.println("Element name or Symbol name can not be blank!! please enter values");
			result = false;
		} else if (!Pattern.matches("^[a-zA-Z]", element) || !Pattern.matches("^[a-zA-Z]", symbol)) {
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

}
