package contactmanagementsoftware;

import java.io.Serializable;

public class Relatives extends Acquaintances implements Serializable {

    private String BDate;
    private String LDate;

    Relatives() {
        
    }

    public String getBDate() {
        return BDate;
    }

    public void setBDate(String BDate) {
        this.BDate = BDate;
    }

    public String getLDate() {
        return LDate;
    }

    public void setLDate(String LDate) {
        this.LDate = LDate;
    }
}
