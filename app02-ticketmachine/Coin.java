/**
 * Represents a named coin and associated value in pennies.
 *
 * @author Matt Hensman
 * @version 2020-10-06
 */
public enum Coin
{
    TEN_PENCE(10),
    TWENTY_PENCE(20),
    ONE_POUND(100),
    TWO_POUNDS(200);
    
    private final int value;
    
    private Coin(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }
}
