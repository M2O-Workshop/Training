/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package model;

import java.util.function.Predicate;

import constant.UnderWriteConst;
import entity.ProposalEntity;
import util.EntityManager;

/**
 * @author Yamamoto Takashi <br>
 *  <br>
 *  がん商品査定処理クラス <br>
 *  がん商品に対する諾否査定を行う <br>
 *  <br>
 *  更新履歴 2016/12/11 Yamamoto Takashi：新規作成 <br>
 */
public class CancerUnderwrite {

  /**
   * がん商品査定処理メソッド <br>
   * 性別と年齢から査定結果を導出する <br>
   * ラムダ式記法（java.util.functionパッケージのPredicateインターフェースを実装） <br>
   * JDK1.7以前の開発環境の場合は、独自にInterfaceクラスを定義して実装すること <br>
   */
  static Predicate<ProposalEntity> underWriteLogic = ( entity )
    -> EntityManager.checkGender( entity, UnderWriteConst.GENDER_MALE ) && EntityManager.checkAge( entity, UnderWriteConst.CANCE_MALE_UPPER_AGE ) ? true
      : EntityManager.checkGender( entity, UnderWriteConst.GENDER_FEMALE ) && EntityManager.checkAge( entity, UnderWriteConst.CANCE_FEMALE_UPPER_AGE ) ? true
        : EntityManager.checkGender( entity, UnderWriteConst.GENDER_CORP ) && EntityManager.checkAge( entity, UnderWriteConst.CANCE_CORP_UPPER_AGE ) ? true
          : false;
}
