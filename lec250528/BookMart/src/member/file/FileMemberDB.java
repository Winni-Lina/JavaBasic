package member.file;

public interface FileMemberDB {
	String DATA_FILE = "./data/member";
	void saveMembers();
	void loadMembers();
}
