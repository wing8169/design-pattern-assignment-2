package contactmanagementsoftware;

import java.io.Serializable;

/**
 * Relatives is the concrete class for relatives
 */
public class Relatives extends Acquaintances implements Serializable {

    private String bDate;
    private String lDate;

    /**
     * get birthday
     *
     * @return birthday
     */
    public String getBDate() {
        return bDate;
    }

    /**
     * set birthday
     *
     * @param bDate birthday
     */
    public void setBDate(String bDate) {
        this.bDate = bDate;
    }

    /**
     * get last meet date
     *
     * @return last meet date
     */
    public String getLDate() {
        return lDate;
    }

    /**
     * set last meet date
     *
     * @param lDate last meet date
     */
    public void setLDate(String lDate) {
        this.lDate = lDate;
    }
}
