
/**
 * @author COLNOT Clémence
 * @version 2021.12.15
 */

public class Item {
    private String aDescription;
    private int aWeight;
    private String aName;

    /**
     * Item Constructor
     *
     * @param String pName,String pDescription, int pWeight
     */
    public Item(final String pName, final String pDescription, final int pWeight) {
        this.aName = pName;
        this.aDescription = pDescription;
        this.aWeight = pWeight;

    }// Item

    /**
     * Getter item description
     *
     * @return String aDescription
     */
    public String getDescription() {
        return this.aDescription;
    }// getDescription

    /**
     * Getter item name
     *
     * @return String aDescription
     */
    public String getName() {
        return this.aName;
    }// getDescription

    /**
     * Getter item weight
     *
     * @return int aPoids
     */
    public int getWeight() {
        return this.aWeight;
    }// getWeight

    /**
     * Get String item description and weight
     *
     * @return String Description and weight
     */
    public String getStringDescription() {
        return "Item Description : " + this.aDescription + "\n" + "Item weight: " + this.aWeight;
    }// getStringDescription

}// Item
