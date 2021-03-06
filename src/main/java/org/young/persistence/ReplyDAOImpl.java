
package org.young.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.young.domain.ReplyVO;

@Repository
public class ReplyDAOImpl implements ReplyDAO {

	@Inject
	private SqlSession session;

	private static String namespace = "org.young.mapper.ReplyMapper";


	@Override
	public void create(ReplyVO vo) throws Exception {
		session.insert(namespace + ".create", vo);
	}

	@Override
	public void update(ReplyVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer rno) throws Exception {
		session.delete(namespace + ".delete", rno);
	}

	@Override
	public List<ReplyVO> listAll(Integer bno) throws Exception {
		return session.selectList(namespace + ".listAll");
	}



}
