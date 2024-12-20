package com.blogs.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.blogs.dto.ApiResponse;
import com.blogs.dto.CategoryDTO;
import com.blogs.entities.Category;
import com.blogs.service.CategoryService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController // =@Controller + @ResponseBody
@RequestMapping("/categories")
@AllArgsConstructor
public class CategoryController {
	// depcy
//	@Autowired
	private final CategoryService categoryService;

//	public CategoryController() {
//		System.out.println("in ctor " + getClass());
//	}

	/*
	 * URL - http://host:port/categories Method - GET payload - NONE Resp - list of
	 * categories
	 */
	@GetMapping
	public ResponseEntity<?> listAllCategories() {
		System.out.println("in list");
		return ResponseEntity.ok(categoryService.getAllCategories());
	}

	/*
	 * Desc - Add new Category 
	 * URL - http://host:port/categories 
	 * Method - POST
	 * payload - JSON representation of CategoryDTO (title , desc) 
	 * Successful Resp - SC 201 Category resp dto 
	 * Error resp - SC 400 , error mesg -wrapped in DTO
	 */
	@PostMapping
	@Operation(description = "Create New Category")
	public ResponseEntity<?> addCategory(@RequestBody CategoryDTO newCategory) {
		System.out.println("in add category " + newCategory);
		try {
			// invoke service layer
			return ResponseEntity.status(HttpStatus.CREATED).
					body(categoryService.addNewCategory(newCategory));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).
					body(new ApiResponse(e.getMessage()));
		}
	}

	/*
	 * Desc - Get category details By Id URL - http://host:port/categories/{catId}
	 * Method - GET payload - NONE Successful Resp - SC 200 Category Error resp - SC
	 * 404 , error mesg -wrapped in DTO
	 */
	@GetMapping("/{catId}")
	public ResponseEntity<?> getCategoryDetails(@PathVariable Long catId) {
		System.out.println("in get category " + catId);
		try {
			// invoke service layer method
			return ResponseEntity.ok(categoryService.getCategoryDetails(catId));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

	/*
	 * Desc - Update category Details URL - http://host:port/categories/{catId}
	 * Method - PUT payload - updated category details Successful Resp - SC 200 ,
	 * category Category Error resp - SC 404 , error mesg -wrapped in DTO
	 */
	@PutMapping("/{categoryId}")
	public ResponseEntity<?> updateCategory(
			@PathVariable Long categoryId, 
			@RequestBody Category category) {
		System.out.println("in update " + categoryId + " " + category);
		return ResponseEntity
				.ok(categoryService
						.updateCategoryDetails(categoryId, category));
	}
	/*
	 * Desc - delete category Details 
	 * URL - http://host:port/categories/{catId}
	 * Method - DELETE
	 *  payload - none 
	 *   Successful Resp - SC 200 ,
	 * Category Error resp - SC 404 , error mesg -wrapped in DTO
	 */
	@DeleteMapping("/{catId}")
	public ResponseEntity<?> deleteCategory(@PathVariable Long catId) {
		System.out.println("in delete "+catId);
		return ResponseEntity.ok
				(categoryService.deleteCategoryDetails(catId));		
	}
	/*
	 * Desc - Get category n associated post details by id
	 *  URL - http://host:port/categories/{catId}/posts
	 * Method - GET 
	 * payload - NONE 
	 * Successful Resp - SC 200 Category + post details
	 * Error resp - SC 404 , error mesg -wrapped in DTO(ApiResponse)
	 */
	@GetMapping("/{catId}/posts")
	public ResponseEntity<?> getCategoryAndPostDetails
	(@PathVariable Long catId) {
		System.out.println("in get category n posts" + catId);
		try {
			// invoke service layer method
			return ResponseEntity.ok
					(categoryService.getCategoryAndPostDetails(catId));
		} catch (RuntimeException e) {
			System.out.println(e);
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(e.getMessage()));
		}
	}

}
