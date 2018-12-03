import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

    // A proposta em torno da Streams API é reduzir a preocupação do desenvolvedor com a forma de implementar controle de fluxo ao lidar com coleções, deixando isso a cargo da API.

    public static void main(String[] args) {

        // https://bit.ly/2rkJHSy
        // https://bit.ly/2SprEGk

        /* CRIANDO UM STREAM (parallelStream(), possibilitará paralelizar o seu processamento, oferecendo maior eficiência ao processamento).
            List<String> items = new ArrayList<String>();
            items.add("um");
            items.add("dois");
            items.add("três");
            Stream<String> stream = items.stream();
        */

        /* CRIAÇÃO DE STREAM A PARTIR DE I/O, ARRAYS E VALORES.
            Stream <String> lines= Files.lines(Paths.get(“myFile.txt”),       Charset.defaultCharset());
            Stream<Integer> numbersFromValues = Stream.of(1, 2, 3, 4, 5);
            IntStream numbersFromArray = Arrays.stream(new int[] {1, 2, 3, 4, 5});
        */

        System.out.println("Java Studies");
    }
}
