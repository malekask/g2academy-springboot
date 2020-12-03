create table authors (id bigint not null, created_at datetime, createdby varchar(255), updated_at datetime, address varchar(255), name varchar(255), url varchar(255), primary key (id)) engine=InnoDB;
create table authors_audit (id bigint not null, rev integer not null, revtype tinyint, address varchar(255), name varchar(255), url varchar(255), primary key (id, rev)) engine=InnoDB;
create table books (id bigint not null, created_at datetime, createdby varchar(255), updated_at datetime, price double precision, isbn varchar(20), title varchar(255), publish_on mediumint, author_id bigint not null, publisher_id bigint not null, primary key (id)) engine=InnoDB;
create table books_audit (id bigint not null, rev integer not null, revtype tinyint, price double precision, isbn varchar(20), title varchar(255), publish_on mediumint, author_id bigint, publisher_id bigint, primary key (id, rev)) engine=InnoDB;
create table hibernate_sequence (next_val bigint) engine=InnoDB;
insert into hibernate_sequence values ( 1 );
create table publishers (id bigint not null, created_at datetime, createdby varchar(255), updated_at datetime, address varchar(255), name varchar(255), phone varchar(255), url varchar(255), primary key (id)) engine=InnoDB;
create table publishers_audit (id bigint not null, rev integer not null, revtype tinyint, address varchar(255), name varchar(255), phone varchar(255), url varchar(255), primary key (id, rev)) engine=InnoDB;
create table revinfo (rev integer not null auto_increment, revtstmp bigint, primary key (rev)) engine=InnoDB;
alter table authors_audit add constraint FK4h9eexvqe2tf95cot5h3lmj2f foreign key (rev) references revinfo (rev);
alter table books add constraint FKfjixh2vym2cvfj3ufxj91jem7 foreign key (author_id) references authors (id);
alter table books_audit add constraint FKfyfj7ys56hvrijh5f6uklakbl foreign key (rev) references revinfo (rev);
alter table publishers_audit add constraint FKbqi9jslry84m8frk3oon2o5lm foreign key (rev) references revinfo (rev);

