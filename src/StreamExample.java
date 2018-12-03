import classes.Pessoa;

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

        List<String> items = new ArrayList<String>();
        items.add("um");
        items.add("dois");
        items.add("dois");
        items.add("doze");

        List<Pessoa> pessoas = Arrays.asList(new Pessoa("1", "Leonardo", Arrays.asList("123","456")), new Pessoa("2", "Leandro", Arrays.asList("789","987")));

        // CRIANDO UM STREAM (parallelStream(), possibilitará paralelizar o seu processamento, oferecendo maior eficiência ao processamento).
        Stream<String> stream = items.stream();

        // CRIAÇÃO DE STREAM A PARTIR DE I/O, ARRAYS E VALORES.
        //StreamExample <String> lines= Files.lines(Paths.get(“myFile.txt”), Charset.defaultCharset());
        Stream<Integer> numbersFromValues = Stream.of(1, 2, 3, 4, 5);
        IntStream numbersFromArray = Arrays.stream(new int[] {1, 2, 3, 4, 5});

        // USANDO DISTINCT
        long count = items.stream().distinct().count();
        boolean isExist =  items.stream().anyMatch(element -> element.contains("um"));
        System.out.println(count);
        System.out.println(isExist);

        // Teste para filtrar e achar o primeiro ou retornar "".
        String item = items.stream().filter(s -> s.length() > 3).sorted().findFirst().orElse("");
        System.out.println(item);

        // CRIAÇÃO DE STREAM USANDO MAP (um elemento dentro de um objeto) AND FLATMAP (uma lista de elementos dentro de um objeto)
        Stream<String> streamNomes = pessoas.stream().map(uri -> uri.getName());
        streamNomes.forEach(p -> System.out.println(p));
        Stream<String> streamTelefones = pessoas.stream().flatMap(uri -> uri.getTelefones().stream());
        streamTelefones.forEach(p -> System.out.println(p));

        boolean isValidOne = items.stream().anyMatch(element -> element.contains("do")); // true
        boolean isValidTwo = items.stream().allMatch(element -> element.contains("doze")); // false
        boolean isValidThree = items.stream().noneMatch(element -> element.contains("doze")); // false
        System.out.println(isValidOne);
        System.out.println(isValidTwo);
        System.out.println(isValidThree);

    }
}
