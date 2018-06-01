

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



    //添加产品时回车，要查询当前的sku是否存在
    $("#form_add_product input[name=sku]").bind("keypress", (function (e) {
        if (e.keyCode == 13) {
            if($("#form_add_product input[name=sku]").val()!="")
            {
                var data={"sku":$("#form_add_product input[name=sku]").val()}

                ajax("/user/product/getbysku",data,succ_fun_getbysku_product,true,"post");
            }
            else
            {
                $("#add_product_send").removeAttr("disabled");
                $("#add_product_sku_exist_flag").hide();
            }

        }
    }));




    //入库产品
    $("#form_add_input input[name=sku]").bind("keypress", (function (e) {
        if (e.keyCode == 13) {
            if($("#form_add_input input[name=sku]").val()!="")
            {
                var data={"sku":$("#form_add_input input[name=sku]").val().trim(),"quantity":1}

                ajax("/user/product/input_inventory",data,succ_fun_input_product,true,"post");
            }
            else
            {
                // $("#add_product_send").removeAttr("disabled");
                // $("#add_product_sku_exist_flag").hide();
            }

        }
    }));


    //出库产品
    $("#form_add_output input[name=sku]").bind("keypress", (function (e) {
        if (e.keyCode == 13) {
            if($("#form_add_output input[name=sku]").val()!="")
            {
                var data={"sku":$("#form_add_output input[name=sku]").val().trim(),"quantity":1}

                ajax("/user/product/remove_inventory",data,succ_fun_out_product,true,"post");
            }
            else
            {
                // $("#add_product_send").removeAttr("disabled");
                // $("#add_product_sku_exist_flag").hide();
            }

        }
    }));


    $("#form_add_product input[name=sku]").blur(function () {
        if($("#form_add_product input[name=sku]").val()!="")
        {
            var data={"sku":$("#form_add_product input[name=sku]").val()}

            ajax("/user/product/getbysku",data,succ_fun_getbysku_product,true,"post");
        }
        else
        {
            $("#add_product_send").removeAttr("disabled");
            $("#add_product_sku_exist_flag").hide();
        }
    });

    init_validator_defined ();



    $("#update_product_button").click(function () {
        $("#edit_product_submit").click();
    })
});


function succ_fun_input_product(result)
{
    if(result==undefined)
    {
        alert("处理出错。");
    }
    else
    {
        if(result.msgCode==200)
        {
            if(result.data==null)
            {
                alert("保存异常。");
            }
            else
            {
                $("#form_add_input input[name=sku]").val("");
                setSpanText("#input_show_info",result.data);

                $("#input_show_info span[name=cur_input_number]").html(1);
                $("#search_click").click();
            }
        }
        else
        {
            alert("保存出错，原因: "+result.msg);
        }
    }
}



function succ_fun_getbysku_product(result)
{
    if(result==undefined)
    {
        alert("处理出错。");
    }
    else
    {
        if(result.msgCode==200)
        {
            if(result.data==null)
            {
                $("#add_product_send").removeAttr("disabled");
                $("#add_product_sku_exist_flag").hide();
            }
            else
            {
                $("#add_product_send").attr("disabled",true);
                $("#add_product_sku_exist_flag").show();
            }
            $("#search_click").click();
        }
        else
        {
            alert("保存出错，原因: "+result.msg);
        }
    }
}


