// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_add: '.add', // 添加按钮
			J_delete: '.delete', // 删除按钮
			J_add_all: '.add-all', // 添加按钮
		};

		// 入口函数
		init();

		function init(){
			// ajax添加
			$(el.J_add).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.evaluation.plan_management.list.change;
				$.ajax({
					url: path_url,
					type: 'get',
					dataType: 'json',
					data: {
						add: 'true'
					},
					success: function(data) {
						$('.table tr[data-id='+ id +'] .status-text').text('参与');
						// 修改按钮状态
						$('.add[data-num='+ id +']').attr('disabled','disabled');
						$('.add[data-num='+ id +']').text('已添加');
						// 删除恢复
						$('.delete[data-num='+ id +']').removeAttr('disabled');
						$('.delete[data-num='+ id +']').text('移除');
					},
					error: function(data,errorMsg) {
						console.log('error');
					}
				})
			});
			// ajax移除
			$(el.J_delete).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.evaluation.plan_management.list.change;
				// 删除确认
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							delete: 'true'
						},
						success: function(data) {
							$('.table tr[data-id='+ id +'] .status-text').text('不参与');
							// 修改按钮状态
							$('.delete[data-num='+ id +']').attr('disabled','disabled');
							$('.delete[data-num='+ id +']').text('已移除');
							// 添加恢复
							$('.add[data-num='+ id +']').removeAttr('disabled');
							$('.add[data-num='+ id +']').text('添加');
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
			});
			// ajax全部添加
			$(el.J_add_all).click(function(ev) {
				var 
					message = $('.table tbody tr'), // 每条信息
					idArr = new Array;
					path_url = _ajax.url.evaluation.plan_management.list.change;
				// 把所有id加入到idArr中
				for (var i = 0; i < message.length; i++) {
					idArr.push($(message[i]).attr('data-id')); // 把每条数据的ad加入进去
				}
				$.ajax({
					url: path_url,
					type: 'get',
					dataType: 'json',
					data: {
						add_all: 'true',
						id: idArr
					},
					success: function(data) {
						$('.table .status-text').text('参与');
						// 修改按钮状态
						$('.add').attr('disabled','disabled');
						$('.add').text('已添加');
						// 删除恢复
						$('.delete').removeAttr('disabled');
						$('.delete').text('移除');
					},
					error: function(data,errorMsg) {
						console.log('error');
					}
				})
			});
		}
});