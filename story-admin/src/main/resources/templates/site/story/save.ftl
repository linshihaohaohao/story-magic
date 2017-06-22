<#import "../../global.ftl" as global />
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
            ${param???string('编辑站点','新建站点')}
            </span></th>
        </tr>
        <tr>
            <td valign="middle" style="word-break: break-all; border-color: rgb(221, 221, 221);" align="right" width="20%">名称</td>
            <td valign="top" style="word-break: break-all; border-color: rgb(221, 221, 221);" width="80%">
                <input style="width:100%" required="true" name="name" id="name" class="mini-textbox"></td>
        </tr>
        <tr>
            <td valign="middle" style="word-break: break-all; border-color: rgb(221, 221, 221);" align="right" width="20%">URL</td>
            <td valign="top" style="word-break: break-all; border-color: rgb(221, 221, 221);" width="80%">
                <input style="width:100%" required="true" name="url" id="url" class="mini-textbox"></td>
        </tr>
        <tr>
            <td valign="middle" style="word-break: break-all; border-color: rgb(221, 221, 221);" align="right" width="20%">类型</td>
            <td valign="middle" style="word-break: break-all; border-color: rgb(221, 221, 221);" width="80%" align="left">
                <input style="width:100%" name="type" id="type" class="mini-textbox"></td>
        </tr>
        </tbody>
    </table>
</div>
<div id="story-form" style="margin: auto;width:80%;">
    <br/>
    <h2 align="center">编辑网站规则</h2>
    <a class="mini-button" iconCls="icon-add" onclick="addNode()" plain="true"></a>
    <div id="m_option_table" class="mini-treegrid"
         style="margin: auto;width:100%;height:300px;border: 0px;"
         showPager="false" allowCellEdit="true" allowDrop="true" resultAsTree="false"
         allowCellSelect="true" llowDrag="false" showTreeIcon="true"
         allowAlternating="true" editNextOnEnterKey="false" idField="id">
        <div property="columns" >
            <#--<div type="indexcolumn" name="treeColumn"  align="center" headerAlign="center">拖动排序</div>-->
            <#--treeColumn="treeColumn" a-->
            <div field="name" width="60" align="center" headerAlign="center">名称
                <input property="editor" required="true"  name="name" id="name" class="mini-textbox"/>
            </div>
            <div field="bookName" width="60" align="center" headerAlign="center">书名
                <input property="editor" class="mini-textbox" name="bookName" id="bookName"/>
            </div>
                <div field="bookDescription" width="60" align="center" headerAlign="center">简洁
                    <input property="editor" class="mini-textbox" name="bookDescription" id="bookDescription"/>
                </div>
            <div field="authorName" width="60" align="center" headerAlign="center">作者
                <input property="editor" class="mini-textbox"/>
            </div>
            <div field="type" width="60" align="center" headerAlign="center">类型
                <input property="editor" class="mini-combobox" url="<@global.api 'api/site/storyRule/storyType'/>"  valueField="data" textField="data" showNullItem="false"/>
            </div>
            <div field="listRule" width="60" align="center" headerAlign="center">列表规则
                <input property="editor" class="mini-textbox"/>
            </div>
            <div field="chapterName" width="60" align="center" headerAlign="center">章节规则
                <input property="editor" class="mini-textbox"/>
            </div>
            <div field="url" width="60" align="center" headerAlign="center">页面链接
                <input property="editor" required="true" class="mini-textbox"/>
            </div>
            <div field="urlRule" width="60" align="center" headerAlign="center">详情规则
                <input property="editor" class="mini-textbox"/>
            </div>
            <div field="resourceSiteRule" width="60" align="center" headerAlign="center">资源网站名称规则
                <input property="editor" class="mini-textbox"/>
            </div>
            <div field="resourceSiteUrlRule" width="60" align="center" headerAlign="center">资源网站Url规则
                <input property="editor" class="mini-textbox"/>
            </div>
            <div field="lastUpdateRule" width="60" align="center" headerAlign="center">最后更新时间获取规则
                <input property="editor" class="mini-textbox"/>
            </div>
            <div field="ruleType" width="60" align="center" headerAlign="center">规则类型
                <input property="editor" class="mini-combobox" url="<@global.api 'api/site/storyRule/ruleType'/>"  valueField="data" textField="data" showNullItem="false"/>
            </div>
            <div field="albumUrl" width="60" align="center" headerAlign="center">封面
                <input property="editor" class="mini-textbox"/>
            </div>
                <div field="" renderer="rendererForContent"  width="60" align="center" headerAlign="center" >内容
                    <#--<input property="editor" onbuttonclick="onbuttonedit" class="mini-buttonedit" readonly/>-->
                </div>
                <div field=""  renderer="rendererForChapter"  width="60" align="center" headerAlign="center">章节

                </div>
            <div name="action" renderer="renderAction" align="center" headerAlign="center" width="50">操作
            </div>
        </div>
    </div>
</div>
</div>

<div id="content-form" style="margin-top:20px"   class="mini-window" title="内容规则" style="650px;height: 350px;"
     showModal="true" allowResize="true" allowDrag="true">
    <table data-sort="sortDisabled" style="width:80%;margin:auto;">
        <tbody>
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
    <div style="width: 100%;height: 20px;text-align: center">
        <a class="mini-button" iconCls="icon-save" plain="true" onclick="contentSave()">保存</a>
        <a class="mini-button" iconCls="icon-undo" plain="true" onclick="miniClose()">返回</a>
    </div>
</div>


<div id="chapter-form" style="margin-top:20px"   class="mini-window" title="章节规则" style="650px;height: 350px;"
     showModal="true" allowResize="true" allowDrag="true">
    <table data-sort="sortDisabled" style="width:80%;margin:auto;">
        <tbody>
        <tr>
            <td valign="middle" style="word-break: break-all; border-color: rgb(221, 221, 221);" align="right" width="20%">名称</td>
            <td valign="top" style="word-break: break-all; border-color: rgb(221, 221, 221);" width="80%">
                <input style="width:100%" required="true" name="name" id="name" class="mini-textbox"></td>
        </tr>
        <tr>
            <td valign="middle" style="word-break: break-all; border-color: rgb(221, 221, 221);" align="right" width="20%">章节列表规则</td>
            <td valign="middle" style="word-break: break-all; border-color: rgb(221, 221, 221);" width="80%" align="left">
                <input style="width:100%" name="chapterListPageRule" required="true" id="chapterListPageRule" class="mini-textbox"></td>
        </tr>
        </tbody>
    </table>
    <div style="width: 100%;height: 20px;text-align: center">
        <a class="mini-button" iconCls="icon-save" plain="true" onclick="chapterSave()">保存</a>
        <a class="mini-button" iconCls="icon-undo" plain="true" onclick="miniClose()">返回</a>
    </div>
</div>

<#-- 网站规则
position:fixed;z-index: 99999;bottom: 0px;-->
<div style="width: 100%;height: 20px;text-align: center">
    <a class="mini-button" iconCls="icon-save" plain="true" onclick="save()">保存</a>
    <a class="mini-button" iconCls="icon-undo" plain="true" onclick="closeWindow('back')">返回</a>
</div>
</body>
</html>
<@global.importRequest/>
<script type="text/javascript">
    var storySiteId = "${param!''}";
</script>
<@global.resources 'js/storyRule/storySiteSave.js'/>
