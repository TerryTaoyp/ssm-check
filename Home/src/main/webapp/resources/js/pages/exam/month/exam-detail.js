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
				if (arr.length) {
					$("body").animate({scrollTop:0}, 500);
					$(el.J_tip).text('题目未全部回答或评分未全部评价,请确认您的答题');
					return false;
				}
			});
			$(el.J_answer).parent().click(function(ev) {
				console.log('change');
			});
			$('.answer + ins').click(function(ev) {
				console.log('change');
			});
		}
});