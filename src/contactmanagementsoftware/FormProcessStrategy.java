package contactmanagementsoftware;

import javax.swing.*;
import java.util.ArrayList;

/**
 * FormProcessStrategy defines the validation process and adds the created instance into local states.
 */
public interface FormProcessStrategy {
    /**
     * validate form and add into acquaintances if passed
     *
     * @param frame          JFrame
     * @param name           name
     * @param mobile         mobile number
     * @param email          email
     * @param one            dynamic field one
     * @param two            dynamic field two
     * @param three          dynamic field three
     * @param acquaintances  acquaintances
     * @param categoryIndex  category index
     * @param arrayListIndex arrayList index
     * @param isAdd          checks if the form is add or edit
     * @return if the data is valid
     */
    boolean validateFormData(JFrame frame, JTextField name, JTextField mobile, JTextField email, JTextArea one,
                             JTextArea two, JTextArea three, ArrayList<ArrayList<Acquaintances>> acquaintances,
                             int categoryIndex, int arrayListIndex, boolean isAdd);
}
