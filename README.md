Sistema de Controle de Aluguel de Quadra Esportiva

Objetivo
Desenvolver um sistema para controlar o aluguel de uma quadra esportiva, evitando conflitos de horario registrando pagamentos e permitindo consultas por dia

Tabelas:

Cliente

 id
 nome
 telefone


Horario

 id
 descricaoHorario
 valor


Aluguel

 id
 data
 cliente
 listaHorarios
 valorTotal
 pago

Regras de negocio identificadas

1 Não permitir cadastrar cliente com nome vazio.
2 Não permitir cadastrar horario com valor negativo.
3 Não permitir reservar um horario que ja esteja ocupado na mesma data.
4 O aluguel deve registrar:
    cliente
    data
    horario(s) escolhido(s)
    valor cobrado
    status de pagamento
5 O sistema deve calcular automaticamente o valor total quando o cliente alugar mais de um horario no mesmo dia.
6 O sistema deve permitir consultar todos os alugueis realizados em um determinado dia.
7 Um cliente pode fazer varios alugueis.
8 Um aluguel pode conter um ou mais horarios, desde que todos sejam da mesma data da reserva.
9 O sistema deve impedir inconsistencias de dados basicos no cadastro.
