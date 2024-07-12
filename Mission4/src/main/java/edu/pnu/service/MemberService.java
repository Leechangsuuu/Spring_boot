package edu.pnu.service;

import java.util.List;

import edu.pnu.dao.MemberDao;
import edu.pnu.domain.MemberDto;

public class MemberService {
//	private List<MemberDTO> list = new ArrayList<>();
	private MemberDao memberDao;
	
	public MemberService() {
		memberDao = new MemberDao();
	}
	public List<MemberDto> getAllMembers() {
		// TODO Auto-generated method stub
		return memberDao.getAllMembers();
	}
	public MemberDto getMemberById(Integer id) {
		return memberDao.getMemberById(id);
	}
	public MemberDto addMember(MemberDto dto) {
		return memberDao.addMember(dto);
	}
	public int updateMember(MemberDto dto) {
		return memberDao.updateMember(dto);
	}
	public int removeMember(MemberDto dto) {
		return memberDao.removeMember(dto);
	}

}
