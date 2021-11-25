package bookstore;

public class BookClass implements Book {
	private String isbn;
	private String author;
	private String title;
	private int sales;
	private String publisher;
	
	public BookClass(String isbn, String author, String title, String publisher) {
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.sales = 0;
		this.publisher = publisher;
	}

	@Override
	public String isbn() {
		return isbn;
	}

	@Override
	public String author() {
		return author;
	}

	@Override
	public String title() {
		return title;
	}

	@Override
	public int sales() {
		return sales;
	}
	
	@Override
	public int increaseSales(int amount) {
		sales += amount;
		return sales;
	}
	
	@Override
	public String publisher() {
		return publisher;
	}

	@Override
	public int compareTo(Book o) {
		//Comparacao por author e desempate por titulo
		int comparacao = this.author().compareTo(o.author());
		if (comparacao == 0)
			return this.title().compareTo(o.title());
		else
			return comparacao;
	}
}
