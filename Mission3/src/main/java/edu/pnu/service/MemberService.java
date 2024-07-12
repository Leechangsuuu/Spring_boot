package edu.pnu.service;

import java.util.List;
import edu.pnu.dao.MemberDAO;
import edu.pnu.domain.MemberDTO;


public class MemberService {
//	private List<MemberDTO> list = new ArrayList<>();
	private MemberDAO memberDAO;
	
	public MemberService() {
		memberDAO = new MemberDAO();
	}
	public List<MemberDTO> getAllMembers() {
		// TODO Auto-generated method stub
		return memberDAO.getAllMembers();
	}
	public MemberDTO getMemberById(Integer id) {
		return memberDAO.getMemberById(id);
	}
	public MemberDTO addMember(MemberDTO dto) {
		return memberDAO.addMember(dto);
	}
	public int updateMember(MemberDTO dto) {
		return memberDAO.updateMember(dto);
	}
	public int removeMember(MemberDTO dto) {
		return memberDAO.removeMember(dto);
	}
	

	


}
