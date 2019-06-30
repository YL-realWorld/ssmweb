$(function() {
    $("#btn-login").click(function() {
        var login_name = $('#login_name').val();
        var login_pass = $('#login_pass').val();
        if (login_name == 'null' || login_name == '' || login_pass == 'null' || login_pass == '') {
            alert("please input login name or password");
            return false;
        }
        login_pass = hex_md5(login_pass);
        login_name = hex_md5(login_name);
        $.ajax({
            url: '/home/login.php',
            type: 'POST',
            data: {'uname':login_name, 'upass':login_pass},
            success: function(data){
                if(data.code == 200){
                    window.location.href = '/home/user.php';
                }
            }
        });
    });
})
