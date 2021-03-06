package org.young.service;

import java.util.List;

import org.young.domain.ReplyVO;

public interface ReplyService {

	public void regist(ReplyVO board) throws Exception;

	public void modify(ReplyVO board) throws Exception;

	public void remove(Integer bno) throws Exception;

	public List<ReplyVO> listAll(Integer bno) throws Exception;

}
