package memberservice.member.exception;

public class NoMemberException extends Exception{
	// 기본생성자
	public NoMemberException() {
		
	}
	//오류 메세지를 부모 객체의 생성자에게 전달하는 생성자
	public NoMemberException(int memberNo) {
		super("없는 회원입니다 : " + memberNo);
	}

}
