function ajax(url,data,succ_fun,async,type) {
    if (async==""||async==undefined) {
        async = true;
    }
    if (type=="get"||type=="GET") {
        type = "get";
    }
    else
    {
        type = "post";
    }
    $.ajax({
        url: url,
        data: data,
        dataType: "json",
        type: type,
        async: async,
        success: function (result) {
            succ_fun(result);
        },
        error: function (r) {
            window.location.href="/login.html"
            //alert("请求失败，请刷新重试");
        }
    });
}


function ajax_class(url,data,succ_fun,async,type) {
    if (async==""||async==undefined) {
        async = true;
    }
    if (type=="get"||type=="GET") {
        type = "get";
    }
    else
    {
        type = "post";
    }

    if(data!=""&&data!=undefined)
    {
        data=JSON.stringify(data);
    }

    $.ajax({
        url: url,
        data: data,
        dataType: "json",
        contentType: "application/json",
        type: type,
        async: async,
        success: function (result) {
            succ_fun(result);
        },
        error: function (r) {
            window.location.href="/login.html"
            //alert("请求失败，请刷新重试");
        }
    });
}

var websit_domain_url="http://47.89.247.164:8080"
//对某个标签内的input进行赋值
function setInputData(selector, obj) {
    var propertyNames = getObjectPropNameArr(obj);
    $(selector + " select," + selector + " input," + selector + " textarea").each(function (j) {
        for (var i = 0; i < propertyNames.length; i++) {
            var name = $(this).attr("name");
            try {
                if (name != undefined && name == propertyNames[i]) {
                    $(this).val(obj[propertyNames[i]]);
                    break;
                }
            } catch (e) {
                console.log(e);
            }
        }
    });
}

//对某个标签内的input进行赋值
function setSpanText(selector, obj) {
    var propertyNames = getObjectPropNameArr(obj);
    $(selector + " span").each(function (j) {
        for (var i = 0; i < propertyNames.length; i++) {
            try {
                if ($(this).attr("name") == propertyNames[i]) {
                    $(this).html(obj[propertyNames[i]]);
                    break;
                }
            } catch (e) {
                console.log(e);
            }
        }
    });
}

//对某个标签内的img的src进行赋值
function setImgSrc(selector, obj) {
    var propertyNames = getObjectPropNameArr(obj);
    $(selector + " img").each(function (j) {
        for (var i = 0; i < propertyNames.length; i++) {
            if ($(this).attr("name") == propertyNames[i]) {
                //$(this).html(obj[propertyNames[i]]);
                $(this).attr("src", obj[propertyNames[i]]);
                break;
            }
        }
    });
}


//禁能标签内所有的input select textarea
function setinputDisabled(selector,flag) {
    if(removenull(flag)=="")
    {
        flag=true;
    }
    var obj = {};
    $(selector + " select," + selector + " input," + selector + " textarea").each(function (j) {
        if(flag==false)
        {
            $(this).removeAttr("disabled");
        }
        else
        {
            $(this).attr("disabled",true);
        }

    });
    // return obj;
}

//获取某个标签内的input select的值返回对象
function getEelementData(selector) {
    var obj = {};
    $(selector + " select," + selector + " input," + selector + " textarea").each(function (j) {
        obj[$(this).attr("name")] = $.trim($(this).val());
    });
    return obj;
}



//获取jqgrid选中行的数据
function getGridSelectData(selector) {
    var rowid = $(selector).jqGrid('getGridParam', 'selrow');
    var rowData = $(selector).getRowData(rowid);
    return rowData;
}

//隐藏checkbox
function hideJgridCheckbox(yundangrid_selector, ids) {
    for (var i = 0; i < ids.length; i++) {
        var id = ids[i];
        $(yundangrid_selector).find("[id=" + id + "]").find("[role=checkbox]").hide().attr("disabled", true);
    }
}


//返回js对象的属性名称
function getObjectPropNameArr(o) {
    var tmpArr = [];
    for (var item in o) {
        tmpArr.push(item);
    }
    return tmpArr;
}

function clearInputData(selector) {
    if (selector == undefined) { selector = "body"; }
    $(selector + " select," + selector + " input," + selector + " textarea").each(function (j) {
        $(this).val("");
    });
}

//去掉空字符
function removenull(str) {

    if ((str === "") || (str === null) || (str === undefined)|| (str == "null") || (str == "undefined")) {

        return "";
    }

    else {
        return str;
    }
}

function request_arg(strParame) {
    var args = new Object();
    var query = location.search.substring(1);

    var pairs = query.split("&"); // Break at ampersand
    for (var i = 0; i < pairs.length; i++) {
        var pos = pairs[i].indexOf('=');
        if (pos == -1) continue;
        var argname = pairs[i].substring(0, pos);
        var value = pairs[i].substring(pos + 1);
        value = decodeURIComponent(value);
        args[argname] = value;
    }
    return args[strParame];
}