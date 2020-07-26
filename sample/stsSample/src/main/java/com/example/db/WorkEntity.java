/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package com.example.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author yamamoto-t <br />
 *         サンプル用エンティティ <br />
 *         DB接続検証用に作成 <br />
 *         更新履歴 2016/11/01 yamamoto-t：新規作成 <br />
 *                  2020/07/26 yamamoto-t：テーブル名を修正 <br />
 */
@Entity
@Table(name = "test01") // memo:デフォルトはクラス名=テーブル名（省略可）
public class WorkEntity {

  @Id // memo:エンティティの主キーとなるオブジェクト１つのみに@Idを付ける（省略不可）
  @Column(name = "staff_no") // memo:@Columnでカラム名を紐づける（省略可）
  private String staff_no;
  @Column(name = "office_cd")
  private String office_cd;
  @Column(name = "staff_name")
  private String staff_name;
  @Column(name = "work_time")
  private String work_time;
  @Column(name = "create_date")
  private String create_date;

  /**
   * デフォルトコンストラクタ <br />
   * 自動生成されたコンストラクタ <br />
   */
  public WorkEntity() {
    super();
  }

  /**
   * 引数付きコンストラクタ <br />
   * パラメータを初期値に持つインスタンスを生成する <br />
   *
   * @param staff_no スタッフNo
   * @param office_cd 事務所コード
   * @param staff_name スタッフ名
   * @param work_time 勤務時間
   * @param create_date 作成日
   */
  public WorkEntity( String staff_no, String office_cd, String staff_name, String work_time,
      String create_date ) {
    super();
    this.staff_no = staff_no;
    this.office_cd = office_cd;
    this.staff_name = staff_name;
    this.work_time = work_time;
    this.create_date = create_date;
  }

  /**
   * @return staff_no
   */
  public String getStaff_no() {
    return staff_no;
  }

  /**
   * @param staff_no セットする staff_no
   */
  public void setStaff_no( String staff_no ) {
    this.staff_no = staff_no;
  }

  /**
   * @return office_cd
   */
  public String getOffice_cd() {
    return office_cd;
  }

  /**
   * @param office_cd セットする office_cd
   */
  public void setOffice_cd( String office_cd ) {
    this.office_cd = office_cd;
  }

  /**
   * @return staff_name
   */
  public String getStaff_name() {
    return staff_name;
  }

  /**
   * @param staff_name セットする staff_name
   */
  public void setStaff_name( String staff_name ) {
    this.staff_name = staff_name;
  }

  /**
   * @return work_time
   */
  public String getWork_time() {
    return work_time;
  }

  /**
   * @param work_time セットする work_time
   */
  public void setWork_time( String work_time ) {
    this.work_time = work_time;
  }

  /**
   * @return create_date
   */
  public String getCreate_date() {
    return create_date;
  }

  /**
   * @param create_date セットする create_date
   */
  public void setCreate_date( String create_date ) {
    this.create_date = create_date;
  }

}
