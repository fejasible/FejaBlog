/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2017/3/5 12:40:20                            */
/*==============================================================*/


drop table if exists article;

drop table if exists article_type;

drop table if exists config;

drop table if exists recommend;

drop table if exists type;

/*==============================================================*/
/* Table: article                                               */
/*==============================================================*/
create table article
(
   article_id           int not null auto_increment,
   title                varchar(255),
   content              text,
   is_delete            int default 0,
   is_draft             int default 0,
   visible              int default 0,
   date                 date,
   primary key (article_id)
);

/*==============================================================*/
/* Table: article_type                                          */
/*==============================================================*/
create table article_type
(
   article_type_id      int not null auto_increment,
   article_id           int,
   type_id              int,
   primary key (article_type_id)
);

/*==============================================================*/
/* Table: config                                                */
/*==============================================================*/
create table config
(
   config_id            int not null auto_increment,
   blog_name            varchar(255),
   blog_describe        text,
   copyright            varchar(255),
   username             varchar(255),
   password             varchar(255),
   profile              text,
   primary key (config_id)
);

/*==============================================================*/
/* Table: recommend                                             */
/*==============================================================*/
create table recommend
(
   recommend_id         int not null auto_increment,
   article_id           int,
   primary key (recommend_id)
);

/*==============================================================*/
/* Table: type                                                  */
/*==============================================================*/
create table type
(
   type_id              int not null auto_increment,
   type                 varchar(255),
   primary key (type_id)
);

alter table article_type add constraint FK_Reference_3 foreign key (article_id)
      references article (article_id) on delete restrict on update cascade;

alter table article_type add constraint FK_Reference_4 foreign key (type_id)
      references type (type_id) on delete restrict on update cascade;

alter table recommend add constraint FK_Reference_5 foreign key (article_id)
      references article (article_id) on delete restrict on update restrict;

