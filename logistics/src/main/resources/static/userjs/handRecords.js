

var grid_selector="#grid-table_1";
var pager_selector="#grid-pager_1";
var grid_content="#jqgrid_content";
var grid_jsonData = [];
var reload_jsondata={};




$(function () {
    init_table_grid();
    $("#search_keyword").bind("keypress", (function (e) {
        if (e.keyCode == 13) {
            $("#search_click").click();
        }
    }));

    $("#search_click").click(function () {
        var keyword=$("#search_keyword").val();
        if(removenull(keyword)!="")
        {
            keyword=keyword.trim();

        }
        var data={"keyword":keyword};
        refreshDataGrid(data);
    });
    
    
})


function init_table_grid()
{
    

    var init = false;
    var test=$(".col-xs-12").width();
    $(window).resize(function () {
        var width=$(grid_content).width() - 10;
        if(width<500)
        {
            width=500;
            $(grid_content).attr("style","overflow:scroll")
        }
        else
        {
            $(grid_content).attr("style","")
        }

        $(grid_selector).setGridWidth(width);

    });
    var width=$(grid_content).width() - 10;
    if(width<500)
    {
        width=500;
        $(grid_content).attr("style","overflow:scroll")
    }
    else
    {
        $(grid_content).attr("style","")
    }

    // var auctionId=$("#auction_id").val();
    // var statusList=new Array();
    // statusList.push(0);
    // statusList.push(null);
    // var local_status=0;

    var title=['用户名','类型','描述','时间'];




    jQuery(grid_selector).jqGrid({
        // postData: {"auctionId":auctionId,"statusList":statusList},
        url: "/user/handle_records/search",
        datatype: "json",
        height: "auto",
        mtype: "post",
        colNames:title,
        colModel:[
            {name:'userName',index:'userName', width:80},
            {name:'type',index:'type', width:80,
                formatter: function (cellvalue, options, row) {





                    var temp="";
                    if(cellvalue==0)
                    {
                        temp="添加商品";
                    }
                    else if(cellvalue==1)
                    {
                        temp="商品入库";
                    }
                    else if(cellvalue==2)
                    {
                        temp="商品出库";
                    }
                    else if(cellvalue==3)
                    {
                        temp="修改商品信息";
                    }
                    else if(cellvalue==4)
                    {
                        temp="修改会员信息";
                    }
                    else if(cellvalue==5)
                    {
                        temp="修改用户密码";
                    }
                    else if(cellvalue==6)
                    {
                        temp="删除商品";
                    }
                    return temp;
                }},

            {
                name: 'description', index: 'description', width: 120 },





            {name:'dateCreated',index:'dateCreated', width:80,resize:false,sortable: false,formatter: function (cellvalue, options, row){
                if(removenull(cellvalue)!="")
                {
                    var date=new Date(cellvalue);
                    return date.getFullYear()+'-'+(date.getMonth()+1)+'-'+date.getDate()+" "+date.getHours()+":"+date.getMinutes()+":"+date.getSeconds();


                }
                else
                {
                    return "";
                }
            }},




        ],
        jsonReader: {
            root: "data.data",
            page: "data.curpage",
            total: "data.totalpage",
            // records: "data.pageSize"
            records: "data.totalnum"
        },

        viewrecords : true,
        rowNum:10,
        rowList:[10,20,30],
        pager : pager_selector,
        altRows: true,
        //toppager: true,

        multiselect: false,
        //multikey: "ctrlKey",
        multiboxonly: false,
        // serializeGridData: function(postData) {
        //     return JSON.stringify(postData);
        // },
        sortname:'dateCreated',
        sortorder:'desc',
        loadComplete : function(json) {

            $("#sendselectedinvoice").attr("disabled",true);
            $("#dispute_selected").attr("disabled",true);
            $("#print_selected").attr("disabled",true);
            reload_jsondata=json;
            //$("#myauction_error_content_1").attr("style","display:none");

            var table = this;
            setTimeout(function () {
                updatePagerIcons(table);
            }, 0);
            //防止出现水平滚动条
            if (init == false) {
                $(".ui-jqgrid-bdiv").css({ 'overflow-x': 'hidden' });
                $(".ui-jqgrid-htable th:last").css({ "width": $(".ui-jqgrid-htable th:last").width() - 2 });
                $(".jqgfirstrow td:last").css({ "width": $(".jqgfirstrow td:last").width() - 2 });
                init = true;
            }
            //隐藏不可删除和编辑的复选框
            var hiddenIds = [];
            if (json.msgCode == "200") {
                if ((removenull(json) != "") && removenull(json.data) != ""&& removenull(json.data.data) != "") {
                    grid_jsonData = json.data.data;

                }
            }

            else {
                // alert("Error：" + json.msg);
                //  bootbox.alert("Error：" + json.msg);


                //$("#myauction_error_content_1").attr("style","");
                //$("#myauction_error_content_1 p").html("Error：" + json.msg);
            }
        },

        gridComplete: function () {
            //隐藏 city=已揽收的 复选框

        },
        onSelectRow: function (rowid, status) {
            //设置没复选框的行不给选中
            // if (status == true) {
            //     var display = $(grid_selector).find("[id=" + rowid + "]").find("[role=checkbox]:hidden");
            //     if (display.length > 0) { $(grid_selector).setSelection(rowid, false); }
            // }
            var rowIds = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');
            if(removenull(rowIds)===""||rowIds.length<=0)
            {
                $("#sendselectedinvoice").attr("disabled",true);
                $("#dispute_selected").attr("disabled",true);
                $("#print_selected").attr("disabled",true);
            }
            else
            {
                $("#sendselectedinvoice").removeAttr("disabled");
                $("#dispute_selected").removeAttr("disabled");
                $("#print_selected").removeAttr("disabled");
            }

        },
        onSelectAll:function(rowids,statue){
            // alert(rowids);
            var rowIds = jQuery(grid_selector).jqGrid('getGridParam', 'selarrrow');
            if(removenull(rowIds)===""||rowIds.length<=0)
            {
                $("#sendselectedinvoice").attr("disabled",true);
                $("#dispute_selected").attr("disabled",true);
                $("#print_selected").attr("disabled",true);
            }
            else
            {
                $("#sendselectedinvoice").removeAttr("disabled");
                $("#dispute_selected").removeAttr("disabled");
                $("#print_selected").removeAttr("disabled");
            }

        },
        onCheckAllRow:function (rowid, status) {
            var rows=rowid;
        },
        autowidth: true

    });





//navButtons
    jQuery(grid_selector).jqGrid('navGrid',pager_selector,
        { 	//navbar options
            edit: false,
            editicon : 'icon-pencil blue',
            add: false,
            addicon : 'icon-plus-sign purple',
            del: false,
            delicon : 'icon-trash red',
            search: false,
            searchicon : 'icon-search orange',
            refresh: true,
            refreshicon : 'icon-refresh green',
            refreshstate: "current",
            view: false,
            viewicon : 'icon-zoom-in grey',
            delfunc: function () {
                var ids = $(grid_selector).jqGrid('getGridParam', 'selarrrow');
                //alert(ids);

                if ((removenull(ids) === "") || (ids.length < 1)) {
                    // alert("please choose the items!");
                    // bootbox.alert("please choose the items!");
                    var message=get_alert_message("jqgrid_chooseitems",lan_flag_hearder);
                    bootbox.alert(message);
                    return false;
                }



                delete_rows(ids);

            }
        }
    );



    //replace icons with FontAwesome icons like above
    function updatePagerIcons(table) {
        var replacement =
            {
                'ui-icon-seek-first': 'icon-double-angle-left bigger-140',
                'ui-icon-seek-prev': 'icon-angle-left bigger-140',
                'ui-icon-seek-next': 'icon-angle-right bigger-140',
                'ui-icon-seek-end': 'icon-double-angle-right bigger-140'
            };
        $('.ui-pg-table:not(.navtable) > tbody > tr > .ui-pg-button > .ui-icon').each(function () {
            var icon = $(this);
            var $class = $.trim(icon.attr('class').replace('ui-icon', ''));

            if ($class in replacement) icon.attr('class', 'ui-icon ' + replacement[$class]);
        });
    }




}




