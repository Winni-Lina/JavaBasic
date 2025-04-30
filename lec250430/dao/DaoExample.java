package lec250430.dao;

public class DaoExample {
	public static void dbWord(DataAccessObject dao) {
		dao.select();
		dao.insert();
		dao.update();
		dao.delete();
	}
	
	public static void main(String[] args) {
		dbWord(new OracleDao());
		dbWord(new MySqlDao());
	}
}
