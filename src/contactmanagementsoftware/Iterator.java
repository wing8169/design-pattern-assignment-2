package contactmanagementsoftware;

/**
 * @author ritz619
 * Iterator is the base interface for iterators
 */
public interface Iterator {
    /**
     * check if has next item
     *
     * @return boolean has next
     */
    boolean hasNext();

    /**
     * get the next item
     *
     * @return next item
     */
    Object next();
}
