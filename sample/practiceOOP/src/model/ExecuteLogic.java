/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package model;

import constant.UnderWriteConst;
import entity.ProposalEntity;
import util.entityManager;

/**
 * @author （作成者） <br />
 *         （クラス論理名） <br />
 *         （説明） <br />
 *         更新履歴 yyyy/mm/dd （更新者）：（説明） <br />
 */
public class ExecuteLogic {

  /**
   * （コンストラクター論理名） <br />
   * （説明） <br />
   */
  private ExecuteLogic() {
    // インスタンスの生成は不可
  }

  /**
   * （メソッド論理名） <br />
   * （説明） <br />
   * 
   * @param entity
   * @return
   */
  public static ProposalEntity exec( ProposalEntity entity ) {
    
    // がん商品の場合
    if ( UnderWriteConst.PRODUCT_CANCER.equals( entity.getProduct() ) ) {
      // 査定処理を実行
      entity.setResult( new CancerUnderwrite().underWriteLogic( entity ) );
    }
    // 処理結果を返却する
    return entityManager.createResultStr( entity );
  }

}
