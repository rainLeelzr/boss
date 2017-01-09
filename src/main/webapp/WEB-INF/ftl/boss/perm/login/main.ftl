<!DOCTYPE html>
<html>

<head>
  <title>boss</title>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no">
  <meta http-equiv="expires" content="0">
  <meta http-equiv="pragma" content="no-cache">
  <meta http-equiv="cache-control" content="no-cache">
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
    overflow: hidden;
  }
  </style>
</head>

<body>
  <div id="layout1" class="mini-layout" style="width: 100%; height: 100%;" splitSize="0" showSplitIcon="true">
    <div class="header" region="north" height="70" showSplit="true" showHeader="false">
      <h1 style="margin:0;padding:15px;cursor:default;font-family:微软雅黑,黑体,宋体;">boss业务运营支撑系统</h1>
      <div style="position:absolute;top:18px;right:10px;">
        <a class="mini-button mini-button-iconTop" iconCls="icon-add" onclick="onQuickClick" plain="true">快捷</a>
        <a class="mini-button mini-button-iconTop" iconCls="icon-edit" onclick="onClick" plain="true">首页</a>
        <a class="mini-button mini-button-iconTop" iconCls="icon-date" onclick="onClick" plain="true">消息</a>
        <a class="mini-button mini-button-iconTop" iconCls="icon-edit" onclick="onClick" plain="true">设置</a>
        <a class="mini-button mini-button-iconTop" iconCls="icon-close" onclick="onClick" plain="true">关闭</a>
      </div>
    </div>
    <div title="south" region="south" showSplit="true" showHeader="false" height="30">
      <div style="line-height:28px;text-align:center;cursor:default">Copyright © Rain </div>
    </div>
    <div region="west" showHeader="false" width="180" showSplit="true" splitSize="6" showSplitIcon="true" minWidth="100">
      <!--OutlookMenu-->
      <div id="leftTree" class="mini-outlookmenu" onitemclick="leftMenuTree.onItemClick" idField="id" parentField="parentId" textField="menuName" borderStyle="border:0" activeIndex="0">
      </div>
    </div>
    <div title="center" region="center" bodyStyle="overflow:hidden;" showSplit="true">
      <div id="mainTab" class="mini-tabs" activeIndex="0" style="width:100%;height:100%;">
        <!-- <div title="首页" url="http://www.baidu.com">
        </div>
        <div title="子页面关闭" url="../tabs/pages/page1.html">
        </div> -->
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
  <script src="/js/boss/perm/login/main/leftMenuTree.js"></script>
  <script src="/js/boss/perm/login/main/tabs.js"></script>
  <script type="text/javascript">
  'use strict';

  //页面初始化标准方法
  (function() {
    leftMenuTree.init();
    common.heartbeat();
  })();

  //开发调试方法
  (function() {
    setTimeout(leftMenuTree.selectNode, 100);
  })();
  </script>
</body>

</html>
