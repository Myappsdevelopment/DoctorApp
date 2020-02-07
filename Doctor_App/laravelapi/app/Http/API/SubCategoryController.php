<?php
   
namespace App\Http\Controllers\API;
   
use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\SubCategory;
use Validator;
use App\Http\Resources\SubCategory as SubCategoryResource;
   
class SubCategoryController extends BaseController
{

/**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
       // SubCategory::findAll($id);

        $product =  SubCategory::where('categories_id', $id)->get();

        if (is_null($product)) {
            return $this->sendError('Product not found.');
        }
   
        return $this->sendResponse($product, 'Sub Category retrieved successfully.');

       // return $this->sendResponse(new SubCategoryResource($product), 'Product retrieved successfully.');
    }
}