package contactmanagementsoftware;

import java.io.Serializable;

/**
 * PersonalFriends is the concrete class for personal friend
 */
public class PersonalFriends extends Acquaintances implements Serializable {

    private String aContext;
    private String aDate;
    private String events;

    /**
     * get acquaintance context
     *
     * @return acquaintance context
     */
    public String getAContext() {
        return aContext;
    }

    /**
     * set acquaintance context
     *
     * @param aContext acquaintance context
     */
    public void setAContext(String aContext) {
        this.aContext = aContext;
    }

    /**
     * get acquaintance date
     *
     * @return acquaintance date
     */
    public String getADate() {
        return aDate;
    }

    /**
     * set acquaintance date
     *
     * @param aDate acquaintance date
     */
    public void setADate(String aDate) {
        this.aDate = aDate;
    }

    /**
     * get event
     *
     * @return event
     */
    public String getEvents() {
        return events;
    }

    /**
     * set event
     *
     * @param events event
     */
    public void setEvents(String events) {
        this.events = events;
    }

}
