import java.io.File;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.stream.Collectors;
import java.util.stream.IntStream;



public class Run {
    public static void main(String[] args) {
        String fileName = "day1.txt";
        File file = new File(fileName);
        final var left = new ArrayList<Integer>();
        final var right = new ArrayList<Integer>();

        try {
        Files.lines(file.toPath())
        .forEach(line -> {
            final String[] values = line.split("   ");
            left.add(Integer.parseInt(values[0]));
            right.add(Integer.parseInt(values[1]));

        });
        } catch(final Exception e) {
            System.out.println(e);
        }

        final var rList = right.stream().sorted().toList();
        final var lList = left.stream().sorted().toList();
        final var range = IntStream.range(0, rList.size());
        //Distance a
        System.out.println(range.map(i -> Math.abs(rList.get(i) - lList.get(i)))
        .sum());

        //Total similarity b
        System.out.println(lList.stream()
        .map(l -> rList.stream().filter(r -> r.equals(l)).count() * l)
        .reduce(0L, Long::sum));
}

}