$(function(){
    query();
});

var flightNo;//航班号
var no;       //机号
var airlineCompany;//航空公司
var Seatt;

function cx() {
    query();
}

function query() {
    if (flightNo==undefined || flightNo=="---所有---"){
        flightNo="";
    }
    if (Seatt==undefined || Seatt=="---所有---"){
        Seatt="";
    }
    if (no==undefined || no=="---所有---"){
        no="";
    }
    if (airlineCompany==undefined || airlineCompany=="---所有---"){
        airlineCompany="";
    }
    layui.use('table', function(){
        var table = layui.table;
        //第一个实例
        table.render({
            elem: '#userList'
            ,height: 500
            ,id:'id'
            ,url: 'newAction/queryFR' //数据接口
            ,where:{'airlineCompany':airlineCompany,'seat':Seatt,'flightNo':flightNo,'no':no}
            ,page: true //开启分页
            ,limit:10
            ,cols: [[ //表头
                {type: "checkbox", fixed:"left", width:50},
                {field: 'airCode', title: '航空公司二字码', minWidth:50, align:"center"},
                {field: 'flightNo', title: '航班', minWidth:50, align:'center'},
                {field: 'task', title: '任务性质', minWidth:50, align:'center'},
                {field: 'seat', title: '进出港', minWidth:50, align:'center'},
                {field: 'no', title: '机号', minWidth:50, align:'center'},
                {field: 'attribute', title: '机型', minWidth:50, align:'center'},
                {field: 'nature', title: '航班性质', minWidth:50, align:'center'},
                {field: 'airportStart', title: '起飞机场', minWidth:50, align:'center'},
                {field: 'planTakeTime', title: '计划起飞时间', minWidth:50, align:'center'},
                {field: 'planLandTime', title: '计划落地时间', minWidth:50, align:'center'},
                {field: 'flightAgent', title: '航班状态', minWidth:50, align:'center'},
                {title: '操作', minWidth:175, templet:function(value){
                        var obj = JSON.stringify(value);
                       return " <button class=\"layui-btn layui-btn-sm\" value='编辑' onclick='member_edit("+obj+")'>\n" +
                           "                            <i class=\"layui-icon\">&#xe642;</i>\n" +
                           "   </button>" +
                           "<button class=\"layui-btn layui-btn-sm\" oclick=\"delete("+value.id+")\">\n" +
                           "    <i class=\"layui-icon\">&#xe640;</i>\n" +
                           "  </button>";
                    }}
            ]]
        });
    });
}
/*-编辑*/
function member_edit(data){
    layer.open({
        type: 1,
        title: '修改航班动态信息',
        maxmin: true,
        shadeClose:true, //点击遮罩关闭层
        shade: 1 ,   //遮罩
        anim:4,
        area : ['920px' , ''],
        content:$('#add_menber_style'),
        btn:['提交','取消'],
        success: function (layero, index) {
           /* var checkStatus = table.checkStatus('id');
            console.log("row="+checkStatus.data)*/
          /*  for(var i=1;Object.entries(data).length>i;i++) {
                var id = '#' + Object.entries(data)[i][0];
                var text = Object.entries(data)[i][1];
                $(id).val(text);
            }*/
            //ifram
            var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
             for(var i=1;Object.entries(data).length>i;i++) {
                 var id = '#' + Object.entries(data)[i][0];
                 var text = Object.entries(data)[i][1];
                 body.contents().find(id).val(text);
             }
            var iframeWin = window[layero.find('iframe')[0]['name']];//得到iframe页的窗口对象，执行iframe页的方法：
            }
            //ifram
            /*var body = layer.getChildFrame('body', index);  //巧妙的地方在这里哦
             for(var i=1;Object.entries(data).length>i;i++) {
                 var id = '#' + Object.entries(data)[i][0];
                 var text = Object.entries(data)[i][1];
                 body.contents().find(id).val(text);
             }*/
        },
        yes:function(index,layero){
            var num=0;
            var str="";
            $(".add_menber input[type$='text']").each(function(n){
                if($(this).val()=="")
                {
                    layer.alert(str+=""+$(this).attr("name")+"不能为空！\r\n",{
                        title: '提示框',
                        icon:0,
                    });
                    num++;
                    return false;
                }
            });
            if(num>0){  return false;}
            else{
                $("#add_menber_form").submit();
                layer.alert('编辑成功！',{
                    title: '提示框',
                    icon:1,
                });
                layer.close(index);
            }
        }
    });
}

/*-删除*/
function member_del(obj,id){
    layer.confirm('确认要删除吗？',function(index){
        $(obj).parents("tr").remove();
        layer.msg('已删除!',{icon:1,time:1000});
    });
}
/*
layer.open({
        title: '在线调试'
        ,content: '可以填写任意的layer代码'
        ,type:1
        ,anim:4          //动画
        ,area: ['500px', '300px']
        ,btn: ['按钮一', '按钮二', '按钮三']
        ,shade: 1        //遮罩
        ,shadeClose:true //点击遮罩关闭
        ,scrollbar :true  //滚动条
        ,btnAlign: 'c'
        ,yes: function(index, layero){
            layer.alert('酷毙了', {icon: 1});
        }
        ,btn2: function(index, layero){
            //按钮【按钮二】的回调
            return false //开启该代码可禁止点击该按钮关闭
        }
        ,btn3: function(index, layero){
            //return false 开启该代码可禁止点击该按钮关闭
        }
        ,cancel: function(){
            //右上角关闭回调
            //return false 开启该代码可禁止点击该按钮关闭
        }
    });
}

*/
/*   $.ajax({
                         url:'/ssm_wy/queryCost',
                         method: 'post',
                         data:JSON.stringify(li),//"cBcfyzqDate":fyzq,"cBjfyzqDate":fyxq},
                         dataType: 'JSON',
                         contentType:"application/json",
                         success: function (res) {
                          },
                         error: function (data) {
                         }
                     });
                    */