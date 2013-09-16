package se.liu.ida.jonny928.tddc70.closestsums;

/**
 * Created with IntelliJ IDEA.
 * User: Jonathan
 * Date: 2013-09-16
 * Time: 14:27
 * To change this template use File | Settings | File Templates.
 */
public class Main {

    public static void main(String[] args) {
        Kattio io = new Kattio(System.in, System.out);
        SortedList mySortedList = new SortedList();

        io.println("Mata in 10 heltal:");
        io.flush();

        for (int i = 0; i < 10; i++) {
            mySortedList.add(io.getInt());
        }

        io.println("Mata in ett heltal för att hitta det heltal i listan som är närmast:");
        io.flush();
        io.println(mySortedList.findClosestMember(io.getInt()));
        io.flush();

    }

    public Main() {
    }
}
