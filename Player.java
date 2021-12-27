import java.util.Stack;
import java.util.HashMap;

/**
 * @author COLNOT Clémence
 * @version 2021.12.15
 */
public class Player {
    private Room aCurrentRoom;
    private Stack<RoomAndDirection> aPrevRoom;
    private ItemList aItems;
    private int aWeight;
    private int aWeightMax;
    private int aNbMoves;
    private static int sNbMovesMax = 150;

    /**
     * Player constructor
     *
     * @param Room pCurrent
     */
    public Player(final Room pCurrent) {
        this.aPrevRoom = new Stack<RoomAndDirection>();
        this.aCurrentRoom = pCurrent;
        this.aItems = new ItemList();
        this.aWeight = 0;
        this.aWeightMax = 5;
        this.aNbMoves = 0;
    }// Player

    /**
     * Setter current room
     *
     * @param Room pCurrentRoom
     */
    public void setCurrentRoom(final Room pCurrentRoom) {
        this.aCurrentRoom = pCurrentRoom;
    }// setCurrentRoom

    /**
     * Getter Current position
     *
     * @return Room aCurrentRoom
     */
    public Room getCurrentRoom() {
        return this.aCurrentRoom;
    }// getCurrentRoom

    /**
     * Setter previous room
     *
     * @param Room pPrevRoom
     */
    public void setPreviousRoom(final Room pPrevRoom, final String pDirection) {
        this.aPrevRoom.push(new RoomAndDirection(pPrevRoom, pDirection));
    }// setPreviousRoom

    /**
     * Getter Previous position
     *
     * @return RoomAndDirection aPrevRoom
     */
    public RoomAndDirection getPreviousRoom() {
        return this.aPrevRoom.pop();
    }// getPreviousRoom

    /**
     * Getter get Weight
     *
     * @return int Weight
     */
    public int getWeight() {
        return this.aWeight;
    }// getWeight

    /**
     * Set Weight
     *
     * @param int pWeight
     */
    public void setWeight(final int pWeight) {
        this.aWeight = pWeight;
    }// getWeight

    /**
     * Getter get WeightMax
     *
     * @return int WeightMax
     */
    public int getWeightMax() {
        return this.aWeightMax;
    }// getWeight

    /**
     * Set WeightMax
     *
     * @param int pWeight
     */
    public void setWeightMax(final int pWeight) {
        this.aWeightMax = pWeight;
    }// getWeightMax

    /**
     * Getter get NbMoves
     *
     * @return int NbMoves
     */
    public int getNbMoves() {
        return this.aNbMoves;
    }// getNbMoves

    /**
     * Setter NbMoves : adds 1
     */
    public void setNbMoves() {
        this.aNbMoves += 1;
    }// setNbMoves

    /**
     * Getter get NbMovesMax
     *
     * @return int NbMovesMax
     */
    public int getNbMovesMax() {
        return this.sNbMovesMax;
    }// getNbMovesMax


    /**
     * Getter All Previous positions
     *
     * @return Stack<RoomAndDirection> aPrevRoom
     */
    public Stack<RoomAndDirection> getPreviousRooms() {
        return this.aPrevRoom;
    }// getPreviousRooms

    /**
     * Search in the HashMap if this Item have been taken
     *
     * @return HashMap<String, Item> aItems
     */
    public ItemList getItemList() {
        return this.aItems;
    }// getItems

    /**
     * Take Item
     *
     * @param Item pItem, Room pRoom
     */
    public void take(final Item pItem, final Room pRoom) {
        if (pRoom.getItemList().itemIsInList(pItem)) {
            if (!this.aItems.itemIsInList(pItem)) {
                if ((pItem.getWeight() + this.aWeight) <= this.aWeightMax) {
                    this.aWeight += pItem.getWeight();
                    this.aItems.addItem(pItem);
                    pRoom.getItemList().removeItem(pItem);
                }
            }
        }
    }// take

    /**
     * Drop Item
     *
     * @param Item pItem, Room pRoom
     */
    public void drop(final Item pItem, final Room pRoom) {
        if (!pRoom.getItemList().itemIsInList(pItem)) {
            if (this.aItems.itemIsInList(pItem)) {
                this.aWeight -= pItem.getWeight();
                this.aItems.removeItem(pItem);
                pRoom.getItemList().addItem(pItem);
            }
        }
    }// drop


}
