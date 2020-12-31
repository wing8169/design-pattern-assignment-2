package contactmanagementsoftware;

import java.io.Serializable;
import java.util.Scanner;

public class PersonalFriends extends Acquaintances implements Serializable {

    private String AContext;
    private String ADate;
    private String Events;

    PersonalFriends() {
    }

    public String getAContext() {
        return AContext;
    }

    public void setAContext(String AContext) {
        Scanner reader = new Scanner(System.in);
        if (!AContext.isEmpty()) {
            this.AContext = AContext;
        } else {
            System.out.println("Enter atleast one character");
            setAContext(reader.nextLine());
        }
    }

    public String getADate() {
        return ADate;
    }

    public void setADate(String ADate) {
        this.ADate = ADate;
    }

    public String getEvents() {
        return Events;
    }

    public void setEvents(String Events) {
        Scanner reader = new Scanner(System.in);
        if (!Events.isEmpty()) {
            this.Events = Events;
        } else {
            System.out.println("Enter atleast one character");
            setEvents(reader.nextLine());
        }
    }

}
