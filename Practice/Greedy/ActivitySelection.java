package Greedy;

import java.util.*;

public class ActivitySelection {

    static class Activity {

        int start, end;

        public Activity(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }


        public static void find(ArrayList<Activity> list) {
            Comparator<Activity> c = Comparator.comparingInt(o -> o.end);
            list.sort(c);
            Activity previous = list.get(0);

            System.out.println(previous.start + " to "+previous.end);
            for(int i = 0 ; i < list.size();i++){
                Activity current = list.get(i);
                if(current.start >= previous.end){
                    System.out.println(current.start +  " to " + current.end);
                    previous = current ;
                }
            }

        
    }

    public static void main(String[] args) {
        ArrayList<Activity> list = new ArrayList<>();
        list.add(new Activity(0, 6));
        list.add(new Activity(3, 4));
        list.add(new Activity(1, 2));
        list.add(new Activity(5, 8));
        list.add(new Activity(5, 7));
        list.add(new Activity(8, 9));

        find(list);
    }
}
