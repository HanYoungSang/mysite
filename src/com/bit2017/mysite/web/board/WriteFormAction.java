package com.bit2017.mysite.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2017.mysite.vo.UserVo;
import com.bit2017.web.Action;
import com.bit2017.web.util.WebUtil;

public class WriteFormAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// is auth?
		HttpSession session = request.getSession();
		if( session == null ) {
			WebUtil.redirect(
				request.getContextPath() + "/board",
				request,
				response );
			return;
		}
		UserVo authUser = (UserVo)session.getAttribute( "authUser" );
		if( authUser == null ) {
			WebUtil.redirect(
				request.getContextPath() + "/board",
				request,
				response );
			return;
		}	

		WebUtil.forward(
			"/WEB-INF/views/board/write.jsp", 	
			request, 
			response );
	}

}
