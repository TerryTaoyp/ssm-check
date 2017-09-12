// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_kind: '.kind',// 考核方式复选框
			J_nature: '.nature',// 考核性质下拉框
			J_name: '.name',// 计划名称
			J_time_start: '.daterangepicker_start', // 开始时间
			J_time_end: '.daterangepicker_end', // 结束时间
			J_tip: '.tip', //提示信息
			J_ajax_submit: '.J-ajax-submit', // ajax提交按钮
			J_change: '.change', // 修改按钮
			J_delete: '.delete', // 删除按钮
			J_status: '.status', // 状态按钮
		};

		// 入口函数
		init();

		function init(){
			// 根据考核性质决定考核方式是否出现
			// $(el.J_nature).change(function() {
			// 	// 考核性质下拉框的值
			// 	var val = $(el.J_nature).val();
			// 	if (val == 1) {
			// 		$(el.J_kind).removeClass('none');
			// 	}else{
			// 		$(el.J_kind).addClass('none');
			// 		$(el.J_kind + ' input').prop(
			// 			{
			// 				checked:false
			// 			}
			// 		);
			// 	}
			// });
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
				var path_url = _ajax.url.evaluation.plan_management.list.change, // 后台方法地址
					name = $(el.J_name).val(), // 计划名称
					position = $(el.J_position).val(), // 考核对象选项值
					position_text = $(el.J_position).find('option:selected').text(), //考核对象选项的文本值
					nature = $(el.J_nature).val(), // 考核性质选项值
					nature_text = $(el.J_nature).find('option:selected').text(), // 考核性质的文本值
					time_start = $(el.J_time_start).val(), // 开始时间
					time_end = $(el.J_time_end).val(); // 结束时间
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							name: name,
							nature: nature,
							time_start: time_start,
							time_end: time_end,
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
								$('.table tr[data-id='+ id +'] > td.name-text').text(name);
								$('.table tr[data-id='+ id +'] > td.nature-text').text(nature_text);
								$('.table tr[data-id='+ id +'] > td.time-start-text').text(time_start);
								$('.table tr[data-id='+ id +'] > td.time-end-text').text(time_end);
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
							delete: 'true'
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
			// ajax修改状态
			$(el.J_status).click(function(ev) {
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.evaluation.plan_management.list.change,
					text = $('.table tr[data-id='+ id +'] .status-text').text();
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							status: 'true'
						},
						success: function(data) {
							if (text == "已开启") {
								$('.table tr[data-id='+ id +'] .status-text').text('未开启');
							}
							else{
								$('.table tr[data-id='+ id +'] .status-text').text('已开启');
							}
							// 修改数据数量信息
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
					
			});
		}
});