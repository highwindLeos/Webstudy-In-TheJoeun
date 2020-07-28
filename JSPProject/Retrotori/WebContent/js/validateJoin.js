/**
 * 
 */

function validateForm() {
	
	var mPw = frm_join.mPw.value;
	var mPwchk = frm_join.mPwChk.value;
	
	if (mPw != mPwchk) {
		swal('확인 패스워드 틀림 : 패스워드 확인란을 확인해주세요.','','error');
		mPw = "";
		mPwchk = "";
		frm_join.mPw.focus();
		return false;
	}
	
	return true;
}

function modifyValidateForm() {
	
	var mPw = frm_modify.mPw.value;
	var mPwchk = frm_modify.mPwChk.value;
	
	if (mPw != mPwchk) {
		swal('기존의 패스워드를 확인해주세요.','','error');
		mPw = "";
		mPwchk = "";
		frm_modify.mPw.focus();
		return false;
	}
	
	return true;
}