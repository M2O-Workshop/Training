/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */
package model;

import entity.ProposalEntity;

/**
 * @author Yamamoto Takashi <br>
 * <br>
 * 査定インターフェースクラス <br>
 * 全ての査定処理modelは当クラスを継承すること <br>
 * <br>
 * 更新履歴 2016/12/31 Yamamoto Takashi：新規作成 <br>
 */
public interface AbstractUnderWrite {

  /**
   * 抽象査定メソッド <br>
   * 査定処理のインターフェースを指定 <br>
   *  @param entity 査定前エンティティ
   *  @return ProposalEntity 査定済みエンティティ
   */
  ProposalEntity underWriteLogic( ProposalEntity entity );

}
