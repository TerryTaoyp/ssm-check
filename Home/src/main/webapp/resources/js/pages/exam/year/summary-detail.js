// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_score: '.score', // 打分分数
		};

		// 入口函数
		init();

		function init(){

			// ajax修改
			$(el.J_ajax_submit).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				// 附加上点击此按钮的信息在数据库中的顺序
				var path_url = _ajax.url.evaluation.plan_management.list.change,
					score = $(el.J_score).val(),
					id = $("#dataId").val(), // 此文章的id
					reg = /^([1-9]\d?|100)$/; // 1-100数字的正则
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3) && reg.test(score)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id,
							score: score
						},
						success: function(data) {
							// console.log(data.errorMsg[0].msg);
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
							}
							else{
								$(el.J_tip).text(data.errorMsg[0].msg);
							}
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
				}
				else{
					$("body").animate({scrollTop:0}, 500);
					$(el.J_tip).text('请输入数字从0-100内的数字');
				}
			});
		}
});