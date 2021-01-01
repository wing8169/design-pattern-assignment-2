package contactmanagementsoftware;

import java.io.Serializable;

/**
 * CasualAcquaintances is the concrete class for casual acquaintances
 */
public class CasualAcquaintances extends Acquaintances implements Serializable {

    private String whenWhere;
    private String circumstances;
    private String otherInfo;

    /**
     * get when and where met the person
     *
     * @return when where
     */
    public String getWhenWhere() {
        return whenWhere;
    }

    /**
     * set when and where met the person
     *
     * @param whenWhere when and where
     */
    public void setWhenWhere(String whenWhere) {
        this.whenWhere = whenWhere;
    }

    /**
     * get circumstances meeting the person
     *
     * @return circumstances
     */
    public String getCircumstances() {
        return circumstances;
    }

    /**
     * set circumstances meeting the person
     *
     * @param circumstances circumstances
     */
    public void setCircumstances(String circumstances) {
        this.circumstances = circumstances;
    }

    /**
     * get other information
     *
     * @return other information
     */
    public String getOtherInfo() {
        return otherInfo;
    }

    /**
     * set other information
     *
     * @param otherInfo other information
     */
    public void setOtherInfo(String otherInfo) {
        this.otherInfo = otherInfo;
    }

}
