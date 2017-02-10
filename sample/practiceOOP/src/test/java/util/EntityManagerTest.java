/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package util;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.core.Is.*;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import entity.ProposalEntity;

/**
 * @author Yamamoto Takashi <br>
 * <br>
 * EntityManager単体テストクラス <br>
 * エンティティ管理処理を単独起動してテストを実行する <br>
 * <br>
 * 更新履歴 2016/12/31 Yamamoto Takashi：新規作成 <br>
 * 2017/01/04 Yamamoto Takashi：査定処理名を要素に追加 <br>
 * 2017/01/05 Yamamoto Takashi：productのvalueを商品種類のみに再修正 <br>
 * 2017/01/20 Yamamoto Takashi：現在日時取得メソッドのテストを追加 <br>
 */
public class EntityManagerTest {

  /**
   * テスト開始処理 <br>
   * テスト実行前に行うべき処理 <br>
   * 
   * @throws java.lang.Exception 基底例外
   */
  @Before
  public void setUp() throws Exception {
    // mockを有効にする。記載なしでも一応動作する。
    MockitoAnnotations.initMocks( this );
  }

  /**
   * テスト終了処理 <br>
   * テスト実行後に行うべき処理 <br>
   * 
   * @throws java.lang.Exception 基底例外
   */
  @After
  public void tearDown() throws Exception {
  }

  /**
   * {@link util.EntityManager#createEntity(javax.servlet.http.HttpServletRequest)} のためのテスト・メソッド。
   * createEntityテスト処理<br>
   * createEntityメソッドをテスト <br>
   */
  @Test
  public void testCreateEntity() {

    // HttpServletRequestをMockitoでmock化
    HttpServletRequest request = mock( HttpServletRequest.class );

    // mockのHttpServletRequestにパラメーターをセット
    given( request.getParameter( "age" ) ).willReturn( "0" );
    given( request.getParameter( "gender" ) ).willReturn( "male" );
    given( request.getParameter( "product" ) ).willReturn( "Cancer" );

    // 検証用エンティティにパラメーターをセット
    ProposalEntity testEntity = new ProposalEntity();
    testEntity.setAge( 0 );
    testEntity.setGender( "male" );
    testEntity.setProduct( "Cancer" );
    testEntity.setUnderWrite( "model.CancerUnderWrite" );

    // #1 検証用エンティティとcreateEntity生成エンティティの一致を比較（年齢）
    assertThat( testEntity.getAge(), is( EntityManager.createEntity( request ).getAge() ) );
    // #2 検証用エンティティとcreateEntity生成エンティティの一致を比較（性別）
    assertThat( testEntity.getGender(), is( EntityManager.createEntity( request ).getGender() ) );
    // #3 検証用エンティティとcreateEntity生成エンティティの一致を比較（商品）
    assertThat( testEntity.getProduct(), is( EntityManager.createEntity( request ).getProduct() ) );
    // #4 検証用エンティティとcreateEntity生成エンティティの一致を比較（査定処理名）
    assertThat( testEntity.getUnderWrite(),
        is( EntityManager.createEntity( request ).getUnderWrite() ) );

  }

  /**
   * {@link util.EntityManager#createResultStr(entity.ProposalEntity)} のためのテスト・メソッド。
   * createResultStrテスト処理<br>
   * createResultStrメソッドをテスト <br>
   */
  @Test
  public void testCreateResultStr() {
    ProposalEntity testEntity = new ProposalEntity();

    // #1 査定結果true："引き受け可能です。"
    testEntity.setResult( true );
    assertThat( "お引き受け可能です。", is( EntityManager.createResultStr( testEntity ).getResultStr() ) );

    // #2 査定結果false："契約不可の条件です。"
    testEntity.setResult( false );
    assertThat( "ご契約不可の条件です。", is( EntityManager.createResultStr( testEntity ).getResultStr() ) );

  }

  /**
   * {@link util.EntityManager#checkGender(entity.ProposalEntity, java.lang.String)} のためのテスト・メソッド。
   * checkGenderテスト処理<br>
   * checkGenderメソッドをテスト <br>
   */
  @Test
  public void testCheckGender() {
    ProposalEntity testEntity = new ProposalEntity();
    String target = "";

    // #1 性別の一致：true
    testEntity.setGender( "abcdefg" );
    target = "abcdefg";
    assertThat( true, is( EntityManager.checkGender( testEntity, target ) ) );

    // #2 性別の不一致：false
    testEntity.setGender( "abcdefg" );
    target = "hijklmn";
    assertThat( false, is( EntityManager.checkGender( testEntity, target ) ) );

    // #3 性別がnull：false ※JSPで制御、実稼働では起こり得ない
    testEntity.setGender( null );
    target = "abcdefg";
    assertThat( false, is( EntityManager.checkGender( testEntity, target ) ) );

  }

  /**
   * {@link util.EntityManager#checkAge(entity.ProposalEntity, int)} のためのテスト・メソッド。 checkAgeテスト処理<br>
   * checkAgeメソッドをテスト <br>
   */
  @Test
  public void testCheckAge() {
    ProposalEntity testEntity = new ProposalEntity();
    int target = 0;

    // #1 閾値に満たない数値：true
    testEntity.setAge( 49 );
    target = 50;
    assertThat( true, is( EntityManager.checkAge( testEntity, target ) ) );

    // #2 閾値と同値の数値：true
    testEntity.setAge( 50 );
    target = 50;
    assertThat( true, is( EntityManager.checkAge( testEntity, target ) ) );

    // #3 閾値を超える数値：false
    testEntity.setAge( 51 );
    target = 50;
    assertThat( false, is( EntityManager.checkAge( testEntity, target ) ) );

  }

  /**
   * {@link util.EntityManager#createDateStr()} のためのテスト・メソッド。 createDateStrテスト処理<br>
   * createDateStrメソッドをテスト <br>
   */
  @Test
  public void testCreateDateStr() {
    Date date = new Date();
    SimpleDateFormat sdf = new SimpleDateFormat( "yyyy/MM/dd HH:mm:ss" );

    // #1 メソッド実行：マシン日付が所定の形式で返却されること
    assertThat( sdf.format( date ), is( EntityManager.createDateStr() ) );

  }

}
