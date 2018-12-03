import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    // A proposta em torno da Streams API é reduzir a preocupação do desenvolvedor com a forma de implementar controle de fluxo ao lidar com coleções, deixando isso a cargo da API.

    public static void main(String[] args) {

        // https://bit.ly/2rkJHSy
        // https://bit.ly/2SprEGk

        // CRIANDO UM STREAM (parallelStream(), possibilitará paralelizar o seu processamento, oferecendo maior eficiência ao processamento).
            List<String> items = new ArrayList<String>();
            items.add("um");
            items.add("dois");
            items.add("dois");
            items.add("dezoito");
            Stream<String> stream = items.stream();

        // CRIAÇÃO DE STREAM A PARTIR DE I/O, ARRAYS E VALORES.
            //StreamExample <String> lines= Files.lines(Paths.get(“myFile.txt”), Charset.defaultCharset());
            Stream<Integer> numbersFromValues = Stream.of(1, 2, 3, 4, 5);
            IntStream numbersFromArray = Arrays.stream(new int[] {1, 2, 3, 4, 5});

         // USANDO DISTINCT
            long count = items.stream().distinct().count();
            boolean isExist =  items.stream().anyMatch(element -> element.contains("um"));

            // Teste para filtrar e achar o primeiro.
            String item = items.stream().filter(s -> s.length() > 3).sorted().findFirst().orElse("");

            System.out.println(count);
            System.out.println(count);
            System.out.println(isExist);

    }
}
