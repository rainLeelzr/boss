'use strict';

var menuTree = (function() {
  /******************** 成员变量 ********************/
  var tree = mini.get('menuTree');

  var loadedToSelect = '';

  /******************** 业务方法 ********************/

  /******************** 工具方法 ********************/
  //加载选中菜单节点的子节点，如果没有选中的菜单，则加载顶级菜单
  function loadSelectedTreeNode() {
    console.log('loadSelectedTreeNode');
    var selected = tree.getSelectedNode();
    if (selected) {
      tree.loadNode(selected);
    } else {
      tree.load();
    }

  }

  //加载根菜单
  function loadTopMenus() {
    // tree.setUrl('/boss/perm/menus/subs?token=' + common.bossToken());
    // tree.load({
    //   id: '-1'
    // });
    tree.load();
    menuDatagrid.loadDatagrid('-1'); //加载顶级菜单列表
  }

  /******************** 初始化方法 ********************/
  function init() {
    tree.setUrl('/boss/perm/menus/subs?token=' + common.bossToken());
  }

  /******************** 事件绑定处理方法 ********************/
  function onBeforeLoad(e) {
    console.log('onBeforeMenuTreeLoad');

    console.log(e);
    if (e.node.id === undefined) {
      console.log('e.node.id === undefined');
      e.params.id = '-1';
    }
  }

  var onLoad = (function() {
    var firstTimeLoad = true;
    console.log('onMenuTreeLoad-outer');

    return function(e) {
      console.log('onMenuTreeLoad-inner');
      console.log('loadedToSelect: ' + menuTree.loadedToSelect);
      if (firstTimeLoad) {
        console.log('onMenuTreeLoad-inner firstTimeLoad');
        firstTimeLoad = false;

        var hasMenus = tree.getList().length > 0 ? true : false;
        if (hasMenus) {
          setTimeout(function() {
            tree.select(0);
          }, 0);
        }
      } else if (menuTree.loadedToSelect != undefined) {
        console.log('onMenuTreeLoad-inner loadedToSelect');
        tree.selectNode(menuTree.loadedToSelect);
        menuTree.loadedToSelect = undefined;
      }
    }
  })();

  function onNodeSelect(e) {
    console.log('onMenuTreeNodeSelect');
    console.log(e);
    menuDatagrid.loadDatagrid(e.node.id);
  }

  function onNodeDbClick(e) {
    console.log('onMenuTreeNodeClick');
    tree.loadNode(e.node);
  }

  /******************** 导出api ********************/
  return {
    tree: tree,
    loadedToSelect: loadedToSelect,
    init: init,
    onBeforeLoad: onBeforeLoad,
    onLoad: onLoad,
    onNodeSelect: onNodeSelect,
    onNodeDbClick: onNodeDbClick,
    loadSelectedTreeNode: loadSelectedTreeNode,
    loadTopMenus: loadTopMenus
  };
})();