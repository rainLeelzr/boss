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
    <style>
    .mini-textarea {
      width: 400px;
    }
    </style>
</head>

<body>
  <form id="form1" method="post">
    <input class="mini-hidden" name="id" type="hidden" />
    <div style="padding-left:11px;padding-bottom:5px;">
      <table style="table-layout:fixed;">
        <tr>
          <td style="width:70px;">帐号：</td>
          <td style="width:150px;">
            <input name="userAccount" class="mini-textbox" required="true" emptyText="请输入帐号" />
          </td>
        </tr>
        <tr>
          <td>姓名：</td>
          <td>
            <input name="userName" class="mini-textbox" required="true" emptyText="请输入姓名" />
          </td>
        </tr>
        <tr>
          <td>性别：</td>
          <td>
            <select name="gender" class="mini-radiobuttonlist">
              <option value="1">男</option>
              <option value="2">女</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>qq：</td>
          <td>
            <input name="qq" class="mini-textbox" required="false" emptyText="请输入qq" />
          </td>
        </tr>
        <tr>
          <td>固话：</td>
          <td>
            <input name="telephone" class="mini-textbox" required="false" emptyText="请输入固话" />
          </td>
        </tr>
        <tr>
          <td>手机：</td>
          <td>
            <input name="mobilePhone" class="mini-textbox" required="false" emptyText="请输入手机" />
          </td>
        </tr>
        <tr>
          <td>电子邮箱：</td>
          <td>
            <input name="email" class="mini-textbox" required="false" emptyText="请输入电子邮箱" />
          </td>
        </tr>
        <tr>
          <td>是否启用：</td>
          <td>
            <select name="enabled" class="mini-radiobuttonlist">
              <option value="1">启用</option>
              <option value="0">停用</option>
            </select>
          </td>
        </tr>
        <tr>
          <td>备注：</td>
          <td>
            <input name="remark" class="mini-textarea" required="false" emptyText="请输入备注" />
          </td>
        </tr>
        <#--<tr>-->
          <#--<td>学历：</td>-->
            <#--<td>-->
              <#--<input name="educational" class="mini-combobox" valueField="id" textField="name" -->
                <#--url="../data/AjaxService.aspx?method=GetEducationals" />-->
                <#--</td>-->
                  <#--</tr>-->
      </table>
    </div>
    <div style="text-align:center;padding:10px;">
      <a class="mini-button" onclick="onOk" style="width:60px;margin-right:20px;">确定</a>
      <a class="mini-button" onclick="onCancel" style="width:60px;">取消</a>
    </div>
  </form>
  <script src="/js/jquery/jquery-2.2.4.js"></script>
  <script src="/js/miniui/miniui.js"></script>
  <script src="/js/miniui/miniuiUtil.js"></script>
  <script>
  mini.parse();

  var action = null;
  var form = new mini.Form('form1');

  function SaveData() {
    var o = form.getData();
    console.log(o);
    form.validate();
    if (form.isValid() == false) {
      return;
    }

    if (o.id == '') {
      add(o);
    } else {
      update(o);
    }
  }

  function add(o) {
    o.token = localStorage.getItem('token');
    $.ajax({
      url: '/boss/perm/users/add',
      type: 'post',
      data: o,
      cache: false,
      success: function(resp) {
        mini.unmask();
        console.log(resp);
        if (!resp.success) {
          if (resp.code == 2) {
            mini.alert(resp.message);
          } else {
            mini.alert(resp.message);
          }
          return;
        }
        CloseWindow("save");
      },
      error: function(jqXHR, textStatus, errorThrown) {
        mini.unmask();
        alert(jqXHR.responseText);
        CloseWindow();
      }
    });
  }

  function update(o) {
    o.token = localStorage.getItem('token');
    $.ajax({
      url: '/boss/perm/users/update',
      type: 'post',
      data: o,
      cache: false,
      success: function(resp) {
        mini.unmask();
        console.log(resp);
        if (!resp.success) {
          if (resp.code == 2) {
            mini.alert(resp.message);
          } else {
            mini.alert(resp.message);
          }
          return;
        }
        CloseWindow("save");
      },
      error: function(jqXHR, textStatus, errorThrown) {
        console.log(jqXHR);
        console.log(textStatus);
        console.log(errorThrown);
        mini.unmask();
        mini.alert('系统错误，错误码：' + jqXHR.status);
        //CloseWindow();
      }
    });
  }

  ////////////////////
  //标准方法接口定义
  function SetData(data) {
    appSetting = data.appSetting;
    action = data.action;
    if (action == "edit") {
      //跨页面传递的数据对象，克隆后才可以安全使用
      data = mini.clone(data);
      var url = '/boss/perm/users/[id]?token=[token]';
      url = url.replace('[id]', data.id);
      url = url.replace('[token]', localStorage.getItem('token'));
      $.ajax({
        url: url,
        cache: false,
        success: function(resp) {
          if (!resp.success) {
            if (resp.code == 2) {
              mini.alert(resp.message);
            }

            return;
          }

          console.log(resp);
          //          var o = mini.decode(text);
          form.setData(resp.data);
          form.setChanged(false);
        }
      });
    }
  }

  function GetData() {
    var o = form.getData();
    return o;
  }

  function CloseWindow(action) {
    if (action == "close" && form.isChanged()) {
      if (confirm("数据被修改了，是否先保存？")) {
        return false;
      }
    }
    if (window.CloseOwnerWindow) return window.CloseOwnerWindow(action);
    else window.close();
  }

  function onOk(e) {
    mini.mask({
      el: document.body,
      cls: 'mini-mask-loading',
      html: '加载中...'
    });
    SaveData();
  }

  function onCancel(e) {
    CloseWindow("cancel");
  }
  </script>
</body>

</html>
