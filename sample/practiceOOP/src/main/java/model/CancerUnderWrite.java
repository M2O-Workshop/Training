/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package model;

import constant.UnderWriteConst;
import entity.ProposalEntity;
import util.EntityManager;

/**
 * @author Yamamoto Takashi <br>
 * <br>
 * がん保険査定処理クラス <br>
 * がん保険に対する諾否査定を行う <br>
 * <br>
 * 更新履歴 2016/12/11 Yamamoto Takashi：新規作成 <br>
 *          2016/12/31 Yamamoto Takashi：戻り値の型を修正 <br>
 */
public class CancerUnderWrite implements AbstractUnderWrite {

  /**
   * デフォルトコンストラクタ <br>
   * 引数なしのコンストラクタ <br>
   */
  public CancerUnderWrite() {
    // 行うべき処理なし
  }

  /**
   * 査定処理ロジック <br>
   * がん保険の査定ロジックを実行する <br>
   *  @param entity 査定前エンティティ
   *  @return ProposalEntity 査定済みエンティティ
   */
  @Override
  public ProposalEntity underWriteLogic( ProposalEntity entity ) {

    //がん保険の査定ロジックを実行
    System.out.println( "がん保険の査定ロジックを実行" );

    // がん保険の査定ロジック
    boolean result = EntityManager.checkGender( entity, UnderWriteConst.GENDER_MALE ) && EntityManager.checkAge( entity, UnderWriteConst.CANCE_MALE_UPPER_AGE ) ? true
      : EntityManager.checkGender( entity, UnderWriteConst.GENDER_FEMALE ) && EntityManager.checkAge( entity, UnderWriteConst.CANCE_FEMALE_UPPER_AGE ) ? true
        : EntityManager.checkGender( entity, UnderWriteConst.GENDER_CORP ) && EntityManager.checkAge( entity, UnderWriteConst.CANCE_CORP_UPPER_AGE ) ? true
          : false;
    // 査定結果をセット
    entity.setResult( result );

    // 査定済みエンティティを返却する
    return entity;
  }

}
