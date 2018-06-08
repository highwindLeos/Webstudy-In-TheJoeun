/**
 * 
 */

function vlidateJoinInfo(){
	// 비밀번호
	if(frm.password.value != frm.password2.value){
		alert('비밀번호의 입력은 두개가 같아야합니다.');
		frm.password.value = '';
		frm.password2.value = '';
		frm.password.focus();
		return false;
	}
	
//	 취미가 (hobby가 배열) 는 받드시 하나 이상 선택
//	 frm.hobby[0] ~ frm.hobby[3]
	if (frm.hobby[0].checked == false &&
		frm.hobby[1].checked == false &&
		frm.hobby[2].checked == false &&
		frm.hobby[3].checked == false) {
		alert('반드시 취미 하나이상 선택해주세요.');
		return false;
	}
	
//	 체크박스가 몇개 인지 모를때 모두 체크해야 할경우
//	var hobbyCount = 0; // checked 된 체크박스의 갯수
//	for (var i = 0; i < frm.hobby.length; i++){
//		if (frm.hobby[i].cheacked == true){
//			hobbyCount++;
//		}
//	}
//	
//	if (hobbyCount == 0){
//		alert('반드시 취미 하나이상 선택해주세요.');
//		return false;
//	}
	
//	if (Boolean(hobbyCount) == false){
//		alert('반드시 취미 하나이상 선택해주세요.');
//		return false;
//	}
	
//	 메일 형식을 체크 : @ 가 중간에 입력
	if (frm.email.value.indexOf('@') == -1 || 
		frm.email.value.indexOf('@') == 0 ||
		frm.email.value.indexOf('@') == frm.email.value.length-1) { // 이 문자가 없으면 -1을 리턴함.
		alert('메일 형식을 확인하세요.');
		frm.email.focus();
		return false;
	}
	return true;
}