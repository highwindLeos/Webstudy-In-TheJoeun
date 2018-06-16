/**
 * 
 */

function serachFriend() {
	var fname = document.getElementById("fname").value;
	var tel = document.getElementById("tel").value;

	location.href = 'friendjoin.jsp?fname='+ fname +'&tel='+ tel;
}