var vm = new Vue({
	el:'#fffs',
	data :{
		ss:'1231',
		user:{
			username:'',
			password:''
		}
	},
	methods :{
		login : function(){
			$.ajax({
				url: '/user/checkLogin',
				data: {'username': vm.user.username,
				'password':vm.user.password},
				success : function(r){
					if (r.code == 0) {
						alert('登录成功');
					}
				}
			})


		}
	}

})