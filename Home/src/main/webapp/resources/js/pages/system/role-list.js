// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_change: '.change', // 修改按钮
			J_delete: '.delete', // 删除按钮
			J_role: '.role',// 角色名称
			J_jurisdiction: '.jurisdiction', // 所选权限
		};

		// 入口函数
		init();

		function init(){

			// 点击修改计划时传一个次序给修改弹出框
			$(el.J_change).click(function(ev) {
				var id = $(this).attr('data-num');
				$('#dataId').val(id);// 传值成功
			});
			// ajax修改提交
			$(el.J_ajax_submit).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				// 附加上点击此按钮的信息在数据库中的顺序
				var path_url = _ajax.url.evaluation.plan_management.list.change,
					role = $(el.J_role).val(), // 角色名称
					jurisdiction = $(el.J_jurisdiction).val(); // 权限
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id:id,
							role: role,
							jurisdiction: jurisdiction,
							remark: remark
						},
						success: function(data) {
							// console.log(data.errorMsg[0].msg);
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom
								var id = $('#dataId').val(); // 获取到当前次序
								$('.table tr[data-id='+ id +'] > td.role-text').text(role);
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
					$(el.J_tip).text('信息为空,无法提交');
				}
			});
			// ajax点击修改
			$(el.J_change).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.system.role.list.change;
					console.log(path_url);
				$.ajax({
					url: '/role/ajax/update',
					type: 'post',
					dataType: 'json',
					data: {
						id: id
					},
					success: function(data) {
						// $('.table tr[data-id='+ id +']').remove();
						console.log(data);
						// 修改数据数量信息
					},
					error: function(data,errorMsg) {
						console.log('error');
					}
				})
			});
			// ajax删除
			$(el.J_delete).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.evaluation.plan_management.list.change;
				// 删除确认
				if (confirm("确认要删除？")) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id
						},
						success: function(data) {
							$('.table tr[data-id='+ id +']').remove();
							// 修改数据数量信息
							// 暂定
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
				}
			});
		}
});