INSERT INTO category (category_id, category_name) VALUES (1, '本');
INSERT INTO category (category_id, category_name) VALUES (2, '音楽');
INSERT INTO category (category_id, category_name) VALUES (3, '家電');
INSERT INTO category (category_id, category_name) VALUES (4, 'パソコン');

-- 本
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76840', 'こころ', '夏目 漱石 の本です', 1, 900);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76841', '〔雨ニモマケズ〕', '宮沢 賢治 の本です', 1, 800);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76842', '走れメロス', '太宰 治 の本です', 1, 880);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76843', '吾輩は猫である', '夏目 漱石 の本です', 1, 900);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76844', '人間失格', '太宰 治 の本です', 1, 880);

-- 音楽

INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76850', '愛はおしゃれじゃない', '岡村靖幸 w 小出祐介', 2, 1080);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76851', '虹の彼方 Remixes', '小瀬村晶', 2, 1080);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76852', 'RECREATION', 'SUPER CAR', 2, 1080);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76853', 'A journey to freedom', 'DE DE MOUSE', 2, 1080);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76854', 'short hair', 'Base Ball Bear', 2, 1080);

-- 家電

INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76860', '単機能レンジ 22L ホワイト NE-EH228-W', 'パナソニック', 3, 10800);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76861', '121L 冷凍庫(フリーザー)シルバーMITSUBISHI MF-U12Y-S', '三菱', 3, 10800);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76862', 'IH炊飯器 極め炊き 3合 NP-GF05XJ', '象印', 3, 10800);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76863', 'ドルチェグスト ジェニオ2 プレミアム ワインレッド MD9771-WR', 'ネスカフェ', 3, 10800);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76864', '餅切り 「まる餅くん」 SMX-5401-W', 'タイガー', 3, 10800);

-- パソコン

INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76870', 'ideapad300 80M300M2JP Windows10', 'Lenovo', 4, 108000);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76871', 'LAVIE Windows10 Celeronデュアルコア1.6GHz', 'NEC', 4, 108000);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76872', 'デスクトップパソコン Optiplex 3020 エクスプレスモデル', 'Dell', 4, 108000);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76873', 'MacBook Air MMGF2J/A', 'Apple', 4, 108000);
INSERT INTO goods (goods_id, goods_name, description, category_id, price)
VALUES ('366cf3a4-68c5-4dae-a557-673769f76874', 'Fire HD 8 タブレット 16GB', 'Amazon', 4, 108000);

