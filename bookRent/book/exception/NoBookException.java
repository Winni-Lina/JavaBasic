package book.exception;

public class NoBookException extends Exception{
	public NoBookException() {
		
	}
	
	public NoBookException(int memberNo) {
		super("없는 책 번호입니다 : " + memberNo);
	}

}
