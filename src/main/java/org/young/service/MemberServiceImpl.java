package org.young.service;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.young.domain.MemberVO;
import org.young.persistence.MemberDAO;

@Service
public class MemberServiceImpl implements MemberService {

	@Inject
	private MemberDAO dao;

	@Override
	public MemberVO read(MemberVO vo) throws Exception {
		return dao.read(vo);
	}

	@Override
	public MemberVO checkSessionKey(String sessionKey) {
		return dao.checkSessionKey(sessionKey);
	}

	@Override
	public void keepLogin(MemberVO vo) {
		dao.keepLogin(vo);
	}

	@Override
	public MemberVO login(MemberVO dto) {
		return dao.login(dto);
	}


}
