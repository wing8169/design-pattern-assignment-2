package contactmanagementsoftware;

/**
 * @author ritz619
 * Factory is the abstract factory in charge of creating acquaintance
 */
public interface Factory {
    /**
     * create acquaintance
     *
     * @param type type of acquaintance
     * @return acquaintance
     */
    Acquaintances createAcquaintance(String type);
}
