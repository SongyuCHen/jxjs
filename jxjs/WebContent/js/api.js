/**
 * common api
 */
var print;
var exports;



/**
 * get root path
 */
function getRootPath() {
	var curWwwPath = window.document.location.href;
	var pathName = window.document.location.pathname;
	var pos = curWwwPath.indexOf(pathName);
	var localhostPath = curWwwPath.substring(0, pos);
	var projectName = pathName.substring(0, pathName.substr(1).indexOf('/') + 1);

	return (localhostPath + projectName);
}

/**
 * print table
 * @param cont		cont=$('#xxxTable').html();
 */
function printTable(cont){
	var wind=window.open('about:blank', '', '');
    
    wind.document.write(
    		'<style>' +
    			'@media print{' +
    				'.no-print{' + 
    					'display:none;' + 
    				'}' + 
    				'.no-wrap{' + 
    					'word-break: keep-all;' + 
    					'white-space:nowrap;' + 
    				'}' + 
    			'}' + 
    			'@media all{' + 
    				'th,td{' + 
    					'border:1px solid #000;' + 
    				'}' + 
    				'table{' + 
    					'border-collapse:collapse;width:95%;' + 
    				'}' + 
    			'}' + 
    			'@page{' +
    				'size: landscape' +
    			'}' +
    		'</style>' + 
    		'<table>'+cont+'</table>');
    wind.print();
}

/**
 * export excel
 * @param url	url
 * @param data	json data
 */
function exportExcel(url, data){
	var paramStr = parseJson(data);
	if(paramStr != null && paramStr != ""){
		url = url + "?" + paramStr;
	}
	
	window.location = url;
}

/**
 * parse json object
 * @param jsonObj		json object
 * @returns {String}	url parameter string
 */
function parseJson(jsonObj){
	var paramStr = "";
	
	for(var key in jsonObj){
		if(jsonObj[key]!= undefined){
			paramStr += key + "=" + jsonObj[key] + "&";
		}
	}
	if(paramStr.length > 0){
		paramStr = paramStr.substring(0, paramStr.length - 1);
	}
	
	return paramStr;
}
