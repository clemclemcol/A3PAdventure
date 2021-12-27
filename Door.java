
/**
 * Décrivez votre classe Door ici.
 *
 * @author COLNOT Clémence
 * @version 2021.12.21
 */
public class Door {
    private boolean aLocked;
    private Item aKey;
    private Room aRoom1;
    private Room aRoom2;
    private boolean aRoom1To2;
    private boolean aRoom2To1;

    /**
     * Constructor
     */
    public Door(final boolean pLocked, final Item pKey, final Room pRoom1,
                final Room pRoom2, final boolean pRoom1To2, final boolean pRoom2To1) {
        this.aLocked = pLocked;
        this.aKey = pKey;
        this.aRoom1 = pRoom1;
        this.aRoom2 = pRoom2;
        this.aRoom1To2 = pRoom1To2;
        this.aRoom2To1 = pRoom2To1;

    }// Door

    /**
     * Constructor
     */
    public Door(final boolean pLocked, final Item pKey, final Room pRoom1,
                final Room pRoom2) {
        this.aLocked = pLocked;
        this.aKey = pKey;
        this.aRoom1 = pRoom1;
        this.aRoom2 = pRoom2;
        this.aRoom1To2 = true;
        this.aRoom2To1 = true;

    }//Door

    /**
     * Set Door Locked
     */
    public void setLocked() {
        this.aLocked = true;
    }// setLocked

    /**
     * Get state Door
     */
    public boolean isLocked() {
        return this.aLocked;
    }// isLocked

    /**
     * Set Door Locked
     */
    public void setKey(Item pKey) {
        this.aKey = pKey;
    }// setKey

    /**
     * Get Key
     */
    public Item getKey() {
        return this.aKey;
    }// getKey

    /**
     * Set room 1
     */
    public void setRoom1(Room pRoom) {
        this.aRoom1 = pRoom;
    }// setRoom1

    /**
     * Get Room1
     */
    public Room getRoom1() {
        return this.aRoom1;
    }// getRoom1

    /**
     * Set room 2
     */
    public void setRoom2(Room pRoom) {
        this.aRoom2 = pRoom;
    }// setRoom2

    /**
     * Get Room2
     */
    public Room getRoom2() {
        return this.aRoom2;
    }// getRoom2

    /**
     * Set pRoom1To2
     */
    public void setRoom1To2(boolean pRoom1To2) {
        this.aRoom1To2 = pRoom1To2;
    }// setRoom1To2

    /**
     * Get state isRoom1To2
     */
    public boolean isRoom1To2() {
        return this.aRoom1To2;
    }// isRoom1To2

    /**
     * Set pRoom2To1
     */
    public void setRoom2To1(boolean pRoom2To1) {
        this.aRoom2To1 = pRoom2To1;
    }// setRoom2To1

    /**
     * Get state isRoom2To1
     */
    public boolean isRoom2To1() {
        return this.aRoom2To1;
    }// isRoom2To1


    /**
     * Unlock the Door
     *
     * @pPlayer
     */
    public void unlock(ItemList pList) {
        if (pList.itemIsInList(this.aKey))
            this.aLocked = false;
    }// unlock
}
