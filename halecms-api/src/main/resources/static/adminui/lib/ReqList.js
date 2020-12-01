function reqadmin(layer, admin, title, posturl, data, requrl) {
    layer.load(1);
    layer.confirm(title, {
        btn: ['确定', '取消'] //按钮
    }, function () {
        layer.load(1);
        //请求删除
        admin.req({
            url: posturl
            , type: "post"
            , data: data
            , done: function (res) {
                layer.closeAll('loading');
                //提示与跳转
                layer.msg(res.message, {
                    time: 500
                }, function () {
                    if (res.success == 0) {
                        if (requrl!="")
                        location.href = requrl;
                    }
                });
            }
            , complete: function () {
                layer.closeAll('loading');
            }
        });

        }, function () {
            layer.closeAll('loading');
        return;
    }); 
}

function reqadmin_editinfo(layer, admin, posturl, data) {
    layer.load(1);
    admin.req({
        url: posturl
        , type: "post"
        , data: data
        , done: function (res) {
            layer.closeAll('loading');
            layer.msg(res.message);
        }
        , complete: function () {
            layer.closeAll('loading');
        }
    });
}

function reqadmin_addoredit(layer, admin, posturl, data, requrl) {
    layer.load(1);
    admin.req({
        url: posturl
        , type: "post"
        , data: data
        , done: function (res) {
            console.log(res);
            layer.closeAll('loading');
            //登入成功的提示与跳转
            if (res.success == 0)
                layer.msg(res.message, {
                    time: 500
                }, function () {
                    if (res.success == 0) {
                        location.href = requrl;
                    }
                });
            else
                layer.msg(res.message);
        }
        , complete: function () {
            layer.closeAll('loading');
        }
    });
}
function GgoodsDetailsAdd() {
    var details = "details[" + i + "]";
    $(".goodsdetailsadd").append("<fieldset class='layui-elem-field fields goodsdetailsfields'><legend>参数名称" + i + "录入</legend><div class='layui-field-box layui-field-box-d'><div class='dts' ><input type='text'        value='参数名称" + i + "' class='layui-input details_name'> <i class='layui-icon layui-icon-d' onclick='GgoodsDetailsRemove(this)'> &#x1007;</i> <textarea     id='" + details + "'  class='details'  placeholder='可以输入栏目的详细介绍'>参数内容" + i + "</textarea></div></div></fieldset>");

    //UE.getEditor(details);
    var ue = UE.getEditor(details);
    // editor准备好之后才可以使用

    i++;
}
function GgoodsDetailsRemove(is) {
    layer.confirm('确定删除此参数？', {
        btn: ['确定', '取消'] //按钮
    }, function (index) {
        $(is).closest(".goodsdetailsfields").remove();
        layer.close(index);
    }, function () {
        return;
    });
}
/**
*设置默认图片#f00
*/
function setDefault(obj) {
    $(".layui-col-md2").css({ "border": "" });
    var setred = $(obj).closest(".layui-col-md2");
    setred.css({ "border": "1px solid #f00" });
    $('#original_img').val(setred.find("img").attr("src"));
    $('#goodsinfo_img').val(setred.find("img").attr("data-info"));
    $('#goods_thumb').val(setred.find("img").attr("data-thumb"));
    $('#goods_img').val(setred.find("img").attr("data-img"));

}