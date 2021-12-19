import java.time.LocalDate;
import java.time.LocalDateTime;

public class Gigasecond {

    LocalDateTime localDate;
    long gigaSecond = 1000000000L;

    public Gigasecond(LocalDate moment) {
        localDate = moment.atStartOfDay().plusSeconds(this.gigaSecond);
    }

    public Gigasecond(LocalDateTime moment) {
        localDate = moment.plusSeconds(this.gigaSecond);
    }

    public LocalDateTime getDateTime() {
        return localDate;
    }
}
