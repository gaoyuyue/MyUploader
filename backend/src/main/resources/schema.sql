create table file(
  id bigint auto_increment ,
  md5 varchar(32) not null ,
  path varchar(100) not null ,
  upload_time datetime(3) not null ,
  primary key (id)
);
