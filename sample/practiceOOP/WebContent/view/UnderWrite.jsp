<%-- 査定条件を入力し、結果を表示する画面 --%>
<%@page import="entity.ProposalEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>practiceOOP</title>
<%-- JavaScript --%>
<script type="text/javascript" src="../js/common.js"></script>
</head>
<body>
  <%
    // 文字エンコードの指定
    request.setCharacterEncoding( "UTF-8" );
    // リクエストからentityを取得
    ProposalEntity entity = ( ProposalEntity ) request.getAttribute( "entity" );
    // entityが空の場合は初期化を行う
    if ( entity == null ) {
      entity = new ProposalEntity();
    }
  %>
  <%-- デバッグコード : entityの格納値を全出力--%>
  debug-code:
  <%= entity.getAge() %>
  <%= entity.getGender() %>
  <%= entity.getProduct() %>
  <%= entity.isResult() %>
  <%= entity.getResultStr() %>

  <%-- 査定条件入力部 --%>
  <p>申し込み条件を入力して下さい。</p>
  <form action="./MainServlet" method="post" name="inputForm" id="inputForm" onSubmit="return inputAgeCheck()">
    <table>
      <tr>
        <td>
          年齢
        </td>
        <td>
          <input type="text" name="age" value="<%= entity.getAge() %>" maxlength="3">
        </td>
        <td id="ageErrorMsg">
          <%-- 初期状態は何も表示しない --%>
        </td>
      </tr>
      <tr>
        <td>
          性別
        </td>
        <td>
          <input type="radio" name="gender" value="male" <%= "male".equals(entity.getGender()) ? " checked=\"checked\"" : "" %>>男
          <input type="radio" name="gender" value="female" <%= "female".equals(entity.getGender()) ? " checked=\"checked\"" : "" %>>女
          <input type="radio" name="gender" value="corporation" <%= "corporation".equals(entity.getGender()) ? " checked=\"checked\"" : "" %>>法人
        </td>
        <td id="genderErrorMsg">
          <%-- 初期状態は何も表示しない --%>
        </td>
      </tr>
      <tr>
        <td>
          保険商品
        </td>
        <td>
          <select name="product" id="product">
            <option value="cancer" <%= "cancer".equals(entity.getProduct()) ? " selected=\"selected\"" : "" %>>がん保険</option>
            <option value="medical" <%= "medical".equals(entity.getProduct()) ? " selected=\"selected\"" : "" %>>医療保険</option>
            <option value="ordinary" <%= "ordinary".equals(entity.getProduct()) ? " selected=\"selected\"" : "" %>>普通保険</option>
          </select>
        </td>
        <td id="productErrorMsg">
          <%-- 初期状態は何も表示しない --%>
        </td>
      </tr>
      <tr>
        <td>
        </td>
        <td>
          <input type="submit" value="査定実行">
          <input type="button" value="リセット" onclick="formReset()">
        </td>
      </tr>
    </table>
  </form>

  <%-- 査定結果出力部 --%>
  <p id="resultLabel">
    <% if ("".equals( entity.getResultStr() )){ %>
      <%-- 初期状態は何も表示しない --%>
    <% }else{ %>
      査定結果：<%= entity.getResultStr() %>
    <% } %>
  </p>

</body>
</html>