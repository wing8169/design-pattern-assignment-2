package contactmanagementsoftware;

import java.io.Serializable;

/**
 * ProfessionalFriends is the concrete class for professional friend
 */
public class ProfessionalFriends extends Acquaintances implements Serializable {

    private String commonInterests;

    /**
     * get common interests
     *
     * @return common interests
     */
    public String getCommonInterests() {
        return commonInterests;
    }

    /**
     * set common interests
     *
     * @param commonInterests common interests
     */
    public void setCommonInterests(String commonInterests) {
        this.commonInterests = commonInterests;
    }

}
