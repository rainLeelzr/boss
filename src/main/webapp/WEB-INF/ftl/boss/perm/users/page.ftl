<!DOCTYPE html>
<html lang="zh-cn">

<head>
  <title>boss-user</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
  <link type="text/css" rel="stylesheet" href="/js/miniui/themes/default/miniui.css">
  <link type="text/css" rel="stylesheet" href="/js/miniui/themes/icons.css">
  <#--<link type="text/css" rel="stylesheet" href="/js/miniui/themes/default/large-mode.css">-->
    <link type="text/css" rel="stylesheet" href="/js/miniui/themes/bootstrap/skin.css">
    <style type="text/css">
    .mini-textbox {
      width: 150px;
    }
    </style>
</head>

<body>
  <div style="width:100%;">
    <div class="mini-toolbar" style="border-bottom:0;padding:0px;">
      <table style="width:100%;">
        <tr>
          <td style="width:100%;">
            <a class="mini-button" iconCls="icon-add" onclick="add()" plain="true">增加</a>
            <a class="mini-button" iconCls="icon-edit" onclick="edit()" plain="true">编辑</a>
            <a class="mini-button" iconCls="icon-remove" onclick="remove()" plain="true">删除</a>
          </td>
          <td style="white-space:nowrap;">
            <form id="searchForm" method="post" onkeydown="if(event.keyCode===13){onKeyEnter();return false;}">
              <input class="mini-textbox" id="userName" name="userName" emptyText="请输入姓名"/>
              <a class="mini-button" onclick="search()">查询</a>
            </form>
          </td>
        </tr>
      </table>
    </div>
  </div>
  <div class="mini-datagrid" id="datagrid1" style="width:100%; height:311px;" allowResize="true" idField="id" multiSelect="true" showEmptyText="true" dataField="data.data" totalField="data.count" onload="onload">
    <div property="columns">
      <div type="indexcolumn"></div>
      <div type="checkcolumn"></div>
      <div field="userAccount" width="120" headerAlign="center" allowSort="true">帐号</div>
      <div field="userName" width="120" headerAlign="center" allowSort="true">姓名</div>
      <div field="gender" width="100" headerAlign="center" allowSort="true" name="gender" renderer="mutil.parseOption">性别</div>
      <div field="qq" width="100" headerAlign="center" allowSort="true">qq</div>
      <div field="telephone" width="100" headerAlign="center" allowSort="true">固话</div>
      <div field="mobilePhone" width="100" headerAlign="center" allowSort="true">手机</div>
      <div field="email" width="100" headerAlign="center" allowSort="true">电子邮箱</div>
      <div field="enabled" width="100" headerAlign="center" allowSort="true" name="enabled" renderer="mutil.parseOption">是否启用</div>
      <div field="remark" width="100" headerAlign="center" allowSort="true">备注</div>
    </div>
  </div>
  <script src="/js/jquery/jquery-2.2.4.js"></script>
  <script src="/js/miniui/miniui.js"></script>
  <script src="/js/miniui/miniuiUtil.js"></script>
  <script src="/js/common/common.js"></script>
  <script>
  'use strict'

  mini.parse();

  var grid = mini.get('datagrid1');
  var searchForm = new mini.Form("searchForm");

  grid.setUrl('/boss/perm/users');
  grid.load({
    token: localStorage.getItem('token')
  });

  function onload(e) {
    // console.log(e);
    var resp = e.result;
    if (!resp.success) {
      if (resp.code == 2) {
        mini.alert(resp.message + '，请重新登录');
        return;
      }

      mini.alert(resp.message);
    }
  }

  function add() {

    mini.open({
      url: '/boss/perm/users/edit',
      title: '新增员工',
      width: 600,
      height: 400,
      onload: function() {
        var iframe = this.getIFrameEl();
        var data = {
          appSetting: appSetting,
          action: 'new'
        };
        iframe.contentWindow.SetData(data);
      },
      ondestroy: function(action) {

        grid.reload();
      }
    });
  }

  function edit() {

    var row = grid.getSelected();
    if (row) {
      mini.open({
        url: '/boss/perm/users/edit',
        title: "编辑员工",
        width: 600,
        height: 400,
        onload: function() {
          var iframe = this.getIFrameEl();
          var data = {
            appSetting: appSetting,
            action: "edit",
            id: row.id
          };
          iframe.contentWindow.SetData(data);

        },
        ondestroy: function(action) {
          grid.reload();

        }
      });

    } else {
      alert("请选中一条记录");
    }

  }

  function remove() {

    var rows = grid.getSelecteds();
    if (rows.length > 0) {
      if (confirm("确定删除选中记录？")) {
        var ids = [];
        for (var i = 0, l = rows.length; i < l; i++) {
          var r = rows[i];
          ids.push(r.id);
        }
        grid.loading("操作中，请稍后......");
        $.ajax({
          url: '/boss/perm/users/delete',
          type: 'post',
          data: {
            ids: ids.join(','),
            token: localStorage.getItem('token')
          },
          success: function(resp) {
            grid.unmask();
            console.log(resp);
            if (!resp.success) {
              if (resp.code == 2) {
                mini.alert(resp.message);
              } else {
                mini.alert(resp.message);
              }
              return;
            }
            grid.reload();
          },
          error: function(jqXHR, textStatus, errorThrown) {
            console.log(jqXHR);
            console.log(textStatus);
            console.log(errorThrown);
            grid.unmask();
            mini.alert('系统错误，错误码：' + jqXHR.status);
          }
        });
      }
    } else {
      alert("请选中一条记录");
    }
  }

  function search() {
    var searchParam = searchForm.getData();
    searchParam.token = localStorage.getItem('token');
    // console.log(searchParam);
    grid.load(searchParam);
  }

  function onKeyEnter(e) {
    search();
  }

  </script>
</body>

</html>
