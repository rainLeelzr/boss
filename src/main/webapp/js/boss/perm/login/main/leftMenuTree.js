'use strict';

var leftMenuTree = (function() {
  /******************** 成员变量 ********************/
  var outlookmenu = mini.get('leftTree');

  var allMenus = [];
  var topMenus = [];

  /******************** 业务方法 ********************/

  /******************** 工具方法 ********************/
  //选择某个菜单
  function selectNode(e) {
    mainTab.showTab({
      id: '249d7af4-3c64-4008-bbfe-3ec2ebc90509',
      text: '菜单管理',
      menuUrl: '/boss/perm/menus/page',

    });
  }

  function loadSecondMenu() {
    // console.log('loadSecondMenu');
    var secondMenu = [];
    //解析出一级菜单
    for (var i = 0, l = allMenus.length; i < l; i++) {
      allMenus[i].enabled = true;
      if (allMenus[i].parentId === '-1') {
        topMenus.push(allMenus[i]);
      }
    }

    //解析出每个一级菜单的二级菜单
    for (var i = 0, l = topMenus.length; i < l; i++) {
      for (var j = 0, k = allMenus.length; j < k; j++) {
        if (topMenus[i].id === allMenus[j].parentId) {
          topMenus[i].children = topMenus[i].children || [];
          topMenus[i].children.push(allMenus[j]);
          secondMenu.push(allMenus[j]);
        }
      }
    }

    //解析出每个二级菜单的三级菜单
    for (var i = 0, l = secondMenu.length; i < l; i++) {
      for (var j = 0, k = allMenus.length; j < k; j++) {
        if (secondMenu[i].id === allMenus[j].parentId) {
          secondMenu[i].children = secondMenu[i].children || [];
          secondMenu[i].children.push(allMenus[j]);
        }
      }
    }

    //渲染第一个拥有二级菜单的一级菜单的二级菜单
    for (var i = 0, l = topMenus.length; i < l; i++) {
      if (topMenus[i].children != undefined) {
        outlookmenu.load(topMenus[i].children);
        // console.log(topMenus);
        return;
      }
    }
  }

  /******************** 初始化方法 ********************/
  function init() {

    $.ajax({
      url: '/boss/perm/menus/mine',
      type: 'get',
      data: {
        token: common.bossToken()
      },
      cache: false,
      dataType: 'json',
      success: function(resp) {
        if (resp.success) {
          allMenus = resp.data;
          topMenus = [];
          // console.log(allMenus);
          loadSecondMenu();
        }
      },
      error: function(text) {

      }
    });
  }

  /******************** 事件绑定处理方法 ********************/
  function onItemClick(e) {
    var item = e.item;
    mainTab.showTab(item);
  }

  /******************** 导出api ********************/
  return {
    outlookmenu: outlookmenu,
    init: init,
    onItemClick: onItemClick,
    selectNode: selectNode
  };
})();