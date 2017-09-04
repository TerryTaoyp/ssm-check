$(document).ready(function() {
	var
		el = {
			J_kind: '.kind',// 考核方式复选框
			J_nature: '.nature',// 考核性质下拉框
			J_name: '.name',// 计划名称
			J_position: '.position',// 选择对象
			J_tip: '.tip', //提示信息
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
		};

		// 入口函数
		init();

		function init(){
			// 根据考核性质决定考核方式是否出现
			$(el.J_nature).change(function() {
				// 考核性质下拉框的值
				var val = $(el.J_nature).val();
				if (val == 1) {
					$(el.J_kind).removeClass('none');
				}else{
					$(el.J_kind).addClass('none');
					$(el.J_kind + ' input').prop(
						{
							checked:false
						}
					);
				}
			});
			// ajax修改
			$(el.J_ajax_submit).click(function() {
				var path_url = _ajax.url.evaluation.plan_management.list.change
				var name = $(el.J_name).val(); // 计划名称
				$.ajax({
					url: path_url,
					type: 'get',
					dataType: 'json',
					data: {
						name: name
					},
					success: function(data) {
						console.log(data.errorMsg[0].msg);
						if (!data.code) {
							$(el.J_tip).text(data.errorMsg[0].msg);
						}else{
							$(el.J_tip).text(data.errorMsg[0].msg);
						}
					},
					error: function(data,errorMsg) {
						console.log('error');
					}
				})
			});
		}
});