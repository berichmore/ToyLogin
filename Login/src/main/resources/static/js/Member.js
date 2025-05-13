$(document).ready(function (){
    $('#loginForm').on('submit', function (e){
        e.preventDefault(); //기본 폰 제출 막기
        loginUser();

    });
    $('#joinForm').on('submit', function (e){
        e.preventDefault();
        joinUser();
    })
})


//로그인 페이지
function loginUser(){
    const data = {
        userId: $('#userId').val(),
        userPassword: $('#userPassword').val()
    };


}


//회원가입
function joinUser(){
    const data = {
        userId: $('#joinUserId').val(),
        userPassword: $('#joinUserPassword').val(),
        userName: $('#joinUserName').val(),
        userEmail: $('#joinUserEmail').val()
    };

    $.ajax({
        url: `/api/member/join`,
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (response){
            alert('회원가입 성공: ' + response.userName);
            window.location.href = '/';
        },
        error: function (xhr){
            alert('회원가입 실패 : ' + xhr.responseText);
        }
    })
}