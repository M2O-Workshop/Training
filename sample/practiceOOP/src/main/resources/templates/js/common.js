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
}
