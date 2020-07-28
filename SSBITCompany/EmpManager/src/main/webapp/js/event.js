
$(document).ready(function(){
	
	$('.modify').click(function (){
		$("input[name=user_no]:checked").each(function() {
			
			var user_no = $(this).val();
			if (user_no == null) {
				alert('수정할 글을 선택해주세요.');
			}
		  location.href = 'modify_is_materForm.do?user_No=' + user_no;
		  
		});
	});
	
	$('.back').click(function (){
		location.href = 'main.do';
	});
	
}); // ready
	