package contactmanagementsoftware;

/**
 * TextChecker is the facade that contains checkers for the user input texts
 */
public class TextChecker {
    private Checker dateChecker, mobileNoChecker;

    /**
     * Initalize all checkers
     */
    public TextChecker() {
        dateChecker = new DateChecker();
        mobileNoChecker = new MobileNoChecker();
    }

    /**
     * validate date
     *
     * @param t date to validate
     * @return validation result
     */
    public boolean validateDate(String t) {
        return dateChecker.validate(t);
    }

    /**
     * validate mobile number
     *
     * @param t number to validate
     * @return validation result
     */
    public boolean validateMobileNo(String t) {
        return mobileNoChecker.validate(t);
    }
}
