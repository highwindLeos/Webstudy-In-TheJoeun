/**
 * 
 */

$(document).ready(function() {
	$('.boardLike').hover(function() {
		$(this).html('<i class="fas fa-heart"></i> 좋아요');
	});
	$('.boardLike').mouseout(function() {
		$(this).html('좋아요');
	});
	
	 var coin = new Audio('http://localhost:8181/Retrotori/js/source/Coin.wav');
	$('.logo').hover(function(){
		coin.play();
	});
	
	 
}); // 좋아요 버튼 올리기이벤트