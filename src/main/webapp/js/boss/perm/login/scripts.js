'use strict'

jQuery(document).ready(function() {

  /*
      Fullscreen background
  */
  $.backstretch('/image/boss/perm/login/background.jpg');

  /*
      Form validation
  */
  $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
    $(this).removeClass('input-error');
  });

  // $('.login-form').on('submit', function(e) {
  //   $(this).find('input[type="text"], input[type="password"], textarea').each(function() {
  //     if ($(this).val() === '') {
  //       e.preventDefault();
  //       $(this).addClass('input-error');
  //     } else {
  //       $(this).removeClass('input-error');
  //     }

  //     if ($(this).attr('id') === 'form-password') {
  //       var md5Pwd = $.md5($(this).val());
  //       var md5PwdAccount = $.md5(md5Pwd + $('#form-username').val());
  //       var md5PwdAccountVCode = $.md5(md5PwdAccount + $('#form-vCode').val());
  //       $(this).val(md5PwdAccountVCode);
  //       alert($(this).val());
  //     }
  //   });
  //   return false;
  // });

  $('#login').on('click', function(e) {
    //用户名
    var $userAccount = $('#form-username');
    if ($userAccount.val() === '') {
      $userAccount.addClass('input-error');
      return;
    } else {
      $userAccount.removeClass('input-error');
    }

    //密码
    var $userPwd = $('#form-password');
    if ($userPwd.val() === '') {
      $userPwd.addClass('input-error');
      return;
    } else {
      $userPwd.removeClass('input-error');
    }

    //验证码
    var $vCode = $('#form-vCode');
    if ($vCode.val() === '') {
      $vCode.addClass('input-error');
      return;
    } else {
      $vCode.removeClass('input-error');
    }

    var md5Pwd = $.md5($userPwd.val());
    var md5PwdAccount = $.md5(md5Pwd + $userAccount.val());
    var md5PwdAccountVCode = $.md5(md5PwdAccount + $vCode.val());
    $userPwd.val(md5PwdAccountVCode);

    $.ajax({
      url: "/boss/login",
      type: 'post',
      data: {
        userAccount: $userAccount.val(),
        userPwd: $userPwd.val(),
        vCode: $vCode.val()
      },
      cache: false,
      dataType: 'json',
      success: function(resp) {
        console.log(resp);
        if (resp.success) {
          localStorage.setItem('token', resp.data.token);
          var url = '/boss/main';
          window.location.href = url;
        } else {
          alert(resp.message);
        }
      },
      error: function(text) {

      }
    });
  });

  $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('keydown', function(e) {
    if(e.keyCode === 13){
      $('#login').trigger('click');
    }
  });


});