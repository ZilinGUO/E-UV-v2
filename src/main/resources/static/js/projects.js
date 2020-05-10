$(document).ready(function(){

    $('#loading-example-btn').click(function () {
        btn = $(this);
        simpleLoad(btn, true)

        // Ajax example
//                $.ajax().always(function () {
//                    simpleLoad($(this), false)
//                });

        simpleLoad(btn, false)
    });

    var table=$("#GroupTable");
    var str="";//定义用于拼接的字符串
    $.ajax({
        url: "/User/getUserInfo.do",
        type: "post",
        data: {},
        async: false,//是否异步请求
        success: function (data) {
            console.log(data);
        }

    })

    // $.ajax({
    //     url: "/Project/findAllProject.do",
    //     type: "post",
    //     async: false,//是否异步请求
    //     success: function (data) {
    //         console.log(data);
    //         $('#table').bootstrapTable("hideLoading");
    //         $('#table').bootstrapTable('append',data);
    //     }
    //
    // })


    $("#table").bootstrapTable({
        url:'/Project/findAllProject.do',  //获取表格数据
        //使用post传参，去掉后无法成功
        method: "get",
        toolbar:"#companyToolbar",
        cache: false,            //禁用ajax缓存
        striped: true,           //表格显示条纹
        pagination: true,        //在底部显示分页组件
        pageSize: 5,                       //每页的记录行数（*）
        pageList: [10, 25, 50, 100],
        pageNumber: 1,            // 首页页码
        sidePagination: 'server', // 设置为服务器端分页
        showColumns:true,        //是否显示内容列下拉框
        showToggle:false,         //切换详细视图和列表视图
        singleSelect:true,        //单选checkbox
        clickToSelect: true,
        onClickRow:function (row,$element) {
            $('.info').removeClass('info');//移除class
            $($element).addClass('info');//添加class
        },
        queryParams:function (params){   //请求服务器数据时，添加额外参数
            return {
                limit : params.limit, // 每页显示数量
                offset : params.offset, // SQL语句起始索引
            }
        },
        idField:'projectid',             //指定主键列
        columns:[{

            // radio: true, // 单选
            checkbox: true,
            width: 50
        },{
            field:'projectName',  //返回json中的name
            title:'project name',   //表格表头显示文字
            halign:'center', //表头居中
            align:'center',
            valign: 'middle' // 上下居中
        },{
            field:'description',  //返回json中的name
            title:'description',   //表格表头显示文字

            halign:'center',
            align:'center',   //左右居中
            valign: 'middle' // 上下居中
        }
        ]
    });

});

function simpleLoad(btn, state) {
    if (state) {
        btn.children().addClass('fa-spin');
        btn.contents().last().replaceWith(" Loading");
    } else {
        setTimeout(function () {
            btn.children().removeClass('fa-spin');
            btn.contents().last().replaceWith(" Refresh");
        }, 2000);
    }
}

function edit(){
    // 获取当前行
    var row=$("#table").bootstrapTable('getSelections');
    console.log(row);
}