/**
 * 共通JavaScriptファイル
 * クライアントサイドで実行する処理を記述する
 * 更新履歴 2016/12/11 Yamamoto Takashi：新規作成
 */

/**
 * 年齢の入力チェック処理
 * 年齢の入力値をチェックする
 * [引数]   無し
 * [返却値] true:  処理を実行
 *          false: 処理を中止
 */
function inputAgeCheck() {
  // 入力チェックの実行
  if ( isNumber(document.inputForm.age.value) == false) {
    //window.alert('年齢には3桁までの半角数値を入力して下さい。');
    document.getElementById("ageErrorMsg").innerHTML
      = "年齢には3桁までの半角数値を入力して下さい。";
    return false;
  }
  return true;
}

/**
 * 数値チェック関数
 * 入力値が数値 (0以上の整数のみ許容) であることをチェックする
 * [引数]   numVal: 入力値
 * [返却値] true:  数値
 *          false: 数値以外
 */
function isNumber(numVal){
  // チェック条件パターン
  var pattern = /^([1-9]\d*|0)$/;
  // チェック条件との一致をチェック
  return pattern.test(numVal);
}

/**
 * 入出力リセット処理
 * 入出力フォームをリセットする
 */
function formReset() {
  // 入力フォーム初期化
  document.inputForm.age.value = "0";	
  document.getElementsByName("gender")[0].checked = true;
  document.getElementById("product").selectedIndex = "0" ;
  // form.resetの場合は遷移時の状態を維持する
  // document.getElementById("inputForm").reset;
  // 出力ラベルの初期化
  document.getElementById("ageErrorMsg").innerHTML = "";
  document.getElementById("resultLabel").innerHTML = "";
  document.getElementById("dateLabel").innerHTML = "";
}

/**
 * 年齢ポップオーバー
 * 年齢ポップオーバーメッセージの定義
 */
$(function() {
  // ポップオーバー文言
  $('#popover_age').attr('data-content','被保険者の年齢を3桁までの半角数値で入力して下さい。');
  // ポップオーバーアクション
  $("[data-toggle=popover_age]").popover({
    trigger: 'hover',// click,hover,focus,manualを選択出来る
    html: true,// HTMLタグを含めるか
  });
});

/**
 * 性別ポップオーバー
 * 性別ポップオーバーメッセージの定義
 */
$(function() {
  // ポップオーバー文言
  $('#popover_gender').attr('data-content','被保険者の性別もしくは法人を選択して下さい。');
  // ポップオーバーアクション
  $("[data-toggle=popover_gender]").popover({
    trigger: 'hover',// click,hover,focus,manualを選択出来る
    html: true,// HTMLタグを含めるか
  });
});

/**
 * 保険商品ポップオーバー
 * 保険商品ポップオーバーメッセージの定義
 */
$(function() {
  // ポップオーバー文言
  $('#popover_product').attr('data-content','申し込む保険商品の種類を選択して下さい。');
  // ポップオーバーアクション
  $("[data-toggle=popover_product]").popover({
    trigger: 'hover',// click,hover,focus,manualを選択出来る
    html: true,// HTMLタグを含めるか
  });
});

/**
 * ボタンポップオーバー
 * ボタンポップオーバーメッセージの定義
 */
$(function() {
  // ポップオーバー文言
  $('#popover_submit').attr('data-content','査定実行：査定を実行します。　リセット：入力を初期化します。');
  // ポップオーバーアクション
  $("[data-toggle=popover_submit]").popover({
    trigger: 'hover',// click,hover,focus,manualを選択出来る
    html: true,// HTMLタグを含めるか
  });
});
