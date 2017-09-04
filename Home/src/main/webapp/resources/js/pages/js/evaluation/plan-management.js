$(document).ready(function() {
	var
		el = {
			J_kind: '.kind',// 考核方式复选框
			J_nature: '.nature', // 考核性质下拉框
		};

		// 入口函数
		init();

		function init(){
			// 根据考核性质决定考核方式是否出现
			$(el.J_nature).change(function(event) {
				// 考核性质下拉框的值
				var val = $(el.J_nature).val();
				if (val == 1) {
					$(el.J_kind).removeClass('none');
					$(el.J_kind + ' input')[0].prop({checked:true});
				}else{
					$(el.J_kind).addClass('none');
				}
			});
		}
});