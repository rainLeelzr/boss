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
  <link rel="stylesheet" href="/js/miniui/themes/default/miniui.css">
</head>
<body>
<div id="layout1" class="mini-layout" style="width: 100%; height: 100%;" splitSize="0">
  <div class="header" region="north" height="120" showSplit="false" showHeader="false">
    <h1 style="margin: 0; padding: 15px; height:39px; cursor: default; font-family: 'Trebuchet MS', Arial, sans-serif;"></h1>

    <div style="position: absolute; top: 10px; right: 10px;">
      选择皮肤：
      <select id="selectSkin" onchange="onSkinChange(this.value)" style="width:100px;" >
          <option value="">Default</option>
          <option value="blue">Blue</option>
          <option value="gray">Gray</option>
          <option value="olive2003">Olive2003</option>
          <option value="blue2003">Blue2003</option>
          <option value="blue2010">Blue2010</option>
          <option value="bootstrap">Bootstrap</option>

          <option value="metro">metro</option>
          <option value="metro-green">metro-green</option>
          <option value="metro-orange">metro-orange</option>

          <option value="jqueryui-uilightness">jqueryui-uilightness</option>
          <option value="jqueryui-humanity">jqueryui-humanity</option>
          <option value="jqueryui-excitebike">jqueryui-excitebike</option>
          <option value="jqueryui-cupertino">jqueryui-cupertino</option>
      </select>

      <span style="color:#fff">当前机构岗位：</span>
      <span style="color:#fff" id="myPos"></span>
      <a class="mini-button mini-button-iconTop" iconCls="icon-download" onclick="downloadControl" plain="true" style="color:#fff">控件下载</a>
      <a class="mini-button mini-button-iconTop" iconCls="icon-reload" onclick="changePos" plain="true" style="color:#fff">切换岗位</a>
      <a class="mini-button mini-button-iconTop" iconCls="icon-reload" onclick="reLogin" plain="true" style="color:#fff">重新登录</a>
      <a class="mini-button mini-button-iconTop" iconCls="icon-close" onclick="logout" plain="true" style="color:#fff">退出</a>
    </div>

    <!-- 申请公开管理菜单id是6f3f51e8-1fc5-44d3-8d63-9a46567b2ae9 -->
    <ul id="menu2" class="mini-menubar mymenu" style="width: 100%;">
      <!--<li onclick="loadPortal"><span style="cursor:pointer">我的桌面</span></li>-->
    <#list userMenu as menu>
      <#if menu_index != 0>
        <li class="separator"></li>
      </#if>
      <li onclick="onMenuClick('${menu.id}')"><span style="cursor:pointer">${menu.menuName}</span></li>
      <#if menu_index == 0>
        <li class="separator"></li>
        <li><a href="${jforumSSO}" target="_blank" style="text-decoration:none;">论坛</a></li>
      </#if>
    </#list>
    </ul>

  </div>

  <div title="south" region="south" showSplit="false" showHeader="false" height="30">
    <div style="line-height: 28px; text-align: center; cursor: default;">Copyright © 广州政通信息科技有限公司版权所有<div style="display:inline;" onclick="window.open('/');">&nbsp;&nbsp;&nbsp;</div></div>
  </div>

  <div showHeader="false" region="west" width="200" maxWidth="250" minWidth="100" >
    <!--OutlookMenu-->
    <div id="leftTree" class="mini-outlookmenu" url="" onitemclick="showTab" idField="id" parentField="pid" textField="text" borderStyle="border:0"></div>

  </div>

  <div title="center" region="center">
    <iframe id="mainframe" frameborder="0" name="main" style="width: 100%; height: 100%;" border="0"></iframe>
    <!--<div showCollapseButton="false" style="border: 0px;width: 100%; height: 100%;">-->
    <!--Tabs-->
    <div id="mainTabs" class="mini-tabs bg-toolbar" activeIndex="0" style="width: 100%; height: 100%;" onactivechanged="onTabsActiveChanged" ontabload="ontabload"></div>
  </div>
</div>
</div>

