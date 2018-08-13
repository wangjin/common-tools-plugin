<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Roll Banner</title>
    <meta th:remove="tag" th:include="fragment/scripts :: css-lib">
    <meta th:remove="tag" th:include="fragment/scripts :: context-path">
</head>
<body>
<script id="edit-dom" type="text/html">
    <form class="layui-form" style="padding: 20px" lay-filter="${modelName?lower_case}-form">
        <div class="layui-form-item">
            <label class="layui-form-label">名称</label>
            <div class="layui-input-block">
                <input type="text" name="name" lay-verify="required" autocomplete="off"
                       placeholder="名称" class="layui-input">
            </div>
        </div>

        <div class="layui-form-item">
            <label class="layui-form-label">地址</label>
            <div class="layui-input-block">
                <input type="text" name="address" lay-verify="required" autocomplete="off"
                       placeholder="地址" class="layui-input">
            </div>
        </div>
        
        <div class="layui-form-item">
            <div class="layui-input-block">
                <button class="layui-btn edit-${modelName?lower_case}" lay-submit="" lay-filter="edit-${modelName?lower_case}">确定</button>
                <button type="reset" class="layui-btn layui-btn-primary">重置</button>
            </div>
        </div>
    </form>
</script>

<div class="layui-row">
    <button class="layui-btn layui-btn-primary" id="add">新增</button>
</div>
<table class="layui-hide" id="${modelName?lower_case}-table" lay-filter="${modelName?lower_case}-table"></table>

<object th:remove="tag" th:include="fragment/scripts :: js-lib"></object>

<script type="text/html" id="${modelName?lower_case}Bar">
    <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
    <a class="layui-btn layui-btn-xs edit" lay-event="edit">编辑</a>
    <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<script>
    //JavaScript代码区域
    layui.use(['element', 'table', 'form', 'layer', 'upload'], function () {
        var table = layui.table, form = layui.form, layer = layui.layer;

        //初始化表格
        table.render({
            elem: '#${modelName?lower_case}-table'
            , url: contextPath + '${modelName?lower_case}/pageData'
            , height: parent.tabContentHeight - 20 - 38
            , cols: [
                [
                    {checkbox: true, fixed: true}
                    , {field: 'id', title: 'ID', width: 100}
                    , {field: 'name', title: '名称'}
                    , {field: 'address', title: '地址'}
                    , {fixed: 'right', width: 200, align: 'center', toolbar: '#${modelName?lower_case}Bar', title: '操作'}
                ]
            ]
            , id: '${modelName?lower_case}Reload'
            , page: true
        });


        $('#add').on('click', function () {
            layer.open({
                type: 1,
                title: '编辑${modelName?lower_case}信息',
                area: ['600px', '350px'],
                content: $('#edit-dom').html(),
                success: function (layero, index) {

                    form.on('submit(edit-${modelName?lower_case})', function (callbackData) {

                        http.jsonPost(contextPath + '${modelName?lower_case}', callbackData.field, function (result) {

                            console.log(result);

                            table.reload('${modelName?lower_case}Reload');
                            layer.close(index);
                        }, function (error) {
                            http.processError(error, '添加${modelName?lower_case}信息失败');
                        });

                        return false;
                    });

                    form.render();

                },
                cancel: function () {
                }

            });
        });


        // 监听表格工具栏
        table.on('tool(${modelName?lower_case}-table)', function (obj) {

            var data = obj.data; //获得当前行数据
            var layEvent = obj.event; //获得 lay-event 对应的值


            switch (layEvent) {

                case 'edit':
                    layer.open({
                        type: 1,
                        title: '编辑${modelName?lower_case}信息',
                        area: ['600px', '350px'],
                        content: $('#edit-dom').html(),
                        success: function (layero, index) {

                            // 表单赋值
                            form.val('${modelName?lower_case}-form', {
                                'name': data.name,
                                'address': data.address
                            });

                            form.on('submit(edit-${modelName?lower_case})', function (callbackData) {
                                data.name = callbackData.field.name;
                                data.address = callbackData.field.address;

                                http.jsonPut(contextPath + '${modelName?lower_case}', data, function (result) {
                                    table.reload('${modelName?lower_case}Reload');
                                    layer.close(index);
                                }, function (error) {
                                    http.processError(error, '更新${modelName?lower_case}信息失败');
                                });

                                return false;
                            });

                        },
                        cancel: function () {
                        }

                    });
                    break;

                case 'del':

                    http.jsonDel(contextPath + '${modelName?lower_case}/' + data.id, function (result) {
                        if (result.status === 204) {
                            table.reload('${modelName?lower_case}Reload');
                        } else if (result.status === 404) {
                            table.reload('${modelName?lower_case}Reload');
                            layer.alert('${modelName?lower_case}不存在');
                        }
                    }, function (error) {
                        http.processError(error, '删除${modelName?lower_case}失败');
                    });
                    break;

            }

        });
    });
</script>

</body>
</html>