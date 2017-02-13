/**
 * Created by hgoscenski on 2/8/17.
 */

import java.time.LocalDate;

public class Homework {
    private LocalDate assignDate;
    private String assignID;
    private String assignName;

    /**
     * @param assignDate takes the date due from the constructor as a LocalDate in the format YYYY-MM-DD
     * @param assignName takes the name of the assignment for easy human readabilty as a String
     */
    public Homework(LocalDate assignDate, String assignName, String assignID) {
        this.assignDate = assignDate;
        this.assignName = assignName;
        this.assignID = assignID;
    }

    public String getAssignID() {
        return assignID;
    }

    public LocalDate getAssignDate() {
        return assignDate;
    }

    public String getAssignName() {
        return assignName;
    }

    @Override
    public String toString() {
        return  "Assignment: " + assignID + ", " + assignName + " | due: " + assignDate +"\n";
    }
}
