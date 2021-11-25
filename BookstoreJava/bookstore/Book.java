package bookstore;

/**
 * @author carlaferreira
 * 
 */

public interface Book extends Comparable<Book>  {
	/**
	 * @return isbn do livro
	 */
	String isbn();
	
	/**
	 * @return editora do livro
	 */
	String publisher();
	
	/**
	 * @return autor do livro
	 */
	String author();
	
	/**
	 * @return titulo do livro
	 */
	String title();
	
	/**
	 * @return numero de livros vendidos
	 */
	int sales();
	
	/**
	 * Regista a venda da quantidade <code>amount</code> de livros 
	 * @param amount quantidade de livros vendidos
	 * @return numero total de vendas 
	 */
	int increaseSales(int amount);
}
