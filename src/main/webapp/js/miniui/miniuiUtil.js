(function (win) {

    //访问boss系统的token
    win.appSetting = {
        bossToken: '4e90c7cc-41bd-45ce-9b61-e453713e14fb'
    };

    // $(document).ajaxComplete(function (evt, request, settings) {
    //     var text = request.responseText;
    //     console.log('ajaxComplete');
    // });

    //每隔25分钟进行一次心跳
    win.heartbeat = function () {
        setTimeout(function () {
            $.ajax({
                url: "/boss/heartbeat",
                type: 'get',
                data: {token: appSetting.bossToken},
                cache: false,
                success: function (text) {

                },
                error: function (text) {

                }
            });
        }, 1000 * 60 * 25);
    };

    win.mtool = {};


})(window);