$(document).ready(function() {
	var
		el = {
			sidebarHolder:'.sidebar',//指向侧边栏导航
			submenuHolder:'.submenu',//指向二级菜单
			menu:'.sidebar-menu',
			active:'.active',
        	tipEl: '.J_tip'//提示元素
		},
		NONE_CLASS = 'none',
		open_class = 'menu-open';

		init();

		function init(){
			// this._addEventLintener();
			// this._hideTip();
			//当前页所在导航栏展开
			var pageUrl;
			pageUrl = window.location.href;
			$('.sidebar-menu a').each(function(){
				url=$(this).attr('href');
				if(url==pageUrl){
					$(this).parents('.treeview').addClass(open_class);
					$(this).parents('.treeview-menu').show();
					// 给自己添加高亮
					$(this).css('color','#fff');
				}
			});
		}
		// _addEventLintener:function(){
		// 	var
		// 		that = this,
		// 		clickHolder = $('a',el.sidebarHolder);
		// 	on(clickHolder,'click',function(evt){
		// 		that._showCurrentMenu(evt.currentTarget);
		// 		that._hideOtherMenu(evt.currentTarget);
		// 	});
		// },
		// /**
		//  * 隐藏提示信息
		//  * @return {[type]} [description]
		//  */
		// _showCurrentMenu:function(holder){
		// 	var
		// 		that = this,
		// 		$submenuHolder = $(holder).next(),
		// 		$parent = $(holder).parent();
		// 	if($submenuHolder && $submenuHolder.hasClass(NONE_CLASS)){
		// 		// alert(window.location.href);
		// 		$submenuHolder.show();
		// 		$submenuHolder.removeClass(NONE_CLASS);
		// 		$parent.addClass(OPEN_CLASS);
		// 		// $parent.addClass(el.active);
		// 	}
		// },
		// _hideOtherMenu:function(holder){
		// 	var
		// 		that = this,
		// 		$parent = $(holder).parent(),
		// 		$dom = $parent.siblings(),
		// 		$otherSubmenu,
		// 		$i;
		// 	S.each($dom,function(i,o){
		// 		$i = $(i),
		// 		$otherSubmenu = $(el.submenuHolder,$i);
		// 		if(!$otherSubmenu.hasClass(NONE_CLASS)){
		// 			$otherSubmenu.hide();
		// 			$otherSubmenu.addClass(NONE_CLASS);
		// 			$i.removeClass(OPEN_CLASS);
		// 		}
		// 	});
		// }
});