package contactmanagementsoftware;

import javax.swing.*;
import java.util.ArrayList;

/**
 * GeneralFormProcess is the base class that validates the general form fields
 */
public class GeneralFormProcess implements FormProcessStrategy {

    TextChecker textChecker;
    Factory factory;
    private static GeneralFormProcess manager; // static instance for singleton design pattern

    public GeneralFormProcess() {
        textChecker = new TextChecker();
        factory = new AcquaintanceFactory();
    }

    /**
     * getInstance gets the instance and creates it if does not exist yet
     *
     * @return instance
     */
    public static GeneralFormProcess getInstance() {
        if (manager == null) {
            synchronized (MUI.class) {
                if (manager == null) // check again within synchronized block to guard for race condition
                    manager = new GeneralFormProcess();
            }
        }
        return manager;
    }

    @Override
    public boolean validateFormData(JFrame frame, JTextField name, JTextField mobile, JTextField email, JTextArea one,
                                    JTextArea two, JTextArea three, JTextArea four, ArrayList<ArrayList<Acquaintances>> acquaintances,
                                    int categoryIndex, int arrayListIndex, boolean isAdd) {
        String Name = name.getText();
        if (Name.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Enter a name");
            return false;
        }
        String Mobile = mobile.getText();
        if (!textChecker.validateMobileNo(Mobile)) {
            JOptionPane.showMessageDialog(frame, "Enter a valid mobile number (6-15 digits)");
            return false;
        }
        String Email = email.getText();
        if (!Email.contains("@")) {
            JOptionPane.showMessageDialog(frame, "Enter a valid email");
            return false;
        }
        return true;
    }
}
