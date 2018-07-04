/**
 * 
 */

function validateForm() {
	
	var mPw = frm_login.mPw.value;
	var mPwchk = frm_login.mPwChk.value;
	
	if (mPw != mPwchk) {
		alert('패스워드 확인란을 확인해주세요.');
		mPw = "";
		mPwchk = "";
		frm_login.mPw.focus();
		return false;
	}
	
	return true;
}