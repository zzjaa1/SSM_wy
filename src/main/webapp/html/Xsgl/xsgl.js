layui.use('table', function(){
    var table = layui.table;

    //第一个实例
    table.render({
        elem: '#demo'
        ,height: 312
        ,url: '' //数据接口
        ,page: true //开启分页
        ,cols: [[ //表头
            {field: 'id', title: '编号', width:80, sort: true, fixed: 'left'}
            ,{field: 'username', title: '所属公司', width:100}
            ,{field: 'sex', title: '姓名', width:80, sort: true}
            ,{field: 'city', title: '性别', width:80}
            ,{field: 'sign', title: '出生日期', width: 177}
            ,{field: 'experience', title: '证件号码', width: 120, sort: true}
            ,{field: 'score', title: '手机号码', width: 120, sort: true}
            ,{field: 'classify', title: '状态', width: 80}
            ,{field: 'wealth', title: '操作', width: 135, sort: true},
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