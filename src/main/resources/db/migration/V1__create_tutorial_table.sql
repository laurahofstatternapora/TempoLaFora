--create table IF NOT EXISTS tutorials (
--    id bigint not null,
--    description varchar(255),
--    published boolean,
--    title varchar(255), primary key (id)
--);
--
--create sequence tutorials_seq start with 1 increment by 50

create database previsao;
create table Cadastro_Metereologico(
cidade varchar(100) not null,
dia varchar(10) not null,
tempo varchar(100) not null,
turno varchar(100) not null,
temp_maxima float(3) not null,
temp_minima float (3) not null,
precipitacao int(3) not null,
umidade int(3) not null,
velocidade_do_tempo int(3) not null,
primary key (cidade)
);

insert into  Cadastro_Metereologico(cidade, dia, tempo, turno, temp_maxima, temp_minima, precipitacao, umidade,
velocidade_do_tempo)
values ('Porto Alegre', 31, 'limpo', 'manhã', 31, 18, 10, 30, 30);