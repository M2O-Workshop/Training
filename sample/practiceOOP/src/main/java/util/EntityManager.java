/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package util;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import constant.UnderWriteConst;
import entity.ProposalEntity;

/**
 * @author Yamamoto Takashi <br>
 * <br>
 * エンティティ管理クラス <br>
 * エンティティに対する汎用的な処理を定義 <br>
 * <br>
 * 更新履歴 2016/12/11 Yamamoto Takashi：新規作成 <br>
 *          2017/01/04 Yamamoto Takashi：createEntityに査定処理名の取得を追加 <br>
 *          2017/01/05 Yamamoto Takashi：査定処理名の取得元をHashMap定数に変更 <br>
 *          2017/01/20 Yamamoto Takashi：設定項目に処理日時を追加 <br>
 */
public final class EntityManager {

  /**
   * デフォルトコンストラクタ <br>
   */
  private EntityManager() {
    // インスタンスの生成は不可
  }

  /**
   * エンティティ生成メソッド <br>
   * リクエストから取得した入力情報を元に申込エンティティを生成する <br>
   * <br>
   * 
   * @param request HTTPリクエスト
   * @return ProposalEntity 申込エンティティ（処理後）
   */
  public static ProposalEntity createEntity( HttpServletRequest request ) {

    ProposalEntity entity = new ProposalEntity();

    // リクエストから入力値を取得
    entity.setAge( Integer.parseInt( request.getParameter( UnderWriteConst.PRAM_AGE ) ) );
    entity.setGender( request.getParameter( UnderWriteConst.PRAM_GENDER ) );
    entity.setProduct( request.getParameter( UnderWriteConst.PRAM_PRODUCT ) );
    entity.setUnderWrite( UnderWriteConst.PRODUCT_UW_MAP.get( request.getParameter( UnderWriteConst.PRAM_PRODUCT ) ) );
    entity.setProcessDate( createDateStr() );

    // 生成したエンティティを返却
    return entity;
  }

  /**
   * 査定結果文字列設定メソッド <br>
   * 査定結果のフラグ値を元に、画面に表示する文字列を設定する <br>
   * <br>
   * 
   * @param entity 申込エンティティ（処理前）
   * @return ProposalEntity 申込エンティティ（処理後）
   */
  public static ProposalEntity createResultStr( ProposalEntity entity ) {
    // 査定結果から文字列を生成
    String resultStr = entity.isResult() ? UnderWriteConst.RESLUT_OK : UnderWriteConst.RESLUT_NG;
    entity.setResultStr( resultStr );
    return entity;
  }

  /**
   * 性別チェックメソッド <br>
   * エンティティに格納された性別の値を確認する <br>
   * <br>
   * 
   * @param entity 申込エンティティ
   * @param target 一致と見なす性別
   * @return boolean 判定結果（true:一致、false:不一致）
   */
  public static boolean checkGender( ProposalEntity entity, String target ) {
    // 性別の一致を確認
    return target.equals( entity.getGender() );
  }

  /**
   * 年齢チェックメソッド <br>
   * エンティティに格納された年齢の値が特定の上限値内か確認する <br>
   * <br>
   * 
   * @param entity 申込エンティティ
   * @param target 上限値
   * @return boolean 判定結果（true:範囲内、false:範囲外）
   */
  public static boolean checkAge( ProposalEntity entity, int target ) {
    // 年齢の適合を確認
    return target >= entity.getAge();
  }

  /**
   * 現在日時チェックメソッド <br>
   * マシン日付を取得しyyyy/MM/dd形式で返却する <br>
   * <br>
   * 
   * @return String マシン日付
   */
  public static String createDateStr() {
    // マシン日付を取得
    Date date = new Date();
    // 日付形式を指定し返却
    SimpleDateFormat sdf = new SimpleDateFormat( UnderWriteConst.DATE_FORMAT );
    return sdf.format( date );
  }
}
