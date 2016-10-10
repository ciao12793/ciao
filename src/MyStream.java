import java.io.BufferedReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class MyStream {

	private String[] array = { "aaa", "bbb", "ccc", "ddd", "eee" };

	public Stream<String> stream() {
		return stream(array);
	}

	public Stream<String> stream(String... array) {

		Iterator<String> iterator = new Iterator<String>() {
			int i = 0;

			@Override
			public boolean hasNext() {
				return i < array.length - 1;
			}

			@Override
			public String next() {
				if (hasNext()) {
					i++;
					return array[i - 1];
				}
				return null;
			}
		};

		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED | Spliterator.IMMUTABLE), false);
	}

	public Stream<String> stream(BufferedReader br) {

		Iterator<String> iterator = new Iterator<String>() {
			String line = null;

			@Override
			public boolean hasNext() {
				try {
					line = br.readLine();
				} catch (IOException e) {
					throw new IllegalStateException(e);
				}

				return line != null;
			}

			@Override
			public String next() {
				return line;
			}
		};

		return StreamSupport.stream(
				Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED | Spliterator.IMMUTABLE), false);
	}

}
