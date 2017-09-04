$(document).ready(function() {
	var
		el = {
			J_kind: '.kind',// 考核方式复选框
			J_nature: '.nature',// 考核性质下拉框
			J_name: '.name',// 计划名称
			J_position: '.position',// 选择对象
			J_tip: '.tip', //提示信息
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_change: '.change', // 修改按钮
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
			// 点击修改计划时传一个次序给修改弹出框
			$(el.J_change).click(function(ev) {
				var id = $(this).attr('data-num');
				$('#dataId').val(id);// 传值成功
			});
			// ajax修改
			$(el.J_ajax_submit).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				// 附加上点击此按钮的信息在数据库中的顺序
				var path_url = _ajax.url.evaluation.plan_management.list.change,
					name = $(el.J_name).val(), // 计划名称
					position = $(el.J_position).val();
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							name: name,
							position: position
						},
						success: function(data) {
							// console.log(data.errorMsg[0].msg);
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('.modal').removeClass('in');
								// 隐藏背景蒙版
								$('.modal-backdrop').removeClass('in');
								// 修改dom
								var id = $('#dataId').val(); // 获取到当前次序
								$('.table tr[data-class='+ id +'] > td.name-text').text(name);
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
					$(el.J_tip).text('信息为空,无法提交');
				}
			});
		}
});