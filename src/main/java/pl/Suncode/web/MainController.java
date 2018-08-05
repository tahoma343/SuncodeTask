package pl.Suncode.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import pl.Suncode.model.RequestEntity;
import pl.Suncode.model.SuncodeEntity;
import pl.Suncode.repository.SuncodeEntityRepository;

@Controller
public class MainController {

	@Autowired
	public SuncodeEntityRepository entityRepository;

	@GetMapping(value = "/main")
	public String main() {
		return "main";
	}

	@PostMapping(value = "/search", produces = "application/json")
	public ResponseEntity<?> searchTable(@RequestBody RequestEntity reqEntity) throws RuntimeException {
		List<SuncodeEntity> multipleValues = entityRepository.getMultipleValues(reqEntity.getValue());
		List<SuncodeEntity> singleValues = entityRepository.getSingleValue(reqEntity.getValue());
		
		Map<String, List<SuncodeEntity>> map = new HashMap();
		map.put("multipleValues", multipleValues);
		map.put("singleValues", singleValues);

		if (multipleValues.isEmpty() && singleValues.isEmpty())
			return new ResponseEntity(HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity(HttpStatus.OK).ok(map);
	}
}
