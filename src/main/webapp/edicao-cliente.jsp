<%--
  Created by IntelliJ IDEA.
  User: Administrador
  Date: 26/07/2022
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edição de Cliente</title>
</head>
<body>
<h1>Edição de Cliente</h1>
<fieldset>
    <legend>Dados basicos</legend>
    <form action="editar-cliente" method="post">
        <div>
            <input type="hidden" name="id" value="${cliente.id}"> <!-- para identificar na alteracao -->
        </div>
        <div>
            <label for="idNome">Nome:</label>
            <input type="text" id="idNome" name="nome" value="${cliente.nome}">
        </div>
        <div>
            <label for="idCpf">CPF:</label>
            <input type="text" id="idCpf" name="cpf" value="${cliente.cpf}">
        </div>
        <div>
            <label for="idEmail">Email:</label>
            <input type="text" id="idEmail" name="email" value="${cliente.email}">
        </div>
        <div>
            <label for="idIdade">Idade:</label>
            <input type="text" id="idIdade" name="idade" value="${cliente.idade}">
        </div>
        <input type="submit" value="Enviar">
    </form>
</fieldset>

</body>
</html>
