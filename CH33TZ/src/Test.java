import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Test {

	public static void main(String[] args) {
		
		/*   Spanish numbers regular expression 
		 *   
		 *   +0044626662626
		 *   +0044652 65 65 65
		 *   +0044652 656 565
		 *   + 0044652652652
		 *   + 0044652 652 652
		 *   + 0044652 65 62 65
		 *   + 0044 652652652
		 *   + 0044 652 652 652
		 *   + 0044 652 65 62 65
		 *   + 00 44652652652
		 *   + 00 44652 652 652
		 *   + 00 44652 65 62 65
		 *   + 00 44 652652652
		 *   + 00 44 652 652 652
		 *   + 00 44 652 65 62 65
		 *   652652652
		 *   652 65 65 65
		 *   655 655 655
		 *   
		 */
		
//		String phoneRegex = "(^(\\+\\s?([0]{2})\\s?([0-9]{2})\\s?)?([6-7]{1}[0-9]{2}){1}(\\s([0-9]{3}\\s?[0-9]{3}|[0-9]{2}\\s?[0-9]{2}\\s?[0-9]{2})|([0-9]){6})$)";
//		Pattern pattern = Pattern.compile(phoneRegex);
//		Matcher matcher = pattern.matcher("652652652");
//		String otherRegex = "^[\\w\\d\\\\\\^\\$\\.\\|\\?\\*\\+\\(\\)\\[\\{\\}\\]\\/\\-!'·%&=¿`´Çç_.;:,]+@[\\w\\d\\.\\-]+\\.[a-z]{2,3}$";
//		pattern = Pattern.compile(otherRegex);
//		matcher = pattern.matcher("d.d.d.dgmail.com");
		String passwordRegex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#\\$%\\^&\\*])(?=\\S+$)(.{8,})";
		Pattern pattern = Pattern.compile(passwordRegex);
		Matcher matcher = pattern.matcher("Mirda!!!!900");
		System.out.println(matcher.matches());
		
		
	}

}
