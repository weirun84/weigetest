var left_tab = "left_tab";
//左边表格
table.render({
    elem: '#' + left_tab
    , data: []
    , method: 'POST'
    , request: {
        pageName: 'pagenumber' //页码的参数名称，默认：page
        , limitName: 'pagesize' //每页数据量的参数名，默认：limit
    }
    , cols: [[
        { checkbox: true, fixed: true }
        , { field: 'goods_id', title: '编号', fixed: true, width: 70 }
        , { field: 'goods_name', title: '商品名称' }
    ]]
    , id: 'left_table_id'
    , page: true
    , response: {
        statusName: 'success' //数据状态的字段名称，默认：code
        , statusCode: 0 //成功的状态码，默认：0
        , countName: 'total' //数据总数的字段名称，默认：count
        , dataName: 'data' //数据列表的字段名称，默认：data
    }
})
//右边表格
table.render({
    elem: '#right_tab'
    , data: product_list
    , cols: [[
        { checkbox: true, fixed: true }
        , { field: 'goods_id', title: 'ID', width: 80, fixed: true }
        , { field: 'goods_name', title: '商品名称（跟该商品关联的商品）' }
    ]]
    , data: []
    , id: 'right_table_id'
    , page: true

});
//公共方法
function getTableData(id) {
    var checkStatus = table.checkStatus(id)
        , data = checkStatus.data;
    return data;
}
function btnIf(data, btn) {
    if (data && data.length) {
        $(btn).removeClass('layui-btn-disabled')
    } else {
        $(btn).addClass('layui-btn-disabled')
    }
}
//重载左边表格
function reloadTable() {
    var goods_id = layui.data('tabData').goods_id;
    var id_str = goods_id.join(',');
    var filed = {};
    if ($('.goods_sreach_name').val() != "") {
        filed["field"] = 'goods_name';
        filed["target"] = 'like';
        filed["val"] = $('.goods_sreach_name').val();
    }
    if ($('.goods_sreach_cat_id').val() > 0) {
        filed["goods"] = { cat_id: $('.goods_sreach_cat_id').val() };
    }
    filed["goods_id"] = id_str;
    table.reload('left_table_id', {
        url: '@Url.Content("List")',
        page: { curr: 1 },
        where: filed, done: function (res, curr, count) {
            this.where = { goods_id: id_str };
        }
    });
    table.reload('right_table_id', {
        data: product_list,
        page: { curr: 1 },
        where: {}, done: function (res, curr, count) {
            this.where = {};
        }
    });

}
//监听左表格选中
table.on('checkbox(left)', function (obj) {
    btnIf(getTableData('left_table_id'), '.left-btn')
});
//监听右表格选中
table.on('checkbox(right)', function (obj) {
    btnIf(getTableData('right_table_id'), '.right-btn')
});
//左按钮点击移动数据
$('.left-btn').on('click', function () {
    if (!$(this).hasClass('layui-btn-disabled')) {
        $('.left-btn,.right-btn').addClass('layui-btn-disabled')
        var data = getTableData('left_table_id');
        //查询缓存是否存在数据
        var goods_id = [];
        product_list.push(getTableData('left_table_id'));
        if (layui.data('tabData').goods_id.length > 0) {
            goods_id = layui.data('tabData').goods_id;
        }
        $.each(data, function (k, v) {
            goods_id.push(v.goods_id)
        });
        //存储缓存
        layui.data('tabData', { key: 'goods_id', value: goods_id })
        reloadTable()
    }
})
//右按钮点击移动数据
$('.right-btn').on('click', function () {
    if (!$(this).hasClass('layui-btn-disabled')) {
        $('.left-btn,.right-btn').addClass('layui-btn-disabled')
        var data = getTableData('right_table_id');

        //查询缓存存在的数据
        var goods_id = layui.data('tabData').goods_id;
        $.each(data, function (k, v) {
            goods_id.splice($.inArray(v.goods_id, goods_id), 1) //删除选中的
            var len = product_list.length;
            var index = 0;
            for (var i = 0; i < len; i++) {
                if (product_list[i].goods_id == v.goods_id) {
                    index = i;
                }
            }
            product_list.splice(index, 1);
        });
        //存储缓存
        layui.data('tabData', { key: 'goods_id', value: goods_id })
        reloadTable()
    }
})
//左表数据事件
table.on('rowDouble(left)', function (obj) {
    var goods_id = layui.data('tabData').goods_id;
    goods_id.push(obj.data.goods_id)
    product_list.push(obj.data);
    layui.data('tabData', { key: 'goods_id', value: goods_id })
    reloadTable()
});
//右表双击时间
table.on('rowDouble(right)', function (obj) {
    var goods_id = layui.data('tabData').goods_id;
    goods_id.splice($.inArray(obj.data.goods_id, goods_id), 1) //删除选中的
    var len = product_list.length;
    var index = 0;
    for (var i = 0; i < len; i++) {
        if (product_list[i].goods_id == obj.data.goods_id) {
            index = i;
        }
    }
    product_list.splice(index, 1);
    layui.data('tabData', { key: 'goods_id', value: goods_id })
    reloadTable()
});