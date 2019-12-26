$("#search").click(function(){
    console.log("clicked");
    $.get("/customer/all",function(res,status){
        console.log("Data: " + res + "\nStatus: " + status);
        $('#tbody').html("");
        str = "";
        $.each(res.resultData,function(index,element){
            console.log(element);
            str += "<tr><td>"+element.id+"</td><td>"+element.customerName+"</td>";
            str +=" <td>2012/01/01</td>\n" +
                "                          <td>学生</td>\n" +
                "                          <td><span class=\"badge badge-success\">在读</span></td>\n" +
                "                          <td>详情</td></tr>"
        });
        $('#tbody').append(str);

    });
});

$("#saveStudent").click(function () {
    console.log("add customer");

    //获取表单的数据
    var newCust = {};
    var t = $('form').serializeArray();
    $.each(t, function () {
        newCust[this.name] = this.value;
    });

    // 补充提交的字段
    console.log(JSON.stringify(newCust));
    $.ajax({
            type: "POST",
            url: "/customer/add",
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify(newCust),
            dataType: "json",
            success: function (res) {
                console.log("Data: " + res.resultData);
            },
            error: function (message) {
                alert("提交失败" + JSON.stringify(message));
            }
        }
    );

    $('#primaryModal').modal('hide'); //隐藏模态框
    $('.modal-backdrop').remove();//去掉遮罩层

});

