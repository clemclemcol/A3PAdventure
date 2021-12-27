import java.util.HashMap;

/**
 * @author COLNOT Clémence
 * @version 2021.12.15
 */
public class ItemList {
    private HashMap<String, Item> aItemList;

    /**
     * ItemList Constructor
     */
    public ItemList() {
        this.aItemList = new HashMap<String, Item>();
    }// ItemList

    /**
     * Add the item to aItems
     *
     * @param Item pItem
     */
    public void addItem(final Item pItem) {
        this.aItemList.put(pItem.getName(), pItem);
    }// addItem

    /**
     * Remove item from aItems
     *
     * @param Item pItem
     */
    public void removeItem(final Item pItem) {
        this.aItemList.remove(pItem.getName(), pItem);
    }// removeItem

    /**
     * Return aItemList
     *
     * @return ItemList
     */
    public HashMap<String, Item> getList() {
        return this.aItemList;
    }// getItem

    /**
     * Return an item from aItems
     *
     * @param String pItem
     * @return Item
     */
    public Item getItem(final String pItem) {
        return this.aItemList.get(pItem);
    }// getItem

    /**
     * Return if an item is in ItemList
     *
     * @param Item pItem
     * @return boolean
     */
    public boolean itemIsInList(final Item pItem) {
        if (this.aItemList.containsValue(pItem))
            return true;
        return false;
    }// itemIsInList

    /**
     * Return if an item is in ItemList
     *
     * @param Item pItem
     * @return boolean
     */
    public boolean nameIsInList(final String pItem) {
        if (this.aItemList.containsKey(pItem))
            return true;
        return false;
    }// nameIsInList

    /**
     * Get all the Item in a ItemList
     *
     * @return String ItemsName
     */
    public String getItemsNames() {
        if (!this.getList().isEmpty()) {
            StringBuilder vItemsNames = new StringBuilder("   Items:  ");
            for (Item vI : this.getList().values()) {
                vItemsNames.append(vI.getName() + "[" + vI.getWeight() + "]").append("   ");
            }
            vItemsNames.append("\n");
            return vItemsNames.toString();
        } else
            return "  There are no item.\n";

    }// getItemsNames

    /**
     * Get all the Item in a ItemList
     *
     * @return String all Item descriptions
     */
    public String getItemsDescription() {
        if (!this.getList().isEmpty()) {
            StringBuilder vItemsNames = new StringBuilder("");
            for (Item vI : this.getList().values()) {
                vItemsNames.append(vI.getDescription()).append("\n");
            }
            return vItemsNames.toString();
        } else
            return "  There are no item.";
    }// getItemsDescription

}
