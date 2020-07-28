/**
 * 메인 슬라이드 라이브러리 호출
 */
$(document).ready(function(){
  $('.single-item').slick({
	  arrows : false,
	  dots : false,
	  speed : 500,
	  autoplay : true,
	  autoplaySpeed : 2000
  });
});