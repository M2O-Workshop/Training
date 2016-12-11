
package entity;

/**
 * @author Yamamoto Takashi <br />
 *  申込エンティティクラス <br />
 *  申込および処理結果に関する情報を格納する <br />
 *  なお、業務プログラムでは入力と出力のエンティティは明示的に分けた方が良い <br />
 *  更新履歴 2016/12/11 Yamamoto Takashi：新規作成 <br />
 */
public class ProposalEntity {

  // 初期値を指定する
  /** 年齢 */
  private int age = 0;
  /** 性別 */
  private String gender = "male";
  /** 保険商品 */
  private String product = ""; //JSP側で初期値を指定済み
  /** 査定結果 */
  private boolean result = false;
  /** 査定結果文字列 */
  private String resultStr = "";

  /**
   * デフォルトコンストラクタ <br />
   */
  public ProposalEntity() {
    super();
  }

  /**
   * 年齢取得メソッド <br />
   * @return age 年齢
   */
  public int getAge() {
    return age;
  }

  /**
   * 年齢設定メソッド <br />
   * @param age 年齢
   */
  public void setAge( int age ) {
    this.age = age;
  }

  /**
   * 性別取得メソッド <br />
   * @return gender 性別
   */
  public String getGender() {
    return gender;
  }

  /**
   * 性別設定メソッド <br />
   * @param gender 性別
   */
  public void setGender( String gender ) {
    this.gender = gender;
  }

  /**
   * 保険商品取得メソッド <br />
   * @return product 保険商品
   */
  public String getProduct() {
    return product;
  }

  /**
   * 保険商品設定メソッド <br />
   * @param product 保険商品
   */
  public void setProduct( String product ) {
    this.product = product;
  }

  /**
   * 査定結果取得メソッド <br />
   * @return result 査定結果
   */
  public boolean isResult() {
    return result;
  }

  /**
   * 査定結果設定メソッド <br />
   * @param result 査定結果
   */
  public void setResult( boolean result ) {
    this.result = result;
  }

  /**
   * 査定結果文字列取得メソッド <br />
   * @return result 査定結果文字列
   */
  public String getResultStr() {
    return resultStr;
  }

  /**
   * 査定結果文字列設定メソッド <br />
   * @param resultStr 査定結果文字列
   */
  public void setResultStr( String resultStr ) {
    this.resultStr = resultStr;
  }

}
