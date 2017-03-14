/**
 * editmd的使用
 */

/**
 * markdown编辑器
 */
$(function() {
	var testEditormdView;
	
	$.get(getRootPath()+"/public/plugin/editormd/examples/test.md", function(markdown) {

		var testEditor;
		
		$(function() {
		    testEditor = editormd("admin-editormd", {
		        height  : 640,
		        syncScrolling : "single",
		        path    : getRootPath()+"/public/plugin/editormd/lib/"
		   	});
		});
	});
});


/**
 * markdown查看器
 */

$(function() {
    var testEditormdView;
    
    $.get(getRootPath()+"/public/plugin/editormd/examples/test.md", function(markdown) {
        
    	  
        testEditormdView2 = editormd.markdownToHTML("editmd-view", {
            htmlDecode      : "style,script,iframe",
            emoji           : true,
            taskList        : true,
            tex             : true, 
            flowChart       : true,
            sequenceDiagram : true, 
        });
    });
});


