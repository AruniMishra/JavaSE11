package standardTest;


import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static java.time.DayOfWeek.SATURDAY;

interface Player<E> {
    void play(E e);
}

interface GamePlayer<E extends Game23> extends Player<E> {
}

interface MusicPlayer<E extends Instrument> extends Player {
}

public class S11 {
}

class s10LowBalanceExceptionT2 extends WithdrawalException { // 1
    public s10LowBalanceExceptionT2(String msg) {
        super(msg);
    }
}

class WithdrawalExceptionT2 extends RuntimeException { // 2
    public WithdrawalExceptionT2(String msg) {
        super(msg);
    }
}

class AccountT2 {
    double balance;

    public static void main(String[] args) {
        try {
            AccountT2 a = new AccountT2();
            a.withdraw(100.0);
        } catch (WithdrawalExceptionT2 e) {
            System.out.println(e.getMessage());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void withdraw(double amount) {
        try {
            throw new s10LowBalanceExceptionT2("Not Implemented");
        } catch (WithdrawalException e) {
            throw new RuntimeException(e.getMessage());
        }
    }
}

class TestClass14 {
    public static void main(String[] args) {
        var day = LocalDate.now().with(SATURDAY).getDayOfWeek();
        System.out.println(day);

        switch (day) {
            case MONDAY:
                TUESDAY:
                WEDNESDAY:
                THURSDAY:
                FRIDAY:
                System.out.println("working");
            case SATURDAY:
                System.out.println("SATURDAY off");
                SUNDAY:
                System.out.println("off");
        }
    }
}

class Game23 {
}

class Cricket extends Game23 {
}

class Instrument {
}

class Guitar extends Instrument {
}

class MidiPlayer implements MusicPlayer<Instrument> {
    public void play(Guitar g) {
    }

    @Override
    public void play(Object o) {

    }
}


class s11T27 {
    public static void main(String[] args) {

        ArrayList<Integer> source = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6));

        List<Integer> destination =
                Collections.synchronizedList(new ArrayList<Integer>());

        source
                // .parallelStream()  // 1
                .stream()  // 1
                .peek(item -> {
                    destination.add(item);
                }) // 2
                .forEachOrdered(System.out::print);

        System.out.println("");
        destination
                .stream() // 3
                .forEach(System.out::print); // 4
    }

    public float parseFloat(String s) {
        float f = 0.0f;      // 1
        try {
            f = Float.valueOf(s).floatValue();    // 2
            return f;      // 3
        } catch (NumberFormatException nfe) {
            f = Float.NaN;    // 4
            return f;     // 5
        } finally {
            return f;     // 6
        }
        // return f ;    // 7
    }
}

class s11T39 {

    public static void copy(String records1, String records2) {
        try (
                InputStream is = new FileInputStream(records1);
                OutputStream os = new FileOutputStream(records2);) {

            byte[] buffer = new byte[1024];
            int bytesRead = 0;
            while ((bytesRead = is.read(buffer)) != -1) {
                os.write(buffer, 0, bytesRead);
                System.out.println("Read and written bytes " + bytesRead);
            }
        } catch (SecurityException | IllegalArgumentException | IOException e) { // LINE 100
        }

    }

}

interface Measurement{
    public default int getLength(){
        return 0;
    }

    public default int getBreadth(){ return 0; }
}

interface Size extends Measurement{
    public static final int UNIT = 100;
    // public static int getLength(){ return 10;}


    public default int getBreadth(){ return 0; }

    // public int getBreadth();
}



class Booby{
}
class Dooby extends Booby{
}
class Tooby extends Dooby{
}

class TestClasss11T50 {
    Booby b = new Booby();
    Tooby t = new Tooby();

    public void do1(List<? super Dooby> dataList){
        //1 INSERT CODE HERE
        dataList.add(t);
        // dataList.add(b);
    }
    public void do2(List<? extends Dooby> dataList){
        //2 INSERT CODE HERE
    }
}