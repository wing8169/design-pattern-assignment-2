package contactmanagementsoftware;

import java.io.Serializable;

/**
 * ContactManagementSoftware is the entry point of the system
 */
public class ContactManagementSoftware implements Serializable {

    /**
     * main method for the system
     *
     * @param args extra arguments
     */
    public static void main(String[] args) {
        MUI mg = MUI.getInstance();
        mg.setVisible(true);
    }
}