function delete_rows(ids)
{
    if(removenull(ids)===""||ids.length<1)
    {

        var message=get_alert_message("jqgrid_deleteitems",lan_flag_hearder);
        bootbox.alert(message);
        //bootbox.alert("Please select the item you want to delete!");
        return false;
    }
    var message=get_alert_message("jqgrid_deleteconfirm",lan_flag_hearder);
    bootbox.confirm(message, function (confirmed) {


        if (confirmed == true) {

            $("#loading").show();
            $.ajax({
                type: "post",
                url: "/biz/house/creditCard/delete",
                // contentType: "application/json",
                dataType: "json",
                // data:data2,
                data: {
                    "ids": ids
                },
                success: function (response) {
                    $("#loading").hide();


                    var code = response.msgCode;
                    if ("200" == code) {
                        //alert("Delete Successfully!");
                        // bootbox.alert("Delete Successfully!");

                        $("#btnAdvanceSearch1").click();
                    }
                    else {
                        // alert("Error：" + response.msg);
                        bootbox.alert("Error：" + response.msg);
                    }
                },
                error:function(error){

                    house_redirct(error);

                }
            });
        } else {

        }
    });
}




//提交js对象参数刷新列表数据
function refreshDataGrid(data) {
    $(grid_selector).jqGrid("setGridParam", { postData: data }).trigger("reloadGrid");
}