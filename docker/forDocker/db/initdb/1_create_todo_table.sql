-- ロールの作成
CREATE ROLE dev WITH LOGIN PASSWORD 'dev';
CREATE DATABASE tododb with owner = dev;
-- DBへ切り替え
\c tododb
-- スキーマ作成
CREATE SCHEMA dev;
-- 権限追加
GRANT ALL PRIVILEGES ON SCHEMA dev TO dev;

-- テーブル作成
CREATE TABLE  dev.todo (
  id serial NOT NULL,
  title varchar(500),
  done BOOLEAN DEFAULT FALSE,
  limit_date TIMESTAMP,
  PRIMARY KEY(id)
);

-- 権限追加
GRANT ALL PRIVILEGES ON dev.todo TO dev;