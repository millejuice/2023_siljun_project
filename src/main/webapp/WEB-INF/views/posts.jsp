<%--
  Created by IntelliJ IDEA.
  User: juhyun
  Date: 2023/12/01
  Time: 7:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@page import="com.example.board.BoardVO, com.example.board.BoardDAO" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
  <title>free board</title>
  <style>
    #list {
      font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
      border-collapse: collapse;
      width: 100%;
    }
    #list td, #list th {
      border: 1px solid #ddd;
      padding: 8px;
      text-align:center;
    }
    #list tr:nth-child(even){background-color: #f2f2f2;}
    #list tr:hover {background-color: #ddd;}
    #list th {
      padding-top: 12px;
      padding-bottom: 12px;
      text-align: center;
      background-color: #006bb3;
      color: white;
    }
  </style>
  <script>
    function delete_ok(id){
      let a = confirm("정말로 삭제하겠습니까?");
      if(a) location.href='deleteok/' + id;
    }
  </script>
</head>
<body>
<div>
  <h1>자유게시판</h1>

</div>
<br>
<table id="list" width="90%">
  <tr>
    <th>Id</th>
    <th>Category</th>
    <th>Title</th>
    <th>Writer</th>
    <th>Content</th>
    <th>Regdate</th>
    <th>View</th>
    <th>Edit</th>
    <th>Delete</th>
  </tr>
  <c:forEach items="${list}" var="u">
    <tr>
      <td>${u.seq}</td>
      <td>${u.category}</td>
      <td>${u.title}</td>
      <td>${u.writer}</td>
      <td>${u.content}</td>
      <td>${u.create_date}</td>
      <td><a href="view/${u.seq}">Detail</a></td>
      <td><a href="editform/${u.seq}">Edit</a></td>
      <td><a href="javascript:delete_ok('${u.seq}')">Delete</a></td>
    </tr>
  </c:forEach>
</table>
<br/><a href="add">목록 추가하기</a>
</body>
</html>
