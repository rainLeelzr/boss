(function(win) {

  var parseOption = function(e) {

    var optName = e.column.name;
    var opts = common.getOptions(optName);
    for (var i = opts.length - 1; i >= 0; i--) {
      if (opts[i].value === e.value) {
        return opts[i].name;
      }
    }
    return '';
  }

  win.mutil = {
    parseOption: parseOption
  };


})(window);