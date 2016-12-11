/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */
package util;

import javax.servlet.http.HttpServletRequest;

import constant.UnderWriteConst;
import entity.ProposalEntity;

/**
 * @author （作成者） <br />
 *  （クラス論理名） <br />
 *  （説明） <br />
 *  更新履歴 yyyy/mm/dd （更新者）：（説明） <br />
 */
 public class entityManager {

  /**
   * （コンストラクター論理名） <br />
   * （説明） <br />
   */
  private entityManager() {
    // インスタンスの生成は不可
  }

  /**
   * （メソッド論理名） <br />
   * （説明） <br />
   * @param request
   * @return
   */
  public static ProposalEntity createEntity( HttpServletRequest request ){
    ProposalEntity entity = new ProposalEntity();
    // リクエストから入力値を取得
    entity.setAge( Integer.parseInt( request.getParameter( UnderWriteConst.PRAM_AGE ) ) );
    entity.setGender( request.getParameter( UnderWriteConst.PRAM_GENDER ) );
    entity.setProduct( request.getParameter( UnderWriteConst.PRAM_PRODUCT ) );
    return entity;
  }
  
  /**
   * （メソッド論理名） <br />
   * （説明） <br />
   * @param entity
   * @return
   */
  public static ProposalEntity createResultStr( ProposalEntity entity ){
    // 査定結果から文字列を生成
    String resultStr = entity.isResult() ? UnderWriteConst.RESLUT_OK : UnderWriteConst.RESLUT_NG;
    entity.setResultStr( resultStr );
    return entity;
  }
  
  
}
