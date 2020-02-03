@extends('layouts.app', ['title' => __('User Management')])

@section('content')
    @include('layouts.headers.cards')

    <div class="container-fluid mt--7">
        <div class="row">
            <div class="col">
                <div class="card shadow">
                    <div class="card-header border-0">
                        <div class="row align-items-center">
                            <div class="col-8">
                                <h3 class="mb-0">{{ __('Products') }}</h3>
                            </div>
                            <div class="col-4 text-right">
                                <a href="{{ route('user.create') }}" class="btn btn-sm btn-primary">{{ __('Add product') }}</a>
                            </div>
                        </div>
                    </div>
                    
                    <div class="col-12">
                        @if (session('status'))
                            <div class="alert alert-success alert-dismissible fade show" role="alert">
                                {{ session('status') }}
                                <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                                    <span aria-hidden="true">&times;</span>
                                </button>
                            </div>
                        @endif
                    </div>

                    <div class="table-responsive">
                        <div>
                        <table class="table align-items-center">
                            <thead class="thead-light">
                                <tr>
                                    <th scope="col">
                                        Project
                                    </th>
                                    <th scope="col">
                                        Budget
                                    </th>
                                    <th scope="col">
                                        Status
                                    </th>
                                    <th scope="col">Users</th>
                                    <th scope="col">
                                        Completion
                                    </th>
                                    <th scope="col"></th>
                                </tr>
                            </thead>
                            <tbody class="list">
                                
                                <tr>
                                    <th scope="row" class="name">
                                        <div class="media align-items-center">
                                            <a href="#" class="avatar rounded-circle mr-3">
                                                <img alt="Image placeholder" src="https://demos.creative-tim.com/argon-dashboard/assets/img/theme/react.jpg" class="rounded-circle">
                                            </a>
                                            <div class="media-body">
                                                <span class="mb-0 text-sm">Argon Design System</span>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="budget">
                                        $2500 USD
                                    </td>
                                    <td class="status">
                                        <span class="badge badge-dot mr-4">
                                          <i class="bg-warning"></i> pending
                                        </span>
                                    </td>
                                    <td>
                                        <div class="avatar-group">
                        <a href="#" class="avatar avatar-sm" data-toggle="tooltip" data-original-title="Ryan Tompson">
                          <img alt="Image placeholder" src="https://demos.creative-tim.com/argon-dashboard/assets/img/theme/react.jpg" class="rounded-circle">
                        </a>
                      
                    </div>
                    
                                    </td>
                                    <td class="completion">
                                        <div class="d-flex align-items-center">
                                            <span class="mr-2">60%</span>
                                            <div>
                                                <div class="progress">
                                                    <div class="progress-bar bg-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%;"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-right">
                                        <div class="dropdown">
                                            <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                              <i class="fas fa-ellipsis-v"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                                <a class="dropdown-item" href="#">Action</a>
                                                <a class="dropdown-item" href="#">Another action</a>
                                                <a class="dropdown-item" href="#">Something else here</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <th scope="row" class="name">
                                        <div class="media align-items-center">
                                            <a href="#" class="avatar rounded-circle mr-3">
                                                <img alt="Image placeholder" src="https://demos.creative-tim.com/argon-dashboard/assets/img/theme/react.jpg" class="rounded-circle">
                                            </a>
                                            <div class="media-body">
                                                <span class="mb-0 text-sm">Angular Now UI Kit PRO</span>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="budget">
                                        $1800 USD
                                    </td>
                                    <td class="status">
                                        <span class="badge badge-dot mr-4">
                                          <i class="bg-success"></i> completed
                                        </span>
                                    </td>
                                    <td>
                                        <div class="avatar-group">
                        <a href="#" class="avatar avatar-sm" data-toggle="tooltip" data-original-title="Ryan Tompson">
                            <img alt="Image placeholder" src="https://demos.creative-tim.com/argon-dashboard/assets/img/theme/react.jpg" class="rounded-circle">
                        </a>
                        
                    </div>
                    
                                    </td>
                                    <td class="completion">
                                        <div class="d-flex align-items-center">
                                            <span class="mr-2">100%</span>
                                            <div>
                                                <div class="progress">
                                                    <div class="progress-bar bg-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-right">
                                        <div class="dropdown">
                                            <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                              <i class="fas fa-ellipsis-v"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                                <a class="dropdown-item" href="#">Action</a>
                                                <a class="dropdown-item" href="#">Another action</a>
                                                <a class="dropdown-item" href="#">Something else here</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <th scope="row" class="name">
                                        <div class="media align-items-center">
                                            <a href="#" class="avatar rounded-circle mr-3">
                                                <img alt="Image placeholder" src="https://demos.creative-tim.com/argon-dashboard/assets/img/theme/react.jpg" class="rounded-circle">
   
                                            </a>
                                            <div class="media-body">
                                                <span class="mb-0 text-sm">Black Dashboard</span>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="budget">
                                        $3150 USD
                                    </td>
                                    <td class="status">
                                        <span class="badge badge-dot mr-4">
                                          <i class="bg-danger"></i> delayed
                                        </span>
                                    </td>
                                    <td>
                                        <div class="avatar-group">
                        <a href="#" class="avatar avatar-sm" data-toggle="tooltip" data-original-title="Ryan Tompson">
                          <img alt="Image placeholder" src="https://demos.creative-tim.com/argon-dashboard/assets/img/theme/react.jpg" class="rounded-circle">
                      </a>
                      
                    </div>
                    
                                    </td>
                                    <td class="completion">
                                        <div class="d-flex align-items-center">
                                            <span class="mr-2">72%</span>
                                            <div>
                                                <div class="progress">
                                                    <div class="progress-bar bg-danger" role="progressbar" aria-valuenow="72" aria-valuemin="0" aria-valuemax="100" style="width: 72%;"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-right">
                                        <div class="dropdown">
                                            <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                              <i class="fas fa-ellipsis-v"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                                <a class="dropdown-item" href="#">Action</a>
                                                <a class="dropdown-item" href="#">Another action</a>
                                                <a class="dropdown-item" href="#">Something else here</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <th scope="row" class="name">
                                        <div class="media align-items-center">
                                            <a href="#" class="avatar rounded-circle mr-3">
                                                <img alt="Image placeholder" src="https://demos.creative-tim.com/argon-dashboard/assets/img/theme/react.jpg" class="rounded-circle">
                                            </a>
                                            <div class="media-body">
                                                <span class="mb-0 text-sm">React Material Dashboard</span>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="budget">
                                        $4400 USD
                                    </td>
                                    <td class="status">
                                        <span class="badge badge-dot mr-4">
                                          <i class="bg-info"></i> on schedule
                                        </span>
                                    </td>
                                    <td>
                                        <div class="avatar-group">
                        <a href="#" class="avatar avatar-sm" data-toggle="tooltip" data-original-title="Ryan Tompson">
                            <img alt="Image placeholder" src="https://demos.creative-tim.com/argon-dashboard/assets/img/theme/react.jpg" class="rounded-circle">
                        </a>
                       
                    </div>
                    
                                    </td>
                                    <td class="completion">
                                        <div class="d-flex align-items-center">
                                            <span class="mr-2">90%</span>
                                            <div>
                                                <div class="progress">
                                                    <div class="progress-bar bg-info" role="progressbar" aria-valuenow="90" aria-valuemin="0" aria-valuemax="100" style="width: 90%;"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-right">
                                        <div class="dropdown">
                                            <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                              <i class="fas fa-ellipsis-v"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                                <a class="dropdown-item" href="#">Action</a>
                                                <a class="dropdown-item" href="#">Another action</a>
                                                <a class="dropdown-item" href="#">Something else here</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                
                                <tr>
                                    <th scope="row" class="name">
                                        <div class="media align-items-center">
                                            <a href="#" class="avatar rounded-circle mr-3">
                                                <img alt="Image placeholder" src="https://demos.creative-tim.com/argon-dashboard/assets/img/theme/react.jpg" class="rounded-circle">
                                            </a>
                                            <div class="media-body">
                                                <span class="mb-0 text-sm">Vue Paper UI Kit PRO</span>
                                            </div>
                                        </div>
                                    </th>
                                    <td class="budget">
                                        $2200 USD
                                    </td>
                                    <td class="status">
                                        <span class="badge badge-dot mr-4">
                                          <i class="bg-success"></i> completed
                                        </span>
                                    </td>
                                    <td>
                                        <div class="avatar-group">
                        <a href="#" class="avatar avatar-sm" data-toggle="tooltip" data-original-title="Ryan Tompson">
                            <img alt="Image placeholder" src="https://demos.creative-tim.com/argon-dashboard/assets/img/theme/react.jpg" class="rounded-circle">
                        </a>
                       
                    </div>
                    
                                    </td>
                                    <td class="completion">
                                        <div class="d-flex align-items-center">
                                            <span class="mr-2">100%</span>
                                            <div>
                                                <div class="progress">
                                                    <div class="progress-bar bg-success" role="progressbar" aria-valuenow="100" aria-valuemin="0" aria-valuemax="100" style="width: 100%;"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </td>
                                    <td class="text-right">
                                        <div class="dropdown">
                                            <a class="btn btn-sm btn-icon-only text-light" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                              <i class="fas fa-ellipsis-v"></i>
                                            </a>
                                            <div class="dropdown-menu dropdown-menu-right dropdown-menu-arrow">
                                                <a class="dropdown-item" href="#">Action</a>
                                                <a class="dropdown-item" href="#">Another action</a>
                                                <a class="dropdown-item" href="#">Something else here</a>
                                            </div>
                                        </div>
                                    </td>
                                </tr>
                                
                            </tbody>
                        </table>
                    </div>
                    
                    </div>
           
                </div>
            </div>
        </div>
            
        @include('layouts.footers.auth')
    </div>
@endsection