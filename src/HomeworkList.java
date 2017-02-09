/**
 * Created by hgoscenski on 2/8/17.
 */

import java.time.LocalDate;
import java.util.*;

public class HomeworkList {

    private ArrayList<Homework> homeworkHolder;

    public HomeworkList(){
        homeworkHolder = new ArrayList<>();
    }

    public void addAssign(Homework newAssign){
        homeworkHolder.add(newAssign);
    }

    public void removeAssign(Homework badAssign){
        homeworkHolder.remove(badAssign);
    }

    public String toString() {
        Iterator<Homework> it = homeworkHolder.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    public String orderByDate(){
        homeworkHolder.sort(Comparator.comparing(Homework::getAssignDate));
        Iterator<Homework> it = homeworkHolder.iterator();
        StringBuilder sb = new StringBuilder();
        while(it.hasNext()){
            sb.append(it.next().toString());
        }
        return sb.toString();
    }

    public Homework earliestDueDate(){
        Iterator<Homework> it = homeworkHolder.iterator();
        Homework tHome = new Homework(LocalDate.of(3000,12,31), "Test Assign");
        while(it.hasNext()){
            Homework t2home = it.next();
            if(t2home.getAssignDate().isBefore(tHome.getAssignDate())){
                tHome = t2home;
            }
        }
        return(tHome);
    }


}
