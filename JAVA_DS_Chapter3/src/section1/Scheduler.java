package section1;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Scanner;

public class Scheduler {
    //private int capacity = 10;
    private ArrayList<Event> events = new ArrayList<>();
    //private Event[] events = new Event[capacity];
    //private int n = 0;
    private Scanner kb;

    private void processCommand(){
        kb = new Scanner(System.in);
        while(true){
            System.out.print("$ ");
            String command = kb.next();
            if(command.equals("addevent")){
//                if(n >= capacity)
//                    reallocate();
                String type = kb.next();
                if(type.equalsIgnoreCase("oneday")){
                    handleAddOneDayEvent();
                }else if(type.equalsIgnoreCase("duration")){
                    handleAddDurationEvent();
                }else if(type.equalsIgnoreCase("deadline")){
                    handleAddDeadLinedEvent();
                }
            }else if(command.equals("list")){
                handleList();
            }else if(command.equals("show")){
                handleShow();
            }else if(command.equals("sort")){
                Collections.sort(events);
            }else if(command.equals("exit")){
                break;
            }
        }
        kb.close();
    }

    private void handleShow() {
        String dateString = kb.next();
        MyDate theDate = parseDateString(dateString);
        for (int i = 0; i < events.size(); i ++){
            if(events.get(i).isRelevant(theDate))
                System.out.println(events.get(i).toString());
        }
    }

//    private void reallocate(){
//        Event[] tmpArray = new Event[capacity * 2];
//        for(int i = 0; i < n; i ++)
//            tmpArray[i] = events[i];
//        events = tmpArray;
//        capacity *= 2;
//    }

    private void handleList() {
        for(Event ev : events){      // enhanced for loop
            System.out.println("    " + ev.toString());
        }
    }

    private void handleAddDeadLinedEvent() {
        System.out.print("Until : ");
        String dateString = kb.next();
        System.out.print("title : ");
        String title = kb.next();
        MyDate date = parseDateString(dateString);
        DeadLinedEvent ev = new DeadLinedEvent(title, date);
        System.out.println(ev.toString());
        events.add(ev);
    }

    private void handleAddDurationEvent() {
        System.out.print("Begin : ");
        String beginString = kb.next();
        System.out.print("End : ");
        String endString = kb.next();
        System.out.print("title : ");
        String title = kb.next();
        MyDate begin = parseDateString(beginString);
        MyDate end = parseDateString(endString);
        DurationEvent ev = new DurationEvent(title, begin, end);
        System.out.println(ev.toString());
        events.add(ev);
    }

    private void handleAddOneDayEvent() {
        System.out.print("when : ");
        String dateString = kb.next();  // 2019/07/16
        System.out.print("title : ");
        String title = kb.next();
        MyDate date = parseDateString(dateString);
        OneDayEvent ev = new OneDayEvent(title, date);
        System.out.println(ev.toString());
        events.add(ev);
    }

    private MyDate parseDateString(String dateString) {
        String[] tokens = dateString.split("/");
        int year = Integer.parseInt(tokens[0]);
        int month = Integer.parseInt(tokens[1]);
        int day = Integer.parseInt(tokens[2]);
        MyDate date = new MyDate(year, month, day);
        return date;
    }

    public static void main(String[] args){
        Scheduler app = new Scheduler();
        app.processCommand();
    }
}
