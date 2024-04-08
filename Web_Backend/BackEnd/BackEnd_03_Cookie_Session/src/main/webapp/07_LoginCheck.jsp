<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%--로그인 처리 용도만 할 것 --%>
    <%
    String id = request.getParameter("id");
    String pw = request.getParameter("password");
    
    //실제로는 id / pw 가지고 db에 저장되어 있는 유저가 맞는지 확인
	//아니면 Manager를 통해 확인 가능(db안배웠으니깐)
    if(id.equals("ssafy")&&pw.equals("1234")){
    	//로그인 성공
    	//세션에 정보를 저장할거임
    	//request.getCookies(); //반복문 돌면서 JSESSIONID 쿠키를 찾아서 값을 이용하서 메모리에 접근 해야하는가?
    	/* HttpSession mySession = request.getSession();
    	//저거 이름 session이라고 하면 X?
    	mySession.setAttribute("id", id); */
    	
    	session.setAttribute("id", id);//JSP가 session영역을 기본으로 접근 가능하다!
    								   //servlet은 불가능 위의 방법으로 해야함
    	
    	 response.sendRedirect("08_Main.jsp");
    	/* request.getRequestDispatcher("/08_Main.jsp").forward(request,response); 
    		얘로 하면 main에서 값을 받아와버릴 수 있음 -> 비밀번호 유출 -> 위험 -> redirect써라*/
    }else{
    	//로그인 실패
    }
    %>
