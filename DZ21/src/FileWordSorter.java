import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FileWordSorter {
    public static void main(String[] args) {
        String fileName = "/Users/daniel/Desktop/Учеба_НТ/БД/javadz/DZ21/src/text"; // Укажите имя вашего файла

        try {
            // Чтение файла в строку
            String content = new String(Files.readAllBytes(Paths.get(fileName)));

            // Разделение строки на слова с учетом знаков препинания
            List<String> words = Arrays.stream(content.split("[\\s,!.]+"))
                    .filter(word -> !word.isEmpty())
                    .collect(Collectors.toList());

            // Сортировка слов в алфавитном порядке без учета регистра
            List<String> sortedWords = words.stream()
                    .sorted(String.CASE_INSENSITIVE_ORDER)
                    .collect(Collectors.toList());

            // Вывод отсортированных слов на экран
            sortedWords.forEach(System.out::println);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}