package contactmanagementsoftware;

/**
 * @author ritz619
 * AcquantanceFactory implements abstract factory Factory to create acquantance by type
 */
public class AcquaintanceFactory implements Factory {

    /**
     * createAcquaintance creates acquaintance by type
     *
     * @param type type of acquaintance
     * @return acquaintance
     */
    @Override
    public Acquaintances createAcquaintance(String type) {
        if (type.equalsIgnoreCase("CasualAcquaintances")) {
            return new CasualAcquaintances();
        } else if (type.equalsIgnoreCase("PersonalFriends")) {
            return new PersonalFriends();
        } else if (type.equalsIgnoreCase("ProfessionalFriends")) {
            return new ProfessionalFriends();
        } else if (type.equalsIgnoreCase("Relatives")) {
            return new Relatives();
        }
        return null;
    }

}