<script type="text/javascript">
  $(function(){
    $("#myPos").load("/base/changePos!getPosName.action");
    var skin = mini.Cookie.get("miniuiSkin");
    if (skin) {
      var selectSkin = document.getElementById("selectSkin");
      selectSkin.value = skin;
    }
  });
  mini.parse();

  function downloadControl () {
    window.open("/ntko/NtkoAllControlSetup.zip");
    // setTimeout(function () {
    // 	window.clo
    // })
  }

  function showTab(e) {
    var tabs = mini.get("mainTabs");
    var item = e.item;
    var id = "tab$" + item.id;
    var tab = tabs.getTab(id);
    if (!tab) {
      tab = {};
      tab._nodeid = item.id;
      tab.name = id;
      tab.title = item.text;
      tab.showCloseButton = true;
      tab.refreshOnClick = true;
      //这里拼接了url，实际项目，应该从后台直接获得完整的url地址
      tab.url = item.url;

      tabs.addTab(tab);
    }
    tabs.activeTab(tab);
  }

  function onTabsActiveChanged(e) {
    var tabs = e.sender;
    var tab = tabs.getActiveTab();
    if (tab && tab._nodeid) {

      //var node = tree.getNode(tab._nodeid);
      //if (node && !tree.isSelectedNode(node)) {
      //	tree.selectNode(node);
      //}
    }
  }

  /**
   *功能:加载子菜单
   */
  function onMenuClick(menuId) {
    //menuId
    var layout = mini.get("layout1");
    layout.showRegion("west");
    var tree = mini.get("leftTree");
    tree.load("/perm/menu!getAllSubMenu.action?id=" + menuId);
    var tabs = mini.get("mainTabs");
    tabs.removeAll();
    $("#mainframe").hide();
    $("#mainTabs").show();
  }

  /**
   *功能:加载我的桌面
   */
  function loadPortal() {
    var layout = mini.get("layout1");
    layout.hideRegion("west");
    var tabs = mini.get("mainTabs");
    tabs.removeAll();
    $("#mainframe").show();
    layout.showRegion("center");
    $("#mainTabs").hide();
    if ($("#mainframe").attr("src") == undefined) {
      $("#mainframe").attr("src", "/desktop/desktopPersonal!gotoMyDesktop.action");//此处为我的桌面加载的地址
    }
  }

  //loadPortal();

  /**
   *功能：退出
   */
  function logout() {
    if (confirm("确定要退出系统吗？")) {
      location.href = "/perm/portal!logout.action";
      window.close();
    }
  }

  /**
   *功能：重新登录 by tan 2014-6-6
   */
  function reLogin() {
    if (confirm("确定要重新登录吗？")) {
      location.href = "/perm/portal!reLogin.action?t=" + new Date().getTime();
    }
  }

  /**
   *切换岗位
   */
  function changePos(){
    if(confirm("确定要切换岗位吗？")) {
      location.href = "/base/changePos.action";
    }
  }

  ////////////////////////////子页面iframe调用
  //一级菜单
  function selectMenuByPending(menuId) {
    var layout = mini.get("layout1");
    layout.showRegion("west");
    var tree = mini.get("leftTree");
    tree.load("/perm/menu!getAllSubMenu.action?id=6f3f51e8-1fc5-44d3-8d63-9a46567b2ae9");
    var tabs = mini.get("mainTabs");
    tabs.removeAll();
    $("#mainframe").hide();
    $("#mainTabs").show();
  }

  //main页面显示tab
  var applyPublicationId = undefined;
  function showTabByPending(applyId) {
    applyPublicationId = applyId;//保存我的桌面传来的申请id
    //6187e531-c51b-4817-802d-7defe00cbc7f
    ///businessflow/applyPublication.action
    //受理申请
    var tabs = mini.get("mainTabs");
    var itemId = "6187e531-c51b-4817-802d-7defe00cbc7f";
    var id = "tab$" + itemId;
    var tab = tabs.getTab(id);
    if (!tab) {
      tab = {};
      tab._nodeid = itemId;
      tab.name = id;
      tab.title = "受理申请";
      tab.showCloseButton = true;
      tab.refreshOnClick = true;
      //这里拼接了url，实际项目，应该从后台直接获得完整的url地址
      tab.url = "/businessflow/applyPublication.action";

      tabs.addTab(tab);
    }
    tabs.activeTab(tab);
  }

  //登录后直接进入“申请事项受理”菜单
  function showAccept() {
    var layout = mini.get("layout1");
    layout.showRegion("west");
    var tree = mini.get("leftTree");
    tree.load("/perm/menu!getAllSubMenu.action?id=6f3f51e8-1fc5-44d3-8d63-9a46567b2ae9");
    var tabs = mini.get("mainTabs");
    tabs.removeAll();
    $("#mainframe").hide();
    $("#mainTabs").show();
    tree.selectNode({id:"6187e531-c51b-4817-802d-7defe00cbc7f"});

    var tabs = mini.get("mainTabs");
    //console.log(tabs);
    var itemId = "6187e531-c51b-4817-802d-7defe00cbc7f";
    var id = "tab$" + itemId;
    var tab = tabs.getTab(id);
    if (!tab) {
      tab = {};
      tab._nodeid = itemId;
      tab.name = id;
      tab.title = "受理申请";
      tab.showCloseButton = true;
      tab.refreshOnClick = true;
      tab.url = "/businessflow/applyPublication.action";
      tabs.addTab(tab);
      //console.log(tab);
    }
    tabs.activeTab(tab);
  }

  //setTimeout(showAccept, 500);

  function ontabload(){
    if(applyPublicationId){
      var tabs = mini.get("mainTabs");
      var tab = tabs.getTab("tab$6187e531-c51b-4817-802d-7defe00cbc7f");
      var ifm = tabs.getTabIFrameEl(tab);
      ifm.contentWindow.process(applyPublicationId);
      applyPublicationId = undefined;//打开process页面后，applyPublicationId置空，避免点击其他二级菜单时，继续加载process页面
    }else{
      return;
    }
  }


</script>
<script src="/js/jquery/jquery-2.2.4.js"></script>
<script src="/js/miniui/miniui.js"></script>
</body>
</html>