function succ_fun_out_product(result)
{
    if(result==undefined)
    {
        alert("处理出错。");
    }
    else
    {
        if(result.msgCode==200)
        {
            if(result.data==null)
            {
                alert("保存异常。");
            }
            else
            {
                $("#form_add_output input[name=sku]").val("");
                setSpanText("#output_show_info",result.data);
                $("#search_click").click();
                $("#output_show_info span[name=cur_input_number]").html(1);
            }
        }
        else
        {
            alert("保存出错，原因: "+result.msg);
        }
    }
}

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

    var title=['SKU','库存','名称','品牌','描述','最后修改人','修改时间','创建时间',''];




    jQuery(grid_selector).jqGrid({
        // postData: {"auctionId":auctionId,"statusList":statusList},
        url: "/user/product/search",
        datatype: "json",
        height: "auto",
        mtype: "post",
        colNames:title,
        colModel:[
            {name:'sku',index:'sku', width:80},
            {name:'inventory',index:'inventory', width:40},
            {name:'name',index:'name', width:60},
            {name:'brand',index:'brand', width:60},

            {name:'description',index:'description', width:100},
            {name:'lastpersion',index:'lastpersion', width:60},




            {name:'dateModified',index:'dateModified', width:80,resize:false,sortable: true,formatter: function (cellvalue, options, row){
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



            {name:'dateCreated',index:'dateCreated', width:80,resize:false,sortable: true,formatter: function (cellvalue, options, row){
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



            {name:'id',index:'id', width:40,resize:false,sortable: true,formatter: function (cellvalue, options, row){
                   var str='<button type="button" class="btn btn-success btn-xs" onclick="edit_product('+row.id+')">编辑</button>';
                   return str;
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

        multiselect: true,
        //multikey: "ctrlKey",
        multiboxonly: true,
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
            del: true,
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
                  alert("请选择要删除的数据。");
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

        alert("请选择要删除的数据。");
        return false;
    }
    var num=ids.length;



    if (confirm("确认删除？")==true){
            var data={"ids[]":ids};
            ajax("/user/product/delete",data,succ_fun_delete,true,"post");
    }else{

    }

    // confirm("你确认要删除选择的"+num+"数据吗？", function (confirmed) {
    //
    //     var data={"ids[]":ids};
    //     ajax("/user/product/delete",data,succ_fun_delete,true,"post");
    // });
}


//删除数据返回处理
function succ_fun_delete(result) {
    if(result==undefined)
    {
        alert("处理出错。");
    }
    else
    {
        if(result.msgCode==200)
        {
            $("#search_click").click();
            alert("删除成功");
        }
        else
        {
            alert("删除出错，原因: "+result.msg);
        }
    }
}



//提交js对象参数刷新列表数据
function refreshDataGrid(data) {
    $(grid_selector).jqGrid("setGridParam", { postData: data }).trigger("reloadGrid");
}



function init_validator_defined () {

    if( typeof (validator) === 'undefined'){ return; }
    console.log('init_validator');

    // initialize the validator function
    validator.message.date = 'not a real date';

    // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
    // $('form')
    //     .on('blur', 'input[required], input.optional, select.required', validator.checkField)
    //     .on('change', 'select.required', validator.checkField)
    //     .on('keypress', 'input[required][pattern]', validator.keypress);

    $('.multi.required').on('keyup blur', 'input', function() {
        validator.checkField.apply($(this).siblings().last()[0]);
    });

    $("#form_add_product").submit(function(e) {
        e.preventDefault();
        var submit = true;

        // evaluate the form using generic validaing
        if (!validator.checkAll($(this))) {
            submit = false;
        }

        if (submit)
        {
            var hasFocus = $("#form_add_product input[name=sku]").is(':focus');
            if(hasFocus==true)//如果焦点在sku输入框，不能提交
            {
                return false;
            }

            add_product();
        }
        // this.submit();

        return false;
    });





    $("#form_update_product").submit(function(e) {
        e.preventDefault();
        var submit = true;

        // evaluate the form using generic validaing
        if (!validator.checkAll($(this))) {
            submit = false;
        }

        if (submit)
        {


            update_product();
        }
        // this.submit();

        return false;
    });

};


function add_product() {
    var data=getEelementData("#form_add_product");
    if(isNaN(parseFloat(data.inventory))||parseFloat(data.inventory<0))
    {
        alert("库存不能小于0.");
        return false;
    }
    ajax_class("/user/product/add",data,succ_fun_add_product,true,"post");

}



function update_product() {
    var data=getEelementData("#form_update_product");
    if(isNaN(parseFloat(data.inventory))||parseFloat(data.inventory<0))
    {
        alert("库存不能小于0.");
        return false;
    }
    ajax_class("/user/product/update",data,succ_fun_update_product,true,"post");

}



function succ_fun_add_product(result) {
    if(result==undefined)
    {
        alert("处理出错。");
    }
    else
    {
        if(result.msgCode==200)
        {
            $("#search_click").click();
            alert("保存成功");
        }
        else
        {
            alert("保存出错，原因: "+result.msg);
        }
    }
}




function succ_fun_update_product(result) {
    if(result==undefined)
    {
        alert("处理出错。");
    }
    else
    {
        if(result.msgCode==200)
        {
            $("#search_click").click();
            $("#close_update").click();
          //  alert("更新成功");
        }
        else
        {
            alert("更新出错，原因: "+result.msg);
        }
    }
}



function edit_product(id)
{
    var obj=null;
    if(grid_jsonData!=null)
    {
        for(var i=0;i<grid_jsonData.length;i++)
        {
            if(grid_jsonData[i].id==id)
            {
                obj=grid_jsonData[i];
                break;
            }
        }
    }

    if(obj!=null)
    {
        setInputData("#form_update_product",obj);
        $("#show_product_detail").click();
    }
}