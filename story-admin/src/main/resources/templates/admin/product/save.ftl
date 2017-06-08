<#import "../../global.ftl" as global />
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
<@global.importMiniui/>
<@global.importUeditorParser/>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            border: 0;
            width: 100%;
            height: 100%;
        }
    </style>
</head>
<body>
<div id="data-form" style="margin-top:20px">
    <!--表单内容-->
      
</div>
<div style="width: 100%;height: 20px;text-align: center">
    <a class="mini-button" iconCls="icon-save" plain="true" onclick="save()">保存</a>
    <a class="mini-button" iconCls="icon-undo" plain="true" onclick="closeWindow('close')">返回</a>
</div>
</body>
</html>
<@global.importRequest/>
<script type="text/javascript">
    var id = "${param.id!''}";
    mini.parse();
    uParse('#data-form', {
        rootPath: Request.BASH_PATH + 'ui/plugins/ueditor',
        chartContainerHeight: 500
    });
    loadData();
    function loadData() {
        if (id != "") {
            Request.get("product/" + id, {}, function (e) {
                if (e.success) {
                    new mini.Form('#data-form').setData(e.data);
                }else{
                	showTips(e.message,"danger");
                }
            });
        }
    }

    function save() {
        var api = "product/" + id;
        var func = id == "" ? Request.post : Request.put;
        var form = new mini.Form("#data-form");
        form.validate();
        if (form.isValid() == false) return;
        //提交数据
        var data = form.getData();
        var box = mini.loading("提交中...", "");
        func(api, data, function (e) {
            mini.hideMessageBox(box);
            if (e.success) {
                if (id == '') {
                    //新增
                    if (window.history.pushState)
                        window.history.pushState(0, "", '?id=' + e.data);
                    id = e.data;
                    showTips("创建成功!");
                } else {
                    //update
                    showTips("修改成功!");
                }
            } else {
                showTips(e.message, "danger");
            }
        });
    }
</script>
