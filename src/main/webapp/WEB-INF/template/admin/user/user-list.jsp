<%@page language="java" contentType="text/html; charset=utf-8"
        pageEncoding="UTF-8" %>

<form>
    <body id="skin-blur-violate">
    <!-- Breadcrumb -->
    <ol class="breadcrumb hidden-xs">
        <li><a href="#">Home</a></li>
        <li><a href="#">Library</a></li>
        <li class="active">Data</li>
    </ol>
    <h4 class="page-title">TABLES</h4>
    <!-- Table Hover -->
    <div class="block-area" id="tableHover">
        <h3 class="block-title">Table with Hover Style</h3>
        <div class="table-responsive overflow">
            <table class="table table-bordered table-hover tile">
                <thead>
                <tr>
                    <th>No.</th>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Username</th>
                </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>
    </div>
    </body>
    <script type="text/javascript">
        var userList = {
            v: {
                id: "userList",
                list: [],
                dTable: null
            },
            fn: {
                init: function () {
                    userList.fn.dataTableInit();
                    // 查询
                    $("#c_search").click(function () {
                        userList.v.dTable.ajax.reload();
                    })

                    $("#delete").click(function () {
                        var checkBox = $("#dataTables tbody tr").find('input[type=checkbox]:checked');
                        var ids = checkBox.getInputId();
                        userList.fn.deleteRow(checkBox, ids)
                    })
                },
                dataTableInit: function () {
                    userList.v.dTable = $bluemobi.dataTable($('#dataTables'), {
                        "processing": true,
                        "serverSide": true,
                        "searching": false,
                        "ordering": false,
                        "ajax": {
                            "url": "admin/product/list",
                            "type": "POST"
                        },
                        "columns": [
                            {"data": "id"},
                            {"data": "name"},
                            {"data": "code"},
                            {"data": "price"},
                            {"data": "productType.name"},
                            {"data": "productArea.name"},
                            {"data": "createDate"},
                            {"data": ""}
                        ],
                        "columnDefs": [
                            {
                                "data": null,
                                "defaultContent": "<button type='button'  title='上架商品' class='btn btn-circle settingAdded'>" +
                                "<i class='fa fa-recycle'></i>" +
                                "</button>" +
                                "&nbsp;&nbsp;" +
                                "<a  title='编辑' target='_blank' class='btn btn-primary btn-circle edit'>" +
                                "<i class='fa fa-edit'></i>" +
                                "</a>" +
                                "&nbsp;&nbsp;" +
                                "<button type='button'  title='删除' class='btn btn-danger btn-circle delete'>" +
                                "<i class='fa fa-bitbucket'></i>" +
                                "</button>",
                                "targets": -1
                            }
                        ],
                        "createdRow": function (row, data, index) {
                            userList.v.list.push(data);
                            $('td', row).eq(0).html("<input type='checkbox' value=" + data.id + ">");
                            if (data.isAdded) {
                                $(row).addClass("success")
                                $('td', row).eq(1).prepend("<span style='color: red'>【上架】</span>");
                                $('td', row).last().find(".settingAdded").addClass("btn-default");
                                $('td', row).last().find(".settingAdded").attr("title", "下架商品")
                            } else {
                                $('td', row).last().find(".settingAdded").addClass("btn-info");
                                $('td', row).last().find(".settingAdded").attr("title", "上架商品")
                            }
                        },
                        rowCallback: function (row, data) {
                            var items = userList.v.list;
                            $('td', row).last().find(".settingAdded").click(function () {
                                userList.fn.settingAdded(data);
                            })

                            $('td', row).last().find(".edit").attr("href", 'admin/product/add?id=' + data.id)

                            $('td', row).last().find(".delete").click(function () {
                                var checkbox = $('td', row).first().find("input[type='checkbox']");
                                userList.fn.deleteRow(checkbox, [data.id]);
                            })
                        },
                        "fnServerParams": function (aoData) {
                            aoData.typeId = $("#typeId").val();
                            aoData.isAdded = $("#isAdded").val();
                        },
                        "fnDrawCallback": function (row) {
                            $bluemobi.uiform();
                        }
                    });
                },
                settingAdded: function (data) {
                    $bluemobi.ajax("admin/product/setting/isAdded", {
                        id: data.id,
                        isAdded: data.isAdded
                    }, function (result) {
                        userList.fn.responseComplete(result, true);
                    })
                },
                deleteRow: function (checkBox, ids) {
                    if (ids.length > 0) {
                        $bluemobi.optNotify(function () {
                            $bluemobi.ajax("admin/product/delete", {ids: JSON.stringify(ids)}, function (result) {
                                if (result.status == "0") {
                                    $bluemobi.notify(result.msg, "success");
                                    userList.v.dTable.ajax.reload();

                                } else {
                                    $bluemobi.notify(result.msg, "error");
                                }
                            })
                        });
                    }
                },
                responseComplete: function (result, action) {
                    if (result.status == "0") {
                        if (action) {
                            userList.v.dTable.ajax.reload(null, false);
                        } else {
                            userList.v.dTable.ajax.reload();
                        }
                        $bluemobi.notify(result.msg, "success");
                    } else {
                        $bluemobi.notify(result.msg, "error");
                    }
                }
            }
        }

        $(document).ready(function () {
            userList.fn.init();
        });
    </script>
</form>

