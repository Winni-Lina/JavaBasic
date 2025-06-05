package test;

import member.SSMemberService;
import member.HashMapMemberDAO;
import member.MemberService;
import member.MemberVO;

public class MemberServiceTest {
	public static void main(String[] args) {
		MemberService ms = new SSMemberService(new HashMapMemberDAO());
		
		// 회원 등록
		ms.registMember(new MemberVO("user1", "1234", "user1"));
		ms.registMember(new MemberVO("user2", "1234", "user2"));
		ms.registMember(new MemberVO("user3", "1234", "user3"));
		
		// 회원 목록
		System.out.println(ms.listMembers());
		
		// 회원 상세정보
		System.out.println(ms.detailMemberInfo("user2"));
		
		ms.updatePassword("user2", "1234", "1111");
		System.out.println(ms.listMembers());
		
		// 회원 삭제
		ms.removeMember("user3", "1234");
		System.out.println(ms.listMembers());
		
		// 로그인
		MemberVO loggedMember = ms.login("user1", "1234");
		System.out.println(loggedMember);
		
		// 정보 추가
		ms.addMemberInfo("user1", "010-1234", "user1@kopo", "서울시 송파구");
		System.out.println(ms.listMembers());
		
	}
}
