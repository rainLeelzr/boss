'use strict';

var mainTab = (function() {
  /******************** 成员变量 ********************/
  var tabs = mini.get('mainTab');

  /******************** 业务方法 ********************/

  /******************** 工具方法 ********************/
  function showTab(item) {
    // console.log(item);
    var tabId = "tab$" + item.id;
    var tab = tabs.getTab(tabId);
    if (!tab) {
      tab = {};
      tab._itemid = item.id;
      tab.name = tabId;
      tab.title = item.text;
      tab.showCloseButton = true;

      //这里拼接了url，实际项目，应该从后台直接获得完整的url地址
      var menuUrl = item.menuUrl;
      if (menuUrl.indexOf('?') > 0) {
        menuUrl += '&token=' + common.bossToken();
      } else {
        menuUrl += '?token=' + common.bossToken();
      }
      // console.log(menuUrl);
      tab.url = menuUrl;

      tabs.addTab(tab);
    }
    tabs.activeTab(tab);
  }

  /******************** 初始化方法 ********************/

  /******************** 事件绑定处理方法 ********************/

  /******************** 导出api ********************/
  return {
    tabs: tabs,
    showTab: showTab
  };
})();