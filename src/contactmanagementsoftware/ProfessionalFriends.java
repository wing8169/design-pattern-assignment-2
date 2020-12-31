package contactmanagementsoftware;

import java.io.Serializable;
import java.util.Scanner;

public class ProfessionalFriends extends Acquaintances implements Serializable {

    private String CommonInterests;

    ProfessionalFriends() {
    }

    public String getCommonInterests() {
        return CommonInterests;
    }

    public void setCommonInterests(String CommonInterests) {
        Scanner reader = new Scanner(System.in);
        if (!CommonInterests.isEmpty()) {
            this.CommonInterests = CommonInterests;
        } else {
            System.out.println("Enter atleast one character");
            setCommonInterests(reader.nextLine());
        }
    }

}
