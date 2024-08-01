package service;

import java.io.FileNotFoundException;
import java.io.IOException;

import dao.MemberDao;
import dao.MemberDaoImpl;

public class MemberServiceImpl implements MemberService {
	
	private MemberDao dao = null;
	
	public MemberServiceImpl() throws FileNotFoundException, 
									  ClassNotFoundException, 
									  IOException {
		
		dao = new MemberDaoImpl();
		
	}

}
