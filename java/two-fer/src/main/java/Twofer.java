public class Twofer {
    public String twofer(String name) {
        String checkedName = (name == null) ? "you" : name;
        return String.format("One for %s, one for me.", checkedName);
    }
}
