import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Передача встроенных функций
 * стр. 117
 */
public class BeautifulFunc {

    public static void main(String[] args) {

        final List<String> words = List.of("Man", "Maksim", "Java", "Soul", "Wellingtons", "cat");

        final List<String> result = rankedWords(w -> score(w) + bonus(w), words);
    }

    static List<String> rankedWords(Function<String, Integer> wordScore, List<String> words) {
        Comparator<String> wordComparator =
                (w1, w2) -> Integer.compare(
                        wordScore.apply(w2),
                        wordScore.apply(w1)
                );
        return words.stream()
                .sorted(wordComparator)
                .collect(Collectors.toList());
    }

    static int score(String word) {
        return word.replaceAll("c", "").length();
    }

    static int bonus(String word) {
        return word.contains("c") ? 5 : 0;
    }
}
