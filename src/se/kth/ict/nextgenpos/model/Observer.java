
package se.kth.ict.nextgenpos.model;
/**
 *
 * @author Bassel
 */
public interface Observer {
    /**
     * called when the balance changes
     * @param spec  the added product specification
     */
    public void notify(ProductSpecification spec); 
    
}
