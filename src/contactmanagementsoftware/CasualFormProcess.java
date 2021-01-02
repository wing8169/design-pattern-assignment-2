package contactmanagementsoftware;

import javax.swing.*;
import java.util.ArrayList;

public class CasualFormProcess extends GeneralFormProcess {

    private static CasualFormProcess manager; // static instance for singleton design pattern

    /**
     * getInstance gets the instance and creates it if does not exist yet
     *
     * @return instance
     */
    public static CasualFormProcess getInstance() {
        if (manager == null) {
            synchronized (MUI.class) {
                if (manager == null) // check again within synchronized block to guard for race condition
                    manager = new CasualFormProcess();
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
        if (!textChecker.validateNormalText(Three)) {
            JOptionPane.showMessageDialog(frame, "Enter a valid value ( 1 to 300 chars)");
            return false;
        }
        CasualAcquaintances ca;
        if (isAdd) {
            ca = (CasualAcquaintances) factory.createAcquaintance("CasualAcquaintances");
        } else {
            ca = (CasualAcquaintances) acquaintances.get(categoryIndex).get(arrayListIndex);
        }
        ca.setName(Name);
        ca.setMobileNo(Mobile);
        ca.setEmail(Email);
        ca.setWhenWhere(One);
        ca.setCircumstances(Two);
        ca.setOtherInfo(Three);
        ca.setAnnoyingAbility(new CantAnnoy());
        System.out.println(ca.tryToAnnoy());
        if (isAdd) {
            acquaintances.get(categoryIndex).add(ca);
        }
        return true;
    }
}
