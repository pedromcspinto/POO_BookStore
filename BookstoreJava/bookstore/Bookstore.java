package bookstore;

import java.util.Iterator;

import bookstore.exceptions.*;

public interface Bookstore {
	
	/**
	 * Adiciona um livro 'a livraria
	 * @param isbn identificador unico do livro
	 * @param author autor do livro
	 * @param title titulo do livro
	 * @param publisher editora do livro
	 * @throws BookAlreadyExistsException se ja existir um livro com isbn dado
	 */
	void addBook(String isbn, String author, String title, String publisher) throws BookAlreadyExistsException;
	
	/**
	 * Dado um isbn devolve o autor do livro associado a esse isbn
	 * @param isbn identificador unico do livro
	 * @return autor do livro
	 * @throws BookDoesNotExistException se nao existir um livro com isbn dado
	 */
	String author(String isbn) throws BookDoesNotExistException;
	
	/**
	 * Dado um isbn devolve o titulo do livro associado a esse isbn
	 * @param isbn identificador unico do livro
	 * @return titulo do livro
	 * @throws BookDoesNotExistException se nao existir um livro com isbn dado
	 */
	String title(String isbn) throws BookDoesNotExistException;
	
	/**
	 * Dado um isbn devolve as vendas do livro associado a esse isbn
	 * @param isbn identificador unico do livro
	 * @return vendas do livro
	 * @throws BookDoesNotExistException se nao existir um livro com isbn dado
	 */
	int sales(String isbn) throws BookDoesNotExistException;
	
	/**
	 * Dado um isbn devolve regista as vendas do livro na quantidade <code>amount</code>
	 * @param isbn identificador unico do livro
	 * @param amount quantidade de livros vendidos
	 * @return vendas totais do livro apos actualizacao
	 * @throws BookDoesNotExistException se nao existir um livro com isbn dado
	 */
	int increaseSales(String isbn, int amount)  throws BookDoesNotExistException;
	
	/**
	 * Devolve o livro mais vendido da livraria
	 * @return livro mais vendido
	 * @throws NoTopSellerException se nao existir um livro com vendas
	 */
	Book topSeller() throws NoTopSellerException;
	
	/**
	 * Devolve um iterador para os livros da livraria do autor <code>author</code>
	 * ordenados por ordem de inserção
	 * @param author autor do livro
	 * @return iterador para todos os livros da livraria de um dado autor
	 */
	Iterator<Book> listBooksByAuthor(String author) throws AuthorDoesNotExist;
	
	/**
	 * Devolve um iterador para os livros ordenados por vendas
	 * ordenados de forma decrescente de vendas e depois por isbn
	 * @return iterador para todos os livros da livraria ordenados por vendas
	 */
	Iterator<Book> listBooksBySales();
	
	/**
	 * Devolve um iterador para os livros da livraria ordenados por titulo e depois por autor
	 * @return iterador para todos os livros da livraria
	 */
	Iterator<Book> listAll();
	
	/**
	 * Devolve um iterador para os livros da editora <code>publisher</code>
	 * ordenados por author e depois por ordem alfabetica do titulo 
	 * (ordem natural dos objectos Book) 
	 * @param author autor do livro
	 * @return iterador para todos os livros da livraria de um dado editor
	 */
	Iterator<Book> listBooksByPublisher(String publisher) throws PublisherDoesNotExist;
}
