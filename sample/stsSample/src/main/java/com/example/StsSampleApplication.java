/**
 * Copyright 2016 EIS Co., Ltd. All rights reserved.
 */

package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yamamoto-t <br />
 *         サンプル用ルートクラス <br />
 *         アプリ起動の起点となるクラス <br />
 *         更新履歴 2016/11/01 yamamoto-t：新規作成 <br />
 */
@SpringBootApplication
@Controller
public class StsSampleApplication extends SpringBootServletInitializer {

  // memo: SpringMVCはmainメソッドが最初に実行される。
  /**
   * サンプルアプリメインメソッド <br />
   * アプリケーションのインスタンスを生成して、起動する。 <br />
   * @param args 起動引数
   */
  public static void main( String[] args ) {
    SpringApplication.run( StsSampleApplication.class, args );
  }

  // memo:Springでwarを生成するために必要な記述。
  /* (非 Javadoc)
   * @see org.springframework.boot.web.support.SpringBootServletInitializer#configure
   * (org.springframework.boot.builder.SpringApplicationBuilder)
   */
  /**
   * warビルドメソッド <br />
   * ビルド時にwarを生成するために必要となる定型メソッド。 <br />
   * @param application アプリケーションビルダー
   */
  @Override
  protected SpringApplicationBuilder configure( SpringApplicationBuilder application ) {
    return application.sources( StsSampleApplication.class );
  }

  // ルートからログイン画面にそのまま遷移
  /**
   * コンテキストルートのコントローラー <br />
   * コンテキストルートにアクセスした際の制御を記述する。 <br />
   * @return ログイン画面へ遷移
   */
  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String index() {
    return "login/login_input";
  }

}
