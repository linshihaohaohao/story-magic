/**
 * Created by zhouhao on 16-5-6.
 */
mini.parse();
uParse('#data-form', {
    rootPath: Request.BASH_PATH+'ui/plugins/ueditor',
    chartContainerHeight: 500
});
var pageData={};
var tableDate=[];
var grid = mini.get("m_option_table");
var contentWindow = mini.get("content-form");
var chapterWindow = new mini.get("chapter-form");
loadData();
function loadData() {
    if (storySiteId != "") {
        Request.get("api/site/story/" + storySiteId, {}, function (e) {
            if (e.success) {
                pageData = e.data;
                grid.setData(e.data.storyRulePos);
                tableDate = e.data.storyRulePos;
                new mini.Form('#data-form').setData(e.data);
            }
        });
    }
}

function addNode() {
    mini.get('m_option_table').addNode({});
}


function renderAction(e){
    // console.log(e);
    var row = e.record;
    var html = "";
    // if(row.type == "content"){
    //     html += createIdActionButton("editId","编辑内容", "edit('" + row._id + "')", "icon-edit");
    // }else if(row.type == "chapter"){
    //     html += createIdActionButton("editId","编辑章节", "edit('" + row._id + "')", "icon-edit");
    // }else {
    // }
   html += createIdActionButton("removeId","删除", "removeNode('" + row._id + "')", "icon-remove");
    return html;
}


function rendererForContent(e) {
    var row = e.record;
    if(row.type == "content") {
        return returnEditInfo(e,"content");
    }
}

function rendererForChapter(e) {
    var row = e.record;
    if(row.type == "chapter") {
        return returnEditInfo(e,"chapter");
    }
}

function returnEditInfo(e,type) {
    var row = e.record;
    var contentName = "";
    if(null != row.storyContentRulePo){
        contentName = row.storyContentRulePo.name;
    }
    var chapterName = "";
    if(null != row.storyChapterRulePo){
        chapterName = row.storyChapterRulePo.name;
    }
    if(type == "content") {
        return '<span  class="action-span"  onclick="openContentWindow(' + row._id + ')">'
            + '<span class="action-icon icon-edit" ></span>'
            +'<a id="contentName_'+ row._id +'" style="font-size: 10px">'+ contentName +'</a>'
            +'</span>';
    }else if(type == "chapter"){
        return '<span  class="action-span"  onclick="openChapterWindow(' + row._id + ')">'
            + '<span class="action-icon icon-edit" ></span>'
            +'<a id="chapterName_'+ row._id +'" style="font-size: 10px">'+ chapterName +'</a>'
            +'</span>';
    }

}



function removeNode(id){
    var nodes = grid.findNodes(function(node){
        if(node._id==id) return true;
    });
    var m_option = mini.get("m_option_table").getData();
    var story = m_option[id-1];
    if( undefined != story && undefined != story.id && null != story.id){
        removeStoryRule(story.id);
    }
    grid.removeNodes(nodes);
    showTips("删除成功");
}
function removeStoryRule(id) {
    var box = mini.loading("提交中...", "");
    Request.delete("api/site/storyRule/"+id, null, function (e) {
        mini.hideMessageBox(box);
        if (e.success) {
            showTips("删除成功");
        } else {
            mini.alert(e.message);
        }
    });
}
function save() {
    var form = new mini.Form("#data-form");
    form.validate();
    if (!form.isValid())return;
    var m_option = grid.getData();
        if(m_option.length < 1){
            mini.alert("请至少增加一条规则");
            return;
        }

        //如果使用原有miniui的对象会自带_id等表格行列属性，如不删除会导致上传至controller层时替换id的至导致server无法获取id时重复保存。
    var pushRoles = [];
    var errorFlag = false;
    console.log(m_option);
    $(m_option).each(function (i, e) {
            if( (null == e.storyChapterRulePo && e.type == "chapter" )
                || (null == e.storyContentRulePo && e.type == "content")){
                mini.alert(e.name+" 的类型为 "+e.type +", 请点击按钮添加相应的内容!");
                errorFlag = true;
            }else {
                errorFlag = false;
            }

        var data = deepCopy(e);
        delete  data._id;
        pushRoles.push(data);
    });

    if(errorFlag){
        return;
    }

    var data = getSourceData(pageData,form.getData());
    data.storyRulePos = pushRoles;
    var func = Request.post;
    var box = mini.loading("提交中...", "");
    func("api/site/story/save", data, function (e) {
        mini.hideMessageBox(box);
        pageData = data;
        if (e.success) {
            showTips("保存成功！页面即将刷新");
            setTimeout(function () {
                window.location.reload();
            },1200);

        } else {
            mini.alert(e.message);
        }
    });
}
function getSourceData(sourceData,newData) {
    var returnData;
    if(undefined != sourceData && null != sourceData && undefined != sourceData.name){
        for(var source in sourceData){
            for(var name in newData){
                if(name == source){
                    sourceData[source] = newData[name];
                }
            }
        }
        returnData = sourceData;
    }else {
        returnData = newData
    }
    return returnData;
}
var deepCopy= function(source) {
    var result={};
    for (var key in source) {
        result[key] = typeof source[key]==='String'? deepCopy(source[key]): source[key];
    }
    return result;
}
function createIdActionButton(id,text, action, icon) {
    return '<span id="'+ id +'" class="action-span" title="' + text + '" onclick="' + action + '">' +
        '<span class="action-icon ' + icon + '"></span>' + "" //text
        + '</span>';
}


