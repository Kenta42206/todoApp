CREATE DATABASE tododb;
-- DBへ切り替え
\c tododb
-- スキーマ作成
CREATE SCHEMA dev;
-- ロールの作成
CREATE ROLE dev WITH LOGIN PASSWORD 'dev';
-- 権限追加
GRANT ALL PRIVILEGES ON SCHEMA dev TO dev;

-- テーブル作成
CREATE TABLE  dev.todo (
  id serial NOT NULL,
  title varchar(500),
  compleated BOOLEAN DEFAULT FALSE,
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  PRIMARY KEY(id)
);

-- 権限追加
GRANT ALL PRIVILEGES ON todo TO dev;