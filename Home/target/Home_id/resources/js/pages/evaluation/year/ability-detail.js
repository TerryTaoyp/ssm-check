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
				$('#add-list input[type="text"]').addClass('a-require-text');
				$('#add-list select').addClass('a-require-option');
				$('#update-list input[type="text"]').removeClass('a-require-text');
				$('#update-list select').removeClass('a-require-option');
			});
			// ajax新增提交
			$(el.J_ajax_submit1).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				// 附加上点击此按钮的信息在数据库中的顺序
				var 
					path_url = _ajax.url.evaluation.year.ability_list.add,
					id = parseInt($('#id').text()), // 本次测试的id
					title = $('.add-title').val(), // 新增题目
					option1 = $('.add-option1').val(), // 选项1
					option2 = $('.add-option2').val(), // 选项2
					option3 = $('.add-option3').val(), // 选项3
					option4 = $('.add-option4').val(), // 选项4
					weight = $('.add-weight').val(), // 权重
					reg = /^([1-9]\d?|100)$/, // 1-100数字的正则
					type = $('.add-type').val(); // 类型的value
					console.log(id);
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3) && reg.test(weight)) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							id: id,
							targetType: type,
							weight: weight,
							target: title,
							optionName1: 1,
							optionName2: 2,
							optionName3: 3,
							optionName4: 4,
							content1: option1,
							content2: option2,
							content3: option3,
							content4: option4,
						},
						success: function(data) {
							var 
								// 要插入的位置
								index = $('.timeline li').length - 3,
								// 序号
								index2 = index + 1;
								html = 
									'<li>' +
									  '<i class="fa bg-blue">'+ index2 +'</i>'+
									  '<div class="timeline-item">'+
									    '<span class="time">'+
									      '<button type="button" class="btn bg-olive change" data-toggle="modal" data-target="#update-list"> 修改 </button>'+
									      '<button type="button" class="btn bg-red delete" style="margin-left: 10px;"> 删除 </button>'+
									    '</span>'+

									    '<h3 class="timeline-header">'+
									      '<a href="#">【'+ type + weight +'%】</a>'+ 
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
							if (data.code) {
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
					$(el.J_tip).text('信息不全或问题比重大于100');
				}
			});
			// ajax点击修改
			$(el.J_change).click(function(ev) {
				$('#add-list input[type="text"]').removeClass('a-require-text');
				$('#add-list select').removeClass('a-require-option');
				$('#update-list input[type="text"]').addClass('a-require-text');
				$('#update-list select').addClass('a-require-option');
				// 获取序列
				var 
					id = $(this).attr('data-num'),
					path_url = _ajax.url.evaluation.plan_management.list.change;
					 // 传值成功
					$('#dataId').val(id);
				$.ajax({
					url: path_url,
					type: 'get',
					dataType: 'json',
					data: {
						id: id
					},
					success: function(data) {
						// 添加默认值
						
						// 权重名称
						$('.update-weight').val(data.data.option.weight);
						// 问题类型
						$('.update-weight').val(data.data.option.weight);
						// 问题
						$('.update-title').val(data.data.option.title);
						// 选项
						$('.update-option1').val(data.data.option.option1);
						$('.update-option2').val(data.data.option.option2);
						$('.update-option3').val(data.data.option.option3);
						$('.update-option4').val(data.data.option.option4);
						

					},
					error: function(data,errorMsg) {
						console.log('error');
					}
				})
			});
			// ajax修改提交
			$(el.J_ajax_submit2).click(function(ev) {
				// 先清空提示信息
				// 附加上点击此按钮的信息在数据库中的顺序
				var 
					path_url = _ajax.url.evaluation.year.ability_list.change,
					id = $('#dataId').val(), // 当前问题序号
					title = $('.update-title').val(), // 新增题目
					option1 = $('.update-option1').val(), // 选项1
					option2 = $('.update-option2').val(), // 选项2
					option3 = $('.update-option3').val(), // 选项3
					option4 = $('.update-option4').val(), // 选项4
					weight = $('.update-weight').val(), // 权重
					type = $('.update-type').val(), // 类型的value
					reg = /^([1-9]\d?|100)$/; // 1-100数字的正则
				// 如果符合条件无法提交
				if (!(ajax_flag1 || ajax_flag2 || ajax_flag3) && reg.test(weight)) {
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
							if (data.code) {
								// 提示信息
								alert('修改成功');
								// 隐藏填写表单
								$('button[data-dismiss="modal"]').click();
								// 修改dom
								// 问题类型
								$('.timeline li[data-id='+id+'] .type').text(type);
								// 权重
								$('.timeline li[data-id='+id+'] .weight').text(weight);
								// 问题
								$('.timeline li[data-id='+id+'] .title').text(title);
								// 选项
								$('.timeline li[data-id='+id+'] .option1').text(option1);
								$('.timeline li[data-id='+id+'] .option2').text(option2);
								$('.timeline li[data-id='+id+'] .option3').text(option3);
								$('.timeline li[data-id='+id+'] .option4').text(option4);
							}
						},
						error: function(data,errorMsg) {
							console.log('error');
						}
					})
				}
				else{
					$("body").animate({scrollTop:0}, 500);
					$(el.J_tip).text('信息不全或问题比重大于100');
				}
			});
			
			// ajax删除
			$(el.J_delete).click(function(ev) {
				// 获取序列
				var 
					that = $(this),
					id = $(this).attr('data-num'),
					path_url = _ajax.url.evaluation.year.ability_list.del;
				// 删除确认
				if (confirm("确认要删除？")) {
					$.ajax({
						url: path_url,
						type: 'get',
						dataType: 'json',
						data: {
							positionId: 1
						},
						success: function(data) {
							that.parents('li').remove();
						},
						error: function(data,errorMsg) {
							console.log(errorMsg);
						}
					})
				}
			});
		}
});