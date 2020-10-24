import java.util.ArrayList;
import java.util.Optional;

/**
 * Represents a course with a set of modules.
 *
 * @author Matt Hensman
 * @version 2020-10-13
 */
public class Course {
    // Course title
    private String title;
    // Course modules
    private ArrayList<Module> modules = new ArrayList();
    
    // Credits each module is worth
    public static int MODULE_CREDITS = 15;

    /**
     * Constructor for objects of class Course
     */
    public Course(String title) {
        this.title = title;
    }

    /**
     * Add module to course.
     */
    public void addModule(Module module) {
        this.modules.add(module);
    }

    /**
     * Get course modules.
     */
    public ArrayList<Module> getModules() {
        return this.modules;
    }

    /**
     * Print course details.
     */
    public void printDetails() {
        System.out.println(this);
    }

    /**
     * Provide string representation.
     */
    @Override
    public String toString() {
        String ret = this.title += "\n";
        for (Module module : this.modules) {
            ret += "  " + module + "\n";
        }
        
        return ret;
    }
}
