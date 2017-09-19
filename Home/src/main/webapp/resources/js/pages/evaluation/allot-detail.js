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
			// 判断刚开始的状态
			$('.status').each(function(i, o) {
				if($(o).text().indexOf('已参与') != -1){ // 判断是否包含'已参与',若没返回-1
					// 修改按钮状态
					$(this).next().children('.add').attr('disabled','disabled');
					$(this).next().children('.add').text('已添加');
					// 删除恢复
					$(this).next().children('.delete').removeAttr('disabled');
					$(this).next().children('.delete').text('移除');
				}
				else{
					// 修改按钮状态
					$(this).next().children('.delete').attr('disabled','disabled');
					$(this).next().children('.delete').text('已移除');
					// 添加恢复
					$(this).next().children('.add').removeAttr('disabled');
					$(this).next().children('.add').text('添加');
				}
			});
			// ajax添加
			$(el.J_add).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-test'),
					uid = $(this).attr('data-user'),
					// tid = $(this).attr('data-data'),
					path_url = _ajax.url.evaluation.plan_management.detail.add;
				$.ajax({
					url: path_url,
					type: 'get',
					dataType: 'json',
					data: {
						tid: id,
						uid: uid,
						// tid: tid
					},
					success: function(data) {
						$('.table button[data-user='+ uid +']').parents('tr').children('.status').text('已参与');
						// 修改按钮状态
						$('.add[data-user='+ uid +']').attr('disabled','disabled');
						$('.add[data-user='+ uid +']').text('已添加');
						// 删除恢复
						$('.delete[data-user='+ uid +']').removeAttr('disabled');
						$('.delete[data-user='+ uid +']').text('移除');
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
                    id = $(this).attr('data-test'),
                    uid = $(this).attr('data-user'),
                    // tid = $(this).attr('data-data'),
					path_url = _ajax.url.evaluation.plan_management.detail.del;
				// 删除确认
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							tid: id,
							uid: uid,
							// tid: tid
						},
						success: function(data) {
							$('.table button[data-user='+ uid +']').parents('tr').children('.status').text('');
							// 修改按钮状态
							$('.delete[data-user='+ uid +']').attr('disabled','disabled');
							$('.delete[data-user='+ uid +']').text('已移除');
							// 添加恢复
							$('.add[data-user='+ uid +']').removeAttr('disabled');
							$('.add[data-user='+ uid +']').text('添加');
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