package Practices;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.Map;

public class StreamTest {
    public static void main(String args[]) {
        System.out.println("Using Java 7: ");
        List<String> strings = Arrays.asList("efg", "", "abc", "bc", "ghij","", "lmn");
        System.out.println("List: " +strings);
        // count the number of non empty strings
        long count = getCountEmptyStringUsingJava7(strings);
        System.out.println("Non empty Strings: " + count);
        // count the number of strings with length 3
        long count_length3 = getCountLength3UsingJava7(strings);
        System.out.println("Strings of length 3: " + count_length3);
        // remove empty string
        List<String> filtered = deleteEmptyStringsUsingJava7(strings);
        System.out.println("Filtered List: " + filtered);
        // merge the string list
        String mergedString = getMergedStringUsingJava7(strings,", ");
        System.out.println("Merged String: " + mergedString);
        // remove duplicate and get square of the int array
        List<Integer> numbers = Arrays.asList(2, 3, 3, 2, 5, 2, 7);
        List<Integer> squaresList = getSquares(numbers);
        System.out.println("Squares List: " + squaresList);
        // get max/min/sum/ave of the int array
        List<Integer> integers = Arrays.asList(1,2,13,4,15,6,17,8,19);
        System.out.println("List: " +integers);
        System.out.println("Highest number in List : " + getMax(integers));
        System.out.println("Lowest number in List : " + getMin(integers));
        System.out.println("Sum of all numbers : " + getSum(integers));
        System.out.println("Average of all numbers : " + getAverage(integers));

        // output 10 random integers
        System.out.println("Random numbers.");
        Random random = new Random();
        for(int i=0; i<10; i++){
            System.out.println(random.nextInt());
        }

        System.out.println("Using Java 8: ");
        System.out.println("List: " +strings);
        // count the number of non empty strings
        count = strings.stream().filter(string -> !string.isEmpty()).count();
        System.out.println("Non empty Strings: " + count);
        count = strings.parallelStream().filter(string -> !string.isEmpty()).count();
        System.out.println("Non empty Strings: " + count);
        // count the number of strings with length 3
        count_length3 = strings.stream().filter(string -> string.length()==3).count();
        System.out.println("Strings of length 3: " + count_length3);
        // remove empty string
        filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println("Filtered List: " + filtered);
        // merge the string list
        mergedString = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
        System.out.println("Merged string: " + mergedString);
        // remove duplicate and get square of the int array
        squaresList = numbers.stream().distinct().map(i -> i*i).collect(Collectors.toList());
        System.out.println("Filtered List: " + squaresList);
        // get max/min/sum/ave of the int array
        IntSummaryStatistics stats = integers.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println("List: " +integers);
        System.out.println("Highest number in List : " + stats.getMax());
        System.out.println("Lowest number in List : " + stats.getMin());
        System.out.println("Sum of all numbers : " + stats.getSum());
        System.out.println("Average of all numbers : " + stats.getAverage());

        random.ints().limit(10).sorted().forEach(System.out::println);

    }
    private static int getCountEmptyStringUsingJava7(List<String> strings){
        int count = 0;
        for (String string : strings){
            if(!string.isEmpty()){
                count++;
            }
        }
        return count;
    }
    private static int getCountLength3UsingJava7(List<String> strings){
        int count = 0;
        for (String string : strings){
            if(string.length() == 3){
                count++;
            }
        }
        return count;
    }
    private static List<String> deleteEmptyStringsUsingJava7(List<String> strings){
        List<String> filteredList = new ArrayList<String>();
        for (String string : strings){
            if(!string.isEmpty()){
                filteredList.add(string);
            }
        }
        return filteredList;
    }
    private static String getMergedStringUsingJava7(List<String> strings, String seperator){
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : strings){
            if(!string.isEmpty()){
                stringBuilder.append(string);
                stringBuilder.append(seperator);
            }
        }
        String mergedString = stringBuilder.toString();
        return mergedString.substring(0, mergedString.length()-2); //?????
    }
    private static List<Integer> getSquares(List<Integer> numbers){
        List<Integer> squaresList = new ArrayList<>();
        for (Integer number : numbers){
            Integer square = number * number;
            if (!squaresList.contains(square)){
                squaresList.add(square);
            }
            }
        return squaresList;
    }
    private static int getMax(List<Integer> integers){
        int max = integers.get(0);
        for (Integer integer : integers){
            if(integer > max){
                max = integer;
            }
        }
        return max;
    }
    private static int getMin(List<Integer> integers){
        int min = integers.get(0);
        for (Integer integer : integers){
            if(integer < min){
                min = integer;
            }
        }
        return min;
    }
    private static int getSum(List<Integer> integers){
        int sum = 0;
        for (Integer integer : integers){
            sum += integer;
        }
        return sum;
    }
    private static int getAverage(List<Integer> integers){
        return getSum(integers) / integers.size();
    }
}
