package com.bit2017.mysite.web.guestbook;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bit2017.mysite.dao.GuestbookDao;
import com.bit2017.mysite.vo.GuestbookVo;
import com.bit2017.web.Action;
import com.bit2017.web.util.WebUtil;

public class ListAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		GuestbookDao dao = new GuestbookDao();
		List<GuestbookVo> list = dao.getList();
		
		request.setAttribute( "list", list );
		WebUtil.forward(
			"/WEB-INF/views/guestbook/list.jsp", 	
			request,
			response );
	}
	
}
