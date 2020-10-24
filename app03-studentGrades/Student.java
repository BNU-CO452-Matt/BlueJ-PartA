import java.util.ArrayList;

/**
 * The Student class represents a student in a student administration system.
 * It holds the student details relevant in our context.
 * 
 * @author Michael Kölling and David Barnes
 * @version 2016.02.29
 */
public class Student {
    // the student's full name
    private String name;
    // the student ID
    private String id;
    // the amount of credits for study taken so far
    private int credits = 0;

    // Student's course
    private Course course;

    /**
     * Create a new student with a given name and ID number.
     */
    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Return the full name of this student.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Sets student's course.
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * Set a new name for this student.
     */
    public void changeName(String replacementName) {
        this.name = replacementName;
    }

    /**
     * Return the student ID of this student.
     */
    public String getStudentID() {
        return this.id;
    }

    /**
     * Add some credit points to the student's accumulated credits.
     */
    public void addCredits(int additionalPoints) {
        this.credits += additionalPoints;
    }

    /**
     * Return the number of credit points this student has accumulated.
     */
    public int getCredits() {
        return this.credits;
    }

    /**
     * Return the login name of this student. The login name is a combination
     * of the first four characters of the student's name and the first three
     * characters of the student's ID number.
     */
    public String getLoginName() {
        return this.name.substring(0, 4) + this.id.substring(0, 3);
    }
    
    /**
     * Print the student's name and ID number to the output terminal.
     */
    public void print() {
        ArrayList<Module> modules = this.course.getModules();
        if (modules.isEmpty()) {
            System.out.println("Student course contains no modules!");
            return;
        }
        
        int finalMark = 0;
        for (Module module : modules) {
            if (!module.isMarked()) {
                System.out.println("Student has not completed all modules!");
                return;
            }

            this.credits += Course.MODULE_CREDITS;
            finalMark += module.getMark();
        }
        
        // Calc average
        finalMark /= modules.size();

        // Convert to letter grade
        char finalGrade;
        if (finalMark >= 70) {
            finalGrade = 'A';
        } else if (finalMark >= 60) {
            finalGrade = 'B';
        } else if (finalMark >= 50) {
            finalGrade = 'C';
        } else if (finalMark >= 40) {
            finalGrade = 'D';
        } else {
            finalGrade = 'F';
        }

        System.out.printf("%s, student ID: %s, credits: %d\n Final grade: %c\n",
                          this.name, this.id, this.credits, finalGrade);
    }
}
