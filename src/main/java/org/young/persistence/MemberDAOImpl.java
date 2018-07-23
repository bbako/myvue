
package org.young.persistence;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.young.domain.MemberVO;

@Repository
public class MemberDAOImpl implements MemberDAO {


	@Inject
	private SqlSession session;

	private static String namespace = "com.nuritelecom.mapper.MemberMapper";

	@Override
	public MemberVO read(MemberVO vo) throws Exception {
		return session.selectOne(namespace+".read", vo);
	}

	@Override
	public MemberVO checkSessionKey(String sessionKey) {
		return session.selectOne(namespace+".checkSessionKey", sessionKey);
	}

	@Override
	public void keepLogin(MemberVO vo) {
		session.selectOne(namespace+".keepLogin", vo);
	}

	@Override
	public MemberVO login(MemberVO dto) {
		return 	session.selectOne(namespace + ".login", dto);
	}


}
