package org.young.persistence;

import java.util.List;

import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.young.domain.BoardVO;
import org.young.domain.FileVO;

public interface BoardDAO {

	public void create(BoardVO vo, MultipartHttpServletRequest request) throws Exception;
	public void create2(BoardVO vo) throws Exception;

	public BoardVO read(Integer bno) throws Exception;

	public void update(BoardVO vo) throws Exception;

	public void delete(Integer bno) throws Exception;

	public List<BoardVO> listAll(int page) throws Exception;

	public int total();

	public int insertFile(FileVO vo);

}
