/**
 * 
 */

$(function(){
	g_dataTable = $("#dataTable").DataTable({
		 columnDefs:[{
            orderable:false,//禁用排序
            targets:[0]   //指定的列
        }],
        order : [[ 6, "desc" ]]
	});

});