// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_ajax_submit1: '.J-ajax-submit1', // 新增ajax提交按钮
			J_ajax_submit2: '.J-ajax-submit2', // 修改ajax提交按钮
			J_change: '.change', // 修改按钮
			J_add: '.add', // 新增按钮
			J_delete: '.delete', // 删除按钮
			J_role: '.role',// 角色名称
			J_jurisdiction: '.jurisdiction', // 所选权限
		};

		// 入口函数
		init();

		function init(){

			// ajax新增
			$(el.J_add).click(function(ev) {
				$('#add-list input').addClass('a-require-text');
				$('#add-list select').addClass('a-require-option');
				$('#update-list input').removeClass('a-require-option');
				$('#update-list select').removeClass('a-require-option');
			});
			// ajax新增提交
			$(el.J_ajax_submit1).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				// 附加上点击此按钮的信息在数据库中的顺序
				var 
					path_url = _ajax.url.evaluation.plan_management.list.change,
					title = $('.add-title').val(), // 新增题目
					option1 = $('.add-option1').val(), // 选项1
					option2 = $('.add-option2').val(), // 选项2
					option3 = $('.add-option3').val(), // 选项3
					option4 = $('.add-option4').val(), // 选项4
					weight = $('.add-weight').val(), // 权重
					type = $('.add-type').val(), // 权重的value
					type_text = $('.add-type').find('option:selected').text(); // 权重的文本值
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							title: title,
							option1: option1,
							option2: option2,
							option3: option3,
							option4: option4,
							weight: weight,
							type: type
						},
						success: function(data) {
							var 
								// 要插入的位置
								index = $('.timeline li').length - 3,
								// 序号
								index
								html = 
									'<li>' +
									  '<i class="fa bg-blue">'+ index + 1 +'</i>'+
									  '<div class="timeline-item">'+
									    '<span class="time">'+
									      '<button type="button" class="btn bg-olive change" data-toggle="modal" data-target="#update-list"> 修改 </button>'+
									      '<button type="button" class="btn bg-red delete" style="margin-left: 10px;"> 删除 </button>'+
									    '</span>'+

									    '<h3 class="timeline-header">'+
									      '<a href="#">【'+ type_text + weight +'%】</a>'+ 
									      title +
									    '</h3>'+

									    '<div class="timeline-body box-body">'+
									      '<div class="form-group">'+
									        '<label>'+
									          'A.' + option1 +
									        '</label>'+
									        '<a class="btn bg-olive btn-xs">优秀(9~10分)</a>'+
									      '</div>'+
									      '<div class="form-group">'+
									        '<label>'+
									          'B.' + option2 +
									        '</label>'+
									        '<a class="btn btn-primary btn-xs">良好(7~8分)</a>'+
									      '</div>'+
									      '<div class="form-group">'+
									        '<label>'+
									          'C.' + option3 +
									        '</label>'+
									        '<a class="btn bg-orange btn-xs">一般(5~6分)</a>'+
									      '</div>'+
									      '<div class="form-group">'+
									        '<label>'+
									          'D.' + option4 +
									        '</label>'+
									        '<a class="btn bg-red btn-xs">不及格(0~4分)</a>'+
									      '</div>'+
									    '</div>'+
									  '</div>'+
									'</li>';
							console.log(index);
							if (!data.code) {
								// 提示信息
								alert('添加成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom
								$('.timeline li').eq(index).after(html);
								
							}
							else{
								// $(el.J_tip).text(data.errorMsg[0].msg);
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
			// ajax修改提交
			$(el.J_ajax_submit2).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				// 附加上点击此按钮的信息在数据库中的顺序
				var 
					id = $('#dataId').val(), // 获取id
					path_url = _ajax.url.evaluation.plan_management.list.change,
					role = $(el.J_role).val(), // 角色名称
					jurisdiction = $(el.J_jurisdiction).val(); // 权限
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id,
							role: role,
							jurisdiction: jurisdiction,
						},
						success: function(data) {
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom
								$('.table tr[data-id='+ id +'] > td.role-text').text(role);
							}
							else{
								// $(el.J_tip).text(data.errorMsg[0].msg);
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
				$('#add-list input').removeClass('a-require-text');
				$('#add-list select').removeClass('a-require-option');
				$('#update-list input').addClass('a-require-option');
				$('#update-list select').addClass('a-require-option');
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.system.role.list.update;
					 // 传值成功
					$('#dataId').val(id);
				$.ajax({
					url: path_url,
					type: 'post',
					dataType: 'json',
					data: {
						id: id
					},
					success: function(data) {
						// 添加默认值
						// 多选
						var length = data.data.powerList.length, // 获取已有权限长度
							length2 = $('.jurisdiction option').length; // 当前存在长度
							// 预先选中属性
							for (var i = 0;i<length;i++) {
								var arr1 = data.data.powerList[i].detail;
								for(var j=0;j<length2;j++){
									var arr2 = $('.jurisdiction option').eq(j).text();
									if (arr1 == arr2) {
										$('.jurisdiction option').eq(j).prop('selected',true);
									}
								}
							}
						// 角色名称
						$(el.J_role).val(data.data.role.name);
						

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
					path_url = _ajax.url.system.role.list.del;
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
							console.log(errorMsg);
						}
					})
				}
			});
		}
});