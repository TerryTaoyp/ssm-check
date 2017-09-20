// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_weight: '.weight', // 权重验证
			J_submit: '.J-submit', // ajax提交按钮
		};

		// 入口函数
		init();

		function init(){

			// 普通修改
			$(el.J_submit).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				var 
					weight = $(el.J_weight).val(), // 权重
					reg = /^([1-9]\d?|100)$/; // 1-100数字的正则
				// 如果符合条件无法提交
				if (!(flag1 || flag2 || flag3) && reg.test(weight)) {
					return true;
				}
				else{
					$("body").animate({scrollTop:0}, 500);
					$(el.J_tip).text('信息为空或权重不在1~100,无法提交');
					return false;
				}
			});
		}
});