/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package com.example.insert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.db.WorkEntity;
import com.example.db.WorkRepository;

/**
 * @author yamamoto-t <br />
 *         サンプル用コントローラー <br />
 *         DB登録処理を制御するコントローラークラス <br />
 *         更新履歴 2016/11/01 yamamoto-t：新規作成 <br />
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "insert", method = RequestMethod.GET)
public class InsertController {

  //リポジトリのインスタンスを生成
  @Autowired
  private WorkRepository workRepository;

  /**
   * DB登録処理メソッド <br />
   * エンティティからDBへデータを登録 <br />
   *
   * @param model パラメータモデル
   * @param staff_no スタッフNo
   * @param office_cd 事務所コード
   * @param staff_name スタッフ名
   * @param work_time 勤務時間
   * @param create_date 作成日
   * @return 登録結果画面へ遷移
   */
  @RequestMapping(value = "insert_record", method = RequestMethod.POST)
  public String insertRecord( Model model,
      @RequestParam("staff_no") String staff_no,
      @RequestParam("office_cd") String office_cd,
      @RequestParam("staff_name") String staff_name,
      @RequestParam("work_time") String work_time,
      @RequestParam("create_date") String create_date ) {

    // DBエンティティの生成
    WorkEntity workEntity = new WorkEntity( staff_no, office_cd, staff_name, work_time, create_date );
    // DBエンティティをリポジトリに引き渡し、保存（登録）
    workRepository.saveAndFlush( workEntity );
    // 結果表示のため、リポジトリに対し全件検索を実行
    Iterable<WorkEntity> list = workRepository.findAll( new PageRequest( 0, 100 ) );
    // 検索結果を格納したリストをリクエストにセット
    model.addAttribute( "results", list );

    // 登録結果画面へ遷移
    return "insert/insert_result";
  }

  /**
   * 戻るボタンロジック <br />
   * 戻るボタン押下時の処理 <br />
   *
   * @param model パラメータモデル
   * @return 登録入力画面へ遷移
   */
  @RequestMapping(value = "execute_back", method = RequestMethod.POST)
  public String executBack( Model model ) {

    // TODO 戻り遷移処理の実装

    // ひとまず何もせず登録入力へ戻る
    return "insert/insert_input";
  }
}
