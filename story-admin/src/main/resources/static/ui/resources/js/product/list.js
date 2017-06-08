 mini.parse();
    var grid = mini.get('datagrid');
    bindDefaultAction(grid);
    search();
    function search() {
        var data = new mini.Form("#searchForm").getData();
        var queryParam = Request.encodeParam(data);
        grid.load(queryParam);
    }
    function rendererAction(e) {
        var row = e.record;
        var html = "";
      if(accessUpdate)
           html += createActionButton("编辑", "edit('" + row.id + "')", "icon-edit");
      if(accessDelete)
      	html += createActionButton("删除", "remove('" + row.id + "')", "icon-remove");
        return html;
    }

    function edit(id){
        openWindow(Request.BASH_PATH + "admin/product/save.html?id="+id, "编辑产品", "70%", "80%", function (e) {
            grid.reload();
        });
    }
    function create() {
        openWindow(Request.BASH_PATH + "admin/product/save.html", "新建产品",  "70%", "80%", function (e) {
            grid.reload();
        });
    }

    function remove(id) {
        mini.confirm("确定删除此产品", "确定？",
                function (action) {
                    if (action == "ok") {
                        grid.loading("删除中...");
                        Request['delete']("product/" + id, {}, function (e) {
                            if (e.success) {
                                grid.reload();
                                showTips("删除成功!");
                            } else {
                                showTips(e.message, 'danger');
                            }
                        });
                    }
                }
        );
    }
