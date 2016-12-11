/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package model;

import entity.ProposalEntity;
import util.entityManager;

/**
 * @author （作成者） <br />
 *         （クラス論理名） <br />
 *         （説明） <br />
 *         更新履歴 yyyy/mm/dd （更新者）：（説明） <br />
 */
public class ExecuteUnderWrite {

  /**
   * （コンストラクター論理名） <br />
   * （説明） <br />
   */
  public ExecuteUnderWrite() {
    // TODO 自動生成されたコンストラクター・スタブ
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
    if ( "cancer".equals( entity.getProduct() ) ) {
      // がん商品の査定を実行
      entity.setResult( new CancerUnderwrite().underWriteLogic( entity ) );
    }
    // 査定結果を返却する
    return entityManager.createResultStr( entity );
  }

}
