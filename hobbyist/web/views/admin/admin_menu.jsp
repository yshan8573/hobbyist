<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" import="java.util.*"%>

<div class="admin_left">
   <ul>
      <li>회원관리</li>
      <li>작가관리</li>
      <ul class="sub">
         <li onclick="location.href='<%= request.getContextPath()%>/admin/adminWriterEnroll'">작가 신청 관리</li>
         <li onclick="location.href='#'">정식 작가 목록</li>
         <li onclick="location.href='#'">예비 작가 목록</li>
      </ul>
      <li>공지&이벤트 관리</li>
      <ul class="sub">
         <li onclick="location.href='<%= request.getContextPath() %>/admin/adminNoticeDelList'">삭제 목록</li>
      </ul>
      <li>클래스샵 관리</li>
      <ul class="sub">
         <li onclick="location.href='<%= request.getContextPath() %>/admin/adminShopList'">클래스 목록</li>
         <li onclick="location.href='<%= request.getContextPath() %>/admin/adminShopWrite'">클래스 등록</li>
         <li onclick="location.href='<%= request.getContextPath() %>/admin/adminPinList'">PIN CODE 관리</li>
      </ul>
      <li>원데이클래스 관리</li>
      <ul class="sub">
         <li onclick="location.href='<%= request.getContextPath() %>/admin/adminOnedayList'">원데이클래스 목록</li>
         <li onclick="location.href='<%= request.getContextPath() %>/admin/adminOnedayWrite'">원데이클래스 등록</li>
      </ul>
      <li>어워드 관리</li>
      <li>커뮤니티 관리</li>
      <li>주문관리</li>
      <ul class="sub">
         <li onclick="location.href='<%= request.getContextPath() %>/admin/adminOrderList'">주문 목록</li>
      </ul>
      <li>정산관리</li>
   </ul>
</div>

<script>
$(function () {
    var adminLeftSelectValue = "";
    $(".admin_left>ul>li").click(function () {
       if($(this).html() == adminLeftSelectValue) {
          adminLeftSelectValue = $(this).html();
          $(this).next("ul").slideToggle(500);
       } else {
          adminLeftSelectValue = $(this).html();
          $(".admin_left>ul>li").next("ul").slideUp(500);
          $(this).next("ul").slideToggle(500);
       }
    })
 })

 $(window).scroll(function () {
    var target = $('#admin_top');
    var scrollTo = $(window).scrollTop();
    if (scrollTo != 0) {
       $('#admin_top').css("top", "97px");  
    } else {
       $('#admin_top').css("top", "213px");
    }
 });

 //메인 헤더 숨기기
 $(window).scroll(function () {
    if ($(window).scrollTop() != 0) {
       $("#header-middle").css("transition", "500ms");
       $("#header-middle").css("height", "0px");
       $("#header-middle .middle").css("display", "none");
    } else {
       $("#header-middle").css("height", "100px");
       setTimeout(function () {
          $("#header-middle .middle").css("display", "inline-block");
       }, 500)
    }
 });
</script>