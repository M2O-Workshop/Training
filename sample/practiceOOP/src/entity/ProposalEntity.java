
package entity;

/**
 * @author （作成者） <br />
 *         （クラス論理名） <br />
 *         （説明） <br />
 *         更新履歴 yyyy/mm/dd （更新者）：（説明） <br />
 */
public class ProposalEntity {

  // 初期値を指定する
  private int age = 0;
  private String gender = "male";
  private String product = "";//JSP側で初期値を指定済み
  private boolean result = false;
  private String resultStr = "";

  /**
   * （コンストラクター論理名） <br />
   * （説明） <br />
   */
  public ProposalEntity() {
    super();
  }

  /**
   * @return age
   */
  public int getAge() {
    return age;
  }

  /**
   * @param age セットする age
   */
  public void setAge( int age ) {
    this.age = age;
  }

  /**
   * @return gender
   */
  public String getGender() {
    return gender;
  }

  /**
   * @param gender セットする gender
   */
  public void setGender( String gender ) {
    this.gender = gender;
  }

  /**
   * @return product
   */
  public String getProduct() {
    return product;
  }

  /**
   * @param product セットする product
   */
  public void setProduct( String product ) {
    this.product = product;
  }

  /**
   * @return result
   */
  public boolean isResult() {
    return result;
  }

  /**
   * @param result セットする result
   */
  public void setResult( boolean result ) {
    this.result = result;
  }

  /**
   * @return resultStr
   */
  public String getResultStr() {
    return resultStr;
  }

  /**
   * @param resultStr セットする resultStr
   */
  public void setResultStr( String resultStr ) {
    this.resultStr = resultStr;
  }

}
