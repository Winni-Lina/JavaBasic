package member;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapMemberDAO implements MemberDAO {

	protected Map<String, MemberVO> memberDB = new HashMap<>();
	protected int memberSeq = 111;
	
	@Override
	public boolean insertMember(MemberVO member) {
		if (memberDB.containsKey(member.getId()) ) return false;
		
		member.setMemberNo(memberSeq++);
		member.setRegDate(new Date());
		memberDB.put(member.getId(), member);
		return true;
	}

	@Override
	public MemberVO selectMember(String id) {
		return memberDB.get(id);
	}

	@Override
	public List<MemberVO> selectAllMembers() {
		return new ArrayList<>(memberDB.values());
	}

	@Override
	public boolean updateMember(MemberVO newMember) {
		memberDB.put(newMember.getId(), newMember);
		return true;
	}

	@Override
	public boolean deleteMember(String id) {
		return memberDB.remove(id) != null;
	}

}
