
/**
 * Represents a student's course with a code and title.
 *
 * @author Matt Hensman
 * @version 2020-09-29
 */
public class Course
{
    // Course code
    private String code;
    // Course title
    private String title;

    /**
     * Constructor for objects of class Course
     */
    public Course(String code, String title)
    {
        this.code = code;
        this.title = title;
    }
    
    /**
     * Gets the course code.
     */
    public String getCode () {
        return code;
    }
    
    /**
     * Gets the course title.
     */
    public String getTitle () {
        return title;
    }
}
