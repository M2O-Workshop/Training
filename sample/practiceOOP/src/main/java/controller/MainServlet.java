
package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import constant.UnderWriteConst;
import entity.ProposalEntity;
import model.ExecuteLogic;
import util.EntityManager;

/**
 * @author Yamamoto Takashi <br>
 *  <br>
 *  メインサーブレットクラス <br>
 *  メインとなるコントローラークラス <br>
 *  <br>
 *  更新履歴 2016/12/11 Yamamoto Takashi：新規作成 <br>
 */
@WebServlet(name = "/MainServlet", urlPatterns = { "/view/MainServlet"})
public class MainServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;

  /**
   * デフォルトコンストラクタ
   */
  public MainServlet() {
    super();
  }

  /**
   * doGetメソッド <br>
   * GETリクエストに対し実行される処理 <br>
   * <br>
   * @param request HTTPリクエスト
   * @param response HTTPレスポンス
   * @throws ServletException サーブレット例外
   * @throws IOException 入出力例外
   */
  protected void doGet( HttpServletRequest request, HttpServletResponse response )
      throws ServletException, IOException {
    // 文字エンコードの設定
    response.setContentType( UnderWriteConst.CONTENT_TYPE );
    request.setCharacterEncoding( UnderWriteConst.ENCORD_TYPE );
    // リクエストからentityを生成する
    ProposalEntity entity = EntityManager.createEntity( request );

    // メイン処理の呼び出し
    entity = ExecuteLogic.exec( entity );

    // 処理結果を設定し再度JSPに遷移する
    request.setAttribute( UnderWriteConst.ATTR_ENTITY, entity );
    RequestDispatcher dispatcher = request.getRequestDispatcher( "/view/UnderWrite.jsp" );
    dispatcher.forward( request, response );
  }

  /**
   * doPostメソッド <br>
   * POSTリクエストに対し実行される処理 <br>
   * <br>
   * @param request HTTPリクエスト
   * @param response HTTPレスポンス
   * @throws ServletException サーブレット例外
   * @throws IOException 入出力例外
   */
  protected void doPost( HttpServletRequest request, HttpServletResponse response )
      throws ServletException, IOException {
    // doGetメソッドに委譲する
    doGet( request, response );
  }
}
