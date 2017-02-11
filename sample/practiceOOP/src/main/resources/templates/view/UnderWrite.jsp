<!-- 査定条件を入力し、結果を表示する画面 -->
<!-- 更新履歴 2016/12/11 Yamamoto Takashi：新規作成 -->
<!--          2016/12/31 Yamamoto Takashi：PJT構成の変更に伴い、jsのPATHを修正 -->
<!--          2017/01/04 Yamamoto Takashi：PRAM_PRODUCTのvalueに査定処理名を追加 -->
<!--          2017/01/05 Yamamoto Takashi：PRAM_PRODUCTのvalueを商品種類のみに再修正 -->
<!--          2017/01/20 Yamamoto Takashi：UI-designにbootstrapを適用 -->
<%-- UnderWriteConstのstatic importを行う --%>
<%@page import="static constant.UnderWriteConst.*"%>
<%@page import="entity.ProposalEntity"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<title>practiceOOP</title>

<!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
<script src="../js/jquery-3.1.1.min.js"></script>
<!-- Include all compiled plugins (below), or include individual files as needed -->
<script type="text/javascript" src="../js/bootstrap.min.js"></script>
<script type="text/javascript" src="../js/common.js"></script>
<!-- Bootstrap CSS-->
<link href="../css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
      <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
      <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>
<body class="bg">
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
  <%--
  debug-code:
  <%= entity.getAge() %>
  <%= entity.getGender() %>
  <%= entity.getProduct() %>
  <%= entity.getUnderWrite() %>
  <%= entity.isResult() %>
  <%= entity.getResultStr() %>
  --%>
  <%-- 査定条件入力部 --%>
  <h1>保険申込査定システム</h1>
  <p class="lead"><small>申し込み条件を入力して下さい。</small><i class="glyphicon glyphicon-pencil"></i></p>
  <form action="./MainServlet" method="post" name="inputForm" id="inputForm" onSubmit="return inputAgeCheck()">
    <table class="table table-condensed" style="table-layout:fixed;">
      <tr>
        <th style="width:300px;"><p>Column Name</p></th> 
        <th style="width:300px;"><p>Input Data</p></th>
        <th style="width:400px;"><p>Warning Message</p></th>
        <th ><p></p></th>
      </tr>
      <tr>
        <td>
        <i class="glyphicon glyphicon-font"></i>　<label for="age">年齢:</label>
        <a href="javascript:void(0);" id="popover_age" data-toggle="popover_age" data-placement="top" title=""><span class="glyphicon glyphicon-question-sign"></span></a>
        </td>
        <td>
          <div class="form-group">
          <input type="text" name=<%= PRAM_AGE %> value=<%= entity.getAge() %> size="10" maxlength="3" class="form-control">
          </div>
        </td>
        <td id="ageErrorMsg">
          <%-- 初期状態は何も表示しない --%>
        </td>
      </tr>
      <tr>
        <td>
        <i class="glyphicon glyphicon-user"></i>　<label for="gender">性別:</label>
        <a href="javascript:void(0);" id="popover_gender" data-toggle="popover_gender" data-placement="top" title=""><span class="glyphicon glyphicon-question-sign"></span></a>
        </td>
        <td>
          <label class="radio-inline">　<input type="radio" name=<%= PRAM_GENDER %> value=<%= GENDER_MALE %> <%= GENDER_MALE.equals(entity.getGender()) ? " checked=\"checked\"" : "" %>>男性</label>
          <label class="radio-inline">　<input type="radio" name=<%= PRAM_GENDER %> value=<%= GENDER_FEMALE %> <%= GENDER_FEMALE.equals(entity.getGender()) ? " checked=\"checked\"" : "" %>>女性</label><br>
          <label class="radio-inline">　<input type="radio" name=<%= PRAM_GENDER %> value=<%= GENDER_CORP %> <%= GENDER_CORP.equals(entity.getGender()) ? " checked=\"checked\"" : "" %>>法人</label>
        </td>
        <td id="genderErrorMsg">
          <%-- 初期状態は何も表示しない --%>
        </td>
      </tr>
      <tr>
        <td>
        <i class="glyphicon glyphicon-tags"></i>　<label for="product">保険商品:</label>
        <a href="javascript:void(0);" id="popover_product" data-toggle="popover_product" data-placement="top" title=""><span class="glyphicon glyphicon-question-sign"></span></a>
        </td>
        <td>
          <div class="form-group">
          <select name=<%= PRAM_PRODUCT %> id="product" class="form-control">
            <option value=<%= PRODUCT_CANCER %> <%= PRODUCT_CANCER.equals(entity.getProduct()) ? " selected=\"selected\"" : "" %>>がん保険</option>
            <option value=<%= PRODUCT_MEDICAL %> <%= PRODUCT_MEDICAL.equals(entity.getProduct()) ? " selected=\"selected\"" : "" %>>医療保険</option>
            <option value=<%= PRODUCT_ORDINARY %> <%= PRODUCT_ORDINARY.equals(entity.getProduct()) ? " selected=\"selected\"" : "" %>>普通保険</option>
          </select>
          </div>
        </td>
        <td id="productErrorMsg">
          <%-- 初期状態は何も表示しない --%>
        </td>
      </tr>
      <tr>
        <td>
          <div class="form-group">
          <input type="submit" value="査定実行" id="image-btn" class="btn btn-primary">
          <input type="button" value="リセット" id="image-btn" onclick="formReset()" class="btn btn-primary active">
          <a href="javascript:void(0);" id="popover_submit" data-toggle="popover_submit" data-placement="top" title=""><span class="glyphicon glyphicon-question-sign"></span></a>
          </div>
        </td>
        <td>
        </td>
        <td id="submitErrorMsg">
          <%-- 初期状態は何も表示しない --%>
        </td>
      </tr>
    </table>
  </form>

  <table>
    <tr>
      <td>
        <p class="lead">　<i class="glyphicon glyphicon-ok"></i>　査定結果：</p>
      </td>
      <td>
        <%-- 査定結果出力部 --%>
          <% if ("".equals( entity.getResultStr() )){ %>
        <%-- 初期状態は何も表示しない --%>
          <% }else{ %>
            <p id="resultLabel" class="lead">
                <strong><%= entity.getResultStr() %></strong>
            </p>
          <% } %>
      </td>
    </tr>
    <tr>
      <td>
        <p class="lead">　<i class="glyphicon glyphicon-time"></i>　査定日時：</p>
      </td>
      <td>
        <%-- 処理日時出力部 --%>
          <% if ("".equals( entity.getResultStr() )){ %>
        <%-- 初期状態は何も表示しない --%>
          <% }else{ %>
            <p id="dateLabel" class="lead">
                <%= entity.getProcessDate() %>
            </p>
          <% } %>
      </td>
    </tr>
  </table>
  <a href="http://wp.m2o-eiwa.1strentalserver.info/wp-login.php" target="_blank"><img src="../images/22992853_A0.png" alt="M2O WKS" class="rb"></a>
</body>
</html>