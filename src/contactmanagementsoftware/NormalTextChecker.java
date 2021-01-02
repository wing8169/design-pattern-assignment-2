package contactmanagementsoftware;

/**
 * @author ritz619
 * NormalTextChecker is the normal checker for text input.
 */
public class NormalTextChecker implements Checker {
    @Override
    public boolean validate(String txt) {
        return !txt.isEmpty() && txt.length() <= 300;
    }
}
