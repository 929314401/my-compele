window.onload=function () {
    var st = window.location.search;
    var queryString = st.substring(st.indexOf("?") + 1);
    var ss = queryString.split("=");
    var token = ss[1];
    $("#token").val(token);
    liststudio($("#page").val(),$("#rows").val(),token);

}

function liststudio(page,rows,token) {
    $.ajax({
        url: "/company/listStudio?token="+token,
        type: "post",
        dataType:"json",
        data:{
            "page" : page,
            "rows" : rows,
        },
        success:function(result){
            var json = eval(result.items);
            $("#lists").empty();

            $.each(json,function (index, item) {
                var star= json[index].star;
                var id = json[index].apply.id;
                var studioname = json[index].apply.studioname;

                var date = new Date(parseInt(json[index].apply.applytime, 10));

                var applytime = getDateTime(date);
                var complete = json[index].apply.complete;
                $("#lists").html(
                    $("#lists").html()+
                    "<tr>" +
                    "<td>" + studioname + "</td>"+
                    "<td>" +applytime+"</td>"+
                    "<td>"+star+"</td>"+
                    "<td>"+complete+"</td>" +

                    "</tr>"
                )
            })
            var totalPage = result.totalPage;

            $("#page").empty();
            $("#sum").empty();
            $("#sum").val(totalPage);
            $("#page").val(result.currentPage);
        }

    })
}



function nextpjPage() {
    if($("#page").val()*1+1>$("#sum").val()){
        alert("当前为最后一页");
    }else {
        liststudio($("#page").val()*1+1,$("#rows").val(),$("#token").val());
    }
}
function beforepjPage() {
    if($("#page").val()==1){
        alert("当前为第一页")
    }else{
        liststudio($("#page").val()-1,$("#rows").val(),$("#token").val());

    }

}
//获取日期格式
function getDate(date) {

    var year = date.getFullYear();

    var month = date.getMonth() + 1;

    var day = date.getDate();

    return year + "-" + month + "-" + day ;
}
//获取日期时间格式
function getDateTime(date) {

    var year = date.getFullYear();

    var month = date.getMonth() + 1;

    var day = date.getDate();

    var hh = date.getHours();

    var mm = date.getMinutes();

    var ss = date.getSeconds();

    return year + "-" + month + "-" + day + " " + hh + ":" + mm + ":" + ss;
}

