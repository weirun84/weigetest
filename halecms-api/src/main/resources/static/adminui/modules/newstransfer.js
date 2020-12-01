layui.define('table',function (exports) {
    "use strict";
    var $ = layui.$
        , table = layui.table
        , admin = layui.admin
        ,MOD_NAME = 'newstransfer'
        , leftbtn = '.news-left-btn', rightbtn = '.news-right-btn', MD5 = 'layui-col-md5', MD2 = 'layui-col-md2', checkbox_lef = 'news-pro_left', checkbox_right = 'news-pro_right', sreach = '.news-layui-btn-sreach', news_product_list = [], news_tabData = []
        ,transfer = {
            index:layui.transfer?(layui.transfer+1000):0
            ,idData:[] //ID池
            , data: [] //原始数据
            , options: []
            , linktype: 0
            , id: 0
            , get: function () {
                return news_tabData;
            }
        }
        ,thisRate = function () {
            var that = this
            return {
                index:that.index
            }
        }
        ,Class = function (options) {
            var that = this
            that.index = transfer.index?transfer.index:++transfer.index
            that.config = options
            transfer.options = options
            news_product_list = options.data[0] ? options.data[0] : []
            news_tabData = options.data[1] ? options.data[1] : []
            that.createHTMLDocument()
            that.render()
        };
    Class.prototype.createHTMLDocument = function () {
        var that = this
            ,elem  = that.config.elem
            , index = that.index, options = that.config;
        //创建页面元素
        var html = '<div class="layui-container">\
                    <div class="layui-row">\
                      <div class="'+ MD5 + '">\
                        <table class="layui-hide" id="'+ options.LEFT_TABLE + '" lay-filter="' + options.checkbox_lef +'"></table>\
                      </div>\
                      <div class="'+MD2+'" style="text-align: center;">\
                        <div id="'+ options.LEFT_BTN + '"  style="margin-bottom: 10px;"><button  data-type="0" type="button" data-index="' + index + '" class="layui-btn  ' + options.LEFT_BTN + ' '  +' layui-btn-disabled"> <i class="layui-icon">&#xe602;</i></button></div>\
                        <div id="'+ options.RIGHT_BTN + '" ><button data-type="1" data-index="' + index + '" type="button" class="layui-btn ' + options.RIGHT_BTN + ' '  +' layui-btn-disabled"> <i class="layui-icon">&#xe603;</i></button></div>\
                      </div>\
                      <div class="'+ MD5 + '">\
                        <table class="layui-hide" id="'+ options.RIGHT_TABLE + '" lay-filter="' + options.checkbox_right +'"></table>\
                      </div>\
                    </div>\
                  </div>';
        $(elem).html(html)
    }
    //初始化表格
    Class.prototype.render = function () {
        var that = this, options = that.config;
        
        var d1_c = {
            elem: '#' + transfer.options.LEFT_TABLE
            , method: 'POST'
            , request: {
                pageName: 'pagenumber' //页码的参数名称，默认：page
                , limitName: 'pagesize' //每页数据量的参数名，默认：limit
            }
            ,cols: [options.cols]
            
            , id: transfer.options.LEFT_TABLE + "id"
            , page: true
            , response: {
                statusName: 'success' //数据状态的字段名称，默认：code
                , statusCode: 0 //成功的状态码，默认：0
                , countName: 'total' //数据总数的字段名称，默认：count
                , dataName: 'data' //数据列表的字段名称，默认：data
            }
        }
        var d2_c = {
            elem: '#' + transfer.options.RIGHT_TABLE
            ,cols: [options.cols]
            ,data: (options.data[0]?options.data[0]:[])
            , id: transfer.options.RIGHT_TABLE + "id"
        }
        if(options.tabConfig){
            d1_c = $.extend(d1_c,options.tabConfig)
            d2_c = $.extend(d2_c,options.tabConfig)
        }
        //transfer.idData.push(that.index)
        table.render(d1_c)
        table.render(d2_c)
        //that.move()
    };
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
        var id = news_tabData;
        var id_str = id.join(',');
        var filed = {};
        if ($(transfer.options.sreachname).val() != "") {
            filed["field"] = 'title';
            filed["target"] = 'like';
            filed["val"] = $(transfer.options.sreachname).val();
        }
        if ($(transfer.options.selectname).val() > 0) {
            filed[transfer.options.catid] = { cat_id: $(transfer.options.selectname).val() };//goods
        }
        filed["id"] = id_str;
        table.reload(transfer.options.LEFT_TABLE + "id", {
            url: transfer.options.url,
            page: { curr: 1 },
            where: filed
        });
        table.reload(transfer.options.RIGHT_TABLE + "id", {
            data: news_product_list,
            page: { curr: 1 },
            where: {}
        });

    }


    //监听左表格选中
    table.on('checkbox(' + checkbox_lef + ')', function (obj) {
       
        btnIf(getTableData(transfer.options.LEFT_TABLE + "id"), '.' + transfer.options.LEFT_BTN)
    });
    //监听右表格选中
    table.on('checkbox(' + checkbox_right + ')', function (obj) {
        btnIf(getTableData(transfer.options.RIGHT_TABLE + "id"), '.' + transfer.options.RIGHT_BTN)
    });
    //左按钮点击移动数据
    $(document).on('click', leftbtn, function () {
        if (!$(this).hasClass('layui-btn-disabled')) {
            $('.' + transfer.options.LEFT_BTN + ',.' + transfer.options.RIGHT_BTN).addClass('layui-btn-disabled')
            var data = getTableData(transfer.options.LEFT_TABLE + "id");
            //查询缓存是否存在数据
            var goodslink = [];
            $.each(data, function (k, v) {
                news_product_list.push(v);
                var jsontable = v;
                var keyArrtable = Object.keys(jsontable);
                var val = jsontable[keyArrtable[0]];
                news_tabData.push(val);
                goodslink.push(val);
            });
            admin.req({
                url: 'AddCMSLink'
                , type: "post"
                , data: { cms_relation_list: goodslink.join(','), link_type: transfer.options.linktype, id: transfer.options.id}
                , done: function (res) {
                    //登入成功的提示与跳转
                    //layer.msg(res.data.msg);
                    reloadTable()
                }
            });
        }
    })
    //右按钮点击移动数据
    $(document).on('click', rightbtn, function () {
        if (!$(this).hasClass('layui-btn-disabled')) {
            $('.' + transfer.options.LEFT_BTN + ',.' + transfer.options.RIGHT_BTN).addClass('layui-btn-disabled')
            var data = getTableData(transfer.options.RIGHT_TABLE + "id");
            var goodslink = [];
            //查询缓存存在的数据
            $.each(data, function (k, v) {
                var len = news_product_list.length;
                var index = 0;
                var jsontable1 = v;
                var keyArrtable1 = Object.keys(jsontable1);
                var val1 = jsontable1[keyArrtable1[0]];
                for (var i = 0; i < len; i++) {
                    var jsontable = news_product_list[i];
                    var keyArrtable = Object.keys(jsontable);
                    var val = jsontable[keyArrtable[0]];
                    if (val == val1) {
                        index = i;
                    }
                }
                
                news_product_list.splice(index, 1);
                news_tabData.splice(index, 1);
                goodslink.push(val1);
            });
            admin.req({
                url: 'DelCMSLink'
                , type: "post"
                , data: { cms_relation_list: goodslink.join(','), link_type: transfer.options.linktype, id: transfer.options.id}
                , done: function (res) {
                    //登入成功的提示与跳转
                    //layer.msg(res.data.msg);
                    reloadTable()
                }
            });
        }
    })
    //左表数据事件
    table.on('rowDouble(' + checkbox_lef + ')', function (obj) {

        var jsontable = obj.data;
        var keyArrtable = Object.keys(jsontable);
        var val = jsontable[keyArrtable[0]];
        var goodslink = [];
        news_product_list.push(obj.data);
        news_tabData.push(val);
        goodslink.push(val);
        //layui.data('news_tabData', { key: 'id', value: id })
        admin.req({
            url: 'AddCMSLink'
            , type: "post"
            , data: { cms_relation_list: goodslink.join(','), link_type: transfer.options.linktype, id: transfer.options.id }
            , done: function (res) {
                //登入成功的提示与跳转
                //layer.msg(res.data.msg);
                reloadTable()
            }
        });
    });
    //右表双击时间
    table.on('rowDouble(' + checkbox_right + ')', function (obj) {
        var jsontable = obj.data;
        var keyArrtable = Object.keys(jsontable);
        var val = jsontable[keyArrtable[0]];
        var len = news_product_list.length;
        var index = 0;
        var goodslink = [];
        for (var i = 0; i < len; i++) {
            var jsontable1 = news_product_list[i];
            var keyArrtable1 = Object.keys(jsontable1);
            var val1 = jsontable1[keyArrtable1[0]];
            if (val1 == val) {
                index = i;
            }
        }
        news_product_list.splice(index, 1);
        news_tabData.splice($.inArray(val, news_tabData), 1) //删除选中的
        goodslink.push(val);
        admin.req({
            url: 'DelCMSLink'
            , type: "post"
            , data: { cms_relation_list: goodslink.join(','), link_type: transfer.options.linktype, id: transfer.options.id}
            , done: function (res) {
                //登入成功的提示与跳转
                //layer.msg(res.data.msg);
                reloadTable()
            }
        });
    });


    //监听搜索

    $(sreach).on('click', function () {
       
        //执行重载
        reloadTable();
    });

    transfer.render = function (options) {
        var inst = new Class(options)
        return thisRate.call(inst)
    }
    exports(MOD_NAME,transfer)
})