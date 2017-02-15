package com.bit2017.mysite.web.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bit2017.mysite.dao.BoardDao;
import com.bit2017.mysite.vo.BoardVo;
import com.bit2017.mysite.vo.UserVo;
import com.bit2017.web.Action;
import com.bit2017.web.util.WebUtil;

public class ReplyFormAction implements Action {

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
		
		long no = WebUtil.checkLongParam( request.getParameter( "no" ), 0L );
		String keyword = WebUtil.checkNullParam( request.getParameter( "kwd" ), "" );
		
		BoardDao dao = new BoardDao();
		BoardVo boardVo = dao.get( no );
		
		request.setAttribute( "boardVo", boardVo );
		request.setAttribute( "keyword", keyword );
		
		WebUtil.forward(
				"/WEB-INF/views/board/reply.jsp", 				
				request,
				response );		
	}
}