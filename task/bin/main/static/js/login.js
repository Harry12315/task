function login() {
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
		url : "/login",
		data : params,
		type : "POST",
		dataType : "text",
		success : function(data){
			if(data == "success"){
				location.href = "/index";
			}else{
				alert("ユーザーIDまたはパスワードが間違えっています");
			}
		}
	});
}