/**
 * Represents a named coin and associated value in pennies.
 *
 * @author Matt Hensman
 * @version 2020-10-06
 */
public enum Coin {
    TEN_PENCE(10),
    TWENTY_PENCE(20),
    ONE_POUND(100),
    TWO_POUNDS(200);
    
    // Coin value in pennies
    private final int value;
    
    /**
     * Coin constructor
     */
    private Coin(int value) {
        this.value = value;
    }

    /**
     * Gets coin value.
     */
    public int getValue() {
        return this.value;
    }
}
