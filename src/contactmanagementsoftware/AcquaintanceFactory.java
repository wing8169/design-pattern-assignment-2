/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

/**
 *
 * @author ritz619
 */
public class AcquaintanceFactory implements Factory{

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
