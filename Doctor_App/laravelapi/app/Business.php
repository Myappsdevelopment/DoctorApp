<?php
  
namespace App;
   
use Illuminate\Database\Eloquent\Model;
   
class Business extends Model
{
    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $table="business";


    protected $fillable = [
        'id', 'business_name','address','goods','owner_name','users_id',
    ];
}