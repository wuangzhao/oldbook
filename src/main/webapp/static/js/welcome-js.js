$(function(){
	var num = 1;
	$('.leftBtn').click(function() {
		if(num > 4){
				num = 1;
			}
		num++;
		$('.bd ul').stop().animate({
			"marginLeft": -(num * 960)+'px'
		},function(){
			if(num >= 5){
				$('.bd ul').css("marginLeft",'-960px');
				num = 1;
			}
		});
	});
	$('.rightBtn').click(function() {
		num--;
		if(num < 0){
			num = 4;
		}
		$('.bd ul').stop().animate({
			"marginLeft": -(num * 960)+'px'
		},function(){
			if(num <= 0){
			$('.bd ul').css("marginLeft",'-3840px');
			num = 4;
			return;
		}
		});
	});
})