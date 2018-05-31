function login() {
    var username=$("#username").val();
    var password=$("#password").val();
    if(username==""||username==undefined||username.trim()=="")
    {
        alert("请输入用户名!");
        return false;
    }
    if(password==""||password==undefined||password.trim()=="")
    {
        alert("请输入密码!");
        return false;
    }

    var data={"password":password,"username":username};
    ajax("/user/login",data,succ_fun,true,"post");
}

function succ_fun(result) {
    if(result==undefined)
    {
        alert("登陆出错。");
    }
    else
    {
        if(result.msgCode==200)
        {
            window.location.href="/member/yuku.html";
        }
        else
        {
            alert("登陆出错，原因: "+result.msg);
        }
    }
}