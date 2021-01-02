package contactmanagementsoftware;

import javax.swing.*;
import java.util.ArrayList;

public class PersonalFormProcess extends GeneralFormProcess {

    private static PersonalFormProcess manager; // static instance for singleton design pattern

    /**
     * getInstance gets the instance and creates it if does not exist yet
     *
     * @return instance
     */
    public static PersonalFormProcess getInstance() {
        if (manager == null) {
            synchronized (MUI.class) {
                if (manager == null) // check again within synchronized block to guard for race condition
                    manager = new PersonalFormProcess();
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
        if (!textChecker.validateNormalText(One)) {
            JOptionPane.showMessageDialog(frame, "Enter a valid value ( 1 to 300 chars)");
            return false;
        }
        String Two = two.getText();
        if (!textChecker.validateNormalText(Two)) {
            JOptionPane.showMessageDialog(frame, "Enter a valid value ( 1 to 300 chars)");
            return false;
        }
        String Three = three.getText();
        if (!textChecker.validateDate(Three)) {
            JOptionPane.showMessageDialog(frame, "Enter a valid date");
            return false;
        }
        PersonalFriends personalF;
        if (isAdd) {
            personalF = (PersonalFriends) factory.createAcquaintance("PersonalFriends");
        } else {
            personalF = (PersonalFriends) acquaintances.get(categoryIndex).get(arrayListIndex);
        }
        personalF.setName(Name);
        personalF.setMobileNo(Mobile);
        personalF.setEmail(Email);
        personalF.setEvents(One);
        personalF.setAContext(Two);
        personalF.setADate(Three);
        personalF.setAnnoyingAbility(new CantAnnoy());
        System.out.println(personalF.tryToAnnoy());
        if (isAdd) {
            acquaintances.get(categoryIndex).add(personalF);
        }
        return true;
    }
}
