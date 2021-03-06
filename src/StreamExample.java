import classes.Pessoa;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    
    public static void main(String[] args) {

        List<String> items = new ArrayList<String>();
        items.add("um");
        items.add("dois");
        items.add("dois");
        items.add("doze");

        List<Pessoa> pessoas = Arrays.asList(
                new Pessoa(1, "Leonardo", Arrays.asList("123","456")),
                new Pessoa(2, "Leandro", Arrays.asList("789","987")),
                new Pessoa(3, "Leonardo", Arrays.asList("123","456")));

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

        // USANDO REDUCE
        List<Integer> integers = Arrays.asList(1, 1, 1);
        Integer reduced = integers.stream().reduce(23, (a, b) -> a + b);
        Optional<Integer> cleanReduced = integers.stream().reduce((a, b) -> a + b);

        // USANDO MÉTRICAS MATEMATICAS
        double averagePrice = pessoas.stream().collect(Collectors.averagingInt(Pessoa::getId));
        int summingPrice = pessoas.stream().collect(Collectors.summingInt(Pessoa::getId));
        IntSummaryStatistics statistics = pessoas.stream().collect(Collectors.summarizingInt(Pessoa::getId));
        System.out.println(averagePrice);
        System.out.println(summingPrice);
        System.out.println(statistics);

        // OUTRAS IMPLEMENTAÇÕES
        System.out.println(pessoas.contains(new Pessoa(1, "Leonardo", Arrays.asList("123","456"))));
        pessoas.sort(Comparator.comparing(Pessoa::getId).reversed());
        pessoas.forEach(p -> System.out.println(p.getId()));

        pessoas.stream().sorted(Comparator.comparing(Pessoa::getId)).forEach(p -> System.out.println(p.getName()));

        List repetidos = new ArrayList();
        IntStream.range(0, pessoas.size()).sorted().forEach(p-> {
            pessoas.sort(Comparator.comparing(Pessoa::getName));
            if(p < pessoas.size()-1){
                if(pessoas.get(p).getName().equalsIgnoreCase(pessoas.get(p+1).getName())){
                    repetidos.add(pessoas.get(p).getName());
                }
            }
        });
        System.out.println(repetidos.stream().distinct().count());

        pessoas.sort(Comparator.comparingInt(a -> a.getName().length()));
        System.out.println(pessoas.get(0).getName());
    }
}
