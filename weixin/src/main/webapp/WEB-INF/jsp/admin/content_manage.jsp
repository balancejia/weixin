<%@ page pageEncoding="UTF-8"%>
<%@ include file="../common/global.jsp"%>
<link rel="stylesheet" href="${BASE}/www/css/amazeui.tree.min.css" />
<div class="am-cf am-padding" style="padding: 0.1rem;">
	<div class="am-fl am-cf">
		<strong class="am-text-primary am-text-lg"  style="margin:2rem;">内容管理</strong>  <small></small>
	</div>
</div>
<hr data-am-widget="divider"  class="am-divider am-divider-default" style="padding: 0.6rem auto;"/>
<div class="am-g">
	<div class="am-u-sm-2" id="tree-container">
		<ul class="am-tree am-tree-folder-select" role="tree"
			id="myTreeSelectableFolder">
			<li class="am-tree-branch am-hide" data-template="treebranch"
				role="treeitem" aria-expanded="false">
				<div class="am-tree-branch-header">
					<button class="am-tree-icon am-tree-icon-caret am-icon-caret-right">
						<span class="am-sr-only">Open</span>
					</button>
					<button class="am-tree-branch-name">
						<span class="am-tree-icon am-tree-icon-folder"></span> <span
							class="am-tree-label"></span>
					</button>
				</div>
				<ul class="am-tree-branch-children" role="group"></ul>
				<div class="am-tree-loader" role="alert">Loading...</div>
			</li>
			<li class="am-tree-item am-hide" data-template="treeitem"
				role="treeitem">
				<button class="am-tree-item-name">
					<span class="am-tree-icon am-tree-icon-item"></span> <span
						class="am-tree-label"></span>
				</button>
			</li>
		</ul>
	</div>
	<div class="am-u-sm-10" id="content-list">
	</div>
</div>
<script type="text/javascript"
	src="${BASE}/www/lib/amazeui/amazeui.tree.min.js"></script>
<script type="text/javascript" src="${BASE}/www/js/menu_tree.js"></script>