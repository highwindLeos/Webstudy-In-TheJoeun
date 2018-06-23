/**
 * 
 */

function chkmodifyForm() {
	var cpwValue = mfrm.cpw.value;
	var cpwChkValue = mfrm.cpwChk.value;
	
	if (cpwValue != cpwChkValue) {
		alert('패스워드와 확인값이 맞지 않습니다. 확인해주세요.');
		mfrm.cpw.value = "";
		mfrm.cpwChk.value = "";
		mfrm.cpw.focus();
		return false;
	}
	return true;
}

function chkRegisterForm() {
	var cid = rfrm.cid.value;
	var cname = rfrm.cname.value;	
	var cemail = rfrm.cemail.value;	
	var cpwValue = rfrm.cpw.value;
	var cpwChkValue = rfrm.cpwChk.value;
	
	if (cid.length == 0){
		alert('ID 는 필수 입력사항입니다.');
		document.rfrm.cid.focus();
		return false;
	}
	
	if (cid.length < 3){
		alert('ID 3글자 이상으로만 가입가능합니다.');
		document.rfrm.cid.focus();
		return false;
	}
	
	if (cname.length == 0){
		alert('이름은 필수 입력사항입니다.');
		document.rfrm.cname.focus();
		return false;
	}
	
	if (cemail.length != 0 && 
			cemail.indexOf('@') == -1 ||
			cemail.indexOf('@') == 0 ||
			cemail.indexOf('@') == cemail.length-1) { // 이메일의 형식을 검증한다.
		alert('이메일의 형식을 맟춰서 입력해주세요 (EX : example@mail.com)');
		document.rfrm.cemail.focus();
		return false;
	}
	
	if (cpwValue != cpwChkValue) {
		alert('패스워드와 확인값이 맞지 않습니다. 확인해주세요.');
		rfrm.cpw.value = "";
		rfrm.cpwChk.value = "";
		rfrm.cpw.focus();
		return false;
	}
	return true;
}