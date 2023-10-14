package standardTest;


import java.time.LocalDate;

import static java.time.DayOfWeek.*;

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

    public void withdraw(double amount) {
        try {
            throw new s10LowBalanceExceptionT2("Not Implemented");
        } catch (WithdrawalException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

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