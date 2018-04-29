package org.sklep.controller;

import java.math.BigDecimal;
import java.util.List;

import org.sklep.enums.KindOfGame;
import org.sklep.model.ComputerGame;
import org.sklep.service.ComputerGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputerGameController {

	@Autowired
	private ComputerGameService cGS;

	@GetMapping("/games")
	@CrossOrigin(value = "http://localhost:8081")
	public List<ComputerGame> listaGier() {
		return cGS.getAllGames();

	}
	
	@GetMapping("/games/{category}")
	public List<ComputerGame> listaGierPoKategorii(@PathVariable String category) {
		return cGS.getAllGamesByCategory(KindOfGame.valueOf(category.toUpperCase()));
	}
	
	@GetMapping("/games/lessthan/{price}")
	public List<ComputerGame> listaGierOCenieNizszaNizX(@PathVariable String price){
		return cGS.getAllByPriceLessThan(new BigDecimal(price));
	}
	
	
	@GetMapping("/games/morethan/{price}")
	public List<ComputerGame> listaGierOCenieWiekszejNizX(@PathVariable String price)
	{
	return cGS.getAllByPriceMoreThan(new BigDecimal(price));	
		
	}
	
	@GetMapping("/games/orderby/")
	public List<ComputerGame> listaGierPosortowanaPoImieniu()
	{
	return cGS.getAllNameOrderBy();
		
	}
	

}
