package contactmanagementsoftware;

/**
 * TextChecker is the facade that contains checkers for the user input texts
 */
public class TextChecker {
    private Checker dateChecker, mobileNoChecker, normalTextChecker;

    /**
     * Initalize all checkers
     */
    public TextChecker() {
        dateChecker = new DateChecker();
        mobileNoChecker = new MobileNoChecker();
        normalTextChecker = new NormalTextChecker();
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

    /**
     * validate mobile number
     *
     * @param t number to validate
     * @return validation result
     */
    public boolean validateNormalText(String t) {
        return normalTextChecker.validate(t);
    }
}
