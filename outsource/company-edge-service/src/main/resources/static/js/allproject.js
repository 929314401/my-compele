window.onload=function () {
    var st = window.location.search;
    var queryString = st.substring(st.indexOf("?") + 1);
    var ss = queryString.split("=");
    var token = ss[1];
    //alert(token)
    $("#token").val(token);
    listproject($("#page").val(),$("#rows").val(),token);

}




function listproject(page,rows,token) {
    $.ajax({
        url: "/company/listproject?token="+token,
        type: "post",
        dataType:"json",
        data:{
            "page" : page,
            "rows" : rows,
        },
        success:function(result){
            var json = eval(result.items);
            $("#lists").empty();
            $.each(json, function (index, item) {
                //循环获取数据
                var id=json[index].id;
                var bid = json[index].bid;
                if(bid==0||bid==null)
                    bid="<a href='/company/liststudio/"+id+"?token="+token+"'>正在竞标</a>";
                   // bid="正在竞标";
                    //href=
                else if(bid==1)
                    bid="已选工作室";
                else if(bid==2)
                    bid="工作室已交付";
                else
                    bid="公司未支付";
                var message = json[index].message;
                var startTime;
                if(json[index].starttime==null){
                    startTime="未设置";
                }else{
                    var date = new Date(parseInt(json[index].starttime, 10));
                    startTime=getDateTime(date);
                }
                var stopTime;
                if(json[index].stoptime==null){
                    stopTime="未设置";
                }else{
                    var date = new Date(parseInt(json[index].stoptime, 10));
                    stopTime=getDateTime(date);
                }
                var money = json[index].money;
                var studioid=json[index].studioid;
                $("#lists").html($("#lists").html() +
                    "<tr>" +
                    "<td>" + message + "</td>"+
                    "<td>" +startTime+"</td>"+
                    "<td>"+stopTime+"</td>"+
                    "<td>"+money+"</td>" +
                    "<td>"+bid+"</td>"+
                    "<td>"+studioid+"</td>"+
                    "</tr>"

                    /*"<td><a href='javascript:void(0)' onclick='subgo("+id+")'/>选他</td></tr>"*/
                ); //+ " - " + idnumber + " - " + sex + "<br/>")
            })
            //$("#page").empty();
            $("#page").empty();
            $("#sum").empty();
            $("#page").val(result.currentPage);
            $("#sum").val(result.totalPage);

        }
    })
}

function nextpjPage() {
    if($("#page").val()*1+1>$("#sum").val()){
        alert("当前为最后一页");
    }else {
        listproject($("#page").val()*1+1,$("#rows").val(),$("#token").val());
    }
}
function beforepjPage() {
   if($("#page").val()==1){
       alert("当前为第一页")
   }else{
       listproject($("#page").val()-1,$("#rows").val(),$("#token").val());

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