package org.young.service;

import org.young.domain.MemberVO;

public interface MemberService {

	public MemberVO read(MemberVO vo) throws Exception;

	public MemberVO checkSessionKey(String sessionKey);

	public void keepLogin(MemberVO vo);


    MemberVO login(MemberVO dto);
}
