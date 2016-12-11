/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package model;

import constant.UnderWriteConst;
import entity.ProposalEntity;

/**
 * @author （作成者） <br />
 *         （クラス論理名） <br />
 *         （説明） <br />
 *         更新履歴 yyyy/mm/dd （更新者）：（説明） <br />
 */
public class CancerUnderwrite implements AbstructUnderWrite {

  /**
   * （メソッド論理名） <br />
   * （説明） <br />
   * @param entity
   * @return
   */
  @Override
  public boolean underWriteLogic( ProposalEntity entity ) {
    boolean result = false; //初期値は不可
    // 男性
    result = UnderWriteConst.GENDER_MALE.equals( entity.getGender() )
        && UnderWriteConst.CANCE_MALE_UPPER_AGE >= entity.getAge() ? true : result;
    // 女性
    result = UnderWriteConst.GENDER_FEMALE.equals( entity.getGender() )
        && UnderWriteConst.CANCE_FEMALE_UPPER_AGE >= entity.getAge() ? true : result;
    // 法人
    result = UnderWriteConst.GENDER_CORP.equals( entity.getGender() )
        && UnderWriteConst.CANCE_CORP_UPPER_AGE >= entity.getAge() ? true : result;
    return result;
  }

}
