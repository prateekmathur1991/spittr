package com.spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spittr.Spittle;
import com.spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {
	
	private SpittleRepository repository;
	
	// Required because @RequstParam defaultValue requires constant expressions
	// Can't even use Long.toString(Long.MAX_VALUE) because that cannot be evaluated at compile time
	private static final String MAX_LONG_AS_STRING = "9223372036854775807";
	
	@Autowired
	public SpittleController(SpittleRepository repository)	{
		this.repository = repository;
	}
	
	@RequestMapping(method=RequestMethod.GET)
	public String spittles(@RequestParam(value="max", defaultValue=MAX_LONG_AS_STRING) long max, 
						   @RequestParam(value="count", defaultValue="20") int count, 
						   Model model)	{
		model.addAttribute("spittleList", repository.findSpittles(max, count));
		return "spittles";
	}
	
	@RequestMapping(value="/{spittleId}", method=RequestMethod.GET)
	public String showSingleSpittle(@PathVariable(value="spittleId") long spittleId, Model model)	{
		model.addAttribute("spittle", repository.findOne(spittleId));
		return "spittle";
	}
}