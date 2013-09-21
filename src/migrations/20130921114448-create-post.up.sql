create table if not exists post (
  id integer ,
  title varchar(255),
  body text,
  saved timestamp,
  version integer);
--;;
create table if not exists name (
  id serial primary key,
  first varchar(255) not null,
--;;
create table if not exists author (
  id serial primary key);
--;;
create table if not exists author_post (
  post_id integer,
  author_id integer
  constraint relationship primary key(post_id, author_id));
  
