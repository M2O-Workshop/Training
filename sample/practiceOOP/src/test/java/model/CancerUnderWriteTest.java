/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package model;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import entity.ProposalEntity;

/**
 * @author Yamamoto Takashi <br>
 * <br>
 * CancerUnderwrite単体テストクラス <br>
 * がん商品査定処理を単独起動してテストを実行する <br>
 * <br>
 * 更新履歴 2016/12/31 Yamamoto Takashi：新規作成 <br>
 *          2017/01/01 Yamamoto Takashi：テスト対象クラスに合わせて呼び出し修正 <br>
 */
public class CancerUnderWriteTest {

  /**
   * テスト開始処理 <br>
   * テスト実行前に行うべき処理 <br>
   * 
   * @throws java.lang.Exception 基底例外
   */
  @Before
  public void setUp() throws Exception {
    // 行うべき処理なし
  }

  /**
   * テスト終了処理 <br>
   * テスト実行後に行うべき処理 <br>
   * 
   * @throws java.lang.Exception 基底例外
   */
  @After
  public void tearDown() throws Exception {
    // 行うべき処理なし
  }

  /**
   * テストメイン処理<br>
   * 査定ロジックの基準に従い、がん商品査定処理をテスト <br>
   */
  @Test
  public void testCancerUnderwrite() {
    ProposalEntity testEntity = new ProposalEntity();
    AbstractUnderWrite model = new CancerUnderWrite();

    // テスト内容を明確にするため敢えてUnderWriteConstの定数は使用せず、リテラル値を適用。

    // #1 男性、0～50歳：OK
    testEntity.setGender( "male" );
    testEntity.setAge( 50 );
    assertThat( true, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

    // #2 男性、51～80歳：NG
    testEntity.setGender( "male" );
    testEntity.setAge( 51 );
    assertThat( false, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

    // #3 男性、81歳～：NG
    testEntity.setGender( "male" );
    testEntity.setAge( 81 );
    assertThat( false, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

    // #4 女性、0～50歳：OK
    testEntity.setGender( "female" );
    testEntity.setAge( 50 );
    assertThat( true, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

    // #5 女性、51～80歳：NG
    testEntity.setGender( "female" );
    testEntity.setAge( 51 );
    assertThat( false, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

    // #6 女性、81歳～：NG
    testEntity.setGender( "female" );
    testEntity.setAge( 81 );
    assertThat( false, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

    // #7 法人、0～50歳：NG
    testEntity.setGender( "corporation" );
    testEntity.setAge( 50 );
    assertThat( false, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

    // #8 法人、51～80歳：NG
    testEntity.setGender( "corporation" );
    testEntity.setAge( 51 );
    assertThat( false, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

    // #9 法人、81歳～：NG
    testEntity.setGender( "corporation" );
    testEntity.setAge( 81 );
    assertThat( false, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

    // #10 未定義の性別：NG ※JSPで制御、実稼働では起こり得ない
    testEntity.setGender( "NonDefValue" );
    testEntity.setAge( 0 );
    assertThat( false, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

    // #11 正値の最小値の年齢：OK ※JSで制御、実稼働では起こり得ない
    testEntity.setGender( "male" );
    testEntity.setAge( Integer.MIN_VALUE );
    assertThat( true, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

    // #12 正値の最大値の年齢：NG ※JSで制御、実稼働では起こり得ない
    testEntity.setGender( "female" );
    testEntity.setAge( Integer.MAX_VALUE );
    assertThat( false, is( ( model.underWriteLogic( testEntity ) ).isResult() ) );

  }

}
