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
		member.setMemberNo(memberSeq++);
		member.setRegDate(new Date());
		return memberDB.put(member.getId(), member) != null;
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
		return memberDB.put(newMember.getId(), newMember) != null;
	}

	@Override
	public boolean deleteMember(String id) {
		return memberDB.remove(id) != null;
	}

}
