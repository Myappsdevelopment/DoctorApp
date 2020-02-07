<?php
   
namespace App\Http\Controllers\API;
   
use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Category;
use Validator;
use App\Http\Resources\Category as CategoryResource;
   
class CategoryController extends BaseController
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $categories = Category::all();
    
        return $this->sendResponse(CategoryResource::collection($categories), 'Category retrieved successfully.');
    }

}