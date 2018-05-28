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
