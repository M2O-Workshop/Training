/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */
package model;

import entity.PersonEntity;

/**
 * @author （作成者） <br />
 *  （クラス論理名） <br />
 *  （説明） <br />
 *  更新履歴 yyyy/mm/dd （更新者）：（説明） <br />
 */
public interface CommonModel {
  
  public abstract boolean underWriteLogic(PersonEntity entity);

}
