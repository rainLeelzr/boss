<!DOCTYPE html>
<html lang="zh-cn">

<head>
  <title>boss-menu</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
  <link type="text/css" rel="stylesheet" href="/js/miniui/themes/default/miniui.css">
  <link type="text/css" rel="stylesheet" href="/js/miniui/themes/icons.css">
  <link type="text/css" rel="stylesheet" href="/js/miniui/themes/bootstrap/skin.css">
  <style type="text/css">
  body {
    margin: 0;
    padding: 0;
    border: 0;
    width: 100%;
    height: 100%;
  }

  .mini-layout-region-west {
    border-left: 1px;
  }

  #searchForm .mini-textbox {
    width: 150px;
  }
  </style>
</head>

<body>
  <div id="layout1" class="mini-layout" style="width: 100%; height: 100%;" showSplitIcon="true">
    <div region="west" showHeader="true" title="菜单树(双击加载子菜单)" minWidth="100" width="230" showSplit="true" showSplitIcon="true">
      <div id="toolbar1" class="mini-toolbar" style="padding:2px;">
        <table style="width:100%;">
          <tr>
            <td style="width:100%;">
              <a class="mini-button" onclick="onRefreshTopMenuclick">刷新根菜单</a>
            </td>
        </table>
      </div>
      <!--OutlookMenu-->
      <ul class="mini-tree" id="menuTree" style="width:100%;  padding:5px;" showTreeIcon="false" textField="menuName" idField="id" parentField="parentId" dataField="data" resultAsTree="false" onbeforeload="menuTree.onBeforeLoad" onload="menuTree.onLoad" onnodeselect="menuTree.onNodeSelect" onnodedblclick="menuTree.onNodeDbClick">
      </ul>
    </div>
    <div region="center" showHeader="false" title="子菜单列表" showCollapseButton="false">
      <div style="width:100%;">
        <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
          <table style="width:100%;">
            <tr>
              <td style="width:100%;">
                <a class="mini-button" iconCls="icon-add" onclick="menuDatagrid.addTop()" plain="true">增加根菜单</a>
                <a class="mini-button" iconCls="icon-add" onclick="menuDatagrid.add()" plain="true">增加</a>
                <a class="mini-button" iconCls="icon-edit" onclick="menuDatagrid.edit()" plain="true">编辑</a>
                <a class="mini-button" iconCls="icon-remove" onclick="menuDatagrid.remove()" plain="true">删除</a>
              </td>
              <!-- <td style="white-space:nowrap;">
                <form id="searchForm" method="post" onkeydown="if(event.keyCode===13){onKeyEnter();return false;}">
                  <input class="mini-textbox" id="menuName" name="menuName" emptyText="请输入菜单名" />
                  <a class="mini-button" onclick="search()">查询</a>
                </form>
              </td> -->
            </tr>
          </table>
        </div>
      </div>
      <div class="mini-datagrid" id="menuDatagrid" style="width:100%; height:311px;" allowResize="true" idField="id" multiSelect="true" showEmptyText="true" url="/boss/perm/menus" dataField="data.data" totalField="data.count" sortField="orderNum" sortOrder="asc" onload="menuDatagrid.onLoad">
        <div property="columns">
          <div type="indexcolumn"></div>
          <div type="checkcolumn"></div>
          <div field="menuName" width="120" headerAlign="center" allowSort="true">菜单名</div>
          <div field="ip" width="120" headerAlign="center" allowSort="true">主机ip</div>
          <div field="menuUrl" width="100" headerAlign="center" allowSort="true">菜单链接</div>
          <div field="orderNum" width="100" headerAlign="center" allowSort="true">顺序</div>
          <div field="enabled" width="100" headerAlign="center" allowSort="true">启用状态</div>
          <div field="remark" width="100" headerAlign="center" allowSort="true">备注</div>
        </div>
      </div>
    </div>
  </div>
  </div>
  <script src="/js/jquery/jquery-2.2.4.js"></script>
  <script src="/js/miniui/miniui.js"></script>
  <script src="/js/miniui/miniuiUtil.js"></script>
  <script src="/js/common/common.js"></script>
  <script type="text/javascript">
  'use strict';

  mini.parse();
  </script>
  <script src="/js/boss/perm/menus/page/menuTree.js"></script>
  <script src="/js/boss/perm/menus/page/menuDatagrid.js"></script>
  <script type="text/javascript">
  'use strict';

  function onRefreshTopMenuclick(e) {
    menuTree.loadTopMenus();
  }

  // var searchForm = new mini.Form("searchForm");

  // function search() {
  //   var searchParam = searchForm.getData();
  //   searchParam.token = common.bossToken();
  //   // console.log(searchParam);
  //   subMenuGrid.load(searchParam);
  // }

  // function onKeyEnter(e) {
  //   search();
  // }


  //页面初始化标准方法
  (function() {
    menuTree.init();
    menuDatagrid.init();
  })();
  </script>
</body>

</html>
