create table Curso (
	codigo int,
	nome varchar(20)
);

create table Log_Curso (
	data_hora timestamp,
	operacao varchar(20),
	codigo varchar(20)
);

drop table Log_Curso;