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

		// �����ŕێ����Ă����K���Ȓl�����Ƃ�stream���쐬�B�{��Stream.of()���g���Εs�v�������K�ł���Ă݂��B
		System.out.println(myStream.stream().collect(Collectors.joining(",")));

		// �����ɉ�����stream���쐬�B�{��Stream.of()���g���Εs�v�������K�ł���Ă݂��B
		System.out.println(myStream.stream("AAA", "BBB", "CCC").collect(Collectors.joining(",")));

		// Reader��n����Stream���쐬�B
		String str = String.join("\n", "abc", "def", "ghi");
		try (StringReader reader = new StringReader(str); BufferedReader br = new BufferedReader(reader);) {

			Stream<String> stream = myStream.stream(br);
			stream.forEach(System.out::println);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
