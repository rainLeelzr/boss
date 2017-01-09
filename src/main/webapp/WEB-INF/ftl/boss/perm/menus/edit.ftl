<!DOCTYPE html>
<html lang="zh-cn">

<head>
  <title>boss-menu</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
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
    <input class="mini-hidden" id="parentId" name="parentId" type="hidden" />
    <div style="padding-left:11px;padding-bottom:5px;">
      <table style="table-layout:fixed;">
        <tr>
          <td style="width:70px;">菜单名：</td>
          <td style="width:150px;">
            <input class="mini-textbox" id="menuName" name="menuName" emptyText="请输入菜单名" vtype="maxLength:64" required="true" /> </td>
        </tr>
        <tr>
          <td>主机ip：</td>
          <td>
            <input class="mini-textbox" id="ip" name="ip" emptyText="请输入主机ip" vtype="maxLength:64" required="false" /> </td>
        </tr>
        <tr>
          <td>菜单链接：</td>
          <td>
            <input class="mini-textbox" id="menuUrl" name="menuUrl" emptyText="请输入菜单链接" vtype="maxLength:128" required="true" /> </td>
        </tr>
        <tr>
          <td>顺序：</td>
          <td>
            <input class="mini-spinner" id="orderNum" name="orderNum" emptyText="请输入顺序" minValue="1" maxValue="127" /> </td>
        </tr>
        <tr>
          <td>启用：</td>
          <td>
            <input class="mini-textbox" id="enabled" name="enabled" emptyText="请输入启用状态" required="false" /> </td>
        </tr>
        <tr>
          <td>备注：</td>
          <td>
            <textarea class="mini-textarea" id="remark" name="remark" style="width:350px;" emptyText="请输入备注"></textarea>
          </td>
        </tr>
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
  'use strict'

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

    mini.mask({
      el: document.body,
      cls: 'mini-mask-loading',
      html: '加载中...'
    });
    if (o.id == '') {
      add(o);
    } else {
      update(o);
    }
  }

  function add(o) {
    o.token = localStorage.getItem('token');
    $.ajax({
      url: '/boss/perm/menus/add',
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
      url: '/boss/perm/menus/update',
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
    //跨页面传递的数据对象，克隆后才可以安全使用
    data = mini.clone(data);

    action = data.action;
    if (action == "edit") {
      var url = '/boss/perm/menus/[id]?token=[token]';
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

          // console.log(resp);
          //          var o = mini.decode(text);
          form.setData(resp.data);
          form.setChanged(false);
        }
      });
    } else if (action == "new") {
      mini.get('parentId').setValue(data.parentId);
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
    SaveData();
  }

  function onCancel(e) {
    CloseWindow("cancel");
  }

  /**
   * 页面初始化标准方法
   */
  function init() {

  }
  </script>
</body>

</html>
