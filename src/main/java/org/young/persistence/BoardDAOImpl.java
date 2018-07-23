
package org.young.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.young.domain.BoardVO;
import org.young.domain.FileVO;

@Repository
public class BoardDAOImpl implements BoardDAO {


	@Inject
	private SqlSession session;

	/*@Inject
	private FileUtil fileUtils;
*/

	private static String namespace = "org.young.mapper.BoardMapper";

	@Override
	public void create(BoardVO vo, MultipartHttpServletRequest multi) throws Exception {

		/*int a = session.insert(namespace + ".create", vo);
		Object result = fileUtils.parseInsertFileInfo(vo, multi);*/

	}
	@Override
	public void create2(BoardVO vo) throws Exception {

		session.insert(namespace + ".create", vo);

	}

	@Override
	public BoardVO read(Integer bno) throws Exception {

		return session.selectOne(namespace + ".read", bno);
	}

	@Override
	public void update(BoardVO vo) throws Exception {
		session.update(namespace + ".update", vo);
	}

	@Override
	public void delete(Integer bno) throws Exception {
		session.delete(namespace + ".delete", bno);
	}

	@Override
	public List<BoardVO> listAll(int page) throws Exception {
		return session.selectList(namespace + ".listAll", page);
	}

	@Override
	public int total() {
		return session.selectOne(namespace+".total");
	}
	@Override
	public int insertFile(FileVO vo) {
		return session.insert(namespace+".insertFile", vo);
	}
}
