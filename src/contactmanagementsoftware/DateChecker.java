package contactmanagementsoftware;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author ritz619
 */
public class DateChecker {
    /**
     * validateDate validates if the date is valid
     *
     * @param Date date
     * @return date validation
     */
    public static boolean validateDate(String Date) {
        String pattern = "[0-3][0-9]/[0-1][0-9]/[0-9]{4}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(Date);
        return m.find();
    }
}
