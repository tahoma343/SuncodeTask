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

		success : function(res) {
			const multipleVal = res.multipleValues;
			const singleVal = res.singleValues;
			var iter = 0;

			// $('#result').html("&nbsp;");
			// $('#result').append("Multiple Values : "+"</br>");

			$.each(multipleVal[0], function(index, value) {
				$('#headers').append('<th>' + index + '</th>');
			});

			$.each(multipleVal, function() {
				iter++;

				$('#result').append('<tr>');
				$.each(multipleVal[iter], function(index, value) {
					$('#result').append('<th>' + value + '</th>');
				});
			});$('#result').append('</tr>');

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