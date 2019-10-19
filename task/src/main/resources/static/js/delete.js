function delete1() {
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
		url : "/delete",
		data : params,
		type : "POST",
		dataType : "text",
		success : function(data){
			if(data == "success"){
				alert("ユーザー削除しました");
				location.href = "/index";
			}else if(data == "false"){
				alert("入力情報間違えたため、削除できません")
				location.href = "/delete";
			}else{
				alert("ユーザー削除されていません");
				location.href = "/delete";
			}
		}
	});
}