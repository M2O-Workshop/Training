/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package model;

import constant.UnderWriteConst;
import entity.ProposalEntity;
import util.EntityManager;

/**
 * @author Yamamoto Takashi <br />
 *  メインロジッククラス <br />
 *  メイン処理のフローを定義する <br />
 *  更新履歴 2016/12/11 Yamamoto Takashi：新規作成 <br />
 */
public final class ExecuteLogic {

  /**
   * デフォルトコンストラクタ <br />
   */
  private ExecuteLogic() {
    // インスタンスの生成は不可
  }

  /**
   * メイン処理実行メソッド <br />
   * 保険商品別に処理を指定し実行する <br />
   * 
   * @param entity 申込エンティティ（処理前）
   * @return ProposalEntity 申込エンティティ（処理後）
   */
  public static ProposalEntity exec( ProposalEntity entity ) {

    // がん商品の場合
    if ( UnderWriteConst.PRODUCT_CANCER.equals( entity.getProduct() ) ) {
      // 査定処理を実行
      // ラムダ式記法（java.util.functionパッケージのtestメソッドを実装）
      entity.setResult( CancerUnderwrite.underWriteLogic.test( entity ) );
    }
    // 処理結果を返却する
    return EntityManager.createResultStr( entity );
  }

}
