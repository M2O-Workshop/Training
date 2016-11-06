// 画面の終了を確認する
// firefoxはスクリプトで開いたウィンドウのみwindow.close()が有効となる。
function exit_confirm() {
    if (window.confirm('終了しますか？')) {
//        return true;
      window.open('','_self').close();
    }
    return false;

}

//DBへのデータ登録を確認する
function insert_confirm() {
 if (window.confirm('データを登録してよろしいですか？')) {
     return true;
 }
 return false;

}

//戻るボタン押下時の処理
function back_confirm() {
 if (window.confirm('前画面に戻ってよろしいですか？')) {
     return true;
 }
 return false;

}

$('.datetimepicker').datetimepicker({
    format: 'Y-m-d H:i',
    inline: true,
    lang: 'ja'
  });
