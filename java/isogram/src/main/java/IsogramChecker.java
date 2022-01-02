import java.util.Arrays;
import java.util.Locale;
import java.util.stream.Collectors;

class IsogramChecker {

    boolean isIsogram(String phrase) {
        if (phrase.isEmpty())
            return true;
        var filtered = phrase.toLowerCase(Locale.ROOT).replaceAll("-|\\s", "");
        return  Arrays.stream(filtered.split("")).collect(Collectors.toSet()).size() == filtered.length();
    }
}
