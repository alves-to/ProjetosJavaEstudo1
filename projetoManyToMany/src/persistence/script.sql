drop database if exists lumachete;
create database lumachete;
use lumachete;

drop table aluno;
drop table curso;
drop table aluno_curso;

create table aluno(
	idAluno int primary key auto_increment,
	nome varchar(50),
    email varchar(50) unique
);

create table curso(
	idCurso int primary key auto_increment,
	nomeCurso varchar(50) unique
);

create table aluno_curso(
	id_aluno int,
    id_curso int,
    primary key(id_aluno, id_curso),
    foreign key(id_aluno) references aluno(idAluno),
    foreign key(id_curso) references curso(idCurso)					
);

insert into aluno values(100,'eterno smith','eterno@gmail.com');
insert into aluno values(200,'thiago forever','thiago@gmail.com');
insert into aluno values(300,'guilherme reload','reload@gmail.com');
insert into aluno values(400,'hugo infinito','infinito@gmail.com');
commit;
select * from aluno;

insert into curso values(1,'java developer');
insert into curso values(2,'plsql');
insert into curso values(3,'EJB');
commit;
select * from curso;

insert into aluno_curso values(100,1);
insert into aluno_curso values(200,1);
insert into aluno_curso values(200,2);
insert into aluno_curso values(300,1);
insert into aluno_curso values(400,1);
insert into aluno_curso values(400,2);
commit;
select * from aluno_curso;

select a.idAluno, a.nome, a.email, c.idCurso, c.nomeCurso
  from aluno_curso ac inner join aluno a
    on a.idAluno = ac.id_aluno
  inner join curso c
    on c.idCurso = ac.id_curso
  order by a.idAluno, c.idCurso;  

create or replace view V$Consulta as  
  select a.idAluno, a.nome, a.email, c.idCurso, c.nomeCurso
    from aluno_curso ac inner join aluno a
      on a.idAluno = ac.id_aluno
    inner join curso c
      on c.idCurso = ac.id_curso
    order by a.idAluno, c.idCurso;    
  
select * from V$Consulta;
desc V$Consulta;

show tables;
