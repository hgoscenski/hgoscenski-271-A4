import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by hgoscenski on 2/12/17.
 */
public class HomeworkLinkedList {
    private LinkedList<Homework> homeworkHolder;

    public HomeworkLinkedList(){
        homeworkHolder = new LinkedList<>();
    }

    public void addAssign(Homework newAssign){
        homeworkHolder.add(newAssign);
    }

    //More beautiful overloading

    public void removeAssign(Homework badAssign) {
        homeworkHolder.remove(badAssign);
    }

    public void removeAssign(String name){
        Iterator<Homework> it = homeworkHolder.iterator();
        while(it.hasNext()){
            Homework temp = it.next();
            if(temp.getAssignID().equalsIgnoreCase(name)){
                homeworkHolder.remove(temp);
                System.out.print(name + " removed.");
            }
        }
    }

    public String toString() {
        Iterator<Homework> it = homeworkHolder.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    /**
     * @return returns as a string the ordered assignments
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
     * @return returns the arraylist of the
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
