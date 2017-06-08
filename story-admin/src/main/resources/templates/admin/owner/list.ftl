<#import "../../global.ftl" as global />
<#import "../../authorize.ftl" as authorize/>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title></title>
<@global.importMiniui/>
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
<div class="mini-toolbar" style="width: 100%;padding:2px;border-bottom:0;">
    <table id="searchForm" style="width:100%;border: 0px">
        <tr>
            <td style="width:100%;">
            <#if authorize.module('user','C')>
                <a class="mini-button" iconCls="icon-add" plain="true" onclick="create()">新建管理员</a>
                <span class="separator"></span>
            </#if>
                <a class="mini-button" iconCls="icon-reload" plain="true" onclick="grid.reload()">刷新</a>
            </td>
            <td style="white-space:nowrap;">
            	<label>性别: </label>
                 <input name="sex$LIKE" style="width: 100px" onenter="search()" class="mini-textbox"/>
                <a class="mini-button" iconCls="icon-search" plain="true" onclick="search()">查询</a>
            </td>
        </tr>
    </table>
</div>
<div class="mini-fit">
    <div id="datagrid" class="mini-datagrid" style="width:100%;height:100%;"
         url="<@global.api 'owner'/>" ajaxOptions="{type:'GET',dataType:'json'}" idField="id"
         sizeList="[10,20,50,200]" pageSize="20">
        <div property="columns">
            <div type="indexcolumn"></div>
                               <div field="id" width="120" align="center" headerAlign="center" allowSort="true">id</div>
                               <div field="sex" width="120" align="center" headerAlign="center" allowSort="true">性别</div>
                               <div field="name" width="120" align="center" headerAlign="center" allowSort="true">姓名</div>
            <div name="action" width="100" renderer="rendererAction" align="center" headerAlign="center">操作</div>
        </div>
    </div>
</div>
</body>
</html>
<script type="text/javascript">
    var accessUpdate =${authorize.module('owner','U')?c};
    var accessDelete =${authorize.module('owner','D')?c};
</script>
<@global.importRequest/>
<@global.resources 'js/owner/list.js'/>