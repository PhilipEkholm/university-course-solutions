package laboration6;

import java.util.Calendar;

public class DateTest {
    public void test() {
        Calendar cal = Calendar.getInstance();
        Date datum = new Date();
        datum.setDate(cal.get(Calendar.YEAR), cal.get(Calendar.MONTH) + 1, cal.get(Calendar.DAY_OF_MONTH));
        datum.showDate();
    }

    public static void main(String[] args) {
        DateTest prog = new DateTest();
        prog.test();
    }
}
