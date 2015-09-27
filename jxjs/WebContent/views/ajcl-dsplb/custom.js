var baseUrl = getRootPath();

$(document).ready(function(){
	
	print = function(){
		var cont = $("#dataTable").html();
		printTable(cont);
	};
	
	exports = function(){
		var url = baseUrl + "/ajcl/exportExcel";
		var data = "";
		
		exportExcel(url, data);
	};
});