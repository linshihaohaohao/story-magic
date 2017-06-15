/**
 * Created by zhouhao on 16-5-6.
 */
mini.parse();
uParse('#data-form', {
    rootPath: Request.BASH_PATH+'ui/plugins/ueditor',
    chartContainerHeight: 500
});
var pageData={};
var grid = mini.get("m_option_table");
loadData();
function loadData() {
    if (storySiteId != "") {
        Request.get("api/site/story/" + storySiteId, {}, function (e) {
            if (e.success) {
                pageData = e.data;
                grid.setData(e.data.storyRulePos);
                new mini.Form('#data-form').setData(e.data);
            }
        });
    }
}


function removeNode(id){
    var nodes = grid.findNodes(function(node){
        if(node._id==id) return true;
    });
    grid.removeNodes(nodes);
}
function renderAction(e){
    return createActionButton("删除","removeNode("+e.record._id+")","icon-remove");
}


function ondrop(e) {
    var dragNode = e.dragNode;
    var dropNode = e.dropNode;
    var dragAction = e.dragAction;
    var index = dragNode.sortIndex;
    var pNode;
    if ("before" == dragAction || "after" == dragAction) {
        dropNode.sortIndex = dragNode.sortIndex;
        pNode = tree.getParentNode(dragNode);
    }
    if ("add" == dragAction) {
        pNode = dropNode;
    }
    reSortModule(pNode);
    tree.selectNode(dragNode);
}


function save() {
    var form = new mini.Form("#data-form");
    form.validate();
    if (!form.isValid())return;
    var m_option = mini.get("m_option_table").getData();
    // if (!m_option.isValid())return;
    var storyRulePos = [];
    // if(undefined != storySiteId && null != storySiteId){
        $(m_option).each(function (i, e) {
            delete e._id;
            delete e._level;
            delete e._pid;
            delete e._uid;
            storyRulePos.push(e);
        });

        if(storyRulePos.length < 1){
            mini.alert("请至少增加一条规则");
            return;
        }
    var data = getSourceData(pageData,form.getData());
    data.storyRulePos = storyRulePos;
    var func = Request.post;
    var box = mini.loading("提交中...", "");
    func("api/site/story/save", data, function (e) {
        mini.hideMessageBox(box);
        if (e.success) {
            // if (undefined == storySiteId || null == storySiteId || "" == storySiteId)storySiteId = e.data;
            pageData = {};
            showTips("保存成功");
            setTimeout(function () {
                if(storySiteId == "")closeWindow('back');
            },800);
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
