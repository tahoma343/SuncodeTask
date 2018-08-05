const $BASE_URL = 'http://localhost:8080/';
function send() {
	var $data = {
		"value" : $('#tableType').val()
	};

	$.ajax({
		type : 'POST',
		contentType : 'application/json',
		dataType : 'json',
		url : $BASE_URL + 'search',
		data : JSON.stringify($data),
		
		beforeSend: function(){
			 $('#multipleResults').html('&nbsp;');
		     $('#singleResults').html('&nbsp;');
		   },
		success : function(res) {
			displayTable(res.multipleValues, 'multiple');
			displayTable(res.singleValues, 'single');
		},
		error : function(error) {
			$('#error').text(error.status);
		},
		complete : function() {
			var cleanUp = function() {
				$('#error').html('&nbsp;');
			}
			setTimeout(cleanUp, 3000);
		}
	});
}

	function displayTable(values, type) {
		var iter = 0;
		$('#'+type+'Results').append('<tr id="' + type + 'Headers"></tr>');
		
		$.each(values[0], function(index, value) {
			$('#'+type+'Headers').append('<th>' + index + '</th>');
		});

		$.each(values, function() {
			$('#'+type+'Results').append('<tr>');
			$.each(values[iter], function(index, value) {
				$('#'+type+'Results').append('<th>' + value + '</th>');
			});
			iter++;
		});
		$('#'+type+'Results').append('</tr>');
	}
	
	