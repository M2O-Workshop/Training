/*
----------------------------------------------------------------
サンプルアプリ用JavaScript
  更新履歴
  2016/11/12 yamamoto-t：新規作成
----------------------------------------------------------------
 */

// exitConfirm：画面の終了を確認する
// firefoxはスクリプトで開いたウィンドウのみwindow.close()が有効となる。
function exitConfirm() {
  if (window.confirm('終了しますか？')) {
    // return true;
    window.open('', '_self').close();
  }
  return false;
}

// set2fig：数値の桁数を調整する
// 桁数が1桁だったら先頭に0を加えて2桁に調整する。
function set2fig(num) {
  var ret;
  if (num < 10) {
    ret = "0" + num;
  } else {
    ret = num;
  }
  return ret;
}

// showClock：現在日時の生成
// マシン日付を取得し、msgとして編集する。
function showClock() {
  var nowTime = new Date();
  var nowYear = set2fig(nowTime.getFullYear());
  var nowMonth = set2fig(nowTime.getMonth() + 1);
  var nowDay = set2fig(nowTime.getDate());
  var nowWeek = nowTime.getDay();
  var weekArray = new Array("Sun", "Mon", "Tue", "Wed", "The", "Fri", "Thr");

  var nowHour = set2fig(nowTime.getHours());
  var nowMin = set2fig(nowTime.getMinutes());
  var nowSec = set2fig(nowTime.getSeconds());

  var msg = "Today is " + nowYear + "/" + nowMonth + "/" + nowDay + "（"
      + weekArray[nowWeek] + "）　";
  var msg = msg + "Now is " + nowHour + ":" + nowMin + ":" + nowSec + " .";

  // HTML埋め込み用にIDを定義
  document.getElementById("ClockArea").innerHTML = msg;
}

// setTimer：時計の自動更新
// showClock()を1000ミリ秒間隔で実行する。
function setTimer() {
  showClock();
  setInterval('showClock()', 1000);
}

// JavaScriptの動作確認用
function test() {
  alert("testです。");
}
