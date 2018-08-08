var vm = new Vue({
	el:'main'{
		data :{
			user:{
				username:'',
				password:''
			},
		}
		methods :{
			login : function(){
				$.$.ajax({
					url: '/path/to/file',
					type: 'default GET (Other values: POST)',
					dataType: 'default: Intelligent Guess (Other values: xml, json, script, or html)',
					data: {param1: 'value1'},
				})
				
				
			}
		}

	}
})