import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class Test {
	public static void main(String[] args) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("dd-MM月 -yy", Locale.CHINA);
		String a="31-3月 -28";
		SimpleDateFormat sf1 = new SimpleDateFormat("yyyy-MM-dd");
		System.out.println(sf.parse(a));
		System.out.println(sf1.format(sf.parse(a)));
	}
}
