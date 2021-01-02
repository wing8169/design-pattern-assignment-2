package contactmanagementsoftware;

import java.io.Serializable;

/**
 * Acquaintances is the base abstract class for Acquaintances
 */
public abstract class Acquaintances implements Serializable {

    private String name;
    private String mobileNo;
    private String email;
    private Annoy annoyType;

    /**
     * set name
     *
     * @param name name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * set mobile number
     *
     * @param mobileNo mobile number
     */
    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    /**
     * set email
     *
     * @param email email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * get name
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * get mobile number
     *
     * @return mobile number
     */
    public String getMobileNo() {
        return mobileNo;
    }

    /**
     * get email
     *
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * check if the person is annoying
     *
     * @return response from the person
     */
    public String tryToAnnoy() {
        return annoyType.annoy();
    }

    /**
     * define if the person is annoying
     *
     * @param newAnnoyType annoy behavior
     */
    public void setAnnoyingAbility(String newAnnoyType) {
        if (newAnnoyType.equalsIgnoreCase("n")) {
            annoyType = new CantAnnoy();
        }
        if (newAnnoyType.equalsIgnoreCase("y")) {
            annoyType = new CanAnnoy();
        }
    }

}
