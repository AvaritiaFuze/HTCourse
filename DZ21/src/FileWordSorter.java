import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.stream.Collectors;

public class FileWordSorter {
    public static void main(String[] args) {
        String fileName = "/Users/daniel/Desktop/Учеба_НТ/БД/javadz/DZ21/src/text"; // Убедитесь, что имя файла указано правильно

        try {
            // Чтение файла в строку
            String content = new String(Files.readAllBytes(Paths.get(fileName)));

            // Разделение строки на слова с учетом знаков препинания
            List<String> words = Arrays.stream(content.split("[\\s,.!?\t\n]+"))
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.toList());

            // Сортировка слов в алфавитном порядке без учета регистра
            List<String> sortedWords = words.stream()
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList());

            // Подсчет количества каждого слова
            Map<String, Long> wordCount = words.stream()
                    .collect(Collectors.groupingBy(String::toLowerCase, Collectors.counting()));

            // Нахождение слова с максимальной частотой
            long maxFrequency = Collections.max(wordCount.values());
            List<String> mostFrequentWords = wordCount.entrySet().stream()
                    .filter(entry -> entry.getValue() == maxFrequency)
                    .map(Map.Entry::getKey)
                    .collect(Collectors.toList());

            // Вывод отсортированных слов на экран
            System.out.println("Отсортированные слова:");
            sortedWords.forEach(System.out::println);

            // Вывод частоты встречаемости слов
            System.out.println("\nЧастота встречаемости слов:");
            wordCount.forEach((word, count) -> System.out.println(word + ": " + count));

            // Вывод слова с максимальной частотой
            System.out.println("\nСлово(а) с максимальной частотой:");
            mostFrequentWords.forEach(word -> System.out.println(word + ": " + maxFrequency));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}