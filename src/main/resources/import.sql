insert into grupo(id, nome, descricao) values (1, "grupo 1", "Grupo que cuida da limpeza.");
insert into grupo(id, nome, descricao) values (2, "grupo 2", "Grupo que cuida do arranjo.");
insert into grupo(id, nome, descricao) values (3, "grupo 3", "Grupo que cuida da comida.");

insert into pessoa(id, nome, email, funcao, grupo_id) values (1, "Pedro", "opedrooo@algo.com", "cara da vassoura", 1);
insert into pessoa(id, nome, email, funcao, grupo_id) values (2, "Paula", "paulaada@outroalgo.com", "gerente de balde", 1);
insert into pessoa(id, nome, email, funcao, grupo_id) values (3, "Phelipe", "phepepe@maisoutroalgo.com", "cara do paninho", 1);
insert into pessoa(id, nome, email, funcao, grupo_id) values (4, "Marcos", "marcaum@gemail.com", "abridor de portas", 2);
insert into pessoa(id, nome, email, funcao, grupo_id) values (5, "Mariza", "mamariza@iarru.com", "encarregada de ser a mandona", 2);
insert into pessoa(id, nome, email, funcao, grupo_id) values (6, "Nathan", "nathanada@autiluki.com", "cara da esponja", 3);
insert into pessoa(id, nome, email, funcao, grupo_id) values (7, "Nicole", "nicool.hahaha@rotimeil.com", "gerente de cozinha", 3);

insert into tarefa(id, nome, descricao, data_inicio, data_fim, grupo_id, pessoa_id) values (1, "Varrer sala", "Varrer a sala para esperar visitantes.", "2019-06-01 00:00:00", "2019-06-01 00:00:00", 1, 1);
insert into tarefa(id, nome, descricao, data_inicio, data_fim, grupo_id, pessoa_id) values (2, "Cuidar do balde", "Levar o balde para perto do Pedro toda vez que este se mover de local.", "2019-06-01 00:00:00", "2019-06-01 00:00:00", 1, 2);
insert into tarefa(id, nome, descricao, data_inicio, data_fim, grupo_id, pessoa_id) values (3, "Limpar janelas", "Limpar as janelas da sala para esperar visitantes.", "2019-06-01 00:00:00", "2019-06-01 00:00:00", 1, 3);
insert into tarefa(id, nome, descricao, data_inicio, data_fim, grupo_id, pessoa_id) values (4, "Cuidar da porta", "Abrir a porta para todos os visitantes que forem chegando.", "2019-06-02 00:00:00", "2019-06-02 00:00:00", 2, 4);
insert into tarefa(id, nome, descricao, data_inicio, data_fim, grupo_id, pessoa_id) values (5, "Mandar fazerem tarefas", "Ficar vigiando se os demais encarregados realizaram suas tarefas.", "2019-06-02 00:00:00", "2019-06-02 00:00:00", 2, 5);
insert into tarefa(id, nome, descricao, data_inicio, data_fim, grupo_id, pessoa_id) values (6, "Lavar pratos", "Lavar os pratos para a chegada dos visitantes.", "2019-06-02 00:00:00", "2019-06-02 00:00:00", 3, 6);
insert into tarefa(id, nome, descricao, data_inicio, data_fim, grupo_id, pessoa_id) values (7, "Cuidar da cozinha", "Gerenciar as comidas que estiverem sendo feitas.", "2019-06-02 00:00:00", "2019-06-02 00:00:00", 3, 7);
insert into tarefa(id, nome, descricao, data_inicio, data_fim, grupo_id) values (8, "Limpar cozinha", "Limpar a cozinha para o preparo da comida.", "2019-06-01 00:00:00", "2019-06-01 00:00:00", 1);
insert into tarefa(id, nome, descricao, data_inicio, data_fim, grupo_id) values (9, "Receber visitantes", "Garantir que os visitantes se sentem bem recebidos.", "2019-06-02 00:00:00", "2019-06-02 00:00:00", 2);