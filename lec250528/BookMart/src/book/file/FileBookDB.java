package book.file;

public interface FileBookDB {
	String DATA_FILE = "./data/bookDB";
	void saveBooks();
	void loadBooks();
}
