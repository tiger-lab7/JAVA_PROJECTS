import java.util.*;
import java.nio.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
//import java.nio.charset.StandartCharset;
import java.util.stream.Stream;
import java.io.*;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.stream.Collectors;


public class Streams {
	
	public static void main(String... args) {
		Path path = Paths.get("C:/Users/Dopoln Literature.txt");

		try (Stream<String> strStream = Files.lines(path)) {
			Map<Integer, List<String>> result = strStream
				//.peek(System.out::println)
				.filter(str -> { return str.matches(".*20.*"); })
				//.collect(Collectors.groupingBy(str -> { return str.length(); }));
				.collect(Collectors.groupingBy(String::length));

			NavigableMap<Integer, List<String>> orderedMap = new TreeMap<>(result);

			//System.out.println("MAX VALUE: " + orderedMap.max());

			try (FileOutputStream fos = new FileOutputStream(new File("C:/Output.txt"))) {
				ObjectOutputStream oos = new ObjectOutputStream(fos);
				oos.writeObject(orderedMap);
			} 

			try (FileInputStream fis = new FileInputStream(new File("C:/Output.txt"))) {
				ObjectInputStream ois = new ObjectInputStream(fis);
				var orderedMapRestored = (TreeMap<Integer, List<String>>)ois.readObject();
				orderedMapRestored.forEach((key, value) -> {
					System.out.println(key + " " + value); } );
			} 

			new File("C:/Output.txt").delete();  

			
		} catch (ClassNotFoundException | IOException ex) { ex.printStackTrace(); }
	}
}