package member;

import java.util.List;

public interface MemberService {
	boolean registMember(MemberVO member);
	List<MemberVO> listMembers();
	MemberVO detailMemberInfo(String id);
	MemberVO login(String id, String password);
	boolean updatePassword(String id, String oldPassword, String newPassword);
	boolean addMemberInfo(String id, String mobile, String email, String address);
	boolean removeMember(String id, String password);
}
