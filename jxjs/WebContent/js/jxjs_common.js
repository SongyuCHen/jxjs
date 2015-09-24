var g_dataTable = null;

$(function() {
	g_dataTable = $("#dataTable").DataTable({
		"sDom" : '<"top">rt<"bottom"ip<"clear">>',
		language : {
			"sProcessing" : "������...",
			"sLengthMenu" : "��ʾ _MENU_ ����",
			"sZeroRecords" : "û��ƥ����",
			"sInfo" : "��ʾ�� _START_ �� _END_ �������� _TOTAL_ ��",
			"sInfoEmpty" : "��ʾ�� 0 �� 0 �������� 0 ��",
			"sInfoFiltered" : "(�� _MAX_ ��������)",
			"sInfoPostFix" : "",
			"sSearch" : "����:",
			"sUrl" : "",
			"sEmptyTable" : "��������Ϊ��",
			"sLoadingRecords" : "������...",
			"sInfoThousands" : ",",
			"oPaginate" : {
				"sFirst" : "��ҳ",
				"sPrevious" : "��ҳ",
				"sNext" : "��ҳ",
				"sLast" : "ĩҳ"
			},
			"oAria" : {
				"sSortAscending" : ": ���������д���",
				"sSortDescending" : ": �Խ������д���"
			}
		}

	});

});

function dataTable_search() {
	var query = $("#dataTable-search-input").val();
	query = query.trim();
	g_dataTable.search(query).draw();
}