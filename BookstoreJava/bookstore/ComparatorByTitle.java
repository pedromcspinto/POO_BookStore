package bookstore;
import java.util.Comparator;

/**
 * Classe que implementa o método compare entre dois objectos
 * @param <Book> o tipo de objectos a ser comparado
 */
public class ComparatorByTitle implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		//Comparacao por titulo e desempate por autor
		int comparacao = b1.title().compareTo(b2.title());
		if (comparacao == 0)
			return b1.author().compareTo(b2.author());
		else
			return comparacao;
	}
}
