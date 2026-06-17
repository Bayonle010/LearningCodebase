package Java.JavaCollections.treesetchallenge;

import java.util.NavigableSet;
import java.util.TreeSet;

public class Theatre {

    private String theatreName;
    private int seatPerRow;
    private NavigableSet<Seat> seats;

    public Theatre(String theatreName, int rows,  int totalSeat) {
        this.theatreName = theatreName;
        this.seatPerRow = totalSeat/rows;

        seats = new TreeSet<>();
        for (int i = 0; i < totalSeat; i++){
            char rowChar = (char) (i/ seatPerRow + (int)  'A');
            int seatInRow = i % seatPerRow + 1;
            seats.add(new Seat(rowChar, seatInRow));

        }
    }

    public void printSeatMap(){
        String separatorLine = "-".repeat(90);
        System.out.printf("%1$s%n%2$s Seat Map%n%1$s%n", separatorLine, theatreName);

        int index = 0;
        for (Seat s : seats) {
            System.out.printf("%-8s%s",
                    s.seatNum + ((s.reserved) ? "(\u25CF)" : ""),
                    ((index++ + 1) % seatPerRow == 0) ? "\n" : "");

        }
        System.out.println(separatorLine);
    }


    public String reserveSeat(char row, int seat){
        Seat requestedSeat = new Seat(row, seat);
        Seat requested = seats.floor(requestedSeat);

        if (requested == null || !requested.seatNum.equals(requestedSeat.seatNum)){
            System.out.print("--> No such seat: " + requestedSeat);
            System.out.printf(": Seat must be between %s and %s%n", seats.first(), seats.last());
        }else {
            if (!requested.reserved){
                requested.reserved = true;
                return requested.seatNum;
            }else {
                System.out.println("Seat already reserved. ");
            }
        }
        return  null;
    }


    class Seat implements Comparable<Seat>{
        private String seatNum;
        private boolean reserved;

        public Seat(char rowChar, int seatNo){
            this.seatNum = "%c%03d".formatted(rowChar, seatNo).toUpperCase();
        }

        @Override
        public String toString() {
            return seatNum;
        }

        @Override
        public int compareTo(Seat o) {
            return seatNum.compareTo(o.seatNum);
        }
    }
}
