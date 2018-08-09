var vm = new Vue({
	el:'#docommon',
	data :{
		searchText:'',
		user:{
			username:'',
			password:''
		}
	},
	methods:{
		search:function(){

		},
		userlogin:function(){
			$.ajax({
				url:'/user/checkLogin',
				data:{'username':vm.user.username,'password':vm.user.password},
				success : function(r){
					if(r.code == 0){
						alert('ojbk');
					}
					else{
						alert('nononoon');
					}
				}
			})
		}
	}
})