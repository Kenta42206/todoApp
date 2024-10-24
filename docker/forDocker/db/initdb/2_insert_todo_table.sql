\c tododb
-- サンプルレコード作成
INSERT INTO dev.todo VALUES(1, '御飯食べる', false, '2019/03/01 10:00:00');
INSERT INTO dev.todo VALUES(2, '眠いので寝ること', false, '2019/03/01 10:00:00');
INSERT INTO dev.todo VALUES(3, '仕事を探す', false, now());
-- DBコンテナ初期化の際にIdシーケンスが狂うので
-- シーケンスを新たなに作成して修正する
create sequence todo_seq;
GRANT USAGE ON SEQUENCE todo_seq TO dev;
select setval('todo_seq', (select max(id) from dev.todo));
-- シーケンスをテーブルに適用する
ALTER TABLE dev.todo ALTER COLUMN id SET DEFAULT nextval('todo_seq');