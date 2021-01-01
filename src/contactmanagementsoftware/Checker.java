package contactmanagementsoftware;

/**
 * Checker validates the texts entered by the user
 */
public interface Checker {
    /**
     * validate string
     *
     * @param t string to validate
     * @return validation result
     */
    boolean validate(String t);
}
