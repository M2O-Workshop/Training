/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package model;

import entity.ProposalEntity;

/**
 * @author Yamamoto Takashi <br>
 * <br>
 * 普通保険査定処理クラス <br>
 * 普通保険に対する諾否査定を行う <br>
 * <br>
 * 更新履歴 2016/12/31 Yamamoto Takashi：新規作成 <br>
 */
public class OrdinaryUnderWrite implements AbstractUnderWrite {

  /**
   * デフォルトコンストラクタ <br>
   * 引数なしのコンストラクタ <br>
   */
  public OrdinaryUnderWrite() {
    // 行うべき処理なし
  }

  /**
   * 査定処理ロジック <br>
   * 普通保険の査定ロジックを実行する <br>
   *  @param entity 査定前エンティティ
   *  @return ProposalEntity 査定済みエンティティ
   */
  @Override
  public ProposalEntity underWriteLogic( ProposalEntity entity ) {

    // TODO 普通保険の査定ロジックを実装する
    System.out.println( "普通保険の査定ロジックを実装して下さい。" );

    // 査定済みエンティティを返却する
    return entity;
  }

}
