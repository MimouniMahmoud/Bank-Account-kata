package account;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
@RunWith(MockitoJUnitRunner.class)
public class ClockTest {

    @Test
    public void return_toDays_date_in_dd_MM_yyyy_format(){
        Clock clock = new TestableClock();
        String date = clock.toDayAsString();
        assertThat(date).isEqualTo("14/06/2020");
    }

    private class TestableClock extends Clock{
        @Override
        protected LocalDate today() {
            return LocalDate.of(2020,6,14);
        }
    }
}
