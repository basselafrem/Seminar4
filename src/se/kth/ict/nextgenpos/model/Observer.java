
package se.kth.ict.nextgenpos.model;
/**
 * the interface is used by objects that wants to be notified about new products the have been registered
 * @author Bassel
 */
public interface Observer {
    /**
     * called when the balance changes
     * @param spec  the added product specification
     */
    public void notify(ProductSpecification spec); 
    
}
