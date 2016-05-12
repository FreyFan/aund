<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/context/mytags.jsp"%>
<t:base type="jquery,easyui,zTree"></t:base>

<div class="easyui-layout" fit="true">
	<div region="center" style="padding: 1px;">
		<t:datagrid name="roleList" title="common.role.list" actionUrl="roleController.do?roleGrid" idField="id" sortName="createDate" sortOrder="desc">
			<t:dgCol title="common.code" field="id" hidden="true"></t:dgCol>
			<t:dgCol title="common.role.code" field="roleCode"></t:dgCol>
			<t:dgCol title="common.role.name" field="roleName"></t:dgCol>
			<t:dgCol title="common.createby" field="createBy"></t:dgCol>
			<t:dgCol title="common.createtime" field="createDate" formatter="yyyy-MM-dd"></t:dgCol>
			<t:dgCol title="common.updateby" field="updateBy"></t:dgCol>
			<t:dgCol title="common.updatetime" field="updateDate" formatter="yyyy-MM-dd"></t:dgCol>
		</t:datagrid>
	</div>
</div>

<div region="west" style="width: 300px;" split="true" title="树形结构">
	<ul id="treeDemo" class="ztree"></ul>
</div>

<script type="text/javascript">
	var setting = {};

	var zNodes = [ {
		name : "父节点1 - 展开",
		open : true,
		children : [ {
			name : "父节点11 - 折叠",
			children : [ {
				name : "叶子节点111"
			}, {
				name : "叶子节点112"
			}, {
				name : "叶子节点113"
			}, {
				name : "叶子节点114"
			} ]
		}, {
			name : "父节点12 - 折叠",
			children : [ {
				name : "叶子节点121"
			}, {
				name : "叶子节点122"
			}, {
				name : "叶子节点123"
			}, {
				name : "叶子节点124"
			} ]
		}, {
			name : "父节点13 - 没有子节点",
			isParent : true
		} ]
	}, {
		name : "父节点2 - 折叠",
		children : [ {
			name : "父节点21 - 展开",
			open : true,
			children : [ {
				name : "叶子节点211"
			}, {
				name : "叶子节点212"
			}, {
				name : "叶子节点213"
			}, {
				name : "叶子节点214"
			} ]
		}, {
			name : "父节点22 - 折叠",
			children : [ {
				name : "叶子节点221"
			}, {
				name : "叶子节点222"
			}, {
				name : "叶子节点223"
			}, {
				name : "叶子节点224"
			} ]
		}, {
			name : "父节点23 - 折叠",
			children : [ {
				name : "叶子节点231"
			}, {
				name : "叶子节点232"
			}, {
				name : "叶子节点233"
			}, {
				name : "叶子节点234"
			} ]
		} ]
	}, {
		name : "父节点2 - 折叠",
		children : [ {
			name : "父节点21 - 展开",
			open : true,
			children : [ {
				name : "叶子节点211"
			}, {
				name : "叶子节点212"
			}, {
				name : "叶子节点213"
			}, {
				name : "叶子节点214"
			} ]
		}, {
			name : "父节点22 - 折叠",
			children : [ {
				name : "叶子节点221"
			}, {
				name : "叶子节点222"
			}, {
				name : "叶子节点223"
			}, {
				name : "叶子节点224"
			} ]
		}, {
			name : "父节点23 - 折叠",
			children : [ {
				name : "叶子节点231"
			}, {
				name : "叶子节点232"
			}, {
				name : "叶子节点233"
			}, {
				name : "叶子节点234"
			} ]
		} ]
	}, {
		name : "父节点2 - 折叠",
		children : [ {
			name : "父节点21 - 展开",
			open : true,
			children : [ {
				name : "叶子节点211"
			}, {
				name : "叶子节点212"
			}, {
				name : "叶子节点213"
			}, {
				name : "叶子节点214"
			} ]
		}, {
			name : "父节点22 - 折叠",
			children : [ {
				name : "叶子节点221"
			}, {
				name : "叶子节点222"
			}, {
				name : "叶子节点223"
			}, {
				name : "叶子节点224"
			} ]
		}, {
			name : "父节点23 - 折叠",
			children : [ {
				name : "叶子节点231"
			}, {
				name : "叶子节点232"
			}, {
				name : "叶子节点233"
			}, {
				name : "叶子节点234"
			} ]
		} ]
	}, {
		name : "父节点3 - 没有子节点",
		isParent : true
	}

	];

	$(document).ready(function() {
		$.fn.zTree.init($("#treeDemo"), setting, zNodes);
	});
</script>
