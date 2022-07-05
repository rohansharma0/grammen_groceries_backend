package com.cognizant.backend.controller;

import com.cognizant.backend.payload.ApiResponse;
import com.cognizant.backend.payload.SubCategoryDto;
import com.cognizant.backend.service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(methods = RequestMethod.GET)
public class SubCategoryController {

    @Autowired
    private SubCategoryService subCategoryService;

    //post - create subCategory
    @PostMapping("/category/{categoryId}/sub-category")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SubCategoryDto> createSubCategory(@Valid @RequestBody SubCategoryDto subCategoryDto , @PathVariable Long categoryId){
        SubCategoryDto createSubCategoryDto = this.subCategoryService.createSubCategory(subCategoryDto , categoryId);
        return new ResponseEntity<>(createSubCategoryDto , HttpStatus.CREATED);
    }

    //put - update user
    @PutMapping("/sub-category/{subCategoryId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<SubCategoryDto> updateSubCategory(@Valid @RequestBody SubCategoryDto subCategoryDto , @PathVariable Long subCategoryId){
        SubCategoryDto updateSubCategoryDto = this.subCategoryService.updateSubCategory(subCategoryDto , subCategoryId);
        return new ResponseEntity<>(updateSubCategoryDto , HttpStatus.OK);
    }

    //delete - delete user
    @DeleteMapping("/sub-category/{subCategoryId}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<ApiResponse> deleteSubCategory(@PathVariable Long subCategoryId){
        this.subCategoryService.deleteSubCategory(subCategoryId);
        return new ResponseEntity<>( new ApiResponse("SubCategory Deleted Successfully" , true) , HttpStatus.OK);
    }

    //get - user get
    @GetMapping("/sub-categories")
    public ResponseEntity<List<SubCategoryDto>> getAllSubCategories(){
        return ResponseEntity.ok(this.subCategoryService.getAllSubCategories());
    }

    @GetMapping("/sub-category/{subCategoryId}")
    public ResponseEntity<SubCategoryDto> getSubCategory(@PathVariable Long subCategoryId){
        return ResponseEntity.ok(this.subCategoryService.getSubCategoryById(subCategoryId));
    }

    //get - get subCategory by category
    @GetMapping("category/{categoryId}/sub-categories")
    public ResponseEntity<List<SubCategoryDto>> getSubCategoriesByCategory(@PathVariable Long categoryId){
        List<SubCategoryDto> subCategories = this.subCategoryService.getSubCategoryByCategory(categoryId);
        return new ResponseEntity<>(subCategories , HttpStatus.OK);
    }
}
