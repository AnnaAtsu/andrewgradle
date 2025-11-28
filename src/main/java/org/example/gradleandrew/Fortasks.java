package org.example.gradleandrew;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Fortasks {


    public static void main(String[] args) {
        int num = 12034;
        System.out.println(sumTwoNumbers(num));
        System.out.println(isPalindrom("levels"));
        System.out.println(isPalindromWithBuilder("level"));
        System.out.println(countLetters("aвтотестирование"));
        System.out.println(countVowels("aвтотестирование"));
        System.out.println(countVowelSet("aвтотестирование"));
        System.out.println(reverseString("Selenium"));
        System.out.println(countNumbersWithStream());
        System.out.println(deleteDubles());
        System.out.println(oddNumbersSum());
        System.out.println(findLongWord("Java is great"));
        System.out.println(oddGroupNumbers());



        //    6. Получить список имён всех людей старше 25 лет (Stream API + filter + map).
        System.out.println(popularCountry());
        List<Person> people = Arrays.asList(
                new Person("Анна", 21),
                new Person("Борис", 30),
                new Person("Марина", 27)
        );
            List<String> olderpeople = people.stream()
                    .filter(s -> s.getAge() > 25)
                    .map(Person::getName)
                    .collect(Collectors.toList());
        System.out.println(olderpeople);


    }

    // 0. Найти сумму чисел
    public static int sumTwoNumbers(int num) {
        int summa = 0;
        while (num > 0) {
            int n = num % 10;
            summa += n;
            num /= 10;
        }
        return summa;
    }
    //  1. Найти первое неповторяющееся число в массиве.
    //   Пример: {4, 5, 1, 2, 1, 4, 2} → результат: 5

    // 2. Проверить, является ли строка палиндромом.
    //        Пример: "level" → true

    public static boolean isPalindrom(String str) {
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;

    }

    public static boolean isPalindromWithBuilder(String str) {
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }


    // 3. Посчитать количество букв в строке.
    //  Пример: "Автотестирование" → 7
    public static int countLetters(String str) {
        char[] chars = str.toCharArray();
        int count = 0;
        for (char c : chars) {
            if (Character.isLetter(c)) {
                count++;

            }
        }
        return count;
    }
// 3.1 Посчитать количество гласных букв в строке.
    //  Пример: "Автотестирование" → 7

    public static int countVowels(String str) {
        char[] chars = str.toLowerCase().toCharArray();
        int count = 0;
        for (char c : chars) {
            if (c == 'a' || c == 'e' || c == 'и' || c == 'я' || c == 'ю' || c == 'у' || c == 'э' || c == 'о' || c == 'ё' || c == 'ы') {
                count++;
            }
        }
        return count;
    }

    // 3.1 Посчитать количество гласных букв в строке.
    //  Пример: "Автотестирование" → 7

    public static int countVowelSet(String str) {
        Set<Character> vowels = Set.of('а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я');
        int count = 0;
        for (char c : str.toLowerCase().toCharArray()) {
            if (vowels.contains(c)) {
                count++;
            }
        }
        return count;
    }
    //  4. Развернуть строку без использования StringBuilder.reverse().
    //       Пример: "Selenium" → "muineleS"

    public static String reverseString(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }
        return reverseString(str.substring(1)) + str.charAt(0);

    }

    //   5. Посчитать сумму всех чисел в списке с помощью Stream API.
    //   Пример: [1, 2, 3, 4, 5] → 15
    public static int countNumbersWithStream() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5);
        return numbers.stream().reduce(0, Integer::sum);
//или для массива -- int[] array = {1, 2, 3, 4, 5};
//int sum = Arrays.stream(array).sum();
}


      //  7. Найти самое длинное слово в списке строк.
        //        Пример: ["Selenium", "Java", "Automation", "Test"] → "Automation"


     //   8. Удалить дубликаты из списка (Stream API + distinct).
      //  Пример: [1, 2, 2, 3, 4, 4, 5] → [1, 2, 3, 4, 5]

    public static List<Integer> deleteDubles() {
        List<Integer> allNumbers = List.of(1, 2, 2, 3, 4, 4, 5);
        List<Integer> nonDubles = allNumbers.stream()
                .distinct()
                .collect(Collectors.toList());
        return nonDubles;
    }

      //  9. Найти топ-1 самый часто встречающийся элемент в списке.
      //  Пример: ["Москва", "Казань", "Москва", "Томск", "Москва", "Казань"] → "Москва"

    public static String popularCountry() {
        List<String> cities = List.of("Москва", "Казань", "Москва", "Томск", "Москва", "Казань");
        Map<String, Long> mostPopular = cities.stream()
                .collect(Collectors.groupingBy(city -> city, Collectors.counting()));

        return mostPopular.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);

    }


//

//10. Сумма чётных чисел
//Напишите метод, который принимает список целых чисел и возвращает сумму всех чётных чисел.
//
//Пример:
//[1, 2, 3, 4, 5, 6] → 12
//

public static int oddNumbersSum() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6);
      int sum = numbers.stream()
                .filter(number -> (number % 2) == 0)
                .mapToInt(number -> number)
                .sum();
      return sum;
}

//11. Поиск самого длинного слова
//Напишите метод, который принимает строку из слов (разделённых пробелами) и возвращает самое длинное слово. Если таких несколько — верните первое.
//
//Пример:
//"Java is great" → "great"
//"QA automation" → "automation"

    public static String findLongWord(String phrase) {
       String[] words = phrase.trim().split("\\s+");
       String longestword = "";
       for(String word : words) {
           if(word.length() > longestword.length()) {
               longestword = word;
           }
       }

       return longestword;
    }



//8. Проверка, что все элементы в списке уникальны
//Напишите метод, который принимает список строк и возвращает true, если все элементы уникальны, и false — если есть дубликаты.
//
//Пример:
//["a", "b", "c"] → true
//["a", "b", "a"] → false

    public static boolean isUniqueList() {
        List<String> letters = List.of("a", "b", "c");
        
    }

    }

