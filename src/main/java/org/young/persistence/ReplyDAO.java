package org.young.persistence;

import java.util.List;

import org.young.domain.ReplyVO;

public interface ReplyDAO {

	public void create(ReplyVO vo) throws Exception;
	
	public void update(ReplyVO vo) throws Exception;

	public void delete(Integer rno) throws Exception;

	public List<ReplyVO> listAll(Integer bno) throws Exception;

}
