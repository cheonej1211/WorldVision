$(document).ready(function(){
		catchError('${param.error}');
		var userInputId = getCookie("userInputId");
		$("input[name='account']").val(userInputId);

		if($("input[name='account']").val() != ""){ 
													
			$("#saveId").attr("checked", true); 
		}

		$("#saveId").change(function(){ 
			if($("#saveId").is(":checked")){
				var userInputId = $("input[name='account']").val();
				setCookie("userInputId", userInputId, 7);
			}else{
				deleteCookie("userInputId");
			}
		});

		$("input[name='account']").keyup(function(){ 
			if($("#saveId").is(":checked")){
				var userInputId = $("input[name='account']").val();
				setCookie("userInputId", userInputId, 7); 
			}
		});
	});

	function catchError( code) {
		if( code) {
			var errorCode = code;
			if( errorCode == 1) {
				$('#error').show();
			} else if( errorCode == 2) {
			} else if( errorCode == 3) {
				Mms.alert('계정 로그인 횟수를 초과했습니다.<br>관리자에게 문의해주세요.');
			}
		}
	}

	function setCookie(cookieName, value, exdays){
		var exdate = new Date();
		exdate.setDate(exdate.getDate() + exdays);
		var cookieValue = escape(value) + ((exdays==null) ? "" : "; expires=" + exdate.toGMTString());
		document.cookie = cookieName + "=" + cookieValue;
	}

	function deleteCookie(cookieName){
		var expireDate = new Date();
		expireDate.setDate(expireDate.getDate() - 1);
		document.cookie = cookieName + "= " + "; expires=" + expireDate.toGMTString();
	}

	function getCookie(cookieName) {
		cookieName = cookieName + '=';
		var cookieData = document.cookie;
		var start = cookieData.indexOf(cookieName);
		var cookieValue = '';
		if(start != -1){
			start += cookieName.length;
			var end = cookieData.indexOf(';', start);
			if(end == -1)end = cookieData.length;
			cookieValue = cookieData.substring(start, end);
		}
		return unescape(cookieValue);
	}