<!-- 査定条件を入力し、結果を表示する画面 -->
<!-- 更新履歴 2016/12/11 Yamamoto Takashi：新規作成 -->
<!--          2016/12/31 Yamamoto Takashi：PJT構成の変更に伴い、jsのPATHを修正 -->
<!--          2017/01/04 Yamamoto Takashi：PRAM_PRODUCTのvalueに査定処理名を追加 -->
<!--          2017/01/05 Yamamoto Takashi：PRAM_PRODUCTのvalueを商品種類のみに再修正 -->
<%-- UnderWriteConstのstatic importを行う --%>
<%@page import="static constant.UnderWriteConst.*"%>
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
    request.setCharacterEncoding( ENCORD_TYPE );
    // リクエストからentityを取得
    ProposalEntity entity = ( ProposalEntity ) request.getAttribute( ATTR_ENTITY );
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
  <%= entity.getUnderWrite() %>
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
          <input type="text" name=<%= PRAM_AGE %> value=<%= entity.getAge() %> maxlength="3">
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
          <input type="radio" name=<%= PRAM_GENDER %> value=<%= GENDER_MALE %> <%= GENDER_MALE.equals(entity.getGender()) ? " checked=\"checked\"" : "" %>>男
          <input type="radio" name=<%= PRAM_GENDER %> value=<%= GENDER_FEMALE %> <%= GENDER_FEMALE.equals(entity.getGender()) ? " checked=\"checked\"" : "" %>>女
          <input type="radio" name=<%= PRAM_GENDER %> value=<%= GENDER_CORP %> <%= GENDER_CORP.equals(entity.getGender()) ? " checked=\"checked\"" : "" %>>法人
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
          <select name=<%= PRAM_PRODUCT %> id="product">
            <option value=<%= PRODUCT_CANCER %> <%= PRODUCT_CANCER.equals(entity.getProduct()) ? " selected=\"selected\"" : "" %>>がん保険</option>
            <option value=<%= PRODUCT_MEDICAL %> <%= PRODUCT_MEDICAL.equals(entity.getProduct()) ? " selected=\"selected\"" : "" %>>医療保険</option>
            <option value=<%= PRODUCT_ORDINARY %> <%= PRODUCT_ORDINARY.equals(entity.getProduct()) ? " selected=\"selected\"" : "" %>>普通保険</option>
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