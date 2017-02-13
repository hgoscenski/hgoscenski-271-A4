import sun.management.HotspotMemoryMBean;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by hgoscenski on 2/8/17.
 */
public class testInput {
    public static void main(String[] args) {

//        Testing for the class with a couple of different grades
        LocalDate d1 = LocalDate.of(2017, 1, 2);
        LocalDate d2 = LocalDate.of(2016, 1, 1);
        LocalDate d3 = LocalDate.of(2017, 2, 2);

        Scanner stdin = new Scanner(System.in);
        String sentinel = "";

        Homework h1 = new Homework(d1, "Test 1", "A1");
        Homework h2 = new Homework(d2, "Quiz 1", "A2");
        Homework h3 = new Homework(d3, "Exam 3", "A3");
        Homework h4 = new Homework(d2, "Test Test", "A4");

        HomeworkList hwl = new HomeworkList();

        hwl.addAssign(h1);
        hwl.addAssign(h2);
        hwl.addAssign(h3);
        hwl.addAssign(h4);

        System.out.println("Standard toString printout of assignments:\n" + hwl.toString());

        hwl.removeAssign(h3);

        System.out.println("Standard toString printout of assignments:\n" + hwl.toString());

        System.out.println("Printing out the earliest due date");
        printEarliestDueDate(hwl);

        System.out.println(hwl.orderByDate());

        System.out.println("---------------------------------------\nThis is the second implementation test input\n---------------------------------------");

        HomeworkLinkedList hwll = new HomeworkLinkedList();

        hwll.addAssign(h1);
        hwll.addAssign(h2);
        hwll.addAssign(h3);
        hwll.addAssign(h4);

        System.out.println("Standard toString printout of assignments:\n" + hwll.toString());

        System.out.println("Removing A3");
        hwll.removeAssign(h3);

        System.out.println("Standard toString printout of assignments:\n" + hwll.toString());

        System.out.println("Printing out the earliest due date");
        printEarliestDueDate(hwll);

        System.out.println("Ordered printout of assignments by due date:\n" + hwll.orderByDate());

        System.out.println("---------------------------------------\nEnd of sample data\nThis is the interactive portion\n---------------------------------------");

        System.out.println("This is the interactive part.\nYou are starting with a new, empty LinkedList HomeworkList");

        HomeworkLinkedList hwlInteractive = new HomeworkLinkedList();

        printHelp();

        while (!sentinel.equalsIgnoreCase("quit")) {
            sentinel = stdin.next();
            switch (sentinel.toLowerCase()) {
                case "help":
                    printHelp();
                    break;
                case "add": {
                    System.out.println("Please enter the due date year:");
                    int year = stdin.nextInt();
                    System.out.println("Please enter the due date month:");
                    int month = stdin.nextInt();
                    System.out.println("Please enter the due date day");
                    int day = stdin.nextInt();
                    LocalDate tempDate = LocalDate.of(year, month, day);
                    System.out.println("Please enter the Assignment ID in the form of A1");
                    String tempID = stdin.nextLine();
                    System.out.println("Please enter the assignment title");
                    String tempDesc = stdin.next();
                    Homework tempHW = new Homework(tempDate, tempDesc, tempID);
                    hwlInteractive.addAssign(tempHW);
                    break;
                }
                case "remove":
                    System.out.print("Please enter the Assignment ID you want removed");
                    String removeID = stdin.next();
                    hwlInteractive.removeAssign(removeID);
                    break;
                case "print":
                    System.out.println(hwlInteractive.toString());
                    break;
                case "due":
                    printEarliestDueDate(hwlInteractive);
                    break;
                case "earlybird":
                    System.out.println(hwlInteractive.earliestDueDate());
                    break;
            }
        }
    }

    // Some lovely overloading over here
    // I was to lazy to properly encapsulate my code
    // If I was super motivated I would have made an abstract homework list class with
    // the main add,remove,print functions since the syntax and use is the same between arraylists
    // and linkedlists


    public static void printEarliestDueDate(HomeworkLinkedList homeworkListThing){
        ArrayList temp = homeworkListThing.earliestDueDate();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < temp.size(); i++) {
            sb.append(temp.get(i).toString());
        }
        System.out.println(sb);
    }

    public static void printEarliestDueDate(HomeworkList homeworkListThing){
        ArrayList temp = homeworkListThing.earliestDueDate();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < temp.size(); i++) {
            sb.append(temp.get(i).toString());
        }
        System.out.println(sb);
    }

    public static void printHelp(){
        System.out.println("You can add a homework item by typing add\nYou can remove an object by typing remove\nYou can print the list in order assigned by typing print");
        System.out.println("You can type them in order of due date by typing due\nYou can get the earliest due date by typing earlybird");

    }
}

