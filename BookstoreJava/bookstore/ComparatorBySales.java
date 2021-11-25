package bookstore;
import java.util.Comparator;

/**
 * Classe que implementa o método compare entre dois objectos
 * @param <Book> o tipo de objectos a ser comparado
 */
public class ComparatorBySales implements Comparator<Book>{

	@Override
	public int compare(Book b1, Book b2) {
		int sales1 = b1.sales();
		int sales2 = b2.sales();
		
		if (sales1 > sales2)
			return -1;
		else if (sales1 < sales2)
			return 1;
		else // sales1 == sales2
			return b1.isbn().compareTo(b1.isbn());
	}
}
