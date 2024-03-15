package com.ssafy.controller;

import java.io.IOException;

import com.ssafy.board.model.repository.BoardRepository;
import com.ssafy.board.model.repository.BoardRepositoryImpl;
import com.ssafy.board.model.service.BoardService;
import com.ssafy.board.model.service.BoardServiceImpl;
import com.ssafy.dto.Board;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/board")
public class BoardController extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private BoardService service = BoardServiceImpl.getInstance();
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//모든 board요청이 해당 서블릿으로 옴
		String action = req.getParameter("action");
		
		switch(action) {
		case "writeform":
			doWriteForm(req,resp);
			break;
		case "write":
			doWrite(req,resp);
			break;
		case "list":
			doList(req,resp);
			break;
		case "detail":
			doDetail(req,resp);
			break;
		case "remove":
			doRemove(req,resp);
			break;
		case "updateform":
			doUpdateForm(req,resp);
			break;
		case "update":
			doUpdate(req,resp);
			break;
		}
	}
	
	private void doUpdate(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		Board board = service.getBoard(Integer.parseInt(req.getParameter("id")));
		board.setTitle(req.getParameter("title"));
		board.setContent(req.getParameter("content"));
		
		service.modifyBoard(board);
		resp.sendRedirect("board?action=list");
		
	}

	private void doUpdateForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		Board board = service.getBoard(id);
		req.setAttribute("board", board);
		req.getRequestDispatcher("/board/updateform.jsp").forward(req, resp);
	}

	private void doRemove(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		service.removeBoard(id);
		resp.sendRedirect("board?action=list");
		}

	private void doDetail(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		
		req.setAttribute("board", service.getBoard(id));
		
		req.getRequestDispatcher("/board/detail.jsp").forward(req, resp);
		
	}

	private void doWriteForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("board/writeform.jsp").forward(req, resp);
	}
	private void doWrite(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		String title = req.getParameter("title");
		String writer = req.getParameter("writer");
		String content = req.getParameter("content");
		
		//객체에 담아서 service를 호출
		Board board = new Board(title, writer, content);
		service.writeBoard(board);
		resp.sendRedirect("board?action=list");

	}
	private void doList(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setAttribute("list", service.getList());
		req.getRequestDispatcher("/board/list.jsp").forward(req, resp);
	}
}
