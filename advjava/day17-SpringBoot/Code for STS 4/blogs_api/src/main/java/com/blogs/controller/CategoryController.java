package com.blogs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.CategoryReqDTO;
import com.blogs.dto.CategoryRespDTO;
import com.blogs.pojos.Category;
import com.blogs.service.CategoryService;

@RestController
@RequestMapping("/categories")
@CrossOrigin(origins = "http://localhost:3000")
public class CategoryController {
//depcy
	@Autowired
	private CategoryService categoryService;

	public CategoryController() {
		System.out.println("in ctor " + getClass());
	}

	/*
	 * URL - http://host:port/categories 
	 * Method - GET 
	 * payload - none ! 
	 * resp - JSON representation of List<CategoryRespDTO> 
	 * Desc - get all categories
	 */
	@GetMapping
	public ResponseEntity<?> getCategories() {
		System.out.println("get all");
		List<CategoryRespDTO> categories = 
				categoryService.getAllCategories();
		if (categories.isEmpty())
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		return ResponseEntity.ok(categories);
	}

	/*
	 * URL - http://host:port/categories Method - POST payload - JSON representation
	 * of category -> Java - @RequestBody resp - String Desc - add new category
	 */
	@PostMapping
	public ResponseEntity<?> addNewCategory
	(@RequestBody CategoryReqDTO category) {
		System.out.println("in add category " + category);// transient category
		return ResponseEntity.status(HttpStatus.CREATED)
				.body(categoryService.addNewCategory(category));
	}

	/*
	 * URL - http://host:port/categories/{catId} Method - GET payload - URI variable
	 * - category id resp - Category -> JSON Desc - get category details
	 */
	@GetMapping("/{catId}")
	public ResponseEntity<?> getCategoryDetails(@PathVariable Long catId) {
		System.out.println("in get dtls " + catId);
		try {
			// invoke service layer method
			CategoryRespDTO category = categoryService
					.getCategoryDetails(catId);
			return ResponseEntity.ok(category);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}

	/*
	 * URL - http://host:port/categories/{categoryId} Method - PUT payload - updated
	 * category contents resp - success - api resp dto resp - error -api resp dto
	 * Desc - Update category details
	 */
	@PutMapping("/{categoryId}")
	public ResponseEntity<?> updateCategoryDetails
	(@PathVariable Long categoryId, @RequestBody Category category) {
		System.out.println("in update category " + categoryId + " " + category);

		// invoke service layer method
		//TO DO - change Sts code - in case of error !!!
		return ResponseEntity.ok(
				categoryService.updateCategory(categoryId, category));

	}
	/*
	 * URL -  http://host:port/categories?catId=....
	 * Method -  DELETE
	 * payload -  request param
	 * resp success - DTO
	* resp error - DTO
	 * Desc - Hard delete category details
 */
	@DeleteMapping
	public ResponseEntity<?> deleteCategoryDetails(@RequestParam() Long categoryId)
	{
		System.out.println("in delete "+categoryId);
		try {
			//invoke service layer method
			return ResponseEntity.ok(
			categoryService.deleteCategory(categoryId));
		} catch (RuntimeException e) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage()));
		}
	}

}
