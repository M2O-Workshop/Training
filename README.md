# Training
example&amp;sample resources for training.

## Table of Contents

* [Overview](#overview)
* [Documents](#documents)
* [Contents](#contents)
* [And More Informations..](#informations)

***

## <a name="overview"> Overview
OMSBおよびm2oで扱う各種新技術の検証、共有、トレーニングを目的とした
自由開発用のリポジトリです。

なお、環境に関しては原則としてOMSBに準じますが、
例えばJDKは1.8あるいは1.7のどちらも許容する等、
サーバー動作に影響を与えない範囲で自由とします。


## <a name="documents"> Documents
OMSBにおける各種ドキュメントの管理は以下の通り：

* 主にスタートアップ資料やナレッジ資料を扱い、リポジトリの「doc」フォルダの配下に格納
* その他の事項で共有すべき事項は、[wiki](https://github.com/M2O-Workshop/OMSB/wiki)に記載

## <a name="contents"> Contents
Trainingのコンテンツは以下の通り:

* stsSample：シンプルなSpringBoot+Mavenで作成したサンプルWebアプリ。まずはここから。
* jsug-shop：応用的なサンプルWebアプリ。SpringBootのハンズオンをカスタマイズした物です。

## <a name="informations"> And More Informations

（jsug-shopの概要）
SpringBoot公式のハンズオン用プログラムをベースとしている。

汎用的なEC（Electronic Commerce:電子商取引、お買い物）サイトを題材に、
HTML等のリソースやオブジェクト（domain）クラスは予め用意されており、
学習者は提示されたコードでロジッククラスを作成していく内容。
実際に作成後、デザインやJavaScriptの追加等を進めている。

詳細については以下URLを参照のこと。
http://jsug-spring-boot-handson.readthedocs.io/en/latest/index.html


（lombokについて）
jsug-shopはsetter/getterをコード自動補完jar「lombok」に委ねており、
初回ビルドの前にjsug-shopフォルダ直下の「lombok.jar」をダブルクリックする必要がある。
（表示されるウィンドウで「Install/Update」ボタンを押下。
　初回ビルド時の１回のみで良く、eclipseの設定ファイル「eclipse.ini」が更新される。）

詳細については以下URLを参照のこと。
*https://projectlombok.org/
*http://qiita.com/opengl-8080/items/671ffd4bf84fe5e32557

