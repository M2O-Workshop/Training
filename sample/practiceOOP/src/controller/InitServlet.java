package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ProposalEntity;

/**
 * Servlet implementation class InitServlet
 */
@WebServlet(name = "/InitServlet", urlPatterns = {
    "/view/InitServlet"})
public class InitServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InitServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // 文字エンコードの設定
    response.setContentType( "text/html; charset=UTF-8" );
    request.setCharacterEncoding( "UTF-8" );

    // エンティティを初期化し再度JSPに遷移する
    request.setAttribute( "entity", new ProposalEntity() );
    RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/UnderWrite.jsp" );
    dispatcher.forward( request, response );
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
