/**
 * Copyright 2017 EIS Co., Ltd. All rights reserved.
 */

package controller;

import constant.UnderWriteConst;
import entity.ProposalEntity;
import model.AbstractUnderWrite;

/**
 * @author Yamamoto Takashi <br>
 * <br>
 * modelインスタンス生成クラス <br>
 * 選択された商品種別に応じ動的にmodelインスタンスを生成する <br>
 * <br>
 * 更新履歴 2016/12/31 Yamamoto Takashi：新規作成 <br>
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
   * 商品種別からクラス名を判断し、動的にmodelインスタンスを生成する <br>
   * @param entity 申込エンティティ
   * @return AbstractUnderWrite 生成したmodelインスタンス
   * @throws ClassNotFoundException 該当するmodelクラスが存在しない場合
   * @throws InstantiationException 動的なインスタンス生成に失敗した場合
   * @throws IllegalAccessException 範囲外のスコープを参照した場合
   */
  public static AbstractUnderWrite createModel( ProposalEntity entity )
      throws ClassNotFoundException, InstantiationException, IllegalAccessException {

    // 選択された商品種類に応じpackage指定込みのmodel名称を生成する
    StringBuilder modelName = new StringBuilder();
    modelName.append( UnderWriteConst.PACKAGE_MODEL );
    modelName.append( entity.getProduct() );
    modelName.append( UnderWriteConst.UNDERWRITE_LOGIC );

    // modelインスタンスを生成し返却する
    Class<?> cl = Class.forName( modelName.toString() );
    return ( AbstractUnderWrite ) cl.newInstance();
  }

}
