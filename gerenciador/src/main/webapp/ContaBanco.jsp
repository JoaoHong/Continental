<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gerenciamento de contas</title>

</head>

		
<body>

<div class="toolbar" id="kt_toolbar">
	<!--begin::Container-->
	<div id="kt_toolbar_container" class="container-fluid d-flex flex-stack">
		<!--begin::Page title-->
		<div data-kt-swapper="true" data-kt-swapper-mode="prepend" data-kt-swapper-parent="{default: '#kt_content_container', 'lg': '#kt_toolbar_container'}" class="page-title d-flex align-items-center flex-wrap me-3 mb-5 mb-lg-0">
			<!--begin::Title-->
			<h1 class="d-flex align-items-center text-dark fw-bolder fs-3 my-1">Gerenciamento</h1>
			<!--end::Title-->
			<!--begin::Separator-->
			<span class="h-20px border-gray-200 border-start mx-4"></span>
			<!--end::Separator-->
			<!--begin::Breadcrumb-->
			<ul class="breadcrumb breadcrumb-separatorless fw-bold fs-7 my-1">
				<!--begin::Item-->
				<li class="breadcrumb-item text-muted">
					<a href="" class="text-muted text-hover-primary">Usuários</a>
				</li>
			</ul>
			<!--end::Breadcrumb-->
		</div>
		<!--end::Page title-->
		<!--begin::Actions-->

		<!--end::Actions-->
	</div>
	<!--end::Container-->
</div>
<!--end::Toolbar-->		
<!--begin::Post-->
<div class="post d-flex flex-column-fluid" id="kt_post">
	<!--begin::Container-->
	<div id="kt_content_container" class="container-fluid">

		<div class="card card-bordered">
			<!--begin::Card header-->
			<div class="card-header align-items-center py-3 gap-2 gap-md-5">
				<!--begin::Card title-->
				<div class="card-title">
					<h3>Usuários</h3>
				</div>
				<!--end::Card title-->
				<!--begin::Card toolbar-->
				<div class="card-toolbar flex-row-fluid justify-content-end gap-5">						
					<a href="" class="btn btn-primary">Adicionar</a>
				</div>
				<!--end::Card toolbar-->
			</div>
			<!--end::Card header-->
			<!--begin::Card body-->
			<div class="card-body">
				<!--begin: Datatable-->
				<div class="datatable-standard">
					<table class="table table-striped table-row-bordered table-bordered gy-5 gs-20" id="kt_datatable">
						<thead>
							<tr class="text-uppercase">
								<th class="text-center">Id</th>
								<th class="text-center">Nome</th>
								<th class="text-center">Ações</th>
							</tr>
						</thead>
						<tbody>						
							<tr>
								<td class="text-center">@user.Id</td>
								<td class="text-center">@user.Nome</td>
								<td nowrap="nowrap" class="text-center">
									<a href="" class="" title="Editar"> <i class="bi bi-pen fs-1"></i> </a>
									<a href="" data-idElemento="@user.Id" class="btnExcluir" title="Excluir"> <i class="bi bi-trash fs-1"></i> </a>
								</td>
							</tr>							
						</tbody>
					</table>
				</div>
				<!--end: Datatable-->
			</div>
			<!--end::Card body-->				
		</div>

	</div>
	<!--end::Container-->													
</div>


	
</body>
</html>