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

    // Total module credits
    private int credits = 0;

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
        String ret = this.title + "\n";
        
        if (this.modules.size() == 0) {
            ret += "Course has no modules." + "\n";
            return ret;
        }
        
        boolean hasUnmarkedModule = false;
        
        int totalMarks = 0;
        for (Module module : this.modules) {
            ret += " - " + module;

            // Don't count unmarked modules
            if (!module.isMarked()) {
                hasUnmarkedModule = true;
                ret += " (uncompleted)" + "\n";
                continue;
            }

            this.credits += Course.MODULE_CREDITS;
            totalMarks += module.getMark();
            ret += "\n";
        }
        
        // Calc average
        totalMarks /= modules.size();
        
        ret += "\nTotal marks: " + totalMarks;

        // Only assign final grade if all modules are complete
        if (!hasUnmarkedModule) {
            // Convert to letter grade
            char finalGrade;
            if (totalMarks >= 70) {
                finalGrade = 'A';
            } else if (totalMarks >= 60) {
                finalGrade = 'B';
            } else if (totalMarks >= 50) {
                finalGrade = 'C';
            } else if (totalMarks >= 40) {
                finalGrade = 'D';
            } else {
                finalGrade = 'F';
            }
            
            ret += "\nFinal grade: " + finalGrade;
        }
        
        ret += "\n";
        return ret;
    }
}
