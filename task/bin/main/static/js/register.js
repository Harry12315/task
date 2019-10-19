function register() {
	var params={};
	if($("#username").val()==""){
		alert("ユーザーIDを入力してください");
		return;
	}
	if($("#password").val()==""){
		alert("パスワードを入力してください");
		return;
	}

	params.username = $("#username").val();
	params.password = $("#password").val();

	$.ajax({
		url : "/register",
		data : params,
		type : "POST",
		dataType : "text",
		success : function(data){
			if(data == "success"){
				alert("ユーザー登録しました");
				location.href = "/index";
			}else if(data == "false"){
				alert("ユーザー名が重複し、修正してください");
			}else{
				alert("ユーザー登録されていません");
				location.href = "/register";
			}
		}
	});
}

function preregister() {
	var params={};
	if($("#username").val()==""){
		alert("ユーザーIDを入力してください");
		return;
	}
	if($("#password").val()==""){
		alert("パスワードを入力してください");
		return;
	}

	params.username = $("#username").val();
	params.password = $("#password").val();

	$.ajax({
		url : "/register",
		data : params,
		type : "POST",
		dataType : "text",
		success : function(data){
			if(data == "success"){
				alert("ユーザー登録しました");
				location.href = "/login";
			}else if(data == "false"){
				alert("ユーザー名が重複し、修正してください");
			}else{
				alert("ユーザー登録されていません");
				location.href = "/preregister";
			}
		}
	});
}