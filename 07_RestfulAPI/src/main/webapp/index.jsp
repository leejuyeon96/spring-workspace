<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
  </head>
  <body>
    <h1>휴대전화 목록</h1>
    <table border="1">
      <thead>
        <tr>
          <th>모델번호</th>
          <th>모델이름</th>
          <th>가격</th>
          <th>제조사명</th>
        </tr>
      </thead>
      <tbody id="list"></tbody>
    </table>
    <h1>휴대전화 정보</h1>
    <form id="phoneFrm">
      모델번호 : <input type="text" name="num" id="num" /><br />
      모델명 : <input type="text" name="model" id="model" /><br />
      가격 : <input type="text" name="price" id="price" /><br />
      제조사 :
      <select id="vcode" name="vcode">
        <option value="10">삼성</option>
        <option value="20">애플</option>
      </select>
      <br />
      <input type="button" value="추가하기" id="insert" />
      <input type="button" value="수정하기" id="update" />
      <input type="button" value="삭제하기" id="delete" />
    </form>
    <script>
      function list() {
        $.ajax({
          type: "get",
          url: "http://localhost:8080/api/phone",

          success: function (data) {
            let html = "";

            for (let phone of data) {
              html +=
                "<tr>" +
                '<td class="num">' +
                phone.num +
                "</td>" +
                "<td>" +
                phone.model +
                "</td>" +
                "<td>" +
                phone.price +
                "</td>" +
                "<td>" +
                phone.company.vendor +
                "</td>" +
                "</tr>";
            }
            $("#list").html(html);
          },
          error: function (data) {
            console.log("에러 발생");
          },
        });
      }
      list();

      //상세조회
      $("#list").on("click", ".num", function () {
        const num = $(this).text();
        $.ajax({
          type: "get",
          url: "http://localhost:8080/api/phone/" + num, // 상세 정보를 제공하는 API 엔드포인트 URL
          success: function (data) {
            console.log(data);
            // 상세 정보를 화면에 표시
            $("#num").val(data.num);
            $("#model").val(data.model);
            $("#price").val(data.price);
            $("#vcode").val(data.vcode);
          },
        });
      });
      //추가
      $("#insert").on("click", function () {
        //json 방식으로
        let phone = {
          'num': $("#num").val(),
          'model': $("#model").val(),
          'price': $("#price").val(),
          'vcode': $("#vcode").val(),
        };
        $.ajax({
          url: "http://localhost:8080/api/phone",
          type: "post",
          data: JSON.stringify(phone),
          contentType: "application/json",
          success: function () {
            list();
          },
        });
      });
      //수정
      $("#update").on("click", function () {
        //json 방식으로
        let phone = {
          'num': $("#num").val(),
          'model': $("#model").val(),
          'price': $("#price").val(),
          'vcode': $("#vcode").val()
        };
        $.ajax({
          url: "http://localhost:8080/api/phone",
          type: "put",
          data: JSON.stringify(phone),
          contentType: "application/json",
          success: function () {
            list();
          },
        });
      });
      //삭제
      $("#delete").on("click", function () {
        $.ajax({
          type: "delete",
          url: "http://localhost:8080/api/phone/" + $("#num").val(), // 상세 정보를 제공하는 API 엔드포인트 URL
          success: function (data) {
            // 상세 정보를 화면에 표시
            list();
            $("#num").val("");
            $("#model").val("");
            $("#model").val("");
            $("#vcode").val("10");
          },
        });
      });
    </script>
  </body>
</html>
