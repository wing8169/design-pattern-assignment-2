package contactmanagementsoftware;

import java.io.Serializable;

/**
 * @author Mohid Khan
 * CanAnnoy implements not annoying behavior
 */
public class CantAnnoy implements Annoy, Serializable {

    @Override
    public String annoy() {
        return "Not Annoying.";
    }

}
