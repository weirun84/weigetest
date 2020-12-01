////upload layui命名；elem按钮id；picid 图片id；picurl 上传图片的地址；picname 返回值传递的id；errorid 提示错误的id;reload重新加载
//function uploadimg(upload, elem, picid, picurl, picname, errorid) {

//    upload.render({
//        elem: elem
//        , url: picurl
//        , before: function (obj) {
//            //预读本地文件示例，不支持ie8
//            //obj.preview(function (index, file, result) {
//            //    $(picid).attr('src', result); //图片链接（base64）
//            //});
//            layer.load(1);
//        }
//        , done: function (res) {
//            layer.closeAll('loading');
//            //如果上传失败
//            if (res.status == 0) {
//                return layer.msg('上传失败');
//            }
//            $(picid).attr('src', res.path); //图片链接（base64）
//            $(picname).val(res.path);
//            //上传成功
//        }
//        , error: function () {
//            layer.closeAll('loading');
//            //演示失败状态，并实现重传<a class="layui-btn layui-btn-mini demo-reload">重试</a>
//            var demoText = $(errorid);
//            demoText.html('<span style="color: #FF5722;margin-top:5px;">上传失败</span> ');
//            //demoText.find('.demo-reload').on('click', function () {
//            //    reload.upload();
//            //});
//        }
//        , complete: function () {
//            layer.closeAll('loading');
//            var demoText = $(errorid);
//            demoText.html('<span style="color: #FF5722;margin-top:5px;">上传失败</span> ');
//        }
//    });
//}
//upload layui命名；elem按钮id；picid 图片id；picurl 上传图片的地址；picname 返回值传递的id；errorid 提示错误的id;reload重新加载
function uploadimg(elem, picid, picname, errorid, i) {
    var uploadEditor = {};
    $(elem).next().append('<textarea id="uploadEditorsimg'+i+'" style="display: none;"></textarea>');
    // 实例化编辑器，这里注意配置项隐藏编辑器并禁用默认的基础功能。
    uploadEditor[i] = UE.getEditor('uploadEditorsimg' + i, {
        isShow: false,
        focus: false,
        enableAutoSave: false,
        autoSyncData: false,
        autoFloatEnabled: false,
        wordCount: false,
        sourceEditor: null,
        scaleEnabled: true,
        toolbars: [["insertimage"]]
    });
    // 监听多图上传和上传附件组件的插入动作
    uploadEditor[i].ready(function () {
        uploadEditor[i].addListener("beforeInsertImage", function (t, result) {
            for (var j in result) {
                if (result.length == 1) {
                    $(picname).val(result[j].src);
                    $(picid).attr("src", result[j].src)
                }
                else {
                    layer.msg("只能选择单个图片，选择多个图片则无效！");
                }
            }
        });
    });

    // 自定义按钮绑定触发多图上传和上传附件对话框事件
    $(elem).click(function () {
        if ($(picname).val() != "") {
            uploadEditor[i].body.innerHTML = $(picname).val() + ",baidu_picclass_log";
        }
        var dialog = uploadEditor[i].getDialog("insertimage", "remote");
        dialog.title = '图片上传';
        dialog.render();
        dialog.open();
    })
    
    
}
