'use strict';

var menuDatagrid = (function() {
  /******************** 成员变量 ********************/
  var datagrid = mini.get('menuDatagrid');

  /******************** 业务方法 ********************/
  function add() {
    var hasMenus = menuTree.tree.getList().length > 0 ? true : false;
    // console.log(hasMenus);

    var parentId;
    var selectMenu;
    if (hasMenus) {
      selectMenu = menuTree.tree.getSelectedNode();
      // console.log(selectMenu);
      if (!selectMenu) {
        mini.alert('请先在菜单树中选择一个菜单！');
        return;
      }
      parentId = selectMenu.id;
    } else {
      parentId = '';
    }

    if (parentId === undefined) {
      throw new Error('添加菜单时，判断菜单树选择情况异常');
    }

    mini.open({
      url: '/boss/perm/menus/edit',
      title: '新增菜单',
      width: 600,
      height: 400,
      onload: function() {
        var iframe = this.getIFrameEl();
        var data = {
          action: 'new',
          parentId: parentId
        };
        iframe.contentWindow.SetData(data);
      },
      ondestroy: function(action) {
        // datagrid.reload();
        var temp = menuTree.tree.getSelected();
        console.log('menuDatagrid add ondestroy');
        console.log('menuTree.loadedToSelect: ' + menuTree.loadedToSelect);
        if (temp) {
          console.log('menuDatagrid add ondestroy has temp');
          menuTree.loadedToSelect = temp;
          console.log('menuTree.loadedToSelect: ' + menuTree.loadedToSelect);
        }
        menuTree.loadSelectedTreeNode();
      }
    });
  }

  function addTop() {
    mini.open({
      url: '/boss/perm/menus/edit',
      title: '新增根菜单',
      width: 600,
      height: 400,
      onload: function() {
        var iframe = this.getIFrameEl();
        var data = {
          action: 'new',
          parentId: '-1'
        };
        iframe.contentWindow.SetData(data);
      },
      ondestroy: function(action) {
        loadDatagrid('-1');//加载顶级菜单
        menuTree.loadTopMenus();
      }
    });
  }

  function edit() {

    var row = datagrid.getSelected();
    if (row) {
      mini.open({
        url: '/boss/perm/menus/edit',
        title: "编辑菜单",
        width: 600,
        height: 400,
        onload: function() {
          var iframe = this.getIFrameEl();
          var data = {
            action: "edit",
            id: row.id
          };
          iframe.contentWindow.SetData(data);

        },
        ondestroy: function(action) {
          datagrid.reload();
        }
      });

    } else {
      alert("请选中一条记录");
    }

  }

  function remove() {

    var rows = datagrid.getSelecteds();
    if (rows.length > 0) {
      if (confirm("确定删除选中记录？")) {
        var ids = [];
        for (var i = 0, l = rows.length; i < l; i++) {
          var r = rows[i];
          ids.push(r.id);
        }
        datagrid.loading("操作中，请稍后......");
        $.ajax({
          url: '/boss/perm/menus/delete',
          type: 'post',
          data: {
            ids: ids.join(','),
            token: localStorage.getItem('token')
          },
          success: function(resp) {
            datagrid.unmask();
            console.log(resp);

            datagrid.reload();
            menuTree.loadSelectedTreeNode();
          },
          error: function(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            datagrid.unmask();
            mini.alert('系统错误，错误码：' + jqXHR.status);
          }
        });
      }
    } else {
      alert("请选中一条记录");
    }
  }

  /******************** 工具方法 ********************/
  function loadDatagrid(parentId) {
    datagrid.load({
      token: localStorage.getItem('token'),
      parentId: parentId
    });
  }

  /******************** 初始化方法 ********************/
  function init() {

  }

  /******************** 事件绑定处理方法 ********************/
  function onLoad(e) {
    console.log('onSubMenuGridLoad');
    var resp = e.result;
  }

  /******************** 导出api ********************/
  return {
    datagrid: datagrid,
    init: init,
    add: add,
    addTop: addTop,
    edit: edit,
    remove: remove,
    loadDatagrid,
    onLoad: onLoad
  };
})();