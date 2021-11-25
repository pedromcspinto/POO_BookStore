package bookstore;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import bookstore.exceptions.*;

public class BookstoreClass implements Bookstore {
	private static final int NBOOKS = 200;
	private static final int NAUTHORS = 50;
	private static final int NPUBLISHERS = 10;
	
	private Map<String,Book> books;
	private Map<String,List<Book>> authors;
	private Map<String,SortedSet<Book>> publishers;
	private SortedSet<Book> booksBySales;
	private SortedSet<Book> booksByTitle;
	
	public BookstoreClass() {
		books =  new HashMap<>(NBOOKS);
		authors = new HashMap<>(NAUTHORS);
		publishers = new HashMap<>(NPUBLISHERS);
		booksBySales = new TreeSet<>(new ComparatorBySales());
		booksByTitle = new TreeSet<>(new ComparatorByTitle());
	}
	
	public void addBook(String isbn, String author, String title, String publisher) throws BookAlreadyExistsException {
		if (books.containsKey(isbn))
			throw new BookAlreadyExistsException();
		Book book = new BookClass(isbn,author,title,publisher);
		
		// Map<String,Book> books
		books.put(isbn,book);
		
		// SortedMap<String,SortedSet<Book>> authors
		List<Book> authorBooks = authors.get(author);
		if (authorBooks == null)
			authorBooks = new LinkedList<>();
		authorBooks.add(book);
		authors.put(author, authorBooks);
		
		//private Map<String,SortedSet<Book>> publishers;
		SortedSet<Book> publisherBooks = publishers.get(publisher);
		if (publisherBooks == null)
			publisherBooks = new TreeSet<Book>();
		publisherBooks.add(book);
		publishers.put(publisher, publisherBooks);
		
		//private SortedSet<Book> booksBySales;
		//not updated here 
		
		//private SortedSet<Book> booksByTitle;
		booksByTitle.add(book);
	}

	public String author(String isbn) throws BookDoesNotExistException {
		Book book = books.get(isbn);
		if (book == null) throw new BookDoesNotExistException();
		return book.author();
	}

	public String title(String isbn) throws BookDoesNotExistException {
		Book book = books.get(isbn);
		if (book == null) throw new BookDoesNotExistException();
		return book.title();
	}

	public int sales(String isbn) throws BookDoesNotExistException {
		Book book = books.get(isbn);
		if (book == null) throw new BookDoesNotExistException();
		return book.sales();
	}

	public int increaseSales(String isbn, int amount) throws BookDoesNotExistException {
		Book book = books.get(isbn);
		if (book == null) throw new BookDoesNotExistException();
		
		if (booksBySales.contains(book))
			booksBySales.remove(book);
		
		int sales = book.increaseSales(amount);
		
		booksBySales.add(book);
		return sales;
	}

	public Book topSeller() throws NoTopSellerException {
		if (booksBySales.isEmpty()) throw new NoTopSellerException();
		return booksBySales.first();
	}
	
	public Iterator<Book> listBooksByAuthor(String author) throws AuthorDoesNotExist {
		List<Book> set = authors.get(author);
		if (set == null)
			throw new AuthorDoesNotExist();
		return set.iterator();
	}
	
	public Iterator<Book> listBooksBySales() {
		if (booksBySales.isEmpty())
			return null;
 		return booksBySales.iterator();
	}

	public Iterator<Book> listAll() {
		return booksByTitle.iterator();
	}

	public Iterator<Book> listBooksByPublisher(String publisher) throws PublisherDoesNotExist {
		SortedSet<Book> set = publishers.get(publisher);
		if (set == null) 
			throw new PublisherDoesNotExist();
		return set.iterator();
	}
}
