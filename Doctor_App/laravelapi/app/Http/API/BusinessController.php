<?php
   
namespace App\Http\Controllers\API;
   
use Illuminate\Http\Request;
use App\Http\Controllers\API\BaseController as BaseController;
use App\Business;
use Validator;
use App\Http\Resources\Business as BusinessResource;
   
class BusinessController extends BaseController
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        $business = Business::all();
    
        return $this->sendResponse(BusinessResource::collection($business), 'Business retrieved successfully.');
    }
    /**
     * Store a newly created resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return \Illuminate\Http\Response
     */
    public function store(Request $request)
    {
        $input = $request->all();
   
        $validator = Validator::make($input, [
            'users_id' => 'required',
            'business_name' => 'required',
            'owner_name' => 'required',
            'address' => 'required',
            'goods' => 'required',
        ]);
   
        if($validator->fails()){
            return $this->sendError('Validation Error.', $validator->errors());       
        }
   
        $business = Business::create($input);
   
        return $this->sendResponse(new BusinessResource($business), 'Business created successfully.');
    } 
   
    /**
     * Display the specified resource.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function show($id)
    {
        $business = Business::find($id);
  
        if (is_null($business)) {
            return $this->sendError('Business not found.');
        }
   
        return $this->sendResponse(new BusinessResource($business), 'Business retrieved successfully.');
    }
    
    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function update(Request $request, Business $business)
    {
        $input = $request->all();

        //dd($input);
   
        $validator = Validator::make($input, [
            'business_name' => 'required',
            'owner_name' => 'required',
            'address' => 'required',
            'goods' => 'required'
        ]);
   
        if($validator->fails()){
            return $this->sendError('Validation Error.', $validator->errors());       
        }
   
        $business->business_name = $input['business_name'];
        $business->owner_name = $input['owner_name'];
        $business->address = $input['address'];
        $business->goods = $input['goods'];
        $business->save();
   
        return $this->sendResponse(new BusinessResource($business), 'Business updated successfully.');
    }
   
    /**
     * Remove the specified resource from storage.
     *
     * @param  int  $id
     * @return \Illuminate\Http\Response
     */
    public function destroy(Business $business)
    {
        $business->delete();
   
        return $this->sendResponse([], 'Business deleted successfully.');
    }
}