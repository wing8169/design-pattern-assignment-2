package contactmanagementsoftware;

import javax.swing.*;
import java.util.ArrayList;

public class ProfessionalFormProcess extends GeneralFormProcess {

    private static ProfessionalFormProcess manager; // static instance for singleton design pattern

    /**
     * getInstance gets the instance and creates it if does not exist yet
     *
     * @return instance
     */
    public static ProfessionalFormProcess getInstance() {
        if (manager == null) {
            synchronized (MUI.class) {
                if (manager == null) // check again within synchronized block to guard for race condition
                    manager = new ProfessionalFormProcess();
            }
        }
        return manager;
    }

    @Override
    public boolean validateFormData(JFrame frame, JTextField name, JTextField mobile, JTextField email, JTextArea one,
                                    JTextArea two, JTextArea three, JTextArea four, ArrayList<ArrayList<Acquaintances>> acquaintances,
                                    int categoryIndex, int arrayListIndex, boolean isAdd) {
        boolean valid = super.validateFormData(frame, name, mobile, email, one, two, three, four, acquaintances, categoryIndex,
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
        String Four = four.getText();
        if (!Four.equalsIgnoreCase("y") && !Four.equalsIgnoreCase("n")) {
            JOptionPane.showMessageDialog(frame, "Enter Y or N");
            return false;
        }
        ProfessionalFriends proF;
        if (isAdd) {
            proF = (ProfessionalFriends) factory.createAcquaintance("ProfessionalFriends");
        } else {
            proF = (ProfessionalFriends) acquaintances.get(categoryIndex).get(arrayListIndex);
        }
        proF.setName(Name);
        proF.setMobileNo(Mobile);
        proF.setEmail(Email);
        proF.setCommonInterests(One);
        proF.setAnnoyingAbility(Four);
        if (isAdd) {
            acquaintances.get(categoryIndex).add(proF);
        }
        return true;
    }
}
