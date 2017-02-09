import java.time.LocalDate;

/**
 * Created by hgoscenski on 2/8/17.
 */
public class testInput {
    public static void main(String[] args){

        LocalDate d1 = LocalDate.of(2017, 1, 2);
        LocalDate d2 = LocalDate.of(2016, 1, 1);
        LocalDate d3 = LocalDate.of(2017, 2, 2);

        Homework h1 = new Homework(d1, "Test 1");
        Homework h2 = new Homework(d2, "Quiz 1");
        Homework h3 = new Homework(d3, "Exam 3");

        HomeworkList hwl = new HomeworkList();

        hwl.addAssign(h1);
        hwl.addAssign(h2);
        hwl.addAssign(h3);

        System.out.println(hwl.toString());

        System.out.println(hwl.earliestDueDate());

        System.out.println(hwl.orderByDate());



    }
}

