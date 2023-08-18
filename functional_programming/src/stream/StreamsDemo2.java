package stream;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamsDemo2 {

	public static void main(String[] args) throws IOException {

		// Stream from values
		Stream<String> streamFromValues = Stream.of("a1", "a2", "a3");
		System.out.println("Stream from values: " + streamFromValues.collect(Collectors.toList()));

		// Stream from array
		String[] array = { "A1", "A2", "A3", "A4" };
		Stream<String> streamFromArrays = Arrays.stream(array);
		System.out.println("Stream from arrays: " + streamFromArrays.collect(Collectors.toList()));

		Stream<String> streamFromArrays2 = Stream.of(array);
		System.out.println("Stream from arrays v2: " + streamFromArrays2.collect(Collectors.toList()));

		// Stream from file
		File file = new File("1.tmp");
		file.deleteOnExit();
		PrintWriter out = new PrintWriter(file);
		out.println("a1");
		out.println("a2");
		out.println("a3");
		out.close();

		Stream<String> streamFromFile = Files.lines(Paths.get(file.getAbsolutePath()));
		System.out.println("Stream from file: " + streamFromFile.collect(Collectors.toList()));

		// Stream from Collection
		Collection<String> collection = Arrays.asList("A1", "A2", "A3", "A4");
		Stream<String> streamFromCollection = collection.stream();
		System.out.println("Stream from collection: " + streamFromCollection.collect(Collectors.toList()));

		// Numeric stream from String
		IntStream streamFromString = "123".chars();
		System.out.print("Stream from String: ");
		streamFromString.forEach(e -> System.out.print(e + ", "));

		// With the help Stream.builder
		System.out.println();
		Stream.Builder<String> builder = Stream.builder();
		Stream<String> streamFromBuilder = builder.add("a1").add("a2").add("a3").build();
		System.out.println("Stream from builder: " + streamFromBuilder.collect(Collectors.toList()));

		// Infinite Streams
		// Stream.iterate
//		Stream<Integer> streamFromIterate = Stream.iterate(1, n -> n + 2);
//		System.out.println("Stream from iterate: " + streamFromIterate.collect(Collectors.toList()));

		// Stream.generate
//		Stream<String> streamFromGenerate = Stream.generate(() -> "a1");
//		System.out.println("Stream from generate: " + streamFromGenerate.collect(Collectors.toList()));

		// Empty Stream
		Stream<String> streamEmpty = Stream.empty();
		System.out.println("Empty stream: " + streamEmpty.collect(Collectors.toList()));

		// Parallel Stream
		Stream<String> parallelStream = collection.parallelStream();
		System.out.println("Parallel stream: " + parallelStream.collect(Collectors.toList()));

		testFilterAndCount();
		findFirstSkipCount();
		testLimit();
		testDistinct();
		testMatch();
		testMap();
		testMapToInt();
		testFlatMap();
		testFlatMapToInt();
		testSorted();
		testMinMax();
		testForSearch();
		testPeek();
		testReduce();
		testCollect();
	}

	private static void testCollect() {
		System.out.println("\nTest collect start");
		Collection<String> strings = Arrays.asList("a1", "b2", "c3", "a1");

		List<String> distinct = strings.stream().distinct().collect(Collectors.toList());
		System.out.println("Distinct: " + distinct);

		String[] array = strings.stream().distinct().map(String::toUpperCase).toArray(String[]::new);
		System.out.println("Array: " + Arrays.asList(array));

		String join = strings.stream().collect(Collectors.joining(" : ", "<b> ", "</b>"));
		System.out.println("Join: " + join);

		Map<String, String> map = strings.stream().distinct()
				.collect(Collectors.toMap(p -> p.substring(0, 1), p -> p.substring(1, 2)));
		System.out.println("Map: " + map);

		Map<String, List<String>> groups = strings.stream().collect(Collectors.groupingBy(p -> p.substring(0, 1)));
		System.out.println("Groups: " + groups);

		Map<String, String> groupJoin = strings.stream().collect(Collectors.groupingBy(p -> p.substring(0, 1),
				Collectors.mapping(p -> p.substring(1, 2), Collectors.joining(":"))));
		System.out.println("Group by: " + groupJoin);

		Collection<Integer> numbers = Arrays.asList(1, 2, 3, 4);

		long sumOdd = numbers.stream().collect(Collectors.summingInt(p -> p % 2 == 1 ? p : 0));
		System.out.println("Sum odd: " + sumOdd);

		double average = numbers.stream().collect(Collectors.averagingInt(p -> p - 1));
		System.out.println("Average: " + average);

		IntSummaryStatistics statistics = numbers.stream().collect(Collectors.summarizingInt(p -> p + 3));
		System.out.println("Statistics: " + statistics);

		long sumEven = numbers.stream().collect(Collectors.summarizingInt(p -> p % 2 == 0 ? p : 0)).getSum();
		System.out.println("Sum even: " + sumEven);

		Map<Boolean, List<Integer>> parts = numbers.stream().collect(Collectors.partitioningBy(p -> p % 2 == 0));
		System.out.println("Parts: " + parts);
	}

	private static void testReduce() {
		System.out.println("\nTest reduce start");

		Collection<Integer> collection = Arrays.asList(1, 2, 3, 4, 2);
		Integer sum = collection.stream().reduce((s1, s2) -> s1 + s2).orElse(0);
		Integer sumOld = 0;
		for (Integer integer : collection) {
			sumOld += integer;
		}
		System.out.println("Sum: " + sum + " : " + sumOld);

		Integer max1 = collection.stream().reduce((s1, s2) -> s1 > s2 ? s1 : s2).orElse(0);
		Integer max2 = collection.stream().reduce(Integer::max).orElse(0);
		Integer maxOld = null;

		for (Integer i : collection) {
			maxOld = maxOld != null && maxOld > i ? maxOld : i;
		}
		maxOld = maxOld == null ? 0 : maxOld;
		System.out.println("Max: " + max1 + " : " + max2 + " : " + maxOld);

		Integer min = collection.stream().reduce((s1, s2) -> s1 < s2 ? s1 : s2).orElse(0);
		Integer minOld = null;
		for (Integer integer : collection) {
			minOld = minOld != null && minOld < integer ? minOld : integer;
		}
		minOld = minOld == null ? 0 : minOld;
		System.out.println("Min: " + min + " : " + minOld);

		Integer last = collection.stream().reduce((s1, s2) -> s2).orElse(0);
		Integer lastOld = null;
		for (Integer integer : collection) {
			lastOld = integer;
		}
		lastOld = lastOld == null ? 0 : lastOld;
		System.out.println("Last: " + last + " : " + lastOld);

		Integer sumMore2 = collection.stream().filter(o -> o > 2).reduce((s1, s2) -> s1 + s2).orElse(0);
		Integer sumMore2Old = 0;
		for (Integer integer : collection) {
			if (integer > 2)
				sumMore2 += integer;
		}
		System.out.println("SumMore2: " + sumMore2 + " : " + sumMore2Old);

		Integer sumOdd = collection.stream().filter(o -> o % 2 != 0).reduce((s1, s2) -> s1 + s2).orElse(0);
		Integer sumOddOld = 0;
		for (Integer integer : collection) {
			if (integer % 2 != 0)
				sumOddOld += integer;
		}
		System.out.println("SumOdd: " + sumOdd + " : " + sumOddOld);

		Collection<People> peoples = Arrays.asList(new People("William", 16, Sex.MAN), new People("John", 23, Sex.MAN),
				new People("Helen", 42, Sex.WOMEN), new People("Peter", 69, Sex.MAN));

		int oldManAge = peoples.stream().filter(p -> p.getSex() == Sex.MAN).map(People::getAge)
				.reduce((s1, s2) -> s1 > s2 ? s1 : s2).get();
		System.out.println("Old man age: " + oldManAge);

		int youngerAge = peoples.stream().filter(p -> p.getName().contains("e")).mapToInt(People::getAge)
				.reduce((s1, s2) -> s1 < s2 ? s1 : s2).orElse(0);
		System.out.println("Younger age: " + youngerAge);
	}

	private static void testPeek() {
		System.out.println("\nTest peek started");
		Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
		System.out.print("Peak1: ");
		List<String> peek = collection.stream().map(String::toUpperCase).peek(e -> System.out.print(e + " "))
				.collect(Collectors.toList());

		System.out.println();
		System.out.println("Peek2: " + peek);

		Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"),
				new StringBuilder("a3"));
		List<StringBuilder> newList = list.stream().peek(p -> p.append("_new")).collect(Collectors.toList());
		System.out.println("Newu list: " + newList);
	}

	private static void testForSearch() {
		System.out.println("\nFor search started");
		Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
		System.out.print("forEach = ");
		collection.stream().map(String::toUpperCase).forEach(e -> System.out.print(e + ", "));

		System.out.println();
		Collection<StringBuilder> list = Arrays.asList(new StringBuilder("a1"), new StringBuilder("a2"),
				new StringBuilder("a3"));
		list.stream().forEachOrdered(p -> p.append("_new"));
		System.out.println("forEachOrderd: " + list);
	}

	private static void testMinMax() {
		System.out.println("\nTest min - max started");
		Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

		String max = collection.stream().max(String::compareTo).get();
		System.out.println("Max: " + max);

		String min = collection.stream().min(String::compareTo).get();
		System.out.println("Min: " + min);

		Collection<People> peoples = Arrays.asList(new People("William", 16, Sex.MAN), new People("John", 23, Sex.MAN),
				new People("Helen", 42, Sex.WOMEN), new People("Peter", 69, Sex.MAN));

		People oldestPerson = peoples.stream().max((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();
		System.out.println("Oldest person: " + oldestPerson);

		People youngestPerson = peoples.stream().min((p1, p2) -> p1.getAge().compareTo(p2.getAge())).get();
		System.out.println("Youngest person: " + youngestPerson);
	}

	private static void testSorted() {
		System.out.println("\nTest sorted started");
		Collection<String> collection = Arrays.asList("a6", "a1", "a2", "a2", "a3", "a1", "a2", "a3", "a4");

		List<String> sorted = collection.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted: " + sorted);

		List<String> sortedDistinct = collection.stream().sorted().distinct().collect(Collectors.toList());
		System.out.println("Sorted distinct: " + sortedDistinct);

		List<String> sortedReverse = collection.stream().sorted((s1, s2) -> -s1.compareTo(s2))
				.collect(Collectors.toList());
		System.out.println("Sorted reverse: " + sortedReverse);

		List<String> distinctReverse = collection.stream().sorted((s1, s2) -> -s1.compareTo(s2)).distinct()
				.collect(Collectors.toList());
		System.out.println("Distinct reverse: " + distinctReverse);

		Collection<People> peoples = Arrays.asList(new People("William", 16, Sex.MAN), new People("John", 23, Sex.MAN),
				new People("Helen", 42, Sex.WOMEN), new People("Peter", 69, Sex.MAN));

		Collection<People> byName = peoples.stream().sorted((p1, p2) -> -p1.getName().compareTo(p2.getName()))
				.collect(Collectors.toList());
		System.out.println("By name: ");
		for (People people : byName) {
			System.out.println(" " + people);
		}

		Collection<People> bySexAndAge = peoples.stream()
				.sorted((o1, o2) -> o1.getSex() != o2.getSex() ? o1.getSex().compareTo(o2.getSex())
						: o1.getAge().compareTo(o2.getAge()))
				.collect(Collectors.toList());
		System.out.println("By sex and age: ");
		for (People people : bySexAndAge) {
			System.out.println(" " + people);
		}
	}

	private static void testFlatMapToInt() {
		System.out.println("\nTest flat map to int started");
		Collection<String> collection = Arrays.asList("1,2,0", "4,5");
		int sum = collection.stream()
				.flatMapToInt(p -> Arrays.asList(p.split(",")).stream().mapToInt(Integer::parseInt)).sum();
		System.out.println("Sum: " + sum);
	}

	private static void testFlatMap() {
		System.out.println("\nTest flat map started");
		Collection<String> collection = Arrays.asList("1,2,0", "4,5");
		String[] number = collection.stream().flatMap((p) -> Arrays.asList(p.split(",")).stream())
				.toArray(String[]::new);
		System.out.println("Number: " + number);
	}

	private static void testMapToInt() {
		System.out.println("\nTest map to int started");
		Collection<String> collection = Arrays.asList("a6", "a1", "a2", "a2", "a3", "a1", "a2", "a3", "a4");
		int[] number = collection.stream().mapToInt(s -> Integer.parseInt(s.substring(1))).toArray();
		System.out.println("Number: " + Arrays.toString(number));
	}

	private static void testMap() {
		System.out.println("\nTest map started");
		Collection<String> collection = Arrays.asList("a6", "a1", "a2", "a2", "a3", "a1", "a2", "a3", "a4");
		List<String> transform = collection.stream().map(s -> s + "_1").collect(Collectors.toList());
		System.out.println("Transform: " + transform);

		List<Integer> number = collection.stream().map(s -> Integer.parseInt(s.substring(1)))
				.collect(Collectors.toList());
		System.out.println("Number: " + number);
	}

	private static void testMatch() {
		System.out.println("\nTest matched started");
		System.out.println("Test anyMatch, allMatch, noneMatch  start");
		Collection<String> collection = Arrays.asList("a6", "a1", "a2", "a2", "a3", "a1", "a2", "a3", "a4");

		boolean isAnyOneTrue = collection.stream().anyMatch("a1"::equals);
		System.out.println("isAnyOneTrue: " + isAnyOneTrue);
		boolean isAnyOneFalse = collection.stream().anyMatch("a8"::equals);
		System.out.println("isAnyOneTrue: " + isAnyOneFalse);

		boolean isAll = collection.stream().allMatch(s -> s.contains("1"));
		System.out.println("isAll: " + isAll);

		boolean isNotEquals = collection.stream().noneMatch("a7"::equals);
		System.out.println("isNotEquals: " + isNotEquals);
	}

	private static void testDistinct() {

		System.out.println("\nTest distinct started");
		Collection<String> notOrdered = Arrays.asList("a6", "a1", "a2", "a2", "a3", "a1", "a2", "a3", "a4");
		Collection<String> ordered = new HashSet<String>(notOrdered);

		List<String> distinct = notOrdered.stream().distinct().collect(Collectors.toList());
		System.out.println("Distinct: " + distinct);

		List<String> distinctOrdered = ordered.stream().distinct().collect(Collectors.toList());
		System.out.println("Distinct ordered: " + distinctOrdered);
	}

	private static void testLimit() {
		System.out.println("\nTest limit started");
		Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");

		List<String> limit = collection.stream().limit(2).collect(Collectors.toList());
		System.out.println("Limit: " + limit);

		List<String> fromTo = collection.stream().skip(1).limit(2).collect(Collectors.toList());
		System.out.println("From to: " + fromTo);

		String last = collection.stream().skip(collection.size() - 1).findAny().orElse("1");
		System.out.println("Last: " + last);
	}

	private static void findFirstSkipCount() {
		Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
		System.out.println();
		System.out.println("Test find first and skip start");
		String first = collection.stream().findFirst().orElse("1");
		System.out.println("First: " + first);

		String last = collection.stream().skip(collection.size() - 1).findAny().orElse("1");
		System.out.println("Last: " + last);

		String find = collection.stream().filter("a3"::equals).findFirst().get();
		System.out.println("Find: " + find);

		String third = collection.stream().skip(2).findFirst().get();
		System.out.println("Third: " + third);

		System.out.println();
		System.out.println("Test collect start");
		List<String> select = collection.stream().filter(p -> p.contains("1")).collect(Collectors.toList());
		System.out.println("Select: " + select);
	}

	private static void testFilterAndCount() {
		System.out.println();
		System.out.println("Test filter and count start");
		Collection<String> collection = Arrays.asList("a1", "a2", "a3", "a1");
		Collection<People> peoples = Arrays.asList(new People("Marcel", 28, Sex.MAN),
				new People("Georgica", 38, Sex.MAN), new People("Flori", 35, Sex.WOMEN),
				new People("Maria", 20, Sex.WOMEN));

		long count = collection.stream().filter("a1"::equals).count();
		System.out.println("Count for 'a1': " + count);

		List<String> select = collection.stream().filter(s -> s.contains("1")).collect(Collectors.toList());
		System.out.println("Select for '1': " + select);

		List<People> militaryService = peoples.stream()
				.filter(p -> p.getAge() >= 18 && p.getAge() < 29 && p.getSex() == Sex.MAN).collect(Collectors.toList());
		System.out.println("Military service: " + militaryService);

		double manAverageAge = peoples.stream().filter(p -> p.getSex() == Sex.MAN).mapToInt(People::getAge).average()
				.getAsDouble();
		System.out.println("Man average age: " + manAverageAge);

		long peopleHowCanWork = peoples.stream().filter(p -> p.getAge() >= 18)
				.filter(p -> p.getSex() == Sex.WOMEN && p.getAge() < 40 || p.getSex() == Sex.MAN && p.getAge() < 55)
				.count();
		System.out.println("Nr of people who can work: " + peopleHowCanWork);
	}

}

class People {

	private final String name;
	private final Integer age;
	private final Sex sex;

	public People(String name, Integer age, Sex sex) {
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public String getName() {
		return name;
	}

	public Integer getAge() {
		return age;
	}

	public Sex getSex() {
		return sex;
	}

	@Override
	public String toString() {
		return "People [name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name, sex);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		People other = (People) obj;
		return Objects.equals(age, other.age) && Objects.equals(name, other.name) && sex == other.sex;
	}

}

enum Sex {
	MAN, WOMEN;
}