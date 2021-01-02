package contactmanagementsoftware;

import javax.swing.*;
import java.util.ArrayList;

public class RelativeFormProcess extends GeneralFormProcess {

    private static RelativeFormProcess manager; // static instance for singleton design pattern

    /**
     * getInstance gets the instance and creates it if does not exist yet
     *
     * @return instance
     */
    public static RelativeFormProcess getInstance() {
        if (manager == null) {
            synchronized (MUI.class) {
                if (manager == null) // check again within synchronized block to guard for race condition
                    manager = new RelativeFormProcess();
            }
        }
        return manager;
    }

    @Override
    public boolean validateFormData(JFrame frame, JTextField name, JTextField mobile, JTextField email, JTextArea one,
                                    JTextArea two, JTextArea three, ArrayList<ArrayList<Acquaintances>> acquaintances,
                                    int categoryIndex, int arrayListIndex, boolean isAdd) {
        boolean valid = super.validateFormData(frame, name, mobile, email, one, two, three, acquaintances, categoryIndex,
                arrayListIndex, isAdd);
        if (!valid) return false;
        String Name = name.getText();
        String Mobile = mobile.getText();
        String Email = email.getText();
        String One = one.getText();
        if (!textChecker.validateDate(One)) {
            JOptionPane.showMessageDialog(frame, "Enter a valid date");
            return false;
        }
        String Two = two.getText();
        if (!textChecker.validateDate(Two)) {
            JOptionPane.showMessageDialog(frame, "Enter a valid date");
            return false;
        }
        Relatives rel;
        if (isAdd) {
            rel = (Relatives) factory.createAcquaintance("Relatives");
        } else {
            rel = (Relatives) acquaintances.get(categoryIndex).get(arrayListIndex);
        }
        rel.setName(Name);
        rel.setMobileNo(Mobile);
        rel.setEmail(Email);
        rel.setBDate(One);
        rel.setLDate(Two);
        rel.setAnnoyingAbility(new CanAnnoy());
        System.out.println(rel.tryToAnnoy());
        if (isAdd) {
            acquaintances.get(categoryIndex).add(rel);
        }
        return true;
    }
}