//mini窗口操作
//content

function openContentWindow(id) {
    contentWindow.contentClowId = id;
    var form = new mini.Form("#content-form");
    var m_option = grid.getData();
    var story = m_option[id-1];
    if(null != story.storyContentRulePo){
        form.setData(story.storyContentRulePo);
    }

    $("#content-form").css({
        "border-width": "0px",
    "width": "684px",
        "margin-top": "20px",
            "padding": "0px",
        "z-index": "1006",
            "position": "absolute",
        "left": "135px",
            "top": "174px",
        "height": "172px",
    })
    contentWindow.show();
}

function contentSave() {
    var form = new mini.Form("#content-form");
    form.validate();
    if (!form.isValid())return;
    editContent(contentWindow.contentClowId,form.getData());
}

function editContent(id,data){
    var m_option = grid.getData();
    var story = m_option[id-1];
    var content = story.storyContentRulePo;
            var retunData = null;
            if(null != content){
                retunData = getSourceData(content,data);
            }else {
                retunData =  data;
            }
            story.storyContentRulePo = retunData;
            $("#contentName_"+id).html(retunData.name);
            contentWindow.hide();
    delete contentWindow.contentClowId;
}

//chapter

function openChapterWindow(id) {
    chapterWindow.chapterClowId = id;
    var form = new mini.Form("#chapter-form");
    var m_option = grid.getData();
    var story = m_option[id-1];
    if(null != story.storyChapterRulePo){
        form.setData(story.storyChapterRulePo);
    }
    $("#chapter-form").css({
        "border-width": "0px",
        "width": "684px",
        "margin-top": "20px",
        "padding": "0px",
        "z-index": "1006",
        "position": "absolute",
        "left": "135px",
        "top": "174px",
        "height": "172px",
    })
    chapterWindow.show();
}

function chapterSave() {
    var form = new mini.Form("#chapter-form");
    form.validate();
    if (!form.isValid())return;
    editChapter(chapterWindow.chapterClowId,form.getData());
}

function editChapter(id,data){
    var m_option = grid.getData();
    var story = m_option[id-1];
    var chapter = story.storyChapterRulePo;
    var retunData = null;
    if(null != chapter){
        retunData = getSourceData(chapter,data);
    }else {
        retunData =  data;
    }
    story.storyChapterRulePo = retunData;
    $("#chapterName_"+id).html(retunData.name);

    chapterWindow.hide();
    delete chapterWindow.chapterClowId;
}

function miniClose() {
    delete  contentWindow.contentClowId;
    contentWindow.hide();
    delete  chapterWindow.chapterClowId;
    chapterWindow.hide();
}