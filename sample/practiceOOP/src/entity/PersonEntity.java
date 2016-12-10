package entity;

/**
 * @author （作成者） <br />
 *  （クラス論理名） <br />
 *  （説明） <br />
 *  更新履歴 yyyy/mm/dd （更新者）：（説明） <br />
 */
public class PersonEntity {

  private int age = 0;
  private String gender = "";

  /**
   * （コンストラクター論理名） <br />
   * （説明） <br />
   * @param age
   * @param gender
   */
  public PersonEntity( int age, String gender ) {
    super();
    this.age = age;
    this.gender = gender;
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
  
}
