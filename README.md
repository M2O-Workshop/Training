# **Training**  
example&amp;sample resources for training. :baby:  
  
## Table of Contents  
  
* [Overview](#overview)  
* [Documents](#documents)  
* [Contents](#contents)  
* [And More Informations..](#informations)  
  
***  
  
## <a name="overview"> _Overview_ :earth_asia:  
OMSBおよびm2oで扱う各種新技術の検証／共有／トレーニングを目的とした  
自由開発用のリポジトリです。  
  
なお、環境に関しては原則としてOMSBに準じますが、  
例えばJDKは1.8あるいは1.7のどちらも許容する等、  
サーバー動作に影響を与えない範囲で自由とします。  
  
***  
  
## <a name="documents"> _Documents_ :books:  
OMSBにおける各種ドキュメントの管理は以下の通り：  
  
* 主にスタートアップ資料やナレッジ資料を扱い、リポジトリの「doc」フォルダの配下に格納  
* その他の事項で共有すべき事項は、[wiki](https://github.com/M2O-Workshop/OMSB/wiki)に記載  
  
***  
  
## <a name="contents"> _Contents_ :hotsprings:  
Trainingのコンテンツは以下の通り:  
  
* stsSample：シンプルなSpringBoot+Mavenで作成したサンプルWebアプリ。まずはここから。  
* jsug-shop：応用的なサンプルWebアプリ。SpringBootのハンズオンをカスタマイズした物です。  
  
***  
  
## <a name="informations"> _And More Informations_ :sparkles:  
  
### stsSampleの概要  
 SpringBootの環境検証も兼ね、最低限の機能のみを使用して作成した雛形サンプル。  
  
 構成としてはJavaにおけるMVCモデルのステレオタイプとも言える、
 * ログイン画面（認証無し）  
 * DB登録画面  
 * DB登録結果画面  
  
 の3画面のみで構成された簡素なアプリとなっている。  
  
 上記を実現するため、SpringBootフレームワーク部分を除外した自作プログラムは、  
 Javaクラスが5本、HTML(Thymeleaf)が3本、他CSS等の補助ファイル数本のみで稼働している。  
  
 また、個々の自作プログラムも1本あたり数行～数十行程度と短い。  
 プログラムの実体（コアとなる部分）の大部分はF/W側に隠蔽されており、  
 アノテーションを利用しそれらを適宜呼び出し実装するだけで開発が可能となっている。  
  
 当サンプル作成に際しては、以下URLの他、各種Webサイトを参考とした。  
 [techscore/Spring Boot 入門]http://www.techscore.com/blog/2014/05/01/spring-boot-introduction/  
  
### jsug-shopの概要  
 SpringBoot公式のハンズオン用プログラムをベースとしている。  
  
 汎用的なEC（Electronic Commerce:電子商取引、お買い物）サイトが題材となっている。  
 HTML等のリソースやオブジェクト（domain）クラスは予め用意されており、  
 トレイニーは提示されたコードを組み込みながらロジッククラスを作成していく内容。  
 実際に作成した後、CSSやJavaScriptを修正し、主にデザイン観点の試行を行っている。  
  
 なお、当アプリの実装にはlombokを使用しており、その詳細はTrainingのwikiを参照のこと。
  
 公式ハンズオンについては以下URLを参照のこと。  
 [SpringBoot公式サイト]http://jsug-spring-boot-handson.readthedocs.io/en/latest/index.html  
  
***  
  
  
###### 更新履歴  
 2016/11/06　初版作成  
 2016/11/14　全体的なレイアウト修正  
 2016/11/20　jQueryに関して追記  
 2016/12/05　アプリ概要以外のAnd More InformationsをTrainingのwikiに移管  
  
***  
