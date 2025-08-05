package Java8;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class Java8CodeSnippets {

	public static void main(String[] args) {
		simpleRunnable();
		iterateList();
		filterList();
		sortList();
		customFI();
		mapIteration();
		createThread();
		lambdaComparator();
		methodReference();
		lambdaOptional();
		lambdaPredicate();
		lambdaBiFunction();
		lambdaConsumer();
		lambdaSupplier();
		lambdaFunction();
		lambdaUnary();
		lambdaBinary();
		lambdaEvenNumbers();
		
	}

	private static void lambdaEvenNumbers() {
		Predicate<Integer> isEven = x -> x % 2 == 0;
		System.out.println(isEven.test(2));
		System.out.println(isEven.test(3));
	}

	private static void lambdaBinary() {
		BinaryOperator<Integer> multiply = (a, b) -> a * b;
		System.out.println(multiply.apply(2, 3));
	}

	private static void lambdaUnary() {
		UnaryOperator<Integer> square = x -> x * x;
		System.out.println(square.apply(5));
	}

	private static void lambdaFunction() {
		Function<String, Integer> length = s -> s.length();
		System.out.println(length.apply("Lambda"));
	}

	private static void lambdaSupplier() {
		Supplier<String> supplier = () -> "Java";
		System.out.println(supplier.get());
	}

	private static void lambdaConsumer() {
		Consumer<String> print = s -> System.out.println(s);
		print.accept("Hello");
	}

	private static void lambdaBiFunction() {
		BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
		System.out.println(add.apply(2, 3));
	}

	private static void lambdaPredicate() {
		Predicate<String> isEmpty = s -> s.isEmpty();
		System.out.println(isEmpty.test(""));
		System.out.println(isEmpty.test("Java"));
	}

	private static void lambdaOptional() {
		Optional<String> optional = Optional.of("Java");
		optional.ifPresent(s -> System.out.println("Value is present: " + s));
	}

	private static void methodReference() {
		List<String> list = Arrays.asList("Java", "Javascript", "Spring", "JPA");
		list.forEach(System.out::println);
	}

	private static void lambdaComparator() {
		List<String> list = Arrays.asList("Java", "Javascript", "Spring", "JPA");
		list.sort(Comparator.comparingInt(String::length));
		list.forEach(System.out::println);
	}

	private static void createThread() {
		new Thread(() -> System.out.println("Thread with lambda")).start();;
	}

	private static void mapIteration() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("Java", 8);
		map.put("Spring", 5);
		map.put("Lambda", 1);
		
		map.forEach((key, value) -> System.out.println(key + ":" + value));
	}

	private static void customFI() {
		Calculator add = (a, b) -> a + b;
		System.out.println("Addition: " + add.calculate(5, 3));
	}

	private static void sortList() {
		List<String> list = Arrays.asList("Java", "Javascript", "Spring", "JPA");
		list.sort((s1, s2) -> s1.compareTo(s2));
		list.forEach(System.out::println);
	}

	private static void filterList() {
		List<String> list = Arrays.asList("Java", "Javascript", "Spring", "JPA");
		List<String> filteredList = list.stream()
									.filter(s -> s.startsWith("J"))
									.collect(Collectors.toList());
		filteredList.forEach(System.out::println);
	}

	private static void iterateList() {
		List<String> list = Arrays.asList("Ariv", "Eroms", "Ilamathi", "Asai");
		list.forEach(item -> System.out.println(item));
	}

	private static void simpleRunnable() {
		Runnable r = () -> System.out.println("Hello Lambda");
		new Thread(r).start();
	}
}

