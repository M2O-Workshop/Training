package constant;
/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

/**
 * @author （作成者） <br />
 *  （クラス論理名） <br />
 *  （説明） <br />
 *  更新履歴 yyyy/mm/dd （更新者）：（説明） <br />
 */
public class UnderWriteConst {

  //本来はマスタテーブルもしくはプロパティに保持すべき情報だがロジック簡略化のため定数保持

  /** がん保険かつ男性の場合の上限年齢 */
  public static final int CANCE_MALE_UPPER_AGE = 50;
  /** がん保険かつ女性の場合の上限年齢 */
  public static final int CANCE_FEMALE_UPPER_AGE = 50;
  /** がん保険かつ法人の場合の上限年齢 */
  public static final int CANCE_CORP_UPPER_AGE = -1; // 全年齢で不可

  /** 医療保険かつ男性の場合の上限年齢 */
  public static final int MEDICAL_MALE_UPPER_AGE = 80;
  /** 医療保険かつ女性の場合の上限年齢 */
  public static final int MEDICAL_FEMALE_UPPER_AGE = Integer.MAX_VALUE; // 全年齢で許容
  /** 医療保険かつ法人の場合の上限年齢 */
  public static final int MEDICAL_CORP_UPPER_AGE = 80;

  /** 普通保険かつ男性の場合の上限年齢 */
  public static final int ORDINARY_MALE_UPPER_AGE = Integer.MAX_VALUE; // 全年齢で許容
  /** 普通保険かつ女性の場合の上限年齢 */
  public static final int ORDINARY_FEMALE_UPPER_AGE = 80;
  /** 普通保険かつ法人の場合の上限年齢 */
  public static final int ORDINARY_CORP_UPPER_AGE = 80;

  /** がん保険を表すコード値 */
  public static final String PRODUCT_CANCER = "cancer";
  /** 医療保険を表すコード値 */
  public static final String PRODUCT_MEDICAL = "medical";
  /** 普通保険を表すコード値 */
  public static final String PRODUCT_ORDINARY = "ordinary";

  /** 男性を表すコード値 */
  public static final String GENDER_MALE = "male";
  /** 女性を表すコード値 */
  public static final String GENDER_FEMALE = "female";
  /** 法人を表すコード値 */
  public static final String GENDER_CORP = "corporation";

  /** 引き受け可能を表すメッセージ */
  public static final String RESLUT_OK = "引き受け可能です。";
  /** 引き受け不可を表すメッセージ */
  public static final String RESLUT_NG = "契約不可の条件です。";

  /** 年齢を表すパラメータ名称 */
  public static final String PRAM_AGE = "age";
  /** 性別を表すパラメータ名称 */
  public static final String PRAM_GENDER = "gender";
  /** 保険商品を表すパラメータ名称 */
  public static final String PRAM_PRODUCT = "product";
  /** Entityを表す属性名称 */
  public static final String ATTR_ENTITY = "entity";

  /** エンコードの指定 */
  public static final String ENCORD_TYPE = "UTF-8";
  /** コンテンツの指定 */
  public static final String CONTENT_TYPE = "text/html; charset=UTF-8";

}
