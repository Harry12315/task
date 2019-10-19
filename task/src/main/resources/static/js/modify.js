function modify() {
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
		url : "/modify",
		data : params,
		type : "POST",
		dataType : "text",
		success : function(data){
			if(data == "success"){
				location.href = "/modify2";
			}else{
				alert("ユーザーIDまたはパスワードが間違えっています");
			}
		}
	});
}

function modify2() {
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
		url : "/modify2",
		data : params,
		type : "POST",
		dataType : "text",
		success : function(data){
			if(data == "success"){
				alert("修正完了しました");
				location.href = "/index";
			}else{
				alert("修正できませんでした");
			}
		}
	});
}