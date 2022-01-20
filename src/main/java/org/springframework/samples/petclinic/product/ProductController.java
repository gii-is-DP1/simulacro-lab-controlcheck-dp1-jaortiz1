package org.springframework.samples.petclinic.product;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.samples.petclinic.owner.Owner;
import org.springframework.samples.petclinic.pet.Pet;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/product")
public class ProductController {
	@Autowired
	private  ProductService productService;

	
	 private static final String VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM = "products/createOrUpdateProductForm";
	 private static final String VIEWS_PRODUCT_PRODUCTS_LIST = "products/productsList";

	    @GetMapping(path="/create")
	    public String initCreationForm(ModelMap modelMap) {
	        String view = VIEWS_PRODUCT_CREATE_OR_UPDATE_FORM;
	        modelMap.addAttribute("product", new Product());
	        modelMap.addAttribute("productTypes", productService.findAllProductTypes());
	        return view;
	    }
	    @PostMapping(path="/create")
	    public String postProduct(@Valid Product product, BindingResult result, ModelMap model) {
	    	if(result.hasErrors()) {
	    		model.addAttribute("errors", result.getAllErrors());
	    		return "products/createOrUpdateProductForm";
	    	}else {
	    		this.productService.save(product);
	    	}
			return "welcome";
	    	
	    }
}
