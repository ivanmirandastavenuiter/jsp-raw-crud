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
		String injectionRegex = "((<[^>]*(>|$))|(&lt;?(?!&gt;?)(.*(&gt;?){1}|.*$))|(&#0*60(?!&#0*62)(.*(&#0*62){1}|.*$))|(&#x0*3c(?!&#x0*3e)(.*(&#x0*3e){1}|.*$)))";
		Pattern pattern = Pattern.compile(injectionRegex);
		
		Matcher matcher = pattern.matcher("&lt;script&gt;console.log('tumadre')&lt;/script&gt;");
		System.out.println("Scripts con &lt; y &gt;: " + matcher.find());
		matcher = pattern.matcher("&ltscript&gtconsole.log('tumadre')&lt/script&gt");
		System.out.println("Scripts con &lt y &gt: " + matcher.find());
		matcher = pattern.matcher("&#60script&#62console.log('tumadre')&#60/script&#62");
		System.out.println("Scripts con &#60 y &#62: " + matcher.find());
		matcher = pattern.matcher("&#xcscript&#x3onsole.log('tumadre')&#x3/script&#x3");
		System.out.println("Scripts con &#x3c y &#x3e: " + matcher.find());
		matcher = pattern.matcher("&#000060script&#0062console.log('tumadre')&#0060/script&#0062");
		System.out.println("Scripts con overflow de 0 en &#60 y &#62: " + matcher.find());
		matcher = pattern.matcher("&#x000003cscript&#x0003econsole.log('tumadre')&#x000003c/script&#x0000003e");
		System.out.println("Scripts con overflow de 0 en &#x3c y &#x3e: " + matcher.find());
		matcher = pattern.matcher("<script>console.log('tumadre')</script>");
		System.out.println("Scripts con < y >: " + matcher.find());
		matcher = pattern.matcher("wareber");
		System.out.println("Scripts sin nada: " + matcher.find());
		
		String script = "<script>console.log('tumadre')</script>";
		script = script.replaceAll("<", "");
		System.out.println(script);
		script = script.replaceAll(">", "");
		System.out.println(script);
		System.out.println("&#dsadsa".substring(0, 2));
		
	}

}
