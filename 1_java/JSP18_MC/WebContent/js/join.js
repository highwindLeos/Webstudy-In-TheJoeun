/**
 *  회원 가입 검증 함수
 */

function infoConfirm(){
	var id = document.join_frm.id.value; 
	var name = document.join_frm.name.value; 
	var email = document.join_frm.email.value; 
	var birth = document.join_frm.birth.value; 
	var pw = document.join_frm.pw.value; 
	var pwChk = document.join_frm.pwChk.value; 
	
	if (id.length == 0){
		alert('ID 는 필수 입력사항입니다.');
		document.join_frm.id.focus();
		return;
	}
	
	if (id.length < 3){
		alert('ID 3글자 이상으로만 가입가능합니다.');
		document.join_frm.id.focus();
		return;
	}
	
	if (name.length == 0){
		alert('이름은 필수 입력사항입니다.');
		document.join_frm.name.focus();
		return;
	}
	
	if (email.length != 0 && 
		email.indexOf('@') == -1 ||
		email.indexOf('@') == 0 ||
		email.indexOf('@') == email.length-1) { // 이메일의 형식을 검증한다.
		alert('이메일의 형식을 맟춰서 입력해주세요 (EX : example@mail.com)');
		document.join_frm.email.focus();
		return;
	}
	
	if (birth.length == 0){
		alert('생년월일은 필수 입력사항입니다.');
		document.join_frm.name.focus();
		return;
	}
	
	if(pw != pwChk){
		alert('패스워드는 확인란과 같아야 합니다.');
		document.join_frm.pw.value = "";
		document.join_frm.pwChk.value = "";
		document.join_frm.pw.focus();
		return;
	}
	document.join_frm.submit();
}