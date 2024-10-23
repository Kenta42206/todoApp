-- サンプルレコード作成
INSERT INTO dev.todo VALUES(1, '御飯食べる', 'あすからんぐれー', now());
INSERT INTO dev.todo VALUES(2, '眠いので寝ること', 'HappyCat', now());
INSERT INTO dev.todo VALUES(3, '仕事を探す', 'モダン技術で仕事したいマン', now());
-- DBコンテナ初期化の際にIdシーケンスが狂うので
-- シーケンスを新たなに作成して修正する
create sequence todo_seq;
select setval('todo_seq', (select max(id) from dev.todo));
-- シーケンスをテーブルに適用する
ALTER TABLE dev.todo ALTER COLUMN id SET DEFAULT nextval('todo_seq');