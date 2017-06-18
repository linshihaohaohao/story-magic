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


function renderAction(e){
    return createActionButton("删除","removeNode("+e.record._id+")","icon-remove");
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
    $(m_option).each(function (i, e) {
        var data = deepCopy(e);
        delete  data._id;
        pushRoles.push(data);
    });

    var data = getSourceData(pageData,form.getData());
    data.storyRulePos = pushRoles;
    var func = Request.post;
    var box = mini.loading("提交中...", "");


    func("api/site/story/save", data, function (e) {
        mini.hideMessageBox(box);
        pageData = data;
        if (e.success) {
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
        // if(undefined != sourceData._id){
        //     delete  sourceData._id;
        // }
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
