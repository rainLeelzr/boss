'use strict';

(function(win) {
  //获取boss令牌
  var bossToken = function() {
    var token = localStorage.getItem('token');
    return token == null ? '' : token;
  };

  //获取下拉框选项
  var getOptions = (function(optName) {
    var optionCache = {};

    var url = '/boss/base/option/[optName]?token=[token]';
    url = url.replace('[token]', bossToken());

    function getFromCache(optName) {
      if (optionCache[optName]) {
        return optionCache[optName];
      }
    }

    function getFromServer(optName) {
      $.ajax({
        url: url.replace('[optName]', optName),
        type: 'get',
        cache: false,
        async: false,
        dataType: 'json',
        success: function(resp) {
          // console.log(resp);
          if (resp.success) {
            // console.log(resp.data);
            // console.log($.parseJSON(resp.data));
            // optionCache[optName] = $.parseJSON(resp.data);
            optionCache[optName] = resp.data;
          }
        },
        error: function(text) {

        }
      });
      return optionCache[optName];
    }

    return function(optName) {
      var opt = getFromCache(optName);
      if (!opt) {
        opt = getFromServer(optName) || [];
      }
      return opt;
    }

  })();

  //每隔15分钟进行一次心跳，重新获取token
  var heartbeat = function() {
    setTimeout(function() {
      $.ajax({
        url: '/boss/login/reToken',
        type: 'post',
        data: {
          token: bossToken()
        },
        cache: false,
        dataType: 'json',
        success: function(resp) {
          if (resp.success) {
            localStorage.setItem('token', resp.data);
          }
        },
        error: function(text) {

        }
      });
    }, 1000 * 60 * 15);
  };

  //全局ajax统一处理
  (function() {
    var alertedMessage = [];

    function errorHandler(request) {
      if (request.status === 200) {
        var text = request.responseText;
        var resp = $.parseJSON(text);
        if (resp.success) {
          return;
        }

        for (var i = alertedMessage.length - 1; i >= 0; i--) {
          if (alertedMessage[i].code === resp.code) {
            return;
          }
        }

        alertedMessage.push({
          code: resp.code,
          message: resp.message
        });

        alert(resp.message);
      } else {
        alert('status: ' + request.state + 'statusText: ' + request.statusText);
      }
    }

    $(document).ajaxComplete(function(evt, request, settings) {
      // console.log('ajaxComplete');
      // console.log(request);
      errorHandler(request);
    });
  })();


  //导出api
  win.common = {
    bossToken: bossToken,
    getOptions: getOptions,
    heartbeat: heartbeat
  };

})(window);