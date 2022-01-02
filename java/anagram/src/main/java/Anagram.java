import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Anagram {
    Map<String, Integer> characterCount;
    String word;

    public Anagram(String input) {
        this.word = input.toLowerCase(Locale.ROOT);
        this.characterCount = this.stringToMap(this.word);
    }

    public List<String> match(List<String> input) {
        return input.stream().filter(this::checkAnagramMatch).collect(Collectors.toList());
    }

    public Map<String, Integer> stringToMap(String input) {
       return Arrays.stream(input.split("")).collect(Collectors.toMap(Function.identity(), x -> 1, (x,y) -> x + y));
    }

    public Boolean checkAnagramMatch(String input) {
        return !input.toLowerCase(Locale.ROOT).equals(this.word) && this.stringToMap(input.toLowerCase(Locale.ROOT)).equals(this.characterCount);
    }


}
