package user.file;

public interface FileUserDB {
	String DATA_FILE = "./data/UserDB";
	void saveUsers();
	void loadUsers();
}
