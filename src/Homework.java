/**
 * Created by hgoscenski on 2/8/17.
 */

import java.time.LocalDate;

public class Homework {
    private LocalDate assignDate;
    private String assignName;

    public Homework(LocalDate assignDate, String assignName) {
        this.assignDate = assignDate;
        this.assignName = assignName;
    }

    public LocalDate getAssignDate() {
        return assignDate;
    }

    public String getAssignName() {
        return assignName;
    }

    @Override
    public String toString() {
        return "Assignment: " + assignName + " | due: " + assignDate +"\n";
    }
}
