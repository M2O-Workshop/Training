
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import entity.ProposalEntity;
import model.ExecuteUnderWrite;
import util.entityManager;

/**
 * @author （作成者） <br />
 *         （クラス論理名） <br />
 *         （説明） <br />
 *         更新履歴 yyyy/mm/dd （更新者）：（説明） <br />
 */
@WebServlet(name = "/MainServlet", urlPatterns = {
    "/view/MainServlet"
})
public class MainServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * （コンストラクター論理名） <br />
   * （説明） <br />
   */
  public MainServlet() {
    super();
    // 行うべき処理なし
  }

  /*
   * (非 Javadoc)
   * @see javax.servlet.http.HttpServlet#doGet(javax.servlet.http.HttpServletRequest,
   * javax.servlet.http.HttpServletResponse)
   */
  protected void doGet( HttpServletRequest request, HttpServletResponse response )
      throws ServletException, IOException {
    // 文字エンコードの設定
    response.setContentType( "text/html; charset=UTF-8" );
    request.setCharacterEncoding( "UTF-8" );
    // リクエストからentityを生成する
    ProposalEntity entity = entityManager.createEntity( request );

    // 査定処理の呼び出し
    entity = ExecuteUnderWrite.exec( entity );

    // 処理結果を設定し再度JSPに遷移する
    request.setAttribute( "entity", entity );
    RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/UnderWrite.jsp" );
    dispatcher.forward( request, response );
  }

  /*
   * (非 Javadoc)
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost( HttpServletRequest request, HttpServletResponse response )
      throws ServletException, IOException {
    // doGetメソッドに委譲する
    doGet( request, response );
  }
}
