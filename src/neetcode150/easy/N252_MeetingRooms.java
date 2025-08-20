package neetcode150.easy;

import java.util.ArrayList;
import java.util.List;

public class N252_MeetingRooms {

    static class Interval {
        public int start, end;
        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public static boolean canAttendMeetings(List<Interval> intervals) {

        if(intervals.size() < 1) {
             return true;
        }

        intervals.sort((interval1, interval2) -> {
            return interval1.start - interval2.start;
        });

        int end = intervals .get(0).end;

        for(int i=1; i<intervals.size(); i++) {
            if(intervals.get(i).start >= end) {
                end = intervals.get(i).end;
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args){
        Interval interval1 = new Interval(0,30);
        Interval interval2 = new Interval(5,10);
        Interval interval3 = new Interval(15,20);

        ArrayList<Interval> lst = new ArrayList<>();
        lst.add(interval1);
        lst.add(interval2);
        lst.add(interval3);

        System.out.println(canAttendMeetings(lst));

    }
}
