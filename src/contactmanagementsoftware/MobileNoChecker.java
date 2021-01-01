package contactmanagementsoftware;

/**
 * @author ritz619
 * MobileNoCheck validate the mobile number
 */
public class MobileNoChecker implements Checker {
    @Override
    public boolean validate(String str) {
        if (str.isEmpty() || str.length() < 6 || str.length() > 15) {
            return false;
        }
        for (char s : str.toCharArray()) {
            if (!Character.isDigit(s)) return false;
        }
        return true;
    }
}
