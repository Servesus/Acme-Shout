/*
 * ProfileController.java
 * 
 * Copyright (C) 2018 Universidad de Sevilla
 * 
 * The use of this project is hereby constrained to the conditions of the
 * TDG Licence, a copy of which you may download from
 * http://www.tdg-seville.info/License.html
 */

package controllers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import forms.Calculator;

@Controller
@RequestMapping("/profile")
public class ProfileController extends AbstractController {

	// Action-1 ---------------------------------------------------------------		

	@RequestMapping(value = "/action-1", method = RequestMethod.GET)
	public ModelAndView action1() {
		ModelAndView result;
		//Creamos una lista de String para añadir las citas a ella
		List<String> quotes = new ArrayList<String>();
		//Añadimos las citas a la lista quotes
		quotes.add("Make it simple, not simpler -- Albert Einstein");
		quotes.add("I have a dream -- Martin L. King");
		quotes.add("It always seems impossible until it's done -- Nelson Mandela");
		quotes.add("Cogito ergo sum -- René Descartes");
		quotes.add("Have no fear of perfection, you'll never reach it -- " + "Salvador Dalí");
		quotes.add("Those who dare to fail miserably can achieve greatness -- " + "John F. Kennedy");
		quotes.add("It is hard to fail, but it is worse never to have tried to " + "succeed -- Theodore Roosevelt");
		quotes.add("Love is a serious mental disease -- Plato");
		quotes.add("It is our choices, that show what we truly are, far more than our " + "abilities -- J. K. Rowling");
		quotes.add("Only put off until tomorrow what you are willing to " + "die having left undone -- Pablo Picasso");
		quotes.add("Life is not a problem to be solved, but a reality to " + "be experienced -- Søren Kierkegaard");

		//Ordenamos la lista de citas de forma aleatoria
		Collections.shuffle(quotes);
		//Cogemos las 4 primeras citas de la nueva lista ordenada
		quotes = quotes.subList(0, 3);

		result = new ModelAndView("profile/action-1");
		result.addObject("quotes", quotes);

		return result;
	}

	// Action-2 ---------------------------------------------------------------		

	@RequestMapping(value = "/action-2", method = RequestMethod.GET)
	public ModelAndView action2Get() {
		ModelAndView result;
		final Calculator calculator = new Calculator();

		result = new ModelAndView("profile/action-2");
		result.addObject("calculator", calculator);

		return result;
	}

	@RequestMapping(value = "/action-2", method = RequestMethod.POST)
	public ModelAndView action2Post(@Valid final Calculator calculator, final BindingResult binding) {

		ModelAndView result;

		calculator.compute();

		result = new ModelAndView("profile/action-2");
		result.addObject("calculator", calculator);

		return result;
	}

	// Action-3 ---------------------------------------------------------------	

	@RequestMapping("/action-3")
	public ModelAndView action3() {
		throw new RuntimeException("Oops! An *expected* exception was thrown. This is a normal behaviour.");
	}
}
