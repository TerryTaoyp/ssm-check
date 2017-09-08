// 吴晓阳
$(document).ready(function() {
	var
		el = {
			J_tip: '.tip', //提示信息
			J_submit: '.J-submit', // 提交按钮
			J_score: '.score', // 打分分数
			J_answer: '.answer', // 选项
		};

		// 入口函数
		init();

		function init(){
			var flag4; // 验证输入分数是否符合的变量
			// 提交题目
			$(el.J_submit).click(function(ev) {
				// 先清空提示信息
				$(el.J_tip).text('');
				var arr = new Array; // 这个数组代表为填写的题都是哪些
				// 遍历一个一个的题目
				$('.timeline-item').each(function(index, o) {
					var length = $(o).find('.timeline-body > .form-group input[type="radio"]:checked').length;
					if (!length) {
						arr.push(index);
					}	
				});
				// 如果数组长度不为0 不能提交
				if (arr.length || flag4) {
					$("body").animate({scrollTop:0}, 500);
					$(el.J_tip).text('题目未全部回答或评分未全部评价,请确认您的答题');
					return false;
				}
			});

			// 分数提示以及判断
			$(el.J_score).blur(function(ev) {
				var index = "0", // 默认索引值
					that = $(this),
					arr4 = new Array(), // 判断长度的数组
					reg = {
						"0" : /^([0-9]|10)$/, // 没有选选项的正则
						"1" : /^([9]{1}|10)$/, // 9-10
						"2" : /^([7-8]{1})$/, // 7-8
						"3" : /^([5-6]{1})$/, // 5-6
						"4" : /^([0-4]{1})$/ // 0-4
					} // 正则验证对象
				that.parents('.timeline-footer').prev().find('.form-group').each(function(i, o) {
					if ($(o).find('input[type="radio"]').is(':checked')) { // 如果有选中项
						index = $(o).find('input[type="radio"]:checked').attr('data-order');
					}
				});
				if (!reg[index].test(that.val())) {
					arr4.push(index);  // 如果不符合要求 数组长度+1
					that.parent().addClass('has-error');
					that.next().text('分数范围不正确，请重新填写');
					console.log(reg[index]);
				}else{
					arr4.pop(index); // 如果符合要求 数组长度-1
					that.parent().removeClass('has-error');
					that.next().text('');
				}
				// 判断flag4
				if (arr4.length) {
					flag4 = true;
				}else{
					flag4 = false;
				}
			});
		}
});