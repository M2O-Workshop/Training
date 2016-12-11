/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */
package model;

import entity.ProposalEntity;

/**
 * @author （作成者） <br />
 *  （クラス論理名） <br />
 *  （説明） <br />
 *  更新履歴 yyyy/mm/dd （更新者）：（説明） <br />
 */
public class CancerUnderwrite implements CommonModel {

  @Override
  public boolean underWriteLogic( ProposalEntity entity ) {
    // TODO 査定ロジックを実装すること
    return true;
  }

}
