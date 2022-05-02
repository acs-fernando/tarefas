# Tarefas

<h3>Sistema de gerenciamento de tarefas</h3>

Necessário rodar o seguinte script na base MySQL:

<code>
insert into users (id,username,nome,password,dados_pessoa_id,enabled,usuario_tipo) values (nextVal('users_id_seq'),'admin','Usuário Padrão','$2a$10$iCDss1UbryNjJjKuBd0LOOwAl0MAwNqs1TMFUHoo8AFydYJzlQAJG',null,true,'PADRAO');
</code><br>
<code>
insert into authorities (username, authority) values ('admin','master');
</code><br>
<code>
insert into projeto (id,titulo) values (nextVal('projeto_id_seq'),'Company');
</code><br>
<code>
insert into dados_pessoa (id,cpf,email,nome) values (nextVal('dados_pessoa_id_seq'),'664.176.590-38','acassio.fernando89@gmail.com','Acassio Silva');
</code>
