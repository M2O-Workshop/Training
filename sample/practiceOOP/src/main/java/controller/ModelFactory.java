/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */

package controller;

import entity.ProposalEntity;
import model.AbstractUnderWrite;

/**
 * @author Yamamoto Takashi <br>
 * <br>
 * modelインスタンス生成クラス <br>
 * 選択された商品種別に応じ動的にmodelインスタンスを生成する <br>
 * <br>
 * 更新履歴 2016/12/31 Yamamoto Takashi：新規作成 <br>
 *          2017/01/04 Yamamoto Takashi：処理コード値をクラス名を明示する形式に修正 <br>
 */
public class ModelFactory {

  /**
   * デフォルトコンストラクタ <br>
   * 省略した場合暗黙で宣言されるが、明示的に宣言するのがお作法 <br>
   */
  public ModelFactory() {
    // 行うべき処理なし
  }

  /**
   * model生成メソッド <br>
   * エンティティから査定クラス名を取得し、動的にmodelインスタンスを生成する <br>
   * 
   * @param entity 申込エンティティ
   * @return AbstractUnderWrite 生成したmodelインスタンス
   * @throws ClassNotFoundException 該当するmodelクラスが存在しない場合
   * @throws InstantiationException 動的なインスタンス生成に失敗した場合
   * @throws IllegalAccessException 範囲外のスコープを参照した場合
   */
  public static AbstractUnderWrite createModel( ProposalEntity entity )
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {

    // modelインスタンスを生成し返却する
    Class<?> cl = Class.forName( entity.getUnderWrite() );
    return ( AbstractUnderWrite ) cl.newInstance();
  }

}
