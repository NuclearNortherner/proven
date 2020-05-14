package in.blagush.learn.proven;

import java.time.LocalDate;
import java.time.Month;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * https://en.wikipedia.org/wiki/Birthday_problem
 *
 * Interesting thing that seemed false to me, but these calculations proved this 'birthday paradox'
 */
public class BirthdaysParadox {

    public static void main(String[] args) {

        int count = 100000;
        int equals = 0;

        for (int i = 0; i < count; i++) {
            Set<LocalDate> localDates = IntStream.rangeClosed(1, 23)
                    .mapToObj(x -> {
                        int month = new Random().nextInt(12) + 1;
                        int day = new Random().nextInt(Month.of(month).maxLength()) + 1;
                        return LocalDate.of(2020, month, day);
                    }).collect(Collectors.toSet());
            if (localDates.size() < 23) {
                equals++;
            }
        }
        System.out.println("Testing on " + count + " cases. Overall percent of day and month " +
                "birth match for 23 persons is " + (double)equals * 100 / count);
    }

}
