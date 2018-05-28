/* VALIDATOR */
$(function () {
    init_validator_defined();
})
function init_validator_defined () {

    if( typeof (validator) === 'undefined'){ return; }
    console.log('init_validator');

    // initialize the validator function
    validator.message.date = 'not a real date';

    // validate a field on "blur" event, a 'select' on 'change' event & a '.reuired' classed multifield on 'keyup':
    $('form')
        .on('blur', 'input[required], input.optional, select.required', validator.checkField)
        .on('change', 'select.required', validator.checkField)
        .on('keypress', 'input[required][pattern]', validator.keypress);

    $('.multi.required').on('keyup blur', 'input', function() {
        validator.checkField.apply($(this).siblings().last()[0]);
    });

    $('form').submit(function(e) {
        e.preventDefault();
        var submit = true;

        // evaluate the form using generic validaing
        if (!validator.checkAll($(this))) {
            submit = false;
        }

        if (submit)
        {
            resetpassword();
        }
            // this.submit();

        return false;
    });

};


function resetpassword() {

    var old_password=$("#old_password").val();
    var new_password=$("#new_password").val();
    var new_password2=$("#new_password2").val();

    if(new_password!=new_password2)
    {
        alert("两次输入的新密码不相同。");
        return false;
    }

    var data={"password":new_password2,"old_password":old_password};
    ajax("/user/reset_pw",data,succ_fun,true,"post");
}

function succ_fun(result) {
    if(result==undefined)
    {
        alert("修改密码出错。");
    }
    else
    {
        if(result.msgCode==200)
        {
            $("#cancel_form").click();
            alert("修改成功");
        }
        else
        {
            alert("修改出错，原因: "+result.msg);
        }
    }
}