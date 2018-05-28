$(function () {
    ajax("/user/self",{},succ_fun_self,true,"post");
});
function succ_fun_self(result) {
    if(result==undefined)
    {
        alert("获取用户信息出错。");
    }
    else
    {
        if(result.msgCode==200)
        {
            if(result.data!=null)
            {
                $("[name=login_userName]").each(function () {
                    $(this).html(result.data.userName);
                })
            }
        }
        else if(result.msgCode==607)
        {
            window.location.href="/login.html";
        }
        else
        {
            alert("读取个人信息出错，原因: "+result.msg);
        }
    }
}