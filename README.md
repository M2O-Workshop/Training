﻿# **Training**
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

### jsug-shopの概要  
 SpringBoot公式のハンズオン用プログラムをベースとしている。  
  
 汎用的なEC（Electronic Commerce:電子商取引、お買い物）サイトが題材となっている。  
 HTML等のリソースやオブジェクト（domain）クラスは予め用意されており、  
 トレイニーは提示されたコードを組み込みながらロジッククラスを作成していく内容。  
 実際に作成した後、CSSやJavaScriptを修正し、主にデザイン観点の試行を行っている。  

 公式ハンズオンの詳細については以下URLを参照のこと。  
 [SpringBoot公式サイト]http://jsug-spring-boot-handson.readthedocs.io/en/latest/index.html  

### lombokについて  
 jsug-shopはsetter/getterをコード自動補完jar「lombok」に委ねており、  
 初回ビルドの前にjsug-shopフォルダ直下の「lombok.jar」をダブルクリックする必要がある。  

 ※表示されるウィンドウで「Install/Update」ボタンを押下。  
 初回ビルド時の１回のみで良く、eclipseの設定ファイル「eclipse.ini」が更新される。  

 lombok詳細については以下URLを参照のこと。  
 [作成者サイト]https://projectlombok.org/  
 [参考ページ]http://qiita.com/opengl-8080/items/671ffd4bf84fe5e32557  

### Webフォントについて  
 jsug-shopではフォントにWebフォントを採用している。  
 これは2011年から策定が進められているCSS3で実装された新しい技術で、  
 Webアプリ内や内外のサーバーに配置されたフォントファイルでの文字表示が可能となる。  
 結果として、Webアプリにおけるデザインの自由度が飛躍的に高まる。  

 従来CSS2.1まではクライアント（Webページを見るPC）にインストールされたフォントファイルのみが  
 表示可能であったため、自ずとOSプリセットフォントが前提となり大きな制約となっていた。

 Webフォントの詳細については以下URLを参照のこと。  
 [参考ページ]http://www.6666666.jp/design/20160218/  
 なお、フリーフォント使用時は配布元のライセンスや使用条件を必ず確認すること。  

***

