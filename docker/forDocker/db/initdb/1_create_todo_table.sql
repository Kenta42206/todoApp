CREATE DATABASE tododb;
-- DBへ切り替え
\c tododb
-- スキーマ作成
CREATE SCHEMA dev;
-- ロールの作成
CREATE ROLE devUser WITH LOGIN PASSWORD 'postgres';
-- 権限追加
GRANT ALL PRIVILEGES ON SCHEMA dev TO devUser;

-- テーブル作成
CREATE TABLE  dev.todo (
  id serial NOT NULL,
  todo_name varchar(500),
  user_name varchar(100),
  created_at TIMESTAMP,
  updated_at TIMESTAMP,
  PRIMARY KEY(id)
);

-- 権限追加
GRANT ALL PRIVILEGES ON dev.todo TO devUser;