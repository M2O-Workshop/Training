/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package com.example.login;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
//memo:Thymeleaf、コントローラーともに@RequestMappingで階層化が可能。
//マッピングパスにおける先頭の"/"の有無は関係ない模様。

/**
 * @author yamamoto-t <br />
 *         サンプル用コントローラー <br />
 *         ログイン処理を制御するコントローラークラス <br />
 *         更新履歴 2016/11/01 yamamoto-t：新規作成 <br />
 */
@Controller
@EnableAutoConfiguration
@RequestMapping(value = "login", method = RequestMethod.POST)
public class LoginController {

  /**
   * ログイン処理メソッド<br />
   * ログイン処理を実行する <br />
   *
   * @param model パラメータモデル
   * @param user_id ユーザーID
   * @param pass_word パスワード
   * @return DB登録入力画面へ遷移
   */
  @RequestMapping(value = "execute_login", method = RequestMethod.POST)
  public String insertRecord( Model model,
      @RequestParam("user_id") String user_id,
      @RequestParam("pass_word") String pass_word ) {

    // TODO ログイン処理の実装

    return "insert/insert_input";
  }
}
