package com.bit2017.mysite.web.guestbook;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2017.mysite.dao.GuestbookDao;
import com.bit2017.mysite.vo.GuestbookVo;
import com.bit2017.web.Action;
import com.bit2017.web.util.WebUtil;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String no = request.getParameter( "no" );
		String password = request.getParameter( "password" );
		
		GuestbookVo vo = new GuestbookVo();
		vo.setNo(Long.parseLong( no ));
		vo.setPassword(password);
		
		GuestbookDao dao = new GuestbookDao();
		dao.delete(vo);
		
		WebUtil.redirect(
			request.getContextPath() + "/guestbook", 				
			request, 
			response );
	}
}
