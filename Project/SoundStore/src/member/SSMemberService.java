package member;

import java.util.List;

public class SSMemberService implements MemberService{
	private MemberDAO memberDAO;
	
	public SSMemberService(MemberDAO memberDAO) {
		this.memberDAO = memberDAO;
	}

	@Override
	public boolean registMember(MemberVO member) {
		return memberDAO.insertMember(member);
	}

	@Override
	public List<MemberVO> listMembers() {
		return memberDAO.selectAllMembers();
	}

	@Override
	public MemberVO detailMemberInfo(String id) {
		return memberDAO.selectMember(id);
	}

	@Override
	public MemberVO login(String id, String password) {
		// id, password가 동일한 회원이 있는지 확인
		MemberVO member = memberDAO.selectMember(id);
		if(member == null) return null;
		
		if(member != null && member.getPassword().equals(password))
			return member;
		return null;
	}

	@Override
	public boolean updatePassword(String id, String oldPassword, String newPassword) {
		MemberVO member = memberDAO.selectMember(id);
		if(member == null) return false;
		
		if(member.getPassword().equals(oldPassword)) {
			member.setPassword(newPassword);
			return memberDAO.updateMember(member);
		}
		return false;
	}

	@Override
	public boolean addMemberInfo(String id, String moblie, String email, String address) {
		MemberVO member = memberDAO.selectMember(id);
		if (member == null) return false;
		
		member.setMoblie(moblie);
		member.setEmail(email);
		member.setAddress(address);
		
		return memberDAO.updateMember(member);
	}

	@Override
	public boolean removeMember(String id, String passsword) {
		MemberVO member = memberDAO.selectMember(id);
		if(member == null) return false;
		if(!member.getPassword().equals(passsword)) return false;
		return memberDAO.deleteMember(id);
	}

}
