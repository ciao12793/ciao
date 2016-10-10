import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {

	public static void main(String[] args) {
		new Main();
	}

	public Main() {

		MyStream myStream = new MyStream();

		// 内部で保持していた適当な値をもとにstreamを作成。本来Stream.of()を使えば不要だが練習でやってみた。
		System.out.println(myStream.stream().collect(Collectors.joining(",")));

		// 引数に応じたstreamを作成。本来Stream.of()を使えば不要だが練習でやってみた。
		System.out.println(myStream.stream("AAA", "BBB", "CCC").collect(Collectors.joining(",")));

		// Readerを渡してStreamを作成。
		String str = String.join("\n", "abc", "def", "ghi");
		try (StringReader reader = new StringReader(str); BufferedReader br = new BufferedReader(reader);) {

			Stream<String> stream = myStream.stream(br);
			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
