/**
 * 
 */

function updateInfoConfirm() {
	var pw = document.modify_frm.pw.value;
	var pwChk = document.modify_frm.pwChk.value;
	if (pw != pwChk) {
		alert('새 패스워드를 확인하세요.');
		document.modify_frm.pw.value ='';
		document.modify_frm.pwChk.value ='';
		document.modify_frm.pw.focus();
		return;
	}
	document.modify_frm.submit(); //전송을 실행한다.
}