<#import "../../../global.ftl" as global />
<#import "/spring.ftl" as spring/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
<@global.importMiniui/>
<@global.importUeditorParser/>
<@global.importFontIcon/>
    <style type="text/css">
        body {
            margin: 0;
            padding: 0;
            border: 0;
            width: 100%;
            height: 90%;
        }
    </style>
</head>
<body>
<div id="data-form" style="margin-top:20px">
    <table data-sort="sortDisabled" style="width:80%;margin:auto;">
        <tbody>
        <tr class="firstRow">
            <th style="border-color: rgb(221, 221, 221);" rowspan="1" colspan="4"><span id="title" style="font-size: 24px;">
            ${param???string('编辑内容规则','新建内容规则')}
            </span></th>
        </tr>
        <tr>
            <td valign="middle" style="word-break: break-all; border-color: rgb(221, 221, 221);" align="right" width="20%">名称</td>
            <td valign="top" style="word-break: break-all; border-color: rgb(221, 221, 221);" width="80%">
                <input style="width:100%" required="true" name="name" id="name" class="mini-textbox"></td>
        </tr>
        <tr>
            <td valign="middle" style="word-break: break-all; border-color: rgb(221, 221, 221);" align="right" width="20%">规则</td>
            <td valign="middle" style="word-break: break-all; border-color: rgb(221, 221, 221);" width="80%" align="left">
                <input style="width:100%" name="contentRule" required="true" id="contentRule" class="mini-textbox"></td>
        </tr>
        </tbody>
    </table>
</div>

<#--<div id="roleGrid" class="mini-datagrid" style="width:80%;height:200px;margin: auto"-->
     <#--url="<@global.api "role?paging=false"/>" ajaxOptions="{type:'GET'}" showpager="false"-->
     <#--allowCellSelect="true" multiSelect="true" >-->
    <#--<div property="columns">-->
        <#--<div type="checkcolumn"></div>-->
        <#--<div name="id" field="id" width="60">ID</div>-->
        <#--<div name="name" field="name" width="120">角色名称</div>-->
        <#--<div name="remark" field="remark" width="120">备注</div>-->
    <#--</div>-->
</div>
<#--
position:fixed;z-index: 99999;bottom: 0px;-->
<div style="width: 100%;height: 20px;text-align: center">
    <a class="mini-button" iconCls="icon-save" plain="true" onclick="closeContentWindow()">保存</a>
    <a class="mini-button" iconCls="icon-undo" plain="true" onclick="closeWindow('back')">返回</a>
</div>
</body>
</html>
<@global.importRequest/>
<script type="text/javascript">
    function closeContentWindow() {
        var form = new mini.Form("#data-form");
        form.validate();
        if (!form.isValid())return;
        var story  = form.getData();
        closeWindow(story);
    }
    var contentId = "${param!''}";

    mini.parse();
    uParse('#data-form', {
        rootPath: Request.BASH_PATH+'ui/plugins/ueditor',
        chartContainerHeight: 500
    });
    loadData();
    function loadData() {
        if (contentId != "") {
            Request.get("api/site/story/content/" + contentId, {}, function (e) {
                if (e.success) {
                    new mini.Form('#data-form').setData(e.data);
                }
            });
        }
    }
</script>
<#--<@global.resources 'js/storyRule/content/save.js'/>-->
