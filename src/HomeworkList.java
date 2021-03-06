/**
 * Created by hgoscenski on 2/8/17.
 */

import java.time.LocalDate;
import java.util.*;

public class HomeworkList {

    private ArrayList<Homework> homeworkHolder;

    /**
     * a constructor to build my homeowrk list that finally instantiates the ArrayList
     */
    public HomeworkList(){
        homeworkHolder = new ArrayList<>();
    }

    /**
     * @param newAssign adds this assignment to the end of the arraylist
     */
    public void addAssign(Homework newAssign){
        homeworkHolder.add(newAssign);
    }

    /**
     * @param badAssign will remove the assignment references in badassign
     */
    public void removeAssign(Homework badAssign){
        homeworkHolder.remove(badAssign);
    }

    /**
     * @return Makes the toString for the HomeworkList Class
     */
    public String toString() {
        Iterator<Homework> it = homeworkHolder.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    /**
     * @return returns a string of the homework assignments due at the same time
     */
    public String orderByDate(){
        homeworkHolder.sort(Comparator.comparing(Homework::getAssignDate));
        Iterator<Homework> it = homeworkHolder.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    /**
     * @return returns an arraylist of the homework assignments due on the same, early day.
     */
    public ArrayList<Homework> earliestDueDate(){
        homeworkHolder.sort(Comparator.comparing(Homework::getAssignDate));
        Iterator<Homework> it = homeworkHolder.iterator();
        LocalDate earliestDate = homeworkHolder.get(0).getAssignDate();
        ArrayList<Homework> homeArrayReturn = new ArrayList<>();
        while(it.hasNext()){
            Homework tempHomework = it.next();
            if(tempHomework.getAssignDate().isEqual(earliestDate)){
                homeArrayReturn.add(tempHomework);
            }
        }return homeArrayReturn;
    }


}
