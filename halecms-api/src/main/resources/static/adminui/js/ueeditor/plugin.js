/*
 * Created by weishuwen on 2015/3/16.
 *
 * html样式片段不能加空格
*/
UE.plugins["editstyle"] = function () {
    var me = this;
    var dialog = null;
    var COMMAND = {
        editone: 0,
        edittwo: 1,
        editthree: 2,
        editfour: 3,
        editfive: 4,
        editsix: 5,
        editseven: 6,
        editeight: 7
    };
    /**
     *     execCommand(cmdName, dialog): 点击toolbar，调用插件，大部分逻辑都在这里写
     *     queryCommand(cmdName, dialog): 状态处理
     *     
baidu.editor.ui.Dialog: 是否使用弹出层，注意：dialog关闭后其中的内容会清除，但dialog本身不会从dom移除
     *         title: 标题,默认同description
     *         
content: 内容
     */
    me.commands["editone"]
        =
        {
            execCommand:
                function (cmd) {
                    // 判断是否要绑定事件
                    var flag = true;
                    if (!dialog) {
                        dialog = new baidu.editor.ui.Dialog({
                            title: '自定义模板样式',
                            ///content: $("#styleDialog").html(),
                            content: "<iframe id='tempview' name='tempview' src='/ctm_manage/Seomain/TempView' width='1100px' height='450px' ></iframe> ",
                            draggable: true,
                            editor: this,
                            //如果给出了buttons就代表dialog有确定和取消
                            buttons: [
                                {
                                    className: 'edui-okbutton',
                                    label: '确定',
                                    onclick: function () {

                                        //var str = me.body.innerHTML;
                                        //var reg = RegExp('/'+window.tempcsshtml+'/');
                                        //me.body.innerHTML = me.body.innerHTML.replace(reg, "");
                                        var temphtml =  window.temphtml;
                                        me.execCommand('insertHtml', temphtml);
                                        //temphtml = me.body.innerHTML.replace(new RegExp(window.tempcsshtml, 'g'), "");
                                        //me.execCommand('insertHtml', temphtml + window.tempcsshtml);
                                        me.body.innerHTML = me.body.innerHTML.replace(new RegExp(window.tempcsshtml, 'g'), "") + window.tempcsshtml;
                                        
                                        dialog.close(true);
                                    }
                                },
                                {
                                    className: 'edui-cancelbutton',
                                    label: '取消',
                                    onclick: function () {
                                        dialog.close(false);
                                    }
                                }
                            ]
                        });
                        
                        flag = false;
                        dialog.open();  // 打开对话框
                    } else {
                        dialog._show();  //直接显示出来，防止用open时候重新渲染
                    }

                    
                   
                }
        };
};
