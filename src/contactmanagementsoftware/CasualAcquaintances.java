package contactmanagementsoftware;

import java.io.Serializable;
import java.util.Scanner;

public class CasualAcquaintances extends Acquaintances implements Serializable {

    private String WhenWhere;
    private String Circumstances;
    private String OtherInfo;

    CasualAcquaintances() {
    }

    public String getWhenWhere() {
        return WhenWhere;
    }

    public void setWhenWhere(String WhenWhere) {
        Scanner reader = new Scanner(System.in);
        if (!WhenWhere.isEmpty()) {
            this.WhenWhere = WhenWhere;
        } else {
            System.out.println("Enter atleast one character");
            setWhenWhere(reader.nextLine());
        }
    }

    public String getCircumstances() {
        return Circumstances;
    }

    public void setCircumstances(String Circumstances) {
        Scanner reader = new Scanner(System.in);
        if (!Circumstances.isEmpty()) {
            this.Circumstances = Circumstances;
        } else {
            System.out.println("Enter atleast one character");
            setCircumstances(reader.nextLine());
        }
    }

    public String getOtherInfo() {
        return OtherInfo;
    }

    public void setOtherInfo(String OtherInfo) {
        Scanner reader = new Scanner(System.in);
        if (!OtherInfo.isEmpty()) {
            this.OtherInfo = OtherInfo;
        } else {
            System.out.println("Enter atleast one character");
            setOtherInfo(reader.nextLine());
        }
    }

}
