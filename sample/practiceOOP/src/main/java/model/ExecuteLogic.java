/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package model;

import controller.ModelFactory;
import entity.ProposalEntity;
import util.EntityManager;

/**
 * @author Yamamoto Takashi <br>
 *  <br>
 *  メインロジッククラス <br>
 *  メイン処理のフローを定義する <br>
 *  <br>
 *  更新履歴 2016/12/11 Yamamoto Takashi：新規作成 <br>
 *           2016/12/31 Yamamoto Takashi：ロジックから商品種別での分岐を排除 <br>
 */
public final class ExecuteLogic {

  /**
   * デフォルトコンストラクタ <br>
   */
  private ExecuteLogic() {
    // インスタンスの生成は不可
  }

  /**
   * メイン処理実行メソッド <br>
   * modelインスタンスを動的に生成し、査定処理を実行する <br>
   * <br>
   * @param entity 申込エンティティ（処理前）
   * @return ProposalEntity 申込エンティティ（処理後）
   */
  public static ProposalEntity exec( ProposalEntity entity ) {

    try {
      // modelを動的に生成
      AbstractUnderWrite model = ModelFactory.createModel( entity );
      // 査定処理を実行
      entity = model.underWriteLogic( entity );

    } catch ( ClassNotFoundException | InstantiationException | IllegalAccessException e ) {
      // 例外発生時はコンソール出力
      e.printStackTrace();
    }

    // 処理後のエンティティを返却する
    return EntityManager.createResultStr( entity );
  }

}
