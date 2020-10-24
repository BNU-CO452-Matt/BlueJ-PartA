/**
 * Represents a course module with a title, code and percentage mark.
 *
 * @author Matt Hensman
 * @version 2020-10-13
 */
public class Module {
    // Module title
    private String title;
    // Module code
    private String code;

    // Module percentage mark
    private int mark = 0;

    // Indicator of module completion
    private boolean isMarked = false;


    /**
     * Constructor for objects of class Module
     */
    public Module(String title, String code) {
        this.title = title;
        this.code = code;
    }

    /**
     * Constructor for objects of class Module (with mark)
     */
    public Module(String title, String code, int mark) {
        this.title = title;
        this.code = code;
        this.mark = mark;
        this.isMarked = true;
    }

    /**
     * Set module mark.
     */
    public void setMark(int mark) {
        this.mark = mark;
        this.isMarked = true;
    }

    /**
     * Get module mark.
     */
    public int getMark() {
        return this.mark;
    }

    /**
     * Returns boolean indicating whether module has been marked.
     */
    public boolean isMarked() {
        return this.isMarked;
    }

    /**
     * Print module details.
     */
    public void printDetails() {
        System.out.println(this);
    }

    /**
     * Provide string representation.
     */
    @Override
    public String toString() {
        return String.format("%s (%s), mark: %d%%",
                             this.title, this.code, this.mark);
    }
}
