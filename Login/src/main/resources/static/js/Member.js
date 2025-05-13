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

//로그아웃
function logoutUser(){
    $.ajax({
        url: '/api/member/logout',
        type: 'POST',
        success: function(){
            alert("로그아웃이 완료되었습니다.");
            window.location.href = "/login";
        },
        error: function (){
            alert("로그아웃이 실패하였습니다.");
        }
    })
}


//로그인 페이지
function loginUser(){
    const data = {
        userId: $('#userId').val(),
        userPassword: $('#userPassword').val()
    };

    $.ajax({
        url: '/api/member/login',
        type: 'post',
        contentType: 'application/json',
        data: JSON.stringify(data),
        success: function (response){
            alert('로그인이 완료되었습니다' + response.userName);
            window.location.href = '/';
        },
        error: function (xhr){
            alert('로그인 실패 : '  + xhr.responseText);
        }
    })


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
