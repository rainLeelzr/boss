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
          <input id="key" class="mini-textbox" emptyText="请输入姓名" style="width:150px;" onenter="onKeyEnter"/>
          <a class="mini-button" onclick="search()">查询</a>
        </td>
      </tr>
    </table>
  </div>
</div>
<div class="mini-datagrid" id="datagrid1" style="width:100%; height:280px;" allowResize="true" idField="id"
     multiSelect="true" showEmptyText="true"
     ajaxOptions="{type:'get'}" dataField="data.data" totalField="data.count" onload="onload">
  <div property="columns">
    <div type="indexcolumn"></div>
    <div type="checkcolumn"></div>
    <div field="userAccount" width="120" headerAlign="center" allowSort="true">帐号</div>
    <div field="userName" width="120" headerAlign="center" allowSort="true">姓名</div>
    <div field="genderStr" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">性别</div>
    <div field="qq" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">qq</div>
    <div field="telephone" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">固话</div>
    <div field="mobilePhone" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">手机</div>
    <div field="email" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">电子邮箱</div>
    <div field="enabled" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">是否启用</div>
    <div field="remark" width="100" headerAlign="center" dateFormat="yyyy-MM-dd" allowSort="true">备注</div>
  </div>
</div>

<script src="/js/jquery/jquery-2.2.4.js"></script>
<script src="/js/miniui/miniui.js"></script>
<script src="/js/miniui/miniuiUtil.js"></script>
<script>
  mini.parse();

  var grid = mini.get('datagrid1');

  grid.setUrl('/boss/perm/users');
  grid.load({token: appSetting.bossToken});

  function onload(e) {
    console.log(e);
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
      url: '/boss/perm/users/edit?token=' + appSetting.bossToken,
      title: '新增员工', width: 600, height: 400,
      onload: function () {
        var iframe = this.getIFrameEl();
        var data = {
          appSetting: appSetting,
          action: 'new'
        };
        iframe.contentWindow.SetData(data);
      },
      ondestroy: function (action) {

        grid.reload();
      }
    });
  }

  function edit() {

    var row = grid.getSelected();
    if (row) {
      mini.open({
        url: '/boss/perm/users/edit?token=' + appSetting.bossToken,
        title: "编辑员工", width: 600, height: 400,
        onload: function () {
          var iframe = this.getIFrameEl();
          var data = {
            appSetting: appSetting,
            action: "edit",
            id: row.id
          };
          iframe.contentWindow.SetData(data);

        },
        ondestroy: function (action) {
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
        var url = '/boss/perm/users/{ids}?token=' + appSetting.bossToken;
        url = url.replace('{ids}', ids.join(','));
        $.ajax({
          url: url,
          type: 'delete',
          success: function (resp) {
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
          error: function (jqXHR, textStatus, errorThrown) {
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
    var key = mini.get("key").getValue();
    grid.load({key: key});
  }
  function onKeyEnter(e) {
    search();
  }

  heartbeat();
</script>
</body>
</html>