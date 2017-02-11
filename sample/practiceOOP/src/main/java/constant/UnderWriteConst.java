
package constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

/**
 * @author Yamamoto Takashi <br>
 * <br>
 * 査定処理定数クラス <br>
 * 査定処理で使用する定数を定義 <br>
 * <br>
 * 更新履歴 2016/12/11 Yamamoto Takashi：新規作成 <br>
 * 2016/12/31 Yamamoto Takashi：処理コード値の追加、商品名称の修正 <br>
 * 2017/01/04 Yamamoto Takashi：処理コード値をクラス名を明示する形式に修正 <br>
 * 2017/01/05 Yamamoto Takashi：保険商品と査定処理のマッピング情報を追加 <br>
 * 2017/01/20 Yamamoto Takashi：日付形式情報を追加 <br>
 */
public class UnderWriteConst {

  // 本来はマスタテーブルもしくはプロパティに保持すべき情報だがロジック簡略化のため定数保持

  /** がん保険かつ男性の場合の上限年齢. */
  public static final int CANCE_MALE_UPPER_AGE = 50;
  /** がん保険かつ女性の場合の上限年齢. */
  public static final int CANCE_FEMALE_UPPER_AGE = 50;
  /** がん保険かつ法人の場合の上限年齢. */
  public static final int CANCE_CORP_UPPER_AGE = -1; // 全年齢で不可

  /** 医療保険かつ男性の場合の上限年齢. */
  public static final int MEDICAL_MALE_UPPER_AGE = 80;
  /** 医療保険かつ女性の場合の上限年齢. */
  public static final int MEDICAL_FEMALE_UPPER_AGE = Integer.MAX_VALUE; // 全年齢で許容
  /** 医療保険かつ法人の場合の上限年齢. */
  public static final int MEDICAL_CORP_UPPER_AGE = 80;

  /** 普通保険かつ男性の場合の上限年齢. */
  public static final int ORDINARY_MALE_UPPER_AGE = Integer.MAX_VALUE; // 全年齢で許容
  /** 普通保険かつ女性の場合の上限年齢. */
  public static final int ORDINARY_FEMALE_UPPER_AGE = 80;
  /** 普通保険かつ法人の場合の上限年齢. */
  public static final int ORDINARY_CORP_UPPER_AGE = 80;

  /** がん保険を表すコード値. */
  public static final String PRODUCT_CANCER = "Cancer";
  /** 医療保険を表すコード値. */
  public static final String PRODUCT_MEDICAL = "Medical";
  /** 普通保険を表すコード値. */
  public static final String PRODUCT_ORDINARY = "Ordinary";

  /** がん保険査定処理を表すコード値. */
  public static final String CANCER_UNDERWRITE = "model.CancerUnderWrite";
  /** 医療保険査定処理を表すコード値. */
  public static final String MEDICAL_UNDERWRITE = "model.MedicalUnderWrite";
  /** 普通保険査定処理を表すコード値. */
  public static final String ORDINARY_UNDERWRITE = "model.OrdinaryUnderWrite";

  /** 保険商品と査定処理のマッピング情報. */
  public static final Map<String, String> PRODUCT_UW_MAP = new HashMap<String, String>() {
    {
      put( PRODUCT_CANCER, CANCER_UNDERWRITE );
      put( PRODUCT_MEDICAL, MEDICAL_UNDERWRITE );
      put( PRODUCT_ORDINARY, ORDINARY_UNDERWRITE );
    }
  };

  /** 男性を表すコード値. */
  public static final String GENDER_MALE = "male";
  /** 女性を表すコード値. */
  public static final String GENDER_FEMALE = "female";
  /** 法人を表すコード値. */
  public static final String GENDER_CORP = "corporation";

  /** 引き受け可能を表すメッセージ. */
  public static final String RESLUT_OK = "お引き受け可能です。";
  /** 引き受け不可を表すメッセージ. */
  public static final String RESLUT_NG = "ご契約不可の条件です。";

  /** 年齢を表すパラメータ名称. */
  public static final String PRAM_AGE = "age";
  /** 性別を表すパラメータ名称. */
  public static final String PRAM_GENDER = "gender";
  /** 保険商品を表すパラメータ名称. */
  public static final String PRAM_PRODUCT = "product";
  /** Entityを表す属性名称. */
  public static final String ATTR_ENTITY = "entity";

  /** エンコードの指定. */
  public static final String ENCORD_TYPE = "UTF-8";
  /** コンテンツの指定. */
  public static final String CONTENT_TYPE = "text/html; charset=UTF-8";

  /** 日付形式の指定. */
  public static final String DATE_FORMAT = "yyyy/MM/dd HH:mm:ss";

}
