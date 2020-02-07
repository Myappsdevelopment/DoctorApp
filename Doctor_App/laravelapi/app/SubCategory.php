<?php
  
namespace App;
   
use Illuminate\Database\Eloquent\Model;
   
class SubCategory extends Model
{
    /**
     * The attributes that are mass assignable.
     *
     * @var array
     */
    protected $fillable = [
        'id','name', 'users_id','categories_id',
    ];
}